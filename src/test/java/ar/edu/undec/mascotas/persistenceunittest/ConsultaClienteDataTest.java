package ar.edu.undec.mascotas.persistenceunittest;

import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.persistencia.ConsultaClienteRepositoriImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collection;

@SpringBootTest
public class ConsultaClienteDataTest {

    @Autowired
    ConsultaClienteRepositoriImplementation consultaClienteRepositoriImplementation;

    @Test
    void consultarClientePorDocumento_ClienteExiste_ClienteDevuelto(){

        Cliente elCliente = consultaClienteRepositoriImplementation.findByDocumento("35064666");

        Assertions.assertEquals("35064666", elCliente.getDocumento());

    }

    @Test
    void consultarClientes_ClientesExisten_ClientesDevueltos(){
        Collection<Cliente> clienteCollection;
                clienteCollection=consultaClienteRepositoriImplementation.findAll();

        Assertions.assertNotNull(clienteCollection);

    }
}
