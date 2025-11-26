package br.com.gabrielrodrigues07.repositories;

import br.com.gabrielrodrigues07.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
