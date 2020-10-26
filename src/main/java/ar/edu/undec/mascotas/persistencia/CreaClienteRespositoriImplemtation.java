package ar.edu.undec.mascotas.persistencia;

import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.core.repositorio.ICrearClienteRepositorio;
import ar.edu.undec.mascotas.persistencia.crud.ICrearClienteCRUD;
import ar.edu.undec.mascotas.persistencia.crud.ICrearMascotaCRUD;
import ar.edu.undec.mascotas.persistencia.entity.ClienteEntity;
import ar.edu.undec.mascotas.persistencia.entity.MascotaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreaClienteRespositoriImplemtation implements ICrearClienteRepositorio {

    @Autowired
    ICrearClienteCRUD crearClienteCRUD;
    @Autowired
    ICrearMascotaCRUD crearMascotaCRUD;

    @Override
    public boolean existeDocumento(String documento) {
        return false;
    }

    @Override
    public boolean guardarCliente(Cliente elCliente) {
        ClienteEntity clienteEntity = new ClienteEntity();
        List<MascotaEntity> listamascotaEntity = new ArrayList<>();

        clienteEntity.setApellido(elCliente.getApellido());
        clienteEntity.setNombre(elCliente.getNombre());
        clienteEntity.setDocumento(elCliente.getDocumento());
        clienteEntity.setFechanacimiento(elCliente.getFechaNacimiento());
        crearClienteCRUD.save(clienteEntity);

        for (Mascota mascota : elCliente.getListaMascotas()) {
            MascotaEntity mascotaEnti = MascotaEntity.mascotaToMascotaEntity(clienteEntity,mascota);
            crearMascotaCRUD.save(mascotaEnti);
        }
        return this.crearClienteCRUD.save(clienteEntity).getIdcliente()!=null;
    }

    @Override
    public boolean menorDeEdad(LocalDate fechaNacimiento) {
        return false;
    }
}
