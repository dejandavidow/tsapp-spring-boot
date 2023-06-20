package application.timesheets.services;

import application.timesheets.models.Client;

import java.util.List;

public interface IClientsService {
    List<Client> GetAllClients(int pageNumber,int pageSize,String name,Character letter);
    Client GetClientById(int id);
    void AddClient(Client client);
    void DeleteClientById(int id);
    void UpdateClient(int id,Client client);
}
