package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class PersonControllerImplTest {

    @Mock
    PersonService personService;

    @InjectMocks
    PersonControllerImpl personController;

    @Test
    public void testGetAllPersons() {

        Person person = new Person();
        person.setId(1);
        person.setFirstName("firstName");
        person.setLastName("lastName");
        person.setAge(1);

        Mockito.when(personService.findAllPersons()).thenReturn(Arrays.asList(person));

        List<Person> allPersons = personController.findAllPersons();

        assertThat(allPersons.size(), equalTo(1));
        assertThat(allPersons.get(0), equalTo(person));
    }



}