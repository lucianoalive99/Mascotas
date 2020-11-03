package ar.edu.undec.mascotas.core.usecase.input;

import ar.edu.undec.mascotas.core.doamain.Mascota;

import java.util.List;

public interface IConsultarMascotaUseCase {
    List<Mascota> consultarMascotas();
}
