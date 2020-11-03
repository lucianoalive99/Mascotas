package ar.edu.undec.mascotas.core.usecase.input;

import ar.edu.undec.mascotas.core.doamain.Cliente;

import java.util.Collection;

public interface IConsultarClienteUseCase {
    Collection<Cliente> consultarClientes();
}
