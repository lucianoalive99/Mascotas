package ar.edu.undec.mascotas.exception;

public class mascotaExisteException extends Exception{
    public mascotaExisteException(String salida) {
        super();
        System.out.println(salida);
    }
}
