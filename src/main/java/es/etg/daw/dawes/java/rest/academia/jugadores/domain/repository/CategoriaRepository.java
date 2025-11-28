package es.etg.daw.dawes.java.rest.academia.jugadores.domain.repository;

import es.etg.daw.dawes.java.rest.academia.common.domain.repository.CRUDRepository;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.Categoria;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.CategoriaId;


public interface CategoriaRepository extends CRUDRepository<Categoria, CategoriaId>{
    
}
