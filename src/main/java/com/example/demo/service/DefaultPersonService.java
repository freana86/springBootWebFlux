package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class DefaultPersonService implements PersonService {

  @Autowired
  private PersonRepository repository;

  @Override
  public Person createPerson(Person person) {
    Person savedPerson = repository.save(person);
    log.info("Person med id: {} sparad.", savedPerson.getId());
    return savedPerson;
  }

  @Override
  public Person getPerson(Integer id) {
    Person person = repository.findById(id).get();
    log.info("Hämtat person med id: {}.", person.getId());
    return person;
  }

  @Override
  public List<Person> findAllPersons() {
    List<Person> personList = new ArrayList<>();
    repository.findAll().forEach(personList::add);
    log.info("Hittat {} personer.", personList.size());
    return personList;
  }

  @Override
  public void deletePerson(Integer id) {
    log.info("Raderar person med id: {}", id);
    repository.deleteById(id);
  }
}
