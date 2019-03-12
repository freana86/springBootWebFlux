package com.example.demo.client;

import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

/**
 *
 * Denna klass ska användas för att hämta data (lista på personer)
 * från en helt annan Spring Applikation
 *
 */

// Denna annotering talar om för Spring att det ska skapas en instans av denna klass när applikationen startas..
// Man skulle kunna göra en @Bean i en configklass om man vill..
@Component
public class DataApplicationClientImpl implements DataApplicationClient {

  // "Fångar upp" den intansen (@Bean) vi skapade i WebClientConfig.java.. Spring fixar allt åt oss.
  @Autowired
  private WebClient.Builder webclientBuilder;

  @Value("{$dataapplication.url}") // kolla application.yml filen .. där hämtas denna url..
  private String url;

  @Override
  public List<Person> getPersons() {
    // Anropa det andra API:et och hämta en lista på personer..

    List<Person> personList = webclientBuilder.build()
            .get()
            .uri(url)
            .retrieve()
            .bodyToMono(new ParameterizedTypeReference<List<Person>>() {})
            .block();

    return personList;
  }

}
