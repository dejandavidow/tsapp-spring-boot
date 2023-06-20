package application.timesheets.services;

import application.timesheets.exceptions.EntityAlreadyExist;
import application.timesheets.exceptions.NotFoundException;
import application.timesheets.models.Category;
import application.timesheets.models.Client;
import application.timesheets.repositories.IClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientsService implements IClientsService{
    @Autowired
    private IClientsRepository clientsRepository;
    @Override
    public List<Client> GetAllClients(int pageNumber, int pageSize,String name,Character letter) {
        List<Client> pagedClients = new ArrayList<>();
        Pageable page = PageRequest.of(pageNumber,pageSize,Sort.by("clientName"));
        if(name != null)
        {
            pagedClients = clientsRepository.findByClientNameContaining(name,page);
        }
        else if(letter != null){
            pagedClients = clientsRepository.findByClientNameStartsWith(letter,page);
        }
        else {
            pagedClients = clientsRepository.findAll(page).toList();
        }
        return  pagedClients;
    }

    @Override
    public Client GetClientById(int id)  {
          return clientsRepository.findById(id).orElseThrow(() -> new NotFoundException("Client doesn't exists."));
    }

    @Override
    public void AddClient(Client client) {
        Client clientExx = clientsRepository.findByClientName(client.getClientName());
        if(clientExx == null)
        clientsRepository.save(client);
        else
            throw new EntityAlreadyExist("Client already exists!");
    }

    @Override
    public void DeleteClientById(int id) {
        Client client = clientsRepository.findById(id).orElseThrow(() -> new NotFoundException("Client doesn't exists."));
        clientsRepository.delete(client);
    }

    @Override
    public void UpdateClient(int id, Client client) {
        Client clientForUpdate = clientsRepository.findById(id).orElseThrow(() -> new NotFoundException("Client doesn't exists."));
        clientForUpdate.setClientName(clientForUpdate.getClientName());
        clientForUpdate.setAddress(client.getAddress());
        clientForUpdate.setCity(client.getCity());
        clientForUpdate.setCountry(client.getCountry());
        clientForUpdate.setPostalCode(clientForUpdate.getPostalCode());
        clientsRepository.save(clientForUpdate);
    }
}
