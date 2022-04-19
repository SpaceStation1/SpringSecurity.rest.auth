package example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "clients")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Client {

    @Id
    @SequenceGenerator( name = "jpaSequence", sequenceName = "JPA_SEQUENCE", allocationSize = 1, initialValue = 1)
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "jpaSequence")
    @Column(name="id", columnDefinition = "serial")
    @Getter @Setter private Long id;

    @Column(name = "password")
    @Getter @Setter private String password;

    @Column(name = "login")
    @Getter @Setter private String login;

    @Column(name = "firstname")
    @Getter @Setter private String firstName;

    @Column(name = "lastname")
    @Getter @Setter private String lastName;

    @Column(name = "patronymic")
    @Getter @Setter private String patronymic;

    @Column(name = "birthdate")
    @Getter @Setter private LocalDate birthdate;

    @Column(name = "mail")
    @Getter @Setter private String mail;

    @Column(name = "number")
    @Getter @Setter private Long number;


}
