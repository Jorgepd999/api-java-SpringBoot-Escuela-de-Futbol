package es.etg.daw.dawes.java.rest.instituto.alumnos.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.rest.instituto.alumnos.application.useCase.CreateAlumnoUseCase;
import es.etg.daw.dawes.java.rest.instituto.alumnos.application.useCase.DeleteAlumnoUseCase;
import es.etg.daw.dawes.java.rest.instituto.alumnos.application.useCase.FindAlumnoUseCase;
import es.etg.daw.dawes.java.rest.instituto.alumnos.application.service.CreateAlumnoUseService;
import es.etg.daw.dawes.java.rest.instituto.alumnos.application.service.DeleteAlumnoUseService;
import es.etg.daw.dawes.java.rest.instituto.alumnos.application.service.FindAlumnoUseService;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class AlumnoConfig {
    //Metodo POST
    @Bean
    public CreateAlumnoUseCase createAlumnoUseCase(){
        return new CreateAlumnoUseCase();
    }
  //Metodo POST
    @Bean
    public CreateAlumnoUseService createAlumnoUseService(){
        return new CreateAlumnoUseService(createAlumnoUseCase());
    }
    //Metodo GET
     @Bean
    public FindAlumnoUseCase findAlumnoUseCase(){
        return new FindAlumnoUseCase();
    }
    //Metodo GET
    @Bean
    public FindAlumnoUseService findAlumnoUseService(){
        return new FindAlumnoUseService(findAlumnoUseCase());
    }

    @Bean
    //Metodo DELETE
    public DeleteAlumnoUseCase deleteAlumnoUseCase(){
        return new DeleteAlumnoUseCase();
    }
    //Metodo DELETE
    @Bean
    public DeleteAlumnoUseService deleteAlumnoUseService(){
        return new DeleteAlumnoUseService(deleteAlumnoUseCase());
    }
}

