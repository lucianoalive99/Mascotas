package ar.edu.undec.mascotas.repositorio;

import ar.edu.undec.mascotas.doamain.Cliente;

import java.util.List;

public interface IConsultarClienteRepositorio {
    Cliente findByDocumento(String documento);

    List<Cliente> findAll();
}
