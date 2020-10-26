package ar.edu.undec.mascotas.core.doamain;

import java.time.LocalDate;

public class Mascota {
    private String nombre;
    private String raza;
    private LocalDate fechaNacimiento;

    public Mascota(String nombre, String raza, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Mascota() {

    }

    public static Mascota instancia(String nombre, String raza, LocalDate fechaNacimiento) {
        return new Mascota(nombre,raza,fechaNacimiento);
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void modificarDatos(Mascota mascotaModificada) {
        this.nombre = mascotaModificada.getNombre();
        this.raza = mascotaModificada.getRaza();
        this.fechaNacimiento = mascotaModificada.getFechaNacimiento();
    }
}
