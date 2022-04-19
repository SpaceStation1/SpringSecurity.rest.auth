package example.demo.controller;

import example.demo.model.Client;
import example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(value = "/clients")

public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> create(@RequestBody Client client) {
        clientService.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value = "/{id:\\d+}")
    public ResponseEntity<Client> getClient(@PathVariable(name = "id") Long id) {
        final Client client = clientService.gettingClientById(id);
        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/firstname/{firstname}")
    public ResponseEntity<List<Client>> getClientByFirstname(@PathVariable("firstname") String firstName){
        final  List<Client> client = clientService.getClientsByFirstName(firstName);
        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/patronymic/{patronymic}")
    public ResponseEntity<List<Client>> getClientByPatronymic(@PathVariable("patronymic") String patronymic){
        final  List<Client> client = clientService.getClientsByPatronymic(patronymic);
        return client != null
                ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") Long id, @RequestBody Client client) {
        final boolean updated = clientService.updateClient(client, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        final boolean deleted = clientService.deleteClient(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    @GetMapping(value = "/firstname/{firstname}/lastname/{lastname}")
    public ResponseEntity<List<Client>> getByFirstNameAndLastName(@PathVariable(name = "firstname") String firstName,
                                                          @PathVariable(name = "lastname") String lastName){
        List<Client> clients = clientService.getClientsByFirstNameAndLastName(firstName, lastName);
        return clients != null
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/mail/{mail}")
    public ResponseEntity<List<Client>> getByMail (@PathVariable(name = "mail") String mail){
        List<Client> clients = clientService.getClientsByMail(mail);
        return clients != null
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/number/{number}")
    public ResponseEntity<List<Client>> getByNumber (@PathVariable(name = "number") Long number){
        List<Client> clients = clientService.gettingClientsByNumber(number);
        return clients != null
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(value = "/birthdate/{birthdate}")
    public ResponseEntity<List<Client>> getByBirthdate (@PathVariable(name = "birthdate") String birthdate){
        LocalDate dt = LocalDate.parse(birthdate);
        List<Client> clients = clientService.gettingClientByBirthdate(dt);
        return clients != null
                ? new ResponseEntity<>(clients, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}