package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.core.exception.modificarMascotaException;
import ar.edu.undec.mascotas.core.repositorio.IConsultarMascotaRepositorio;
import ar.edu.undec.mascotas.core.repositorio.IModificarMascotaRepositorio;
import ar.edu.undec.mascotas.core.usecase.ModificarMascotaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
class MoficarMascotaUseCaseUnitTestTest {
    @Mock
    IModificarMascotaRepositorio modificarMascotaPorNombreRepositorio;
    @Mock
    IConsultarMascotaRepositorio consultaMascotaPorNombreRepositorio;

    @Test
    void modificarMascota_DatosCorrectos_DatosModificados() throws modificarMascotaException {
        Mascota mascotaSinModificar = Mascota.instancia("simon","boxer", LocalDate.of(2015,2,11));
        Mascota mascotaModificada = Mascota.instancia("simon","caniche", LocalDate.of(2018,5,22));

        when(consultaMascotaPorNombreRepositorio.findByNombre("simon")).thenReturn(mascotaSinModificar);
        when(modificarMascotaPorNombreRepositorio.update(mascotaSinModificar)).thenReturn(true);

        ModificarMascotaUseCase modificarMascotaUseCase = new ModificarMascotaUseCase
                (consultaMascotaPorNombreRepositorio,modificarMascotaPorNombreRepositorio);

        Mascota laMascota = modificarMascotaUseCase.modificarMascota(mascotaModificada);

        Assertions.assertEquals("caniche",laMascota.getRaza());
    }
}