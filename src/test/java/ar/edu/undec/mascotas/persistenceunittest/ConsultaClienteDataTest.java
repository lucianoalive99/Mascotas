package ar.edu.undec.mascotas.persistenceunittest;

import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.persistencia.ConsultaClienteRepositoriImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConsultaClienteDataTest {

    @Autowired
    ConsultaClienteRepositoriImplementation consultaClienteRepositoriImplementation;

    @Test
    void consultarClientePorDocumento_ClienteExiste_ClienteDevuelto(){

        Cliente elCliente = consultaClienteRepositoriImplementation.findByDocumento("35064555");

        Assertions.assertEquals("35064555", elCliente.getDocumento());

    }
}
