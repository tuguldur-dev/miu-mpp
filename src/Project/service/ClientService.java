package Project.service;

import Project.model.Client;
import Project.model.Project;
import Project.repository.ClientRepository;
import Project.repository.ProjectRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientService {
    private final ClientRepository clientRepo = new ClientRepository();
    private final ProjectRepository projectRepo = new ProjectRepository();

    public void createClient(Client client) throws SQLException {
        if (client.getName() == null || client.getName().isBlank())
            throw new IllegalArgumentException("Client name cannot be empty.");
        clientRepo.create(client);
    }

    public Client getClientById(int id) throws SQLException {
        Client c = clientRepo.findById(id);
        if (c == null) throw new IllegalArgumentException("Client not found: " + id);
        return c;
    }

    public List<Client> getAllClients() throws SQLException {
        return clientRepo.findAll();
    }

    public void updateClient(Client client) throws SQLException {
        getClientById(client.getClientId());
        clientRepo.update(client);
    }

    public void deleteClient(int id) throws SQLException {
        getClientById(id);
        clientRepo.delete(id);
    }

    // Task 3: Find clients linked to projects ending within N days from today
    public List<Client> findClientsByUpcomingProjectDeadline(int daysUntilDeadline) throws SQLException {
        LocalDate today = LocalDate.now();
        LocalDate deadline = today.plusDays(daysUntilDeadline);

        List<Project> upcomingProjects = projectRepo.findByEndDateRange(today, deadline);
        if (upcomingProjects.isEmpty()) return new ArrayList<>();

        List<Integer> projectIds = upcomingProjects.stream()
                .map(Project::getProjectId)
                .collect(Collectors.toList());

        return clientRepo.findByProjectIds(projectIds);
    }
}
