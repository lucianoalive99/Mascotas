package ar.edu.undec.mascotas.usecase.input;

import ar.edu.undec.mascotas.doamain.Mascota;

import java.util.List;

public interface IConsultarMascotaUseCase {
    List<Mascota> consultarMascotas();
}
