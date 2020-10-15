package ar.edu.undec.mascotas.usecase.input;

import ar.edu.undec.mascotas.doamain.Cliente;
import ar.edu.undec.mascotas.exception.modificarClienteException;

public interface IModificarClienteUseCase {
    Cliente modificarCliente(Cliente clienteParaModificar) throws modificarClienteException;
}
