package ar.edu.undec.mascotas.core.repositorio;

import ar.edu.undec.mascotas.core.doamain.Cliente;

import java.util.Collection;
import java.util.List;

public interface IConsultarClienteRepositorio {
    Cliente findByDocumento(String documento);

    Collection<Cliente> findAll();
}
