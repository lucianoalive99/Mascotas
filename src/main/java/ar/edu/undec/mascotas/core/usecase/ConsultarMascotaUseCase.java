package ar.edu.undec.mascotas.core.usecase;

import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.core.repositorio.IConsultarMascotaRepositorio;
import ar.edu.undec.mascotas.core.usecase.input.IConsultarMascotaUseCase;

import java.util.List;

public class ConsultarMascotaUseCase implements IConsultarMascotaUseCase {

    private IConsultarMascotaRepositorio consultarMascotaRepositorio;

    public ConsultarMascotaUseCase(IConsultarMascotaRepositorio consultarMascotaRepositorio){
        this.consultarMascotaRepositorio = consultarMascotaRepositorio;
    }

    @Override
    public List<Mascota> consultarMascotas() {
        return this.consultarMascotaRepositorio.findAll();
    }
}
