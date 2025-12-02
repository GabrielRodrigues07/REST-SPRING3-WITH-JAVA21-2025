package br.com.gabrielrodrigues07.services;

import br.com.gabrielrodrigues07.exceptions.ResourceNotFoundException;
import br.com.gabrielrodrigues07.model.Person;
import br.com.gabrielrodrigues07.model.dto.v1.PersonDTO;
import br.com.gabrielrodrigues07.model.dto.v2.PersonDTOV2;
import br.com.gabrielrodrigues07.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.gabrielrodrigues07.mapper.PersonMapper.parseObject;
import static br.com.gabrielrodrigues07.mapper.PersonMapper.parseObjects;

@Service
@RequiredArgsConstructor
public class PersonService {

    private Logger logger = LoggerFactory.getLogger(PersonService.class.getName());

    private final ModelMapper modelMapper;

    @Autowired
    private PersonRepository personRepository;

    public PersonDTO findById(Long id) {
        logger.info("Finding one Person!!");

        return personRepository.findById(id)
                .map(person -> parseObject(person, PersonDTO.class))
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID: " + id));
    }

    public List<PersonDTO> findAll() {
        logger.info("Finding all People!!");

        return parseObjects(personRepository.findAll(), PersonDTO.class);
    }

    public PersonDTO create(PersonDTO personDTO) {
        logger.info("Creating one Person!!");

        Person person = parseObject(personDTO, Person.class);
        Person personSaved = personRepository.save(person);

        return parseObject(personSaved, PersonDTO.class);
    }

    public PersonDTOV2 createV2(PersonDTOV2 personDTO) {
        logger.info("Creating one Person V2!!");

        Person person = parseObject(personDTO, Person.class);
        Person personSaved = personRepository.save(person);

        return parseObject(personSaved, PersonDTOV2.class);
    }

    public PersonDTO update(PersonDTO personDTO) {
        logger.info("Updating one Person!!");
        PersonDTO retrievedPerson = findById(personDTO.getId());
        PersonDTO updatedPersonDTO = updatePersonEntity(personDTO, retrievedPerson);

        Person person = parseObject(updatedPersonDTO, Person.class);

        return parseObject(personRepository.save(person), PersonDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one Person!!");
        Person person = parseObject(findById(id), Person.class);
        personRepository.delete(person);
    }

    private PersonDTO updatePersonEntity(PersonDTO source, PersonDTO target) {
        modelMapper.map(source, target);
        return target;
    }
}
