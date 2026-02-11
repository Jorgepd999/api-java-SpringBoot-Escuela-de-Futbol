package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.view;


import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.jugador.CreateJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.jugador.EditJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.categoria.FindCategoriaService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.CreateJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.DeleteJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.EditJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.FindJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.Categoria;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.CategoriaId;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.JugadorId;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.constants.WebRoutes;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.enums.ModelAttribute;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.enums.ThymView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class JugadorViewController {

    private final FindJugadorUseService findJugadorUseService;
    private final FindCategoriaService findCategoriaUseService;
    private final CreateJugadorUseService createJugadorService;
    private final DeleteJugadorUseService deleteJugadorUseService;
    private final EditJugadorUseService editJugadorUseService;
    private final TemplateEngine templateEngine;

    @Autowired
    private LocaleResolver localeResolver;

    // --- Home ---
    @GetMapping(WebRoutes.JUGADORES_HOME)
    public String home() {
        return ThymView.JUGADORES_HOME.getPath();
    }

    // --- Listar jugadores ---
    @GetMapping(WebRoutes.JUGADORES_LISTA)
    public String listarJugadores(Model model) {
        model.addAttribute(ModelAttribute.JUGADOR_LIST.getName(), findJugadorUseService.findAll());
        model.addAttribute(ModelAttribute.CATEGORIA_LIST.getName(), findCategoriaUseService.findAll());
        return ThymView.JUGADORES_LISTA.getPath();
    }

    // --- Listado con opción de modificar ---
    @GetMapping(WebRoutes.JUGADORES_MODIFICAR)
    public String listarJugadoresModificar(Model model) {
        model.addAttribute(ModelAttribute.JUGADOR_LIST.getName(), findJugadorUseService.findAll());
        model.addAttribute(ModelAttribute.CATEGORIA_LIST.getName(), findCategoriaUseService.findAll());
        return ThymView.JUGADORES_LISTA_PARA_MODIFICAR.getPath();
    }

    // --- Listado con opción de borrar ---
    @GetMapping(WebRoutes.JUGADORES_BORRAR)
    public String listarJugadoresBorrar(Model model) {
        model.addAttribute(ModelAttribute.JUGADOR_LIST.getName(), findJugadorUseService.findAll());
        model.addAttribute(ModelAttribute.CATEGORIA_LIST.getName(), findCategoriaUseService.findAll());
        return ThymView.JUGADORES_LISTA_PARA_BORRAR.getPath();
    }

    // --- Nuevo jugador ---
    @GetMapping(WebRoutes.JUGADOR_NUEVO)
    public String formularioNuevo(Model model) {
        model.addAttribute(ModelAttribute.SINGLE_JUGADOR.getName(), new Jugador());
        model.addAttribute(ModelAttribute.CATEGORIA_LIST.getName(), findCategoriaUseService.findAll());
        return ThymView.JUGADORES_FORMULARIO_NUEVO.getPath();
    }

    @PostMapping(WebRoutes.JUGADOR_NUEVO)
    public String crearJugador(@RequestParam String nombre,
                               @RequestParam String apellido,
                               @RequestParam int edad,
                               @RequestParam String piernaHabil,
                               @RequestParam String email,
                               @RequestParam(defaultValue = "1") int categoria) {

        createJugadorService.createJugador(
                new CreateJugadorCommand(nombre, apellido, edad, piernaHabil, email, new CategoriaId(categoria))
        );

        return "redirect:" + WebRoutes.JUGADORES_LISTA;
    }

    // --- Editar jugador ---
    @GetMapping(WebRoutes.JUGADOR_EDITAR_FORM)
    public String mostrarFormularioEdicion(@PathVariable Integer id, Model model) {
        Jugador jugador = findJugadorUseService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        model.addAttribute("jugador", jugador);
        model.addAttribute(ModelAttribute.CATEGORIA_LIST.getName(), findCategoriaUseService.findAll());

        return ThymView.JUGADORES_FORMULARIO_EDITAR.getPath(); // Tu HTML de edición
    }

    @PostMapping(WebRoutes.JUGADOR_EDITAR_ACTION)
    public String editarJugador(@PathVariable Integer id,
                                @RequestParam String nombre,
                                @RequestParam String apellido,
                                @RequestParam int edad,
                                @RequestParam String piernaHabil,
                                @RequestParam String email) {

        EditJugadorCommand comando = new EditJugadorCommand(
                new JugadorId(id),
                nombre,
                apellido,
                edad,
                piernaHabil,
                email
        );

        editJugadorUseService.update(comando);

        return "redirect:" + WebRoutes.JUGADORES_MODIFICAR;
    }

    // --- Borrar jugador ---
    @PostMapping(WebRoutes.JUGADOR_BORRAR_ID)
    public String borrarJugador(@PathVariable Integer id) {
        deleteJugadorUseService.delete(new JugadorId(id));
        return "redirect:" + WebRoutes.JUGADORES_BORRAR;
    }

    // --- Exportar PDF ---
    @GetMapping(WebRoutes.JUGADORES_PDF)
    public void exportarPDF(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Jugador> jugadores = findJugadorUseService.findAll();
        List<Categoria> categorias = findCategoriaUseService.findAll();
        Locale locale = localeResolver.resolveLocale(request);

        Context context = new Context(locale);
        context.setVariable("jugadores", jugadores);
        context.setVariable("categorias", categorias);

        String htmlContent = templateEngine.process(ThymView.JUGADORES_PDF.getPath(), context);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=jugadores.pdf");

        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.withHtmlContent(htmlContent, null);
        builder.toStream(response.getOutputStream());
        builder.run();
    }
}
