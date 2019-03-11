package com.example.demo.controller;

import com.example.demo.model.Person;

import java.util.List;

public interface PersonController {
  Person createPerson(Person person);
  Person getPerson(Integer id);
  List<Person> findAllPersons();
  void deletePerson(Integer id);
}
