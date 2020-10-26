package ar.edu.undec.mascotas.usecase.input;

import ar.edu.undec.mascotas.doamain.Mascota;
import ar.edu.undec.mascotas.exception.mascotaExisteException;

public interface ICrearMascotaUseCase {

    boolean crearMascota(Mascota laMascota) throws mascotaExisteException;
}
