package ru.gorchanyuk.springcourse.crud.rest.dao;

import ru.gorchanyuk.springcourse.crud.rest.models.Person;

import java.util.List;

public interface PersonDAO {

        public List<Person> index();

        public Person show(int id);

        public void save(Person person);

        public void update(int id, Person updatePerson);

        public void delete(int id);

}
