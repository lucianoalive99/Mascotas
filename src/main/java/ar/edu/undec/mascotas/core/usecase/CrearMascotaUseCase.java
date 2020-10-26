package ar.edu.undec.mascotas.core.usecase;

import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.core.exception.mascotaExisteException;
import ar.edu.undec.mascotas.core.repositorio.ICrearMascotaRepositorio;
import ar.edu.undec.mascotas.core.usecase.input.ICrearMascotaUseCase;

public class CrearMascotaUseCase implements ICrearMascotaUseCase {
    private ICrearMascotaRepositorio crearMascotaRepositorio;

    public CrearMascotaUseCase(ICrearMascotaRepositorio crearMascotaRepositorio) {

        this.crearMascotaRepositorio = crearMascotaRepositorio;
    }

    @Override
    public boolean crearMascota(Mascota laMascota) throws mascotaExisteException {
        if(crearMascotaRepositorio.existe(laMascota.getNombre())){
            throw new mascotaExisteException("La mascota ya existe en el sistema.");
        }
        else
        {
            crearMascotaRepositorio.guardarMascota(laMascota);
            return true;
        }
    }
}
