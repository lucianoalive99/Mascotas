package ar.edu.undec.mascotas.controller.endpoint;

import ar.edu.undec.mascotas.controller.dtomodel.MascotaDTO;
import ar.edu.undec.mascotas.core.doamain.Mascota;
import ar.edu.undec.mascotas.core.exception.mascotaExisteException;
import ar.edu.undec.mascotas.core.usecase.input.ICrearMascotaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/veterinaria")
public class CrearMascotaController {

    @Autowired
    ICrearMascotaUseCase crearMascotaUseCase;

    @PostMapping(value = "/mascotas")
    public ResponseEntity<?> crearMascota(MascotaDTO mascotaDTO, String documento){
        Mascota laMascota = Mascota.instancia(mascotaDTO.getNombre(),mascotaDTO.getRaza(),mascotaDTO.getFechaNacimiento());
        try {
            boolean resultado = crearMascotaUseCase.crearMascota(laMascota,documento);
            return ResponseEntity.status(HttpStatus.OK).body(resultado);
        } catch (mascotaExisteException existeLaMascota) {
            existeLaMascota.printStackTrace();
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(existeLaMascota.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
        }
    }
}
