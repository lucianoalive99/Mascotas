package ar.edu.undec.mascotas.usecase;

import ar.edu.undec.mascotas.doamain.Cliente;
import ar.edu.undec.mascotas.repositorio.IConsultarClienteRepositorio;
import ar.edu.undec.mascotas.usecase.input.IConsultarClienteUseCase;

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
