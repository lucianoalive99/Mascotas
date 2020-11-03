package ar.edu.undec.mascotas.persistencia.crud;

import ar.edu.undec.mascotas.persistencia.entity.ClienteEntity;
import ar.edu.undec.mascotas.persistencia.entity.MascotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface IConsultarMascotaCRUD extends CrudRepository<MascotaEntity,Integer> {
    //@Query("select d from mascotas d where mascotas.cliente= :idcliente")
    //Collection<MascotaEntity> findAllByCliente_Idcliente(@Param("idcliente")Integer idcliente);
}
