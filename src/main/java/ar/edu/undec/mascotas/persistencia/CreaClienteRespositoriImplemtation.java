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
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreaClienteRespositoriImplemtation implements ICrearClienteRepositorio {

    @Autowired
    ICrearClienteCRUD crearClienteCRUD;
    @Autowired
    ICrearMascotaCRUD crearMascotaCRUD;

    @Autowired
    ConsultaClienteRepositoriImplementation consultaClienteRepositoriImplementation;

    @Override
    public boolean existeDocumento(String documento) {
        if(consultaClienteRepositoriImplementation.findByDocumento(documento).getDocumento()==null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean guardarCliente(Cliente elCliente) {

        //Cliente cliente=consultaClienteRepositoriImplementation.findByDocumento(elCliente.getDocumento());

        if(existeDocumento(elCliente.getDocumento())&& !menorDeEdad(elCliente.getFechaNacimiento())){
            ClienteEntity clienteEntity = new ClienteEntity();
            Collection<MascotaEntity> mascotaEntityCollection = new ArrayList<>();

            for (Mascota mascota : elCliente.getCollectionaMascotas()){
                MascotaEntity mascotaEntity = MascotaEntity.mascotaToMascotaEntity(mascota);
                mascotaEntityCollection.add(mascotaEntity);
                //crearMascotaCRUD.save(mascotaEntity);

            }

            clienteEntity.setApellido(elCliente.getApellido());
            clienteEntity.setNombre(elCliente.getNombre());
            clienteEntity.setDocumento(elCliente.getDocumento());
            clienteEntity.setFechanacimiento(elCliente.getFechaNacimiento());
            clienteEntity.setMascotasById(mascotaEntityCollection);

            this.crearClienteCRUD.save(clienteEntity);
            return clienteEntity.getIdcliente()!=null;
        }
        else {
            return false;
        }

    }

    @Override
    public boolean menorDeEdad(LocalDate fechaNacimiento) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        fechaNacimiento.format(fmt);
        LocalDate ahora = LocalDate.now();

        Period periodo = Period.between(fechaNacimiento, ahora);
        if(periodo.getYears()<18){
            return true;
        }else {
            return false;
        }

    }
}
