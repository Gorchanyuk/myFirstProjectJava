package ru.gorchanyuk.springcourse.crud.rest.dao;

import org.springframework.stereotype.Component;
import ru.gorchanyuk.springcourse.crud.rest.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAOList implements PersonDAO {
    private List<Person> people;
    private static int PEOPLE_COUNT;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom", 24, "qwert@gmail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 45, "asdf@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Nial", 34, "zxcv@ya.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 37, "kjkjhhgj@rambler.com"));
    }
    @Override
    public List<Person> index() {
        return people;
    }
    @Override
    public Person show(int id) {
        return people.stream()
                .filter(x -> x.getId() == id)
                .findAny()
                .orElse(null);
    }
    @Override
    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
    @Override
    public void update(int id, Person updatePerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatePerson.getName());
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());
    }
    @Override
    public void delete(int id) {
        people.removeIf(x -> x.getId() == id);
    }
}
