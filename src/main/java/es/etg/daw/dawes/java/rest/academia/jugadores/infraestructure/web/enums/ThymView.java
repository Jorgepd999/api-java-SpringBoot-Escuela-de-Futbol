package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.enums;

/**
 * Enum con las rutas a las plantillas Thymeleaf para los jugadores.
 */
public enum ThymView {

    // --- Home ---
    JUGADORES_HOME("jugadores-home"),

    // --- Listados ---
    JUGADORES_LISTA("jugadores-lista"),
    JUGADORES_LISTA_PARA_BORRAR("jugadores-lista-borrar"),
    JUGADORES_LISTA_PARA_MODIFICAR("jugadores-lista-modificar"),

    // --- Formularios ---
    JUGADORES_FORMULARIO_NUEVO("jugadores-formulario-nuevo"),
    JUGADORES_FORMULARIO_EDITAR("jugadores-formulario-editar"),
    JUGADORES_CREADO("jugadores-creado"),

    // --- PDF ---
    JUGADORES_PDF("jugadores-listaPDF");

    private final String path;

    ThymView(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}
