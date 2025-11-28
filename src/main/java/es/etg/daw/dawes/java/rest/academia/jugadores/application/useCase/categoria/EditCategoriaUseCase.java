package es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.categoria;


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

