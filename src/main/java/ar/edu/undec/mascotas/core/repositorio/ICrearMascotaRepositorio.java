package ar.edu.undec.mascotas.core.repositorio;

import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.core.doamain.Mascota;

public interface ICrearMascotaRepositorio {
    boolean existe(String nombreMascota);

    boolean guardarMascota(Mascota laMascota,String documento);
}
