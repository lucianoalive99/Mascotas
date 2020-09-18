package ar.edu.undec.mascotas.usecase.input;

import ar.edu.undec.mascotas.doamain.Cliente;
import ar.edu.undec.mascotas.exception.clienteMenorEdadException;
import ar.edu.undec.mascotas.exception.documentoExisteException;

public interface ICrearClientetaUseCase {
    boolean crearCliente (Cliente elCliente) throws documentoExisteException, clienteMenorEdadException;
}
