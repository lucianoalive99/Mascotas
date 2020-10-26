package ar.edu.undec.mascotas.core.usecase;

import ar.edu.undec.mascotas.core.doamain.Cliente;
import ar.edu.undec.mascotas.core.exception.modificarClienteException;
import ar.edu.undec.mascotas.core.repositorio.IConsultarClienteRepositorio;
import ar.edu.undec.mascotas.core.repositorio.IModificarClienteRepositorio;
import ar.edu.undec.mascotas.core.usecase.input.IModificarClienteUseCase;

public class ModificarClienteUseCase implements IModificarClienteUseCase {

    private IConsultarClienteRepositorio consultaClientePorDocumentoRepositorio;
    private IModificarClienteRepositorio modificarClienteRepositorio;

    public ModificarClienteUseCase(IConsultarClienteRepositorio consultaClientePorDocumentoRepositorio,
                                   IModificarClienteRepositorio modificarClienteRepositorio) {

        this.consultaClientePorDocumentoRepositorio=consultaClientePorDocumentoRepositorio;
        this.modificarClienteRepositorio=modificarClienteRepositorio;
    }

    public Cliente modificarCliente(Cliente clienteModificado) throws modificarClienteException {
        Cliente clienteParaModificar = consultaClientePorDocumentoRepositorio.findByDocumento(clienteModificado.getDocumento());
        clienteParaModificar.modificarDatosCliente(clienteModificado);

        if(!modificarClienteRepositorio.update(clienteParaModificar)){
            throw new modificarClienteException();
        }else {
            return clienteParaModificar;
        }
    }
}
