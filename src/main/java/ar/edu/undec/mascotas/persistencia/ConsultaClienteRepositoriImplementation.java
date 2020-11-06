package ar.edu.undec.mascotas.persistencia;

import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.core.repositorio.IConsultarClienteRepositorio;
import ar.edu.undec.mascotas.persistencia.crud.IConsultarClienteCRUD;
import ar.edu.undec.mascotas.persistencia.crud.IConsultarMascotaCRUD;
import ar.edu.undec.mascotas.persistencia.entity.ClienteEntity;
import ar.edu.undec.mascotas.persistencia.entity.MascotaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ConsultaClienteRepositoriImplementation implements IConsultarClienteRepositorio {

    @Autowired
    IConsultarClienteCRUD consultarClienteCRUD;
    @Autowired
    IConsultarMascotaCRUD consultarMascotaCRUD;

    @Override
    public Cliente findByDocumento(String documento) {
        Iterable<ClienteEntity> clienteEntityList = consultarClienteCRUD.findAll();
        Cliente elCliente=new Cliente();

        for (ClienteEntity clienteEntity : clienteEntityList) {
            if(clienteEntity.getDocumento().equals(documento)){
                elCliente=ClienteEntity.clienteEntityToCliente(clienteEntity);}
        }

        return elCliente;
    }

    @Override
    public Collection<Cliente> findAll() {

        Collection<Cliente> clientList = new ArrayList<>();
        //Collection<Mascota> mascotas = new ArrayList<>();
                consultarClienteCRUD.findAll().forEach(clienteEntity ->
                        clientList.add(Cliente.instancia(clienteEntity.getApellido(), clienteEntity.getNombre(),
                                clienteEntity.getDocumento(), clienteEntity.getFechanacimiento(),
                                clienteEntity.getMascotasById().stream().map(
                                        MascotaEntity::mascotaEntityToMascota).
                                        collect(Collectors.toCollection(ArrayList::new)))));



                /*stream().map(mascotaEntity ->
                                        Mascota.instancia(mascotaEntity.getNombre(), mascotaEntity.getRaza(),
                                                mascotaEntity.getFechaNacimiento())).collect(Collectors.toList()))));*/


        return clientList;
    }
}
