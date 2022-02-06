package ru.astecom.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import javax.validation.constraints.NotNull;

@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(@NotNull CorsRegistry registry) {
        registry
            .addMapping("/api/**")
            .allowedOrigins("*")
        .allowedMethods("PUT", "GET", "POST", "DELETE", "OPTIONS");
    }

    @Override
    public void addResourceHandlers(@NotNull ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:static/static/");
        registry.addResourceHandler("/storage/**").addResourceLocations("classpath:static/storage/");
    }

    @Override
    public void addViewControllers(@NotNull ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.html");
        registry.addViewController("/{path:^(?!static|api|storage)(?:.*)}/**").setViewName("index.html");
    }
}
