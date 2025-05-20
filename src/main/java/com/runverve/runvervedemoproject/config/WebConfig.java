package com.runverve.runvervedemoproject.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allow all paths
                .allowedOrigins("http://127.0.0.1:5501", "http://localhost:5501")  // Allow your frontend URLs
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow necessary methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true)  // Allow credentials (cookies, etc.)
                .maxAge(3600);  // Cache preflight response for 1 hour
    }
}

