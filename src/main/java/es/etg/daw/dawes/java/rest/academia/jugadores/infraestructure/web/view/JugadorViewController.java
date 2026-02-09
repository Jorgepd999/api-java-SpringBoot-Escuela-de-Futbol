package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.view;

import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.jugador.CreateJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.jugador.EditJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.categoria.FindCategoriaService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.CreateJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.FindJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.jugador.DeleteJugadorUseCase;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.useCase.jugador.EditJugadorUseCase;
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
    private final DeleteJugadorUseCase deleteJugadorUseService;
    private final EditJugadorUseCase editJugadorUseService;
    private final TemplateEngine templateEngine; // Motor de Thymeleaf
    @Autowired
    private LocaleResolver localeResolver;

    @GetMapping(WebRoutes.JUGADORES_HOME)
    public String home() {
        return ThymView.JUGADOR_HOME.getPath();
    }

    @GetMapping(WebRoutes.JUGADORES_LISTA)
    public String listJugadores(Model model) {

        model.addAttribute(
                ModelAttribute.JUGADOR_LIST.getName(),
                findJugadorUseService.findAll());

        model.addAttribute(
                ModelAttribute.CATEGORIA_LIST.getName(),
                findCategoriaUseService.findAll());

        return ThymView.JUGADOR_LIST.getPath();
    }

    // Carga la vista del formulario http://localhost:8080/web/jugadores/nuevo
    @GetMapping(WebRoutes.JUGADOR_NUEVO)
    public String formulario(Model model) {

        model.addAttribute(ModelAttribute.SINGLE_JUGADOR.getName(), new Jugador());
        model.addAttribute(
                ModelAttribute.CATEGORIA_LIST.getName(),
                findCategoriaUseService.findAll());

        return ThymView.JUGADOR_FORM.getPath(); // Devuelvo la vista que carga el formulario
    }

    @PostMapping(WebRoutes.JUGADOR_NUEVO)
    public String crearJugador(@RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam int edad,
            @RequestParam String piernaHabil,
            @RequestParam String email,
            @RequestParam(defaultValue = "1") int categoria,
            Model model) {

        createJugadorService.createJugador(
                new CreateJugadorCommand(nombre, apellido, edad, piernaHabil, email, new CategoriaId(categoria)));

        return ThymView.JUGADOR_CREATED.getPath();
    }

    // Vista: listado para borrar
    @GetMapping(WebRoutes.JUGADOR_BORRAR)
    public String listJugadoresBorrar(Model model) {

        model.addAttribute(
                ModelAttribute.JUGADOR_LIST.getName(),
                findJugadorUseService.findAll());

        model.addAttribute(
                ModelAttribute.CATEGORIA_LIST.getName(),
                findCategoriaUseService.findAll());

        return ThymView.JUGADOR_DELETE.getPath();
    }

    // Acción real de borrado
    @PostMapping(WebRoutes.JUGADOR_BORRAR_ID)
    public String borrarJugador(@PathVariable Integer id) {

        deleteJugadorUseService.delete(new JugadorId(id));

        return "redirect:/web/jugadores/borrar";
    }

    @GetMapping("/web/jugadores/editar")
    public String mostrarFormularioEdicion(@RequestParam Integer id, Model model) {
        // Buscar el jugador por ID usando tu servicio
        Jugador jugador = findJugadorUseService.findById(id);

        // Añadir el jugador al modelo para Thymeleaf
        model.addAttribute("jugador", jugador);

        return "jugador_editar"; // Este es el nombre del HTML de edición (jugador_editar.html)
    }

    @PostMapping("/web/jugadores/editar/{id}")
    public String editarJugador(
            @PathVariable Integer id,
            @RequestParam String nombre,
            @RequestParam String apellido,
            @RequestParam int edad,
            @RequestParam String piernaHabil,
            @RequestParam String email) {

        // Crear el comando de edición sin categoría
        EditJugadorCommand comando = new EditJugadorCommand(
                new JugadorId(id),
                nombre,
                apellido,
                edad,
                piernaHabil,
                email);

        // Llamar al use case de edición
        editJugadorUseService.update(comando);

        return "redirect:/web/jugadores/editar";
    }

    // Listado de Jugadores http://localhost:8080/web/jugadores/pdf
    @GetMapping(WebRoutes.JUGADORES_PDF)
    public void exportarPDF(HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        // Obtengo los datos
        List<Jugador> jugadores = findJugadorUseService.findAll();
        List<Categoria> categorias = findCategoriaUseService.findAll();

        // Obtengo el locale actual de la sesión
        Locale locale = localeResolver.resolveLocale(request);

        // Preparar el contexto de Thymeleaf con el locale
        Context context = new Context(locale);
        context.setVariable("jugadores", jugadores);
        context.setVariable("categorias", categorias);

        String htmlContent = templateEngine.process(ThymView.JUGADOR_LIST_PDF.getPath(), context);

        // Preparo la respuesta
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=jugadores.pdf");

        // Generar PDF
        OutputStream outputStream = response.getOutputStream();
        PdfRendererBuilder builder = new PdfRendererBuilder();
        builder.withHtmlContent(htmlContent, null);
        builder.toStream(outputStream);
        builder.run();
    }
}
