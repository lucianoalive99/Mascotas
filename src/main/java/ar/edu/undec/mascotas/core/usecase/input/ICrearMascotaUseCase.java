package ar.edu.undec.mascotas.core.usecase.input;

import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.core.exception.mascotaExisteException;

public interface ICrearMascotaUseCase {

    boolean crearMascota(Mascota laMascota, String documento) throws mascotaExisteException;
}
