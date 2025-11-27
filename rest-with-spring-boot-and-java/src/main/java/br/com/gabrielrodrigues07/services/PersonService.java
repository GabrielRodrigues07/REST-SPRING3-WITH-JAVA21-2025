package br.com.gabrielrodrigues07.services;

import br.com.gabrielrodrigues07.exceptions.ResourceNotFoundException;
import br.com.gabrielrodrigues07.model.Person;
import br.com.gabrielrodrigues07.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class PersonService {

    private AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    private final ModelMapper modelMapper;

    @Autowired
    private PersonRepository personRepository;

    public Person findById(Long id) {
        logger.info("Finding one Person!!");

        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));
    }

    public List<Person> findAll() {
        logger.info("Finding all People!!");

        return personRepository.findAll();
    }

    public Person create(Person person) {
        logger.info("Creating one Person!!");

        return personRepository.save(person);
    }

    public Person update(Person person) {
        logger.info("Updating one Person!!");
        Person retrivePerson = findById(person.getId());

        return personRepository.save(updatePersonEntity(person, retrivePerson));
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!!");
        Person person = findById(id);
        personRepository.delete(person);
    }

    private Person updatePersonEntity(Person source, Person target) {
        modelMapper.map(source, target);
        return target;
    }
}
