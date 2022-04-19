package example.demo.service;

import example.demo.model.Client;
import org.springframework.security.core.userdetails.UserDetails;
import java.time.LocalDate;
import java.util.List;

public interface ClientService {

    void create(Client client);
    UserDetails loadUserByUsername(String login);
    Client gettingClientByLogin(String login);
    Client gettingClientById(Long id);
    List<Client> getClientsByFirstNameAndLastName(String firstName, String lastName);
    List<Client> getClientsByFirstName(String firstName);
    List<Client> getClientsByMail(String mail);
    List<Client> gettingClientsByNumber(Long number);
    List<Client> gettingClientByBirthdate(LocalDate date);
    List<Client> getClientsByPatronymic(String patronymic);
    boolean deleteClient(Long id);
    boolean updateClient(Client client, Long id);
}
