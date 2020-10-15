package ar.edu.undec.mascotas.repositorio;

import ar.edu.undec.mascotas.doamain.Cliente;

public interface IConsultarClienteRepositorio {
    Cliente findByDocumento(String documento);
}
