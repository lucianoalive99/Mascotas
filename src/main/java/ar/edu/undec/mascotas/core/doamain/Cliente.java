package ar.edu.undec.mascotas.core.doamain;

import java.time.LocalDate;
import java.util.List;

public class Cliente {

    private String apellido;
    private String nombre;
    private String documento;
    private LocalDate fechanacimiento;
    private List<Mascota> listaMascotas;

    public Cliente(String apellido, String nombre, String documento, LocalDate fechanacimiento, List<Mascota> listaMascotas) {

        this.apellido = apellido;
        this.nombre = nombre;
        this.documento = documento;
        this.fechanacimiento = fechanacimiento;
        this.listaMascotas = listaMascotas;

    }

    public Cliente() {

    }

    public static Cliente instancia(String apellido, String nombre, String documento, LocalDate fechanacimiento, List<Mascota> listaMascotas) {
        return new Cliente(apellido,nombre,documento,fechanacimiento, listaMascotas);
    }

    public String getDocumento() {
        return documento;
    }
    public List<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechanacimiento;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public void modificarDatosCliente(Cliente clienteModificado) {
        this.apellido = clienteModificado.getApellido();
        this.nombre = clienteModificado.getNombre();
        this.fechanacimiento = clienteModificado.getFechaNacimiento();
        this.listaMascotas = clienteModificado.getListaMascotas();
    }


}
