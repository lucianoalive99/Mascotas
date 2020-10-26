package ar.edu.undec.mascotas.core.exception;

public class documentoExisteException extends Exception {
    public documentoExisteException(String salida) {
        super();
        System.out.println(salida);
    }
}
