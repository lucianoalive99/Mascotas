package ar.edu.undec.mascotas.core.usecase.input;

import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.core.exception.modificarClienteException;

public interface IModificarClienteUseCase {
    Cliente modificarCliente(Cliente clienteParaModificar) throws modificarClienteException;
}
