package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "JUGADORES")
public class JugadorJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 150)
    private String apellido;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "pierna_habil", nullable = false, length = 20)
    private String piernaHabil;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    private CategoriaJpaEntity categoria;

    public JugadorJpaEntity() {

    }

    public JugadorJpaEntity(Integer id, String nombre, String apellido, int edad, String piernaHabil, String email,
            CategoriaJpaEntity categoria) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.piernaHabil = piernaHabil;

        this.categoria = categoria;
    }
}
