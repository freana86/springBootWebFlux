package com.example.demo.service;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import com.fasterxml.jackson.databind.util.ArrayIterator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class DefaultPersonServiceTest {


    @Mock
    PersonRepository personRepository;

    @InjectMocks
    DefaultPersonService personService;


    @Test
    public void testGetAPerson() {

        Person p = new Person();
        Person[] persons = new Person[5];
        persons[0] = p;
        Iterable<Person> personIterable = new ArrayIterator<Person>(persons);
        Mockito.when(personRepository.findAll()).thenReturn(personIterable);

        List<Person> allPersons = personService.findAllPersons();

        assertThat(allPersons.get(0), equalTo(p));

    }


}