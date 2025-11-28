package es.etg.daw.dawes.java.rest.academia.jugadores.application.service.categoria;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.categoria.EditCategoriaUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.Categoria;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EditCategoriaService {
       private final EditCategoriaUseCase editCategoriaUseCase;

    public Categoria update(EditCategoriaCommand editCategoriaCommand) {
      
        return  editCategoriaUseCase.update(editCategoriaCommand);
    }
}

