package ar.edu.undec.mascotas.usecase;

import ar.edu.undec.mascotas.doamain.Cliente;
import ar.edu.undec.mascotas.exception.clienteMenorEdadException;
import ar.edu.undec.mascotas.exception.documentoExisteException;
import ar.edu.undec.mascotas.repositorio.IcrearClienteRepositorio;

import java.time.LocalDate;
import java.time.Period;

public class CrearClienteUseCase {
    private IcrearClienteRepositorio crearClienteRepositorio;

    public CrearClienteUseCase(IcrearClienteRepositorio crearClienteRepositorio) {

        this.crearClienteRepositorio = crearClienteRepositorio;
    }

    public boolean crearCliente(Cliente elCliente) throws Exception {
        if(crearClienteRepositorio.existeDocumento(elCliente.getDocumento())){
            throw new documentoExisteException("El numero de documento del cliente ya existe en el sistema");
        }
        else{
            if (crearClienteRepositorio.menorDeEdad(elCliente.getFechaNacimiento())){
                throw new clienteMenorEdadException("El Cliente es menor de edad, no se puede cargar en el sistema.");
            }else{
                crearClienteRepositorio.guardarCliente(elCliente);
                return true;
            }
        }
    }

}
