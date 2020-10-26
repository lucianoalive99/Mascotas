package ar.edu.undec.mascotas.persistencia.crud;

import ar.edu.undec.mascotas.persistencia.entity.ClienteEntity;
import org.springframework.data.repository.CrudRepository;

public interface IConsultarClienteCRUD extends CrudRepository<ClienteEntity, Integer> {
}
