package ru.egorkuban.springcrud.dao;

import org.springframework.stereotype.Component;
import ru.egorkuban.springcrud.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 1;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(PEOPLE_COUNT, "Max"));
        people.add(new Person(++PEOPLE_COUNT, "Valterri"));
        people.add(new Person(++PEOPLE_COUNT, "Charles"));
        people.add(new Person(++PEOPLE_COUNT, "Lewis"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream()
                .filter(people -> people.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personToBeUpdate = show(id);
        personToBeUpdate.setName(updatePerson.getName());

    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
