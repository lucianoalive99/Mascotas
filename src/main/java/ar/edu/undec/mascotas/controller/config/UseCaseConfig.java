package ar.edu.undec.mascotas.controller.config;

import ar.edu.undec.mascotas.core.usecase.CrearMascotaUseCase;
import ar.edu.undec.mascotas.persistencia.CreaMascotaRepositorilmplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {
    @Autowired
    CreaMascotaRepositorilmplementation creaMascotaRepositorilmplementation;
    @Bean
    public CrearMascotaUseCase crearMascotaUseCase(){
        return new CrearMascotaUseCase(creaMascotaRepositorilmplementation);
    }
}
