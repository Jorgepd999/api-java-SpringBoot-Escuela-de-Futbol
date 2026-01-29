package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.ui.Model;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.FindJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.enums.ModelAttribute;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.enums.ThymView;
import lombok.RequiredArgsConstructor;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.constants.WebRoutes;


@Controller
@RequiredArgsConstructor
public class JugadorViewController {

    private final FindJugadorUseService findJugadorUseService;

    @GetMapping(WebRoutes.JUGADORES_BASE)
    public String listJugadores(Model model) {
        model.addAttribute(ModelAttribute.JUGADOR_LIST.getName(), findJugadorUseService.findAll());
        return ThymView.JUGADOR_LIST.getPath();
    }
 
}



