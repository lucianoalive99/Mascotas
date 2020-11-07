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
        Mascota mascota1 = Mascota.instancia("gina","caniche", LocalDate.of(2017,3,12));
        Mascota mascota2 = Mascota.instancia("milu","pitbull", LocalDate.of(2019,6,23));
        mascotaList.add(mascota1);
        mascotaList.add(mascota2);

        Cliente elCliente = Cliente.instancia("Alive","Pia","35064000",
                LocalDate.of(2000,7,9),mascotaList);

        boolean resultado = creaClienteRespositoriImplemtation.guardarCliente(elCliente);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearCliente_ClienteMenorEdad_NoCreaCliente(){
        List<Mascota> mascotaList = new ArrayList<>();
        Mascota mascota1 = Mascota.instancia("gina","caniche", LocalDate.of(2017,3,12));
        Mascota mascota2 = Mascota.instancia("milu","pitbull", LocalDate.of(2019,6,23));
        mascotaList.add(mascota1);
        mascotaList.add(mascota2);

        Cliente elCliente = Cliente.instancia("Alive","Pia","35064000",
                LocalDate.of(2005,7,9),mascotaList);

        boolean resultado = creaClienteRespositoriImplemtation.guardarCliente(elCliente);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void crearCliente_DocumentoYaExiste_NoCrearCliente() {
        List<Mascota> mascotaList = new ArrayList<>();
        Mascota mascota1 = Mascota.instancia("gina", "caniche", LocalDate.of(2017, 3, 12));
        Mascota mascota2 = Mascota.instancia("milu", "pitbull", LocalDate.of(2019, 6, 23));
        mascotaList.add(mascota1);
        mascotaList.add(mascota2);

        Cliente elCliente = Cliente.instancia("Alive", "Pia", "35064000",
                LocalDate.of(2000, 7, 9), mascotaList);

        boolean resultado = creaClienteRespositoriImplemtation.guardarCliente(elCliente);
        Assertions.assertTrue(resultado);
    }
}
