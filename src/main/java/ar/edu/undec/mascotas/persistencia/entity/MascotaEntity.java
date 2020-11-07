package ar.edu.undec.mascotas.persistencia.entity;

import ar.edu.undec.mascotas.core.doamain.Mascota;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name ="mascotas")
@SequenceGenerator(name="mascotas_id_seq", initialValue = 1, sequenceName = "mascotas_id_seq",allocationSize = 1)
public class MascotaEntity{

    @Id
    @Column(name="idmascota")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mascotas_id_seq")
    private Integer idMascota;

    @Column(name="nombre")
    private String nombre;
    @Column(name="raza")
    private String raza;
    @Column(name="fechanacimiento")
    private LocalDate fechaNacimiento;


    public MascotaEntity() {
    }

    public void setIdMascota(Integer idMascota) {
        this.idMascota = idMascota;
    }

    public Integer getIdMascota() {
        return idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public static Mascota mascotaEntityToMascota(MascotaEntity mascotaEntity){
        Mascota mascota = new Mascota();
        mascota.setNombre(mascotaEntity.getNombre());
        mascota.setRaza(mascotaEntity.getRaza());
        mascota.setFechaNacimiento(mascotaEntity.getFechaNacimiento());

        return mascota;
    }

    public static MascotaEntity mascotaToMascotaEntity(Mascota mascota){
        MascotaEntity mascotaEntity = new MascotaEntity();
        mascotaEntity.setNombre(mascota.getNombre());
        mascotaEntity.setRaza(mascota.getRaza());
        mascotaEntity.setFechaNacimiento(mascota.getFechaNacimiento());

        return mascotaEntity;
    }
}
