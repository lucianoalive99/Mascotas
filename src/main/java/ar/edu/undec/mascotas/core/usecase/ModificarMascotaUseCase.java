package ar.edu.undec.mascotas.core.usecase;

import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.core.exception.modificarMascotaException;
import ar.edu.undec.mascotas.core.repositorio.IConsultarMascotaRepositorio;
import ar.edu.undec.mascotas.core.repositorio.IModificarMascotaRepositorio;
import ar.edu.undec.mascotas.core.usecase.input.IModificarMascotaUseCase;

public class ModificarMascotaUseCase implements IModificarMascotaUseCase {


    private IModificarMascotaRepositorio modificarMascotaRepositorio;
    private IConsultarMascotaRepositorio consultarMascotaRepositorio;


    public ModificarMascotaUseCase(IConsultarMascotaRepositorio consultaMascotaPorNombreRepositorio, IModificarMascotaRepositorio modificarMascotaRepositorio) {
        this.modificarMascotaRepositorio = modificarMascotaRepositorio;
        this.consultarMascotaRepositorio = consultaMascotaPorNombreRepositorio;
    }

    public Mascota modificarMascota(Mascota mascotaModificada) throws modificarMascotaException {
        Mascota mascotaParaModificar = consultarMascotaRepositorio.findByNombre(mascotaModificada.getNombre());
        mascotaParaModificar.modificarDatos(mascotaModificada);

        if(!modificarMascotaRepositorio.update(mascotaParaModificar)){
            throw new modificarMascotaException();
        }else {
            return mascotaParaModificar;
        }
    }
}
