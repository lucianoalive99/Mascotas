package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.core.exception.mascotaExisteException;
import ar.edu.undec.mascotas.core.repositorio.ICrearMascotaRepositorio;
import ar.edu.undec.mascotas.core.usecase.CrearMascotaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearMascotaUseCaseUnitTest {

    @Mock
    ICrearMascotaRepositorio crearMascotaRepositorio;

    @Test
    void crearMascota_mascotaNoExiste_creaMascota() throws mascotaExisteException {
        //arrange
        Mascota laMascota = Mascota.instancia("simon","boxer", LocalDate.of(2015,2,11));
        CrearMascotaUseCase crearMascotaUseCase = new CrearMascotaUseCase(crearMascotaRepositorio);

        //simulacion de base de datos
        when(crearMascotaRepositorio.existe(laMascota.getNombre())).thenReturn(false);
        when(crearMascotaRepositorio.guardarMascota(laMascota )).thenReturn(true);

        //act
        boolean resultado= crearMascotaUseCase.crearMascota(laMascota);

        //assert
        Assertions.assertTrue(resultado);
    }

    @Test
    void crearMascota_mascotaYaExiste_mascotaExisteException() throws mascotaExisteException {
        //arrange
        Mascota laMascota = Mascota.instancia("simon","boxer", LocalDate.of(2015,2,11));
        CrearMascotaUseCase crearMascotaUseCase = new CrearMascotaUseCase(crearMascotaRepositorio);

        //simulacion de base de datos
        when(crearMascotaRepositorio.existe(laMascota.getNombre())).thenReturn(true);

        //act
        //boolean resultado= crearMascotaUseCase.crearMascota(laMascota);

        //assert
        Assertions.assertThrows(mascotaExisteException.class,()->crearMascotaUseCase.crearMascota(laMascota));
    }
}
