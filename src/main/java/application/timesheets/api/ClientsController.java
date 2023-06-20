package application.timesheets.api;

import application.timesheets.exceptions.NotFoundException;
import application.timesheets.models.Client;
import application.timesheets.repositories.ICategoriesRepository;
import application.timesheets.repositories.IClientsRepository;
import application.timesheets.services.IClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/Clients")
public class ClientsController {
    @Autowired
    private IClientsService clientsService;

    @GetMapping
    public List<Client> GetClients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Character letter
    ) {
        return clientsService.GetAllClients(page, pageSize, name, letter);
    }

    @GetMapping("{id}")
    public Client GetClientById(@PathVariable int id) {
        return clientsService.GetClientById(id);
    }

    @PostMapping
    public void AddClient(@RequestBody Client client) {
        clientsService.AddClient(client);
    }

    @PutMapping("{id}")
    void UpdateClient(@PathVariable int id, @RequestBody Client client)
    {
        clientsService.UpdateClient(id,client);
    }
    @DeleteMapping("{id}")
    public void DeleteClient(@PathVariable int id)
    {
        clientsService.DeleteClientById(id);
    }
}
