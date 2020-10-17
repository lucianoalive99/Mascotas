package ar.edu.undec.mascotas.repositorio;

import ar.edu.undec.mascotas.doamain.Mascota;

import java.util.List;

public interface IConsultarMascotaRepositorio {
    Mascota findByNombre(String nombre);

    List<Mascota> findAll();
}
