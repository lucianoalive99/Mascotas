package ar.edu.undec.mascotas.persistenceunittest;

import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.persistencia.CreaClienteRespositoriImplemtation;
import ar.edu.undec.mascotas.persistencia.crud.ICrearClienteCRUD;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CrearClienteDataTest {

    @Autowired
    CreaClienteRespositoriImplemtation creaClienteRespositoriImplemtation;

    @Mock
    ICrearClienteCRUD crearClienteCRUD;

    @Test
    public void crearCliente_ClienteNoExiste_CrearCorrectamente(){
        List<Mascota> mascotaList = new ArrayList<>();
        Mascota mascota1 = Mascota.instancia("simon","boxer", LocalDate.of(2015,2,11));
        Mascota mascota2 = Mascota.instancia("simon","caniche", LocalDate.of(2018,5,22));
        mascotaList.add(mascota1);
        mascotaList.add(mascota2);

        Cliente elCliente = Cliente.instancia("Alive","Luciano","35064555",
                LocalDate.of(1990,4,13), mascotaList);

        boolean resultado = creaClienteRespositoriImplemtation.guardarCliente(elCliente);
        Assertions.assertTrue(resultado);
    }
}
