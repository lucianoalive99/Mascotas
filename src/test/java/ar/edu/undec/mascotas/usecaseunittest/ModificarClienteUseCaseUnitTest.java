package ar.edu.undec.mascotas.usecaseunittest;

import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.core.exception.modificarClienteException;
import ar.edu.undec.mascotas.core.repositorio.IConsultarClienteRepositorio;
import ar.edu.undec.mascotas.core.repositorio.IModificarClienteRepositorio;
import ar.edu.undec.mascotas.core.usecase.ModificarClienteUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class ModificarClienteUseCaseUnitTest {

    @Mock
    IModificarClienteRepositorio modificarClienteRepositorio;
    @Mock
    IConsultarClienteRepositorio consultaClientePorDocumentoRepositorio;

    @Test
    void modificarCliente_DatosCorrectos_DatosModificados() throws modificarClienteException {
        Mascota mascota1 = Mascota.instancia("simon","boxer", LocalDate.of(2015,2,11));
        Mascota mascota2 = Mascota.instancia("simon","caniche", LocalDate.of(2018,5,22));

        List<Mascota> listaMascotas1 = new ArrayList<>();
        List<Mascota> listaMascotas2 = new ArrayList<>();
        listaMascotas1.add(mascota1);
        listaMascotas2.add(mascota2);

        Cliente ClienteSinModificar = Cliente.instancia("Alive","Luciano","35064555",
                LocalDate.of(2003,4,13), listaMascotas1);
        Cliente ClienteModificado = Cliente.instancia("Oviedo","Sebastian","35064555",
                LocalDate.of(2003,4,13), listaMascotas2);

        when(consultaClientePorDocumentoRepositorio.findByDocumento("35064555")).thenReturn(ClienteSinModificar);
        when(modificarClienteRepositorio.update(ClienteSinModificar)).thenReturn(true);

        ModificarClienteUseCase modificarClienteUseCase = new ModificarClienteUseCase
                (consultaClientePorDocumentoRepositorio, modificarClienteRepositorio);

        Cliente elCliente = modificarClienteUseCase.modificarCliente(ClienteModificado);

        Assertions.assertEquals("35064555", elCliente.getDocumento());
    }


}
