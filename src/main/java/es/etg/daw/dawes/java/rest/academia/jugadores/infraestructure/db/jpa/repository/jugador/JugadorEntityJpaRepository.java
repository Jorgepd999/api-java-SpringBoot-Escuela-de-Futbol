package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.jpa.repository.jugador;

import org.springframework.data.jpa.repository.JpaRepository;


import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.jpa.entity.JugadorJpaEntity;



public interface JugadorEntityJpaRepository extends JpaRepository<JugadorJpaEntity,Integer> {
    
     public JugadorJpaEntity findByNombre(String nombre);
}
