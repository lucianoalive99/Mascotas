package ar.edu.undec.mascotas.persistencia;

import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.core.repositorio.IConsultarMascotaRepositorio;
import ar.edu.undec.mascotas.persistencia.crud.IConsultarMascotaCRUD;
import ar.edu.undec.mascotas.persistencia.entity.MascotaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultarMascotasRepositoriImplementation implements IConsultarMascotaRepositorio {

    @Autowired
    IConsultarMascotaCRUD consultarMascotaCRUD;

    @Override
    public Mascota findByNombre(String nombre) {
        Iterable<MascotaEntity> mascotaList = consultarMascotaCRUD.findAll();
        Mascota laMascota = new Mascota();

        for (MascotaEntity mascota: mascotaList) {
            if (mascota.getNombre().equals(nombre)){
                laMascota = MascotaEntity.mascotaEntityToMascota(mascota);}
        }
        return laMascota;
    }

    @Override
    public List<Mascota> findAll() {
        return null;
    }
}
