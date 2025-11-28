package es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.categoria;


import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.error.CategoriaNotFoundException;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.Categoria;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EditCategoriaUseCase {
    private final CategoriaRepository categoriaRepository;

    public Categoria update(EditCategoriaCommand command){

        return categoriaRepository.getById(command.id())
                .map(p -> {
                    p.setNombre(command.nombre());
                    return categoriaRepository.save(p);})
                    .orElseThrow( ()-> new CategoriaNotFoundException(command.id().getValue()));
                
    }
    
}

