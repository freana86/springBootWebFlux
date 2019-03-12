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

//@Data
//@NoArgsConstructor
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

  public Person() {
  }

  public Integer getId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public int getAge() {
    return this.age;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof Person)) return false;
    final Person other = (Person) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$id = this.getId();
    final Object other$id = other.getId();
    if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
    final Object this$firstName = this.getFirstName();
    final Object other$firstName = other.getFirstName();
    if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
    final Object this$lastName = this.getLastName();
    final Object other$lastName = other.getLastName();
    if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
    if (this.getAge() != other.getAge()) return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof Person;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $id = this.getId();
    result = result * PRIME + ($id == null ? 43 : $id.hashCode());
    final Object $firstName = this.getFirstName();
    result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
    final Object $lastName = this.getLastName();
    result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
    result = result * PRIME + this.getAge();
    return result;
  }

  public String toString() {
    return "Person(id=" + this.getId() + ", firstName=" + this.getFirstName() + ", lastName=" + this.getLastName() + ", age=" + this.getAge() + ")";
  }
}
