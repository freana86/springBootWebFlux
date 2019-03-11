package com.example.demo.service;

import com.example.demo.model.Person;
import java.util.List;

public interface PersonService {
  Person createPerson(Person person);
  Person getPerson(Integer id);
  List<Person> findAllPersons();
  void deletePerson(Integer id);

  // Special
  List<Person> findAllPersonsWithAgeBetween(int minAge, int maxAge);
}
