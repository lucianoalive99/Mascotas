package ar.edu.undec.mascotas.doamain;

import java.time.LocalDate;

public class Cliente {

    private final String apellido;
    private final String nombre;
    private final String documento;
    private final LocalDate fechanacimiento;

    private Cliente(String apellido, String nombre, String documento, LocalDate fechanacimiento) {

        this.apellido = apellido;
        this.nombre = nombre;
        this.documento = documento;
        this.fechanacimiento = fechanacimiento;
    }

    public static Cliente instancia(String apellido, String nombre, String documento, LocalDate fechanacimiento) {
        return new Cliente(apellido,nombre,documento,fechanacimiento);
    }

    public String getDocumento() {
        return documento;
    }

    public LocalDate getFechaNacimiento() {
        return fechanacimiento;
    }
}
