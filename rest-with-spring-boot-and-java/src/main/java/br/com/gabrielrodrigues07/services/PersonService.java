package br.com.gabrielrodrigues07.services;

import br.com.gabrielrodrigues07.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
        logger.info("Finding one Person!!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Gabriel");
        person.setLastName("Alves");
        person.setAddress("Fortaleza - Ceará");
        person.setGender("Male");

        return person;
    }

    public List<Person> findAll() {
        logger.info("Finding all People!!");

        Person person1 = new Person();
        person1.setId(counter.incrementAndGet());
        person1.setFirstName("Gabriel");
        person1.setLastName("Alves");
        person1.setAddress("Fortaleza - Ceará");
        person1.setGender("Male");

        Person person2 = new Person();
        person2.setId(counter.incrementAndGet());
        person2.setFirstName("João");
        person2.setLastName("Silva");
        person2.setAddress("Fortaleza - Ceará");
        person2.setGender("Male");

        return List.of(person1, person2);
    }

    public Person create(Person person) {
        logger.info("Creating one Person!!");
        person.setId(counter.incrementAndGet());
        return person;
    }

    public Person update(Person person) {
        logger.info("Updating one Person!!");
        return person;
    }

    public void delete(String id) {
        logger.info("Deleting one Person!!");
    }
}
