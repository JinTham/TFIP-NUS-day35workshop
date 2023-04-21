package tfip.csf.day35workshop.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig {

    @Bean
    public WebMvcConfigurer configureCors() {
        return new EnableCors("/api/*", "*");
    }
    
}
