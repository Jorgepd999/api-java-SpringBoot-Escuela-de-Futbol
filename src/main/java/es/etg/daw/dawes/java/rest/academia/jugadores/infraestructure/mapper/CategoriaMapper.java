package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.mapper;

import java.util.ArrayList;
import java.util.List;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.Categoria;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.CategoriaId;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.db.jpa.entity.CategoriaJpaEntity;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.categoria.CategoriaRequest;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.categoria.CategoriaResponse;

public class CategoriaMapper {

    public static CreateCategoriaCommand toCommand(CategoriaRequest categoriaRequest) {
        return new CreateCategoriaCommand(categoriaRequest.nombre());
    }

    public static EditCategoriaCommand toCommand(int id, CategoriaRequest categoriaRequest) {
        return new EditCategoriaCommand(new CategoriaId(id), categoriaRequest.nombre());
    }

    public static CategoriaResponse toResponse(Categoria categoria) {
        return new CategoriaResponse(categoria.getId().getValue(),
                categoria.getNombre(),
                categoria.getCreatedAt());
    }

    public static CategoriaJpaEntity toEntity(Categoria c) {

        CategoriaId id = c.getId();

        return CategoriaJpaEntity.builder()
                .id(id != null ? id.getValue() : null)
                .nombre(c.getNombre())
                .build();
    }

    public static Categoria toDomain(CategoriaJpaEntity ce) {

        return Categoria.builder()
                .id(new CategoriaId(ce.getId()))
                .nombre(ce.getNombre())
                .build();
    }

    public static List<Categoria> toDomain(List<CategoriaJpaEntity> lista) {
        List<Categoria> lc = new ArrayList<>();
        for (CategoriaJpaEntity ce : lista) {
            lc.add(toDomain(ce));
        }
        return lc;
    }

}