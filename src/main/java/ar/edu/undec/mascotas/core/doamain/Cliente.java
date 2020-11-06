package ar.edu.undec.mascotas.core.doamain;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collection;

public class Cliente {

    private String apellido;
    private String nombre;
    private String documento;
    private LocalDate fechanacimiento;
    private Collection<Mascota> CollectionaMascotas;

    public Cliente(String apellido, String nombre, String documento, LocalDate fechanacimiento, Collection<Mascota> CollectionaMascotas) {

        this.apellido = apellido;
        this.nombre = nombre;
        this.documento = documento;
        this.fechanacimiento = fechanacimiento;
        this.CollectionaMascotas = CollectionaMascotas;

    }

    public Cliente() {

    }

    public static Cliente instancia(String apellido, String nombre, String documento, LocalDate fechanacimiento, Collection<Mascota> CollectionaMascotas) {
        return new Cliente(apellido,nombre,documento,fechanacimiento, CollectionaMascotas);
    }


    public String getDocumento() {
        return documento;
    }
    public Collection<Mascota> getCollectionaMascotas() {
        return CollectionaMascotas;
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

    public void setCollectionaMascotas(Collection<Mascota> collectionaMascotas) {
        CollectionaMascotas = collectionaMascotas;
    }

    public void modificarDatosCliente(Cliente clienteModificado) {
        this.apellido = clienteModificado.getApellido();
        this.nombre = clienteModificado.getNombre();
        this.fechanacimiento = clienteModificado.getFechaNacimiento();
        this.CollectionaMascotas = clienteModificado.getCollectionaMascotas();
    }


}
