package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.CreateJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.DeleteJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.EditJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.FindJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.CreateJugadorUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.DeleteJugadorUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.EditJugadorUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.FindJugadorUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.repository.JugadorRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class JugadorConfig {

    private final JugadorRepository jugadorRepository;
    //Metodo POST
    @Bean
    public CreateJugadorUseCase createJugadorUseCase(){
        return new CreateJugadorUseCase(jugadorRepository);
    }
  //Metodo POST
    @Bean
    public CreateJugadorUseService createJugadorUseService(){
        return new CreateJugadorUseService(createJugadorUseCase());
    }
    //Metodo GET
     @Bean
    public FindJugadorUseCase findJugadorUseCase(){
        return new FindJugadorUseCase(jugadorRepository);
    }
    //Metodo GET
    @Bean
    public FindJugadorUseService findJugadorUseService(){
        return new FindJugadorUseService(findJugadorUseCase());
    }

    @Bean
    //Metodo DELETE
    public DeleteJugadorUseCase deleteJugadorUseCase(){
        return new DeleteJugadorUseCase(jugadorRepository);
    }
    //Metodo DELETE
    @Bean
    public DeleteJugadorUseService deleteJugadorUseService(){
        return new DeleteJugadorUseService(deleteJugadorUseCase());
    }
    //Metodo PUT
    @Bean
    public EditJugadorUseCase editJugadorUseCase(){
        return new EditJugadorUseCase(jugadorRepository);
    }
    //Metodo PUT
    @Bean 
    public EditJugadorUseService editJugadorUseService(){
        return new EditJugadorUseService(editJugadorUseCase());
    }

}

