package ar.edu.undec.mascotas.exception;

public class clienteMenorEdadException extends Exception {
    public clienteMenorEdadException(String salida) {
        super();
        System.out.println(salida);
    }
}
