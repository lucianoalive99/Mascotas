package ar.edu.undec.mascotas.core.exception;

public class modificarMascotaException extends Throwable {
    public modificarMascotaException() {
        super();
        System.out.println("La mascota no se pudo modificar.");
    }
}
