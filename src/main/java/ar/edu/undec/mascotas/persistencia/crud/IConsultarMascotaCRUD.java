package ar.edu.undec.mascotas.persistencia.crud;

import ar.edu.undec.mascotas.persistencia.entity.MascotaEntity;
import org.springframework.data.repository.CrudRepository;

public interface IConsultarMascotaCRUD extends CrudRepository<MascotaEntity,Integer> {
}
