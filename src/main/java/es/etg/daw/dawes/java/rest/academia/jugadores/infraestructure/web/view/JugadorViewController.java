package es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.view;

import java.util.List;
import java.util.Locale;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.springframework.ui.Model;

import java.io.OutputStream;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import es.etg.daw.dawes.java.rest.academia.jugadores.application.command.jugador.CreateJugadorCommand;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.categoria.FindCategoriaService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.CreateJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.application.service.jugador.FindJugadorUseService;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.Categoria;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.categoria.CategoriaId;
import es.etg.daw.dawes.java.rest.academia.jugadores.domain.model.jugador.Jugador;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.enums.ModelAttribute;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.enums.ThymView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import es.etg.daw.dawes.java.rest.academia.jugadores.infraestructure.web.constants.WebRoutes;

@Controller
@RequiredArgsConstructor
public class JugadorViewController {

    private final FindJugadorUseService findJugadorUseService;
    private final FindCategoriaService findCategoriaUseService;
    private final CreateJugadorUseService createJugadorService;
    private final TemplateEngine templateEngine; // Motor de Thymeleaf
     @Autowired
    private LocaleResolver localeResolver;

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

    // Carga la vista del formulario http://localhost:8082/web/jugadores/nuevo
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


     // Listado de Jugadores http://localhost:8082/web/jugadores/pdf
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
