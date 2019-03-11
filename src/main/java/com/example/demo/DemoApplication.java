package com.example.demo;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

  @Autowired
  PersonRepository personRepository;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    initDemoData();
  }

  // Lägger in lite demodata i databasen...
  private void initDemoData() {
    List<Person> personList = new ArrayList<>();
    for(int i = 0; i < 100; i++) {
      Person person = new Person(
              RandomStringUtils.randomAlphabetic(5),
              RandomStringUtils.randomAlphabetic(5),
              RandomUtils.nextInt(0, 99));

      personList.add(person);
    }
    personRepository.saveAll(personList);
    log.info("{}st personer lades till i databasen...", personList.size());
  }


}
