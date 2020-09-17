package ar.edu.undec.mascotas.repositorio;

import ar.edu.undec.mascotas.doamain.Cliente;

import java.time.LocalDate;

public interface IcrearClienteRepositorio {
    boolean existeDocumento(String documento);

    boolean guardarCliente(Cliente elCliente);

    boolean menorDeEdad(LocalDate fechaNacimiento);
}
