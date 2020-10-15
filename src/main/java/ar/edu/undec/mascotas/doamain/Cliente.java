package ar.edu.undec.mascotas.doamain;

import java.time.LocalDate;
import java.util.List;

public class Cliente {

    private String apellido;
    private String nombre;
    private final String documento;
    private LocalDate fechanacimiento;
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
    private List<Mascota> getListaMAscotas() {
        return listaMascotas;
    }

    private String getNombre() {
        return nombre;
    }

    private String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechanacimiento;
    }

    public void modificarDatosCliente(Cliente clienteModificado) {
        this.apellido = clienteModificado.getApellido();
        this.nombre = clienteModificado.getNombre();
        this.fechanacimiento = clienteModificado.getFechaNacimiento();
        this.listaMascotas = clienteModificado.getListaMAscotas();
    }


}
