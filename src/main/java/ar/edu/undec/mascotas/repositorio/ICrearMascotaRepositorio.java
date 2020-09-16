package ar.edu.undec.mascotas.repositorio;

import ar.edu.undec.mascotas.doamain.Mascota;

public interface ICrearMascotaRepositorio {
    boolean existe(String nombreMascota);

    boolean guardarMascota(Mascota laMascota);
}
