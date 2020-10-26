package ar.edu.undec.mascotas.core.repositorio;

import ar.edu.undec.mascotas.core.doamain.Cliente;

import java.time.LocalDate;

public interface ICrearClienteRepositorio {
    boolean existeDocumento(String documento);

    boolean guardarCliente(Cliente elCliente);

    boolean menorDeEdad(LocalDate fechaNacimiento);
}
