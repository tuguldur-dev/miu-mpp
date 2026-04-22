package Project.service;

import Project.model.Employee;
import Project.model.EmployeeProject;
import Project.model.Project;
import Project.repository.EmployeeProjectRepository;
import Project.repository.EmployeeRepository;
import Project.repository.ProjectRepository;

import java.sql.SQLException;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ProjectService {
    private final ProjectRepository projectRepo = new ProjectRepository();
    private final EmployeeProjectRepository epRepo = new EmployeeProjectRepository();
    private final EmployeeRepository empRepo = new EmployeeRepository();

    public void createProject(Project project) throws SQLException {
        if (project.getName() == null || project.getName().isBlank())
            throw new IllegalArgumentException("Project name cannot be empty.");
        if (project.getStartDate().isAfter(project.getEndDate()))
            throw new IllegalArgumentException("Start date must be before end date.");
        projectRepo.create(project);
    }

    public Project getProjectById(int id) throws SQLException {
        Project p = projectRepo.findById(id);
        if (p == null) throw new IllegalArgumentException("Project not found: " + id);
        return p;
    }

    public List<Project> getAllProjects() throws SQLException {
        return projectRepo.findAll();
    }

    public void updateProject(Project project) throws SQLException {
        getProjectById(project.getProjectId());
        projectRepo.update(project);
    }

    public void deleteProject(int id) throws SQLException {
        getProjectById(id);
        projectRepo.delete(id);
    }

    // Task 1: Calculate projected HR cost for a project
    public double calculateProjectHRCost(int projectId) throws SQLException {
        Project project = getProjectById(projectId);

        long days = ChronoUnit.DAYS.between(project.getStartDate(), project.getEndDate());
        double months = Math.ceil(days / 30.0);

        List<EmployeeProject> assignments = epRepo.findByProjectId(projectId);
        double totalCost = 0.0;
        for (EmployeeProject ep : assignments) {
            Employee emp = empRepo.findById(ep.getEmployeeId());
            if (emp != null) {
                double cost = (emp.getSalary() / 12.0) * months * (ep.getAllocationPct() / 100.0);
                totalCost += cost;
            }
        }
        return totalCost;
    }

    // Task 2: Get active projects for a department, sorted by specified field
    public List<Project> getProjectsByDepartment(int departmentId, String sortBy) throws SQLException {
        return projectRepo.findActiveByDepartment(departmentId, sortBy);
    }
}
