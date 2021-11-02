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

    public List<Person> index(){
        return people;
    }
    public Person show(int id){
        return people.stream()
                .filter(people->people.getId() == id)
                .findAny()
                .orElse(null);
    }
}
