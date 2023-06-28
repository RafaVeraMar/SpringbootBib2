package es.babel.biblioteca.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CircuitBreakerConfig {
    @Bean
    public CircuitBreakerConfig circuitBreakerConfig(){
        return CircuitBreakerConfig.ofDefaults("biblioteca")
    }
}
