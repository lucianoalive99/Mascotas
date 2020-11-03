package ar.edu.undec.mascotas.core.usecase.input;

import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.core.exception.modificarMascotaException;

public interface IModificarMascotaUseCase {
    Mascota modificarMascota(Mascota mascotaParaModificar) throws modificarMascotaException;
}
