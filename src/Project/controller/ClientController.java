package Project.controller;

import Project.model.Client;
import Project.service.ClientService;

import java.sql.SQLException;
import java.util.List;

public class ClientController {
    private final ClientService service = new ClientService();

    public void create(Client client) throws SQLException {
        service.createClient(client);
        System.out.println("Created: " + client);
    }

    public Client getById(int id) throws SQLException {
        Client c = service.getClientById(id);
        System.out.println("Found: " + c);
        return c;
    }

    public List<Client> getAll() throws SQLException {
        List<Client> list = service.getAllClients();
        list.forEach(System.out::println);
        return list;
    }

    public void update(Client client) throws SQLException {
        service.updateClient(client);
        System.out.println("Updated: " + client);
    }

    public void delete(int id) throws SQLException {
        service.deleteClient(id);
        System.out.println("Deleted client id=" + id);
    }

    public List<Client> findByUpcomingDeadline(int days) throws SQLException {
        List<Client> list = service.findClientsByUpcomingProjectDeadline(days);
        System.out.println("Clients with projects ending within " + days + " days:");
        list.forEach(System.out::println);
        return list;
    }
}
