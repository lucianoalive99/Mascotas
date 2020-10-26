package ar.edu.undec.mascotas.usecase.input;

import ar.edu.undec.mascotas.doamain.Mascota;
import ar.edu.undec.mascotas.exception.modificarMascotaException;

public interface IModificarMascotaUseCase {
    Mascota modificarMascota(Mascota mascotaParaModificar) throws modificarMascotaException;
}
