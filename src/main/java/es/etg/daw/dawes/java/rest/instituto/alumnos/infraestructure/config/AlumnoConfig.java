package es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.rest.instituto.alumnos.application.useCase.CreateAlumnoUseCase;
import es.etg.daw.dawes.java.rest.instituto.alumnos.application.service.CreateAlumnoUseService;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AlumnoConfig {
    @Bean
    public CreateAlumnoUseCase createAlumnoUseCase(){
        return new CreateAlumnoUseCase();
    }

    @Bean
    public CreateAlumnoUseService createAlumnoUseService(){
        return new CreateAlumnoUseService(createAlumnoUseCase());
    }
}

