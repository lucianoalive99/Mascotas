package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.doamain.Cliente;
import ar.edu.undec.mascotas.doamain.Mascota;
import ar.edu.undec.mascotas.repositorio.IConsultarClienteRepositorio;
import ar.edu.undec.mascotas.usecase.ConsultarClienteUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConsultarClienteUseCaseUnitTest {

    @Mock
    IConsultarClienteRepositorio consultarClienteRepositorio;

    @Test
    public void ConsultarCliente_ClienteExiste_DevuelveLista(){
        when(consultarClienteRepositorio.findAll()).thenReturn(clientesList());
        ConsultarClienteUseCase consultarClienteUseCase = new ConsultarClienteUseCase(consultarClienteRepositorio);

        List<Cliente> clientesDevueltos = consultarClienteUseCase.consultarClientes();
        Assertions.assertEquals(2,clientesDevueltos.size());

    }
    private List<Cliente> clientesList() {
        List<Mascota> mascotaList1 = new ArrayList<>();
        Mascota mascota1 = Mascota.instancia("simon","boxer", LocalDate.of(2015,2,11));
        Mascota mascota2 = Mascota.instancia("simon","caniche", LocalDate.of(2018,5,22));
        mascotaList1.add(mascota1);
        mascotaList1.add(mascota2);

        List<Mascota> mascotaList2 = new ArrayList<>();
        Mascota mascota3 = Mascota.instancia("sim","box", LocalDate.of(2016,3,15));
        Mascota mascota4 = Mascota.instancia("sim","can", LocalDate.of(2019,8,27));
        mascotaList2.add(mascota3);
        mascotaList2.add(mascota4);

        List<Cliente> clienteList = new ArrayList<>();
        Cliente cliente1 = Cliente.instancia("Alive","Luciano","35064555",
                LocalDate.of(1990,4,13), mascotaList1);
        Cliente cliente2 = Cliente.instancia("Oviedo","Sebastian","24661887",
                LocalDate.of(1991,5,14), mascotaList1);
        clienteList.add(cliente1);
        clienteList.add(cliente2);
        return clienteList;
    }

}
