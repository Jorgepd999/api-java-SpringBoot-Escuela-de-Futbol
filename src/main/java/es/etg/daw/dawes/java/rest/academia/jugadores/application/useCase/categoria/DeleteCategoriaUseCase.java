package es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.categoria;


import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.CategoriaId;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteCategoriaUseCase {
    private final CategoriaRepository categoriaRepository;
    public void delete (CategoriaId id){
        categoriaRepository.deleteById(id);
    }
    
}

