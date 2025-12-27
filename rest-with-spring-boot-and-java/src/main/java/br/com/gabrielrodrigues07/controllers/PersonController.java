package br.com.gabrielrodrigues07.controllers;

import br.com.gabrielrodrigues07.model.dto.PersonDTO;
import br.com.gabrielrodrigues07.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonService personService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE })
    public PersonDTO findById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE })
    public List<PersonDTO> findAll() {
        return personService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE })
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @RequestMapping(method = RequestMethod.PUT,
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE },
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_YAML_VALUE })
    public PersonDTO update(@RequestBody PersonDTO personDTO) {
        return personService.update(personDTO);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        personService.delete(id);
    }
}
