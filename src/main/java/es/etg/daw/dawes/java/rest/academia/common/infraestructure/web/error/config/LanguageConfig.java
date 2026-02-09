package es.etg.daw.dawes.java.rest.academia.common.infraestructure.web.error.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class LanguageConfig implements WebMvcConfigurer {

    public static final String DEFAULT_LANGUAGE = "es";
    public static final String PARAM_LANGUAGE = "lang";

    /**
     * Locale por defecto guardado en la sesión.
     */
    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.forLanguageTag(DEFAULT_LANGUAGE));
        return slr;
    }

    /**
     * Interceptor que cambia el idioma con ?lang=xx en la URL.
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName(PARAM_LANGUAGE);
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    /**
     * Configura el MessageSource para Thymeleaf y Spring Validation.
     * messages.properties -> español por defecto
     * messages_en.properties -> inglés
     * messages_jp.properties -> japonés
     */
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages"); // sin _es ni _en
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setUseCodeAsDefaultMessage(true); // si no encuentra la clave, devuelve la clave
        return messageSource;
    }
}
