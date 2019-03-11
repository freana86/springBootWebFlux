package com.example.demo.controller;


import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonControllerImpl implements PersonController {

  @Autowired
  PersonService personService;

  @Override
  @PostMapping("/person")
  public Person createPerson(Person person) {
    return personService.createPerson(person);
  }

  @Override
  @GetMapping("/person/{id}")
  public Person getPerson(@PathVariable Integer id) {
    return personService.getPerson(id);
  }

  @Override
  @GetMapping("/person")
  public List<Person> findAllPersons() {
    return personService.findAllPersons();
  }

  @Override
  @DeleteMapping("/person/{id}")
  public void deletePerson(@PathVariable Integer id) {
    personService.deletePerson(id);
  }
}
