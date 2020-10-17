package ar.edu.undec.mascotas.usecase;

import ar.edu.undec.mascotas.doamain.Mascota;
import ar.edu.undec.mascotas.repositorio.IConsultarMascotaRepositorio;
import ar.edu.undec.mascotas.usecase.input.IConsultarMascotaUseCase;

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
