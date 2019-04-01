package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 *
 *
 * För att @Data & @NoArgsConstructor ska fungera så måste en plugin i IDEn installeras .. plugin heter "Lombok"
 * Därför är dessa bortkommenterade nu och vi använder vanliga getters & setters mm..
 *
 *
 */

@Data
@NoArgsConstructor
@Entity
public class Person {

  @Id
  @GeneratedValue
  private Integer id;

  public Person(String firstName, String lastName, int age) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }

  private String firstName;
  private String lastName;
  private int age;

}
