package ar.edu.undec.mascotas.usecase.input;

import ar.edu.undec.mascotas.doamain.Cliente;

import java.util.List;

public interface IConsultarClienteUseCase {
    List<Cliente> consultarClientes();
}
