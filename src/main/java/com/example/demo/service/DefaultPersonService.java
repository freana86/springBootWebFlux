package com.example.demo.service;

import com.example.demo.client.DataApplicationClient;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class DefaultPersonService implements PersonService {

  @Autowired
  private PersonRepository repository;

  @Autowired
  private DataApplicationClient dataApplicationClient;

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

  @Override
  public List<Person> findAllPersonsWithAgeBetween(int minAge, int maxAge) {
    List<Person> allByAgeInterval = repository.findAllByAgeInterval(minAge, maxAge);
    log.info("Hittat {} personer.", allByAgeInterval.size());
    return allByAgeInterval;
  }

  //@PostConstruct
  private void initDataFromRemote() {
    List<Person> personsFromOtherApp = this.dataApplicationClient.getPersons();
    log.info("Hämtat {} personer från data-app", personsFromOtherApp.size());


    Iterable<Person> personsStored = repository.saveAll(personsFromOtherApp);
    log.info("Skrivet personer till databas.");
  }


/**
  @Scheduled(initialDelay = 5000, fixedDelay = 2000)
  private void getDataInEvery5Sec() {
    List<Person> personsFromOtherApp = this.dataApplicationClient.getPersons();
    Iterable<Person> personsStored = repository.saveAll(personsFromOtherApp);

    List<Person> result = new ArrayList<>();
    repository.findAll().forEach(result::add);
    log.info("Total: {}", result.size());

    if (result.size() > 1000) {
      repository.deleteAll();
    }

  }
*/

}
