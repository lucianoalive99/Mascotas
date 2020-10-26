package ar.edu.undec.mascotas.usecaseunittest;


import Mockito.MockitoExtension;
import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.core.exception.clienteMenorEdadException;
import ar.edu.undec.mascotas.core.exception.documentoExisteException;
import ar.edu.undec.mascotas.core.repositorio.ICrearClienteRepositorio;
import ar.edu.undec.mascotas.core.usecase.CrearClienteUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearClienteUseCaseUnitTest {

    @Mock
    ICrearClienteRepositorio crearClienteRepositorio;
    @Test
    void crearCliente_clienteNoExiste_creaCliente() throws Exception {
        //arrange
        List<Mascota> listaMascotas = null;
        Cliente elCliente = Cliente.instancia("Alive","Luciano","35064555",
                LocalDate.of(1990,4,13), listaMascotas);
        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(crearClienteRepositorio);

        //base de datos
        when(crearClienteRepositorio.existeDocumento(elCliente.getDocumento())).thenReturn(false);
        when(crearClienteRepositorio.menorDeEdad(elCliente.getFechaNacimiento())).thenReturn(false);
        when(crearClienteRepositorio.guardarCliente(elCliente)).thenReturn(true);
        //act

        //assert
        Assertions.assertTrue(crearClienteUseCase.crearCliente(elCliente));
    }

    @Test
    void crearCliente_clienteNoExiste_clienteMenorDeEdad() throws Exception {
        //arrange
        List<Mascota> listaMascotas = null;
        Cliente elCliente = Cliente.instancia("Alive","Luciano","35064555",
                LocalDate.of(2003,4,13), listaMascotas);
        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(crearClienteRepositorio);

        //base de datos
        when(crearClienteRepositorio.existeDocumento(elCliente.getDocumento())).thenReturn(false);
        when(crearClienteRepositorio.menorDeEdad(elCliente.getFechaNacimiento())).thenReturn(true);
        //act

        //assert
        Assertions.assertThrows(clienteMenorEdadException.class,()-> crearClienteUseCase.crearCliente(elCliente));
    }

    @Test
    void crearCliente_clienteExiste_documentoExisteException() throws Exception {
        //arrange
        List<Mascota> listaMascotas = null;
        Cliente elCliente = Cliente.instancia("Alive","Luciano","35064555",
                LocalDate.of(2003,4,13), listaMascotas);
        CrearClienteUseCase crearClienteUseCase = new CrearClienteUseCase(crearClienteRepositorio);

        //base de datos
        when(crearClienteRepositorio.existeDocumento(elCliente.getDocumento())).thenReturn(true);
        when(crearClienteRepositorio.menorDeEdad(elCliente.getFechaNacimiento())).thenReturn(false);
        //act

        //assert
        Assertions.assertThrows(documentoExisteException.class,()-> crearClienteUseCase.crearCliente(elCliente));
    }
}
