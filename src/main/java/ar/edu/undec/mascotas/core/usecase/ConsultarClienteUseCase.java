package ar.edu.undec.mascotas.core.usecase;

import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.core.repositorio.IConsultarClienteRepositorio;
import ar.edu.undec.mascotas.core.usecase.input.IConsultarClienteUseCase;

import java.util.Collection;

public class ConsultarClienteUseCase implements IConsultarClienteUseCase {

    private IConsultarClienteRepositorio consultarClienteRepositorio;


    public ConsultarClienteUseCase(IConsultarClienteRepositorio consultarClienteRepositorio) {
        this.consultarClienteRepositorio = consultarClienteRepositorio;
    }


    @Override
    public Collection<Cliente> consultarClientes() {
        return this.consultarClienteRepositorio.findAll();
    }
}
