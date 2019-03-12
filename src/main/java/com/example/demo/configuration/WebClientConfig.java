package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * Konfigurationsklass för WebClienten som ska ansluta till ett annat API..
 * Spring kommer automatiskt att köra koden i denna klass och lägga till i sitt context när applikationen startas.
 */

@Configuration
public class WebClientConfig {


  // Skapar en instans av WebClientBuilder..
  // Denna ska sedan "@Autowiras" i de klasser den ska användas.
  @Bean
  public WebClient.Builder webClientBuilder() {
    return WebClient.builder();
  }

}
