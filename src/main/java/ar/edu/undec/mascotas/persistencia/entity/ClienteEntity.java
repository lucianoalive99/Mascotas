package ar.edu.undec.mascotas.persistencia.entity;

import ar.edu.undec.mascotas.core.doamain.Cliente;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

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


    @OneToMany(mappedBy = "cliente")
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

    public ClienteEntity() {
    }

    public static Cliente clienteEntityToCliente(ClienteEntity clienteEntity) {
        Cliente elCliente = new Cliente();
        elCliente.setNombre(clienteEntity.getNombre());
        elCliente.setApellido(clienteEntity.getApellido());
        elCliente.setDocumento(clienteEntity.getDocumento());
        elCliente.setFechanacimiento(clienteEntity.getFechanacimiento());

        return elCliente;
    }
}
