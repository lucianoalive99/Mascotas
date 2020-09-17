package ar.edu.undec.mascotas.doamain;

import java.time.LocalDate;
import java.util.List;

public class Cliente {

    private final String apellido;
    private final String nombre;
    private final String documento;
    private final LocalDate fechanacimiento;
    private List<Mascota> listaMascotas;

    private Cliente(String apellido, String nombre, String documento, LocalDate fechanacimiento, List<Mascota> listaMascotas) {

        this.apellido = apellido;
        this.nombre = nombre;
        this.documento = documento;
        this.fechanacimiento = fechanacimiento;
        this.listaMascotas = listaMascotas;
    }

    public static Cliente instancia(String apellido, String nombre, String documento, LocalDate fechanacimiento, List<Mascota> listaMascotas) {
        return new Cliente(apellido,nombre,documento,fechanacimiento,listaMascotas);
    }

    public String getDocumento() {
        return documento;
    }

    public LocalDate getFechaNacimiento() {
        return fechanacimiento;
    }
}
