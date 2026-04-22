package Project.controller;

import Project.model.Project;
import Project.service.ProjectService;

import java.sql.SQLException;
import java.util.List;

public class ProjectController {
    private final ProjectService service = new ProjectService();

    public void create(Project project) throws SQLException {
        service.createProject(project);
        System.out.println("Created: " + project);
    }

    public Project getById(int id) throws SQLException {
        Project p = service.getProjectById(id);
        System.out.println("Found: " + p);
        return p;
    }

    public List<Project> getAll() throws SQLException {
        List<Project> list = service.getAllProjects();
        list.forEach(System.out::println);
        return list;
    }

    public void update(Project project) throws SQLException {
        service.updateProject(project);
        System.out.println("Updated: " + project);
    }

    public void delete(int id) throws SQLException {
        service.deleteProject(id);
        System.out.println("Deleted project id=" + id);
    }

    public double calculateHRCost(int projectId) throws SQLException {
        double cost = service.calculateProjectHRCost(projectId);
        System.out.printf("HR Cost for project %d: $%.2f%n", projectId, cost);
        return cost;
    }

    public List<Project> getProjectsByDepartment(int departmentId, String sortBy) throws SQLException {
        List<Project> list = service.getProjectsByDepartment(departmentId, sortBy);
        System.out.println("Active projects for department " + departmentId + " (sorted by " + sortBy + "):");
        list.forEach(System.out::println);
        return list;
    }
}
