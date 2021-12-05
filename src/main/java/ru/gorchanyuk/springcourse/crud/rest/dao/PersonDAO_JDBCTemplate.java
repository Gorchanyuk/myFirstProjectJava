package ru.gorchanyuk.springcourse.crud.rest.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.gorchanyuk.springcourse.crud.rest.models.Person;

import java.util.List;
@Component
public class PersonDAO_JDBCTemplate implements PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    public PersonDAO_JDBCTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?",
                new BeanPropertyRowMapper<>(Person.class),
                id).stream().findAny().orElse(null);
    }

    @Override
    public void save(Person person) {
        jdbcTemplate.update("INSERT INTO Person VALUES(1, ?, ?, ?)", person.getName(), person.getAge(),
                person.getEmail());
    }

    @Override
    public void update(int id, Person updatePerson) {
    jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? Where id=?",
            updatePerson.getName(), updatePerson.getAge(), updatePerson.getEmail(), id);
    }

    @Override
    public void delete(int id) {
    jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }
}
