package ar.edu.undec.mascotas.persistencia.entity;

import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.core.doamain.Mascota;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.persistence.criteria.Fetch;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Entity(name="clientes")
@SequenceGenerator(name="clientes_id_seq", initialValue = 1, sequenceName = "clientes_id_seq",allocationSize = 1)
public class ClienteEntity {

    @Id
    @Column(name="idcliente")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientes_id_seq")
    private Integer idcliente;

    @Column(name = "apellido")
    private String apellido;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "documento")
    private String documento;
    @Column(name = "fechanacimiento")
    private LocalDate fechanacimiento;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<MascotaEntity> mascotasById;


    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(LocalDate fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }



    public Collection<MascotaEntity> getMascotasById() {
        return mascotasById;
    }

    public void setMascotasById(Collection<MascotaEntity> mascotasById) {
        this.mascotasById = mascotasById;
    }

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity cliente = (ClienteEntity) o;
        return Objects.equals(idcliente, cliente.idcliente) &&
                Objects.equals(nombre, cliente.nombre) &&
                Objects.equals(apellido, cliente.apellido) &&
                Objects.equals(documento, cliente.documento) &&
                Objects.equals(fechanacimiento, cliente.fechanacimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcliente, nombre, apellido, documento,fechanacimiento);
    }*/

    public ClienteEntity() {
    }

    public static Cliente clienteEntityToCliente(ClienteEntity clienteEntity) {
        Collection<Mascota> mascotaCollection = new ArrayList<>();
        Cliente elCliente = new Cliente();
        elCliente.setNombre(clienteEntity.getNombre());
        elCliente.setApellido(clienteEntity.getApellido());
        elCliente.setDocumento(clienteEntity.getDocumento());
        elCliente.setFechanacimiento(clienteEntity.getFechanacimiento());
        for (MascotaEntity mascotaEntity : clienteEntity.getMascotasById()){
            mascotaCollection.add(MascotaEntity.mascotaEntityToMascota(mascotaEntity));
        }
        elCliente.setCollectionaMascotas(mascotaCollection);

        return elCliente;
    }
}
