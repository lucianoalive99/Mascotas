package ar.edu.undec.mascotas.core.usecase;

import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.core.repositorio.IConsultarClienteRepositorio;
import ar.edu.undec.mascotas.core.usecase.input.IConsultarClienteUseCase;

import java.util.List;

public class ConsultarClienteUseCase implements IConsultarClienteUseCase {

    private IConsultarClienteRepositorio consultarClienteRepositorio;


    public ConsultarClienteUseCase(IConsultarClienteRepositorio consultarClienteRepositorio) {
        this.consultarClienteRepositorio = consultarClienteRepositorio;
    }


    @Override
    public List<Cliente> consultarClientes() {
        return this.consultarClienteRepositorio.findAll();
    }
}
