package es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.categoria;

import java.time.LocalDateTime;


import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CreateCategoriaUseCase {

    private final CategoriaRepository categoriaRepository;

    public Categoria create(CreateCategoriaCommand comando){
        Categoria categoria = Categoria.builder()           
                              .nombre(comando.nombre())
                              .createdAt(LocalDateTime.now()).build();
        return categoriaRepository.save(categoria);
    }
}

