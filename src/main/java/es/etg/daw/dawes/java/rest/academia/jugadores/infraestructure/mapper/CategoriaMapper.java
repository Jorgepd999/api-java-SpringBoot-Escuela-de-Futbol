package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.mapper;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.categoria.CreateCategoriaCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.categoria.EditCategoriaCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.Categoria;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.CategoriaId;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.categoria.CategoriaRequest;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.dto.categoria.CategoriaResponse;

public class CategoriaMapper {

    public static CreateCategoriaCommand toCommand(CategoriaRequest categoriaRequest){
        return new CreateCategoriaCommand(categoriaRequest.nombre());
    }
    public static EditCategoriaCommand toCommand(int id, CategoriaRequest categoriaRequest){
        return new EditCategoriaCommand(new CategoriaId(id),categoriaRequest.nombre());
    }
    public static CategoriaResponse toResponse(Categoria categoria){
        return new CategoriaResponse(categoria.getId().getValue(),
                                      categoria.getNombre(),
                                      categoria.getCreatedAt());
    }

}