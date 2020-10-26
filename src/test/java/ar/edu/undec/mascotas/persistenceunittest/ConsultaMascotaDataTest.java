package ar.edu.undec.mascotas.persistenceunittest;

import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.core.exception.mascotaExisteException;
import ar.edu.undec.mascotas.persistencia.ConsultarMascotasRepositoriImplementation;
import ar.edu.undec.mascotas.persistencia.crud.IConsultarMascotaCRUD;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConsultaMascotaDataTest {

    @Autowired
    ConsultarMascotasRepositoriImplementation consultarMascotasRepositoriImplementation;

    @Test
    void consultaMascotaPorNombre_MascotaExiste_MascotaDevuelta() {
        Mascota laMascota = consultarMascotasRepositoriImplementation.findByNombre("gina");

        Assertions.assertEquals("gina", laMascota.getNombre());
    }

    /*@Test
    void consultaMascotaPorNombre_MascotaNoExiste_MascotaExisteException() {
        Mascota laMascota = consultarMascotasRepositoriImplementation.findByNombre("franchulo");

        Assertions.assertThrows(mascotaExisteException.class)
    }*/
}
