package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.core.repositorio.IConsultarMascotaRepositorio;
import ar.edu.undec.mascotas.core.usecase.ConsultarMascotaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarMascotaUseCaseUnitTest {

    @Mock
    IConsultarMascotaRepositorio consultarMascotaRepositorio;

    @Test
    public void consultarMascota_MascotasExiste_DevuelveLista(){

        when(consultarMascotaRepositorio.devolverMAscotas()).thenReturn(mascotaList());
        ConsultarMascotaUseCase consultarMascotaUseCase = new ConsultarMascotaUseCase(consultarMascotaRepositorio);

        List<Mascota> mascotasDevueltas = consultarMascotaUseCase.consultarMascotas();
        Assertions.assertEquals(2,mascotasDevueltas.size());
    }

    private List<Mascota> mascotaList() {
        List<Mascota> mascotaList = new ArrayList<>();
        Mascota mascota1 = Mascota.instancia("simon","boxer", LocalDate.of(2015,2,11));
        Mascota mascota2 = Mascota.instancia("simon","caniche", LocalDate.of(2018,5,22));
        mascotaList.add(mascota1);
        mascotaList.add(mascota2);
        return mascotaList;
    }
}
