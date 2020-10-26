package ar.edu.undec.mascotas.core.exception;

public class modificarClienteException extends Exception {
    public modificarClienteException() {
        super();
        System.out.println("El Cliente no se pudo modificar.");
    }
}
