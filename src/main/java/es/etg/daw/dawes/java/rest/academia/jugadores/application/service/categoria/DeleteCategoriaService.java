package es.etg.daw.dawes.java.rest.academia.jugadores.application.service.categoria;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.categoria.DeleteCategoriaUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.CategoriaId;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DeleteCategoriaService {
    private final DeleteCategoriaUseCase deleteCategoriaUseCase;

    public void delete (CategoriaId id){
        deleteCategoriaUseCase.delete(id);
    }
    
}

