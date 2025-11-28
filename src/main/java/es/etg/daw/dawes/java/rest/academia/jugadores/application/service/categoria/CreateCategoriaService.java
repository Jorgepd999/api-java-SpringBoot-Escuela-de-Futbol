package es.etg.daw.dawes.java.rest.academia.jugadores.application.service.categoria;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.categoria.CreateCategoriaUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.Categoria;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CreateCategoriaService {
    private final CreateCategoriaUseCase createCategoriaUseCase;

    public Categoria createCategoria(CreateCategoriaCommand comando){
        Categoria categoria = createCategoriaUseCase.create(comando);
        return categoria;
    }
}

