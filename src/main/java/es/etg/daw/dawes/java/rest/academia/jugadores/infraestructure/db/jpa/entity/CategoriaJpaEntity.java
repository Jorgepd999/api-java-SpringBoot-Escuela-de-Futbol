package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.jpa.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@Table(name = "CATEGORIAS")
public class CategoriaJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // Relación inversa (una categoría tiene muchos jugadores)
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<JugadorJpaEntity> jugadores;

    public CategoriaJpaEntity() {
    }

    public CategoriaJpaEntity(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    //Métodos auxiliares para sincronizra productos y categorias
    public void addProducto(JugadorJpaEntity jugador) {
        this.jugadores.add(jugador);
        jugador.setCategoria(this); // Sincroniza el lado Producto
    }

    public void removeProducto(JugadorJpaEntity jugador) {
        this.jugadores.remove(jugador);
        jugador.setCategoria(null); // Desvincula el Producto
    }
}