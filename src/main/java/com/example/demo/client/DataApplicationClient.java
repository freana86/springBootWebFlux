package com.example.demo.client;

import com.example.demo.model.Person;

import java.util.List;

public interface DataApplicationClient {
  List<Person> getPersons();
}
