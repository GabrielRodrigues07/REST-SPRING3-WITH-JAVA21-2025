package br.com.gabrielrodrigues07.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@FieldNameConstants
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "firstname", nullable = false, length = 80)
    private String firstName;
    @Column(name = "lastname", nullable = false, length = 80)
    private String lastName;
    @Column(name = "address", nullable = false, length = 100)
    private String address;
    @Column(name = "gender", nullable = false, length = 6)
    private String gender;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(address, person.address) && Objects.equals(gender, person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender);
    }
}
