package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query("select p from Person p where p.age between :min and :max")
    List<Person> findAllByAgeInterval(@Param("min") int minAge, @Param("max") int maxAge);


}
