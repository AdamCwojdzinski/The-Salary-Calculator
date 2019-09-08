package com.summer.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LearningApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(LearningApplication.class, args);
    }
    
    @Configuration
    public class CorsConfig implements WebMvcConfigurer {
        
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/api/**")
                            .allowedMethods("GET", "POST", "PUT", "DELETE")
                            .allowedOrigins("*")
                            .allowedHeaders("*")
                            .allowCredentials(false).maxAge(3600);
                }
            };
        }
    }
}
