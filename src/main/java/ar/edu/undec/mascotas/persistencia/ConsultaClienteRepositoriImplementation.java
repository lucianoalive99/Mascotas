package ar.edu.undec.mascotas.persistencia;

import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.core.repositorio.IConsultarClienteRepositorio;
import ar.edu.undec.mascotas.persistencia.crud.IConsultarClienteCRUD;
import ar.edu.undec.mascotas.persistencia.entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.SecondaryTable;
import java.util.List;
@Service
public class ConsultaClienteRepositoriImplementation implements IConsultarClienteRepositorio {

    @Autowired
    IConsultarClienteCRUD consultarClienteCRUD;

    @Override
    public Cliente findByDocumento(String documento) {
        Iterable<ClienteEntity> clienteEntityList = consultarClienteCRUD.findAll();
        Cliente elCliente=new Cliente();

        for (ClienteEntity clienteEntity : clienteEntityList) {
            if(clienteEntity.getDocumento().equals(documento)){elCliente=ClienteEntity.clienteEntityToCliente(clienteEntity);}
        }

        return elCliente;
    }

    @Override
    public List<Cliente> findAll() {
        return null;
    }
}
