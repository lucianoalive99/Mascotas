package ar.edu.undec.mascotas.core.usecase.input;

import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.core.exception.clienteMenorEdadException;
import ar.edu.undec.mascotas.core.exception.documentoExisteException;

public interface ICrearClientetaUseCase {
    boolean crearCliente (Cliente elCliente) throws documentoExisteException, clienteMenorEdadException;
}
