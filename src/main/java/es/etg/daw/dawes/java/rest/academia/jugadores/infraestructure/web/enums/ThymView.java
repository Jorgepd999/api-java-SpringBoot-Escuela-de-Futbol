package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.enums;

/**
 * Contiene el listado de plantillas Thymeleaf
 */
public enum ThymView {

    JUGADOR_HOME("jugadores-home"),
    JUGADOR_LIST("jugadores-lista"),
    JUGADOR_DELETE("jugador-borrar"),
    JUGADOR_UPDATE("jugadores-editar"),
    JUGADOR_LIST_PDF("pdf/jugadores-listaPDF"),
    JUGADOR_FORM("jugador-formulario"),
    JUGADOR_CREATED("jugador-creado"),
    JUGADOR_DETAIL("jugadores-detalle"),
    ERROR_GENERIC("error/error-general");

    private final String path;

    ThymView(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
