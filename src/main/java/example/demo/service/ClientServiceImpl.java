package example.demo.service;

import example.demo.model.Client;
import example.demo.repo.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class ClientServiceImpl implements ClientService, UserDetailsService {

    @Autowired
    private ClientRepo clientRepo;

    @Override
    public void create(Client client) {
        clientRepo.save(client);
    }

    @Override
    public Client gettingClientByLogin(String login){
        return clientRepo.findByLogin(login);
    }
    @Override
    public Client gettingClientById(Long id) {
        return clientRepo.findById(id).orElse(null);
    }

    @Override
    public List<Client> getClientsByFirstNameAndLastName(String firstName, String lastName) {
        return clientRepo.findAllByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public List<Client> getClientsByFirstName(String firstName) {
        return clientRepo.findAllByFirstName(firstName);
    }

    @Override
    public List<Client> getClientsByMail(String mail) {
        return clientRepo.findByMail(mail);
    }

    @Override
    public List<Client> gettingClientsByNumber(Long number) {
        return clientRepo.findByNumber(number);
    }

    @Override
    public List<Client> gettingClientByBirthdate(LocalDate date) {
        return clientRepo.findByBirthdate(date);
    }

    @Override
    public List<Client> getClientsByPatronymic(String patronymic) {
        return clientRepo.findAllByPatronymic(patronymic);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Client u = gettingClientByLogin(login);
        if (Objects.isNull(u)) {
            throw new UsernameNotFoundException(String.format("User %s is not found", login));
        }
        return new org.springframework.security.core.userdetails.User(u.getLogin(), u.getPassword(), true, true, true, true, new HashSet<>());
    }

    @Override
    public boolean deleteClient(Long id) {
        if (clientRepo.existsById(id)) {
            clientRepo.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateClient(Client client, Long id) {
        if (clientRepo.existsById(id)) {
            client.setId(id);
            clientRepo.save(client);
            return true;
        }
        return false;
    }
}
