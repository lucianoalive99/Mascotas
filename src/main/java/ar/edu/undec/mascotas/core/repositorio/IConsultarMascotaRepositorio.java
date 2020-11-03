package ar.edu.undec.mascotas.core.repositorio;

import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.persistencia.entity.MascotaEntity;
import org.hibernate.secure.spi.JaccPermissionDeclarations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IConsultarMascotaRepositorio {
    Mascota findByNombre(String nombre);

    List<Mascota> devolverMAscotas();


}
