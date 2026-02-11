package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.enums;

/**
 * Representa los posibles atributos que podemos usar
 * en los modelos de la vista
 */
public enum ModelAttribute {
    JUGADOR_LIST("jugadores"),
    CATEGORIA_LIST("categorias"),
    SINGLE_JUGADOR("jugador"),
    ERROR_MESSAGE("errorMsg"),
    SUCCESS_MESSAGE("successMsg");

    private final String name;
    
    ModelAttribute(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
}