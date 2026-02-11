package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.jpa.repository.categoria;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.jpa.entity.CategoriaJpaEntity;

@Repository
public interface CategoriaEntityJpaRepository extends JpaRepository<CategoriaJpaEntity, Integer> {
    // Hereda automáticamente métodos como: save(), findById(), findAll(), delete(), etc.

    public CategoriaJpaEntity findByNombre(String nombre);
}
