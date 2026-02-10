package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.constants;

public interface WebRoutes {

    // Menú principal
    String JUGADORES_HOME        = "/web/menu";

    // Listados
    String JUGADORES_LISTA       = "/web/jugadores/lista";       // Listado simple
    String JUGADORES_MODIFICAR   = "/web/jugadores/modificar";   // Listado con opción de editar
    String JUGADORES_BORRAR      = "/web/jugadores/borrar";      // Listado con opción de borrar
    String JUGADORES_PDF         = "/web/jugadores/pdf";         // Exportar a PDF

    // Crear jugador
    String JUGADOR_NUEVO         = "/web/jugadores/nuevo";

    // Editar jugador
    String JUGADOR_EDITAR_FORM    = "/web/jugadores/editar/{id}";  // Mostrar formulario
    String JUGADOR_EDITAR_ACTION  = "/web/jugadores/editar/{id}";  // Enviar formulario (POST)

    // Borrar jugador
    String JUGADOR_BORRAR_ID     = "/web/jugadores/borrar/{id}";
}
