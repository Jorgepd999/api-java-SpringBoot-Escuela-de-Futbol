package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.categoria.CreateCategoriaService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.categoria.DeleteCategoriaService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.categoria.EditCategoriaService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.categoria.FindCategoriaService;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.categoria.CreateCategoriaUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.categoria.DeleteCategoriaUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.categoria.EditCategoriaUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.categoria.FindCategoriaUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class CategoriaConfig {

    private final CategoriaRepository categoriaRepository;

    // Método POST
    @Bean
    public CreateCategoriaUseCase createCategoriaUseCase() {
        return new CreateCategoriaUseCase(categoriaRepository);
    }

    @Bean
    public CreateCategoriaService createCategoriaService() {
        return new CreateCategoriaService(createCategoriaUseCase());
    }

    // Método GET
    @Bean
    public FindCategoriaUseCase findCategoriaUseCase() {
        return new FindCategoriaUseCase(categoriaRepository);
    }

    @Bean
    public FindCategoriaService findCategoriaService() {
        return new FindCategoriaService(findCategoriaUseCase());
    }

    // Método DELETE
    @Bean
    public DeleteCategoriaUseCase deleteCategoriaUseCase() {
        return new DeleteCategoriaUseCase(categoriaRepository);
    }

    @Bean
    public DeleteCategoriaService deleteCategoriaService() {
        return new DeleteCategoriaService(deleteCategoriaUseCase());
    }

    // Método PUT
    @Bean
    public EditCategoriaUseCase editCategoriaUseCase() {
        return new EditCategoriaUseCase(categoriaRepository);
    }

    @Bean
    public EditCategoriaService editCategoriaService() {
        return new EditCategoriaService(editCategoriaUseCase());
    }
}