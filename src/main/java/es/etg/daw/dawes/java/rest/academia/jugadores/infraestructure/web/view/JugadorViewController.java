package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.jugador.CreateJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.categoria.FindCategoriaService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.CreateJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.FindJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.CategoriaId;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.enums.ModelAttribute;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.enums.ThymView;
import lombok.RequiredArgsConstructor;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.constants.WebRoutes;

@Controller
@RequiredArgsConstructor
public class JugadorViewController {

    private final FindJugadorUseService findJugadorUseService;
    private final FindCategoriaService findCategoriaUseService;
    private final CreateJugadorUseService createJugadorService;

    @GetMapping(WebRoutes.JUGADORES_BASE)
    public String listJugadores(Model model) {

        model.addAttribute(
                ModelAttribute.JUGADOR_LIST.getName(),
                findJugadorUseService.findAll());

        model.addAttribute(
                ModelAttribute.CATEGORIA_LIST.getName(),
                findCategoriaUseService.findAll());

        return ThymView.JUGADOR_LIST.getPath();
    }


    @PostMapping(WebRoutes.JUGADORES_NUEVO)
    public String crearJugador(@RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam int edad,
            @RequestParam String piernaHabil,
            @RequestParam String email,
            @RequestParam(defaultValue = "1") int categoria,
            Model model) {

       createJugadorService.createJugador(new CreateJugadorCommand(nombre, apellido,edad,piernaHabil,email,new CategoriaId(categoria)));

        return ThymView.JUGADOR_CREATED.getPath();
    }
}
