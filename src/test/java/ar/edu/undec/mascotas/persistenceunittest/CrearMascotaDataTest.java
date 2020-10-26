package ar.edu.undec.mascotas.persistenceunittest;

import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.persistencia.CreaMascotaRepositorilmplementation;
import ar.edu.undec.mascotas.persistencia.crud.ICrearMascotaCRUD;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class CrearMascotaDataTest {

    @Autowired
    CreaMascotaRepositorilmplementation creaMascotaRepositorilmplementation;

    @Mock
    ICrearMascotaCRUD crearMascotaCRUD;

    @Test
    public void crearMascota_MascotaNoExiste_CrearCorrectamente(){
        Mascota laMascota = Mascota.instancia("gino","caniche", LocalDate.of(2019,6,1));

        boolean resultado = creaMascotaRepositorilmplementation.guardarMascota(laMascota);
        Assertions.assertTrue(resultado);
    }
}
