package com.example.demo.client;

import com.example.demo.model.Person;

import java.util.List;

public class DataApplicationResponse {

  private List<Person> personList;

  public DataApplicationResponse() {
  }

  public DataApplicationResponse(List<Person> personList) {
    this.personList = personList;
  }

  public List<Person> getPersonList() {
    return personList;
  }

  public void setPersonList(List<Person> personList) {
    this.personList = personList;
  }
}
