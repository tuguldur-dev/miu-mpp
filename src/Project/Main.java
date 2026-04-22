package Project;

import Project.controller.*;
import Project.model.*;
import Project.repository.*;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        DepartmentController deptCtrl = new DepartmentController();
        EmployeeController empCtrl = new EmployeeController();
        ProjectController projCtrl = new ProjectController();
        ClientController clientCtrl = new ClientController();
        EmployeeProjectRepository epRepo = new EmployeeProjectRepository();
        DepartmentProjectRepository dpRepo = new DepartmentProjectRepository();
        ProjectClientRepository pcRepo = new ProjectClientRepository();

        try {
            System.out.println("=== DEPARTMENT CRUD ===");
            Department dept = new Department(0, "Engineering", "Building A", 500000.0);
            deptCtrl.create(dept);
            int deptId = dept.getDepartmentId();

            deptCtrl.getById(deptId);
            deptCtrl.getAll();

            dept.setBudget(600000.0);
            deptCtrl.update(dept);

            System.out.println("\n=== EMPLOYEE CRUD ===");
            Employee emp = new Employee(0, "Alice Johnson", "Engineer", LocalDate.of(2020, 3, 15), 96000.0, deptId);
            empCtrl.create(emp);
            int empId = emp.getEmployeeId();

            empCtrl.getById(empId);

            emp.setSalary(102000.0);
            empCtrl.update(emp);

            System.out.println("\n=== PROJECT CRUD ===");
            Project project = new Project(0, "Platform Rewrite", "Full backend rewrite", LocalDate.of(2025, 1, 1), LocalDate.of(2025, 7, 31), 250000.0, "Active");
            projCtrl.create(project);
            int projId = project.getProjectId();

            projCtrl.getById(projId);

            project.setStatus("Active");
            projCtrl.update(project);

            System.out.println("\n=== CLIENT CRUD ===");
            Client client = new Client(0, "Acme Corp", "Technology", "Bob Smith", "555-1234", "bob@acme.com");
            clientCtrl.create(client);
            int clientId = client.getClientId();

            clientCtrl.getById(clientId);

            client.setContactEmail("bob.smith@acme.com");
            clientCtrl.update(client);

            System.out.println("\n=== JUNCTION TABLE SETUP ===");
            epRepo.add(new EmployeeProject(empId, projId, 75.0));
            System.out.println("Assigned employee " + empId + " to project " + projId + " at 75%");

            dpRepo.add(new DepartmentProject(deptId, projId));
            System.out.println("Linked department " + deptId + " to project " + projId);

            pcRepo.add(new ProjectClient(projId, clientId));
            System.out.println("Linked project " + projId + " to client " + clientId);

            System.out.println("\n=== TASK 1: calculateProjectHRCost ===");
            double hrCost = projCtrl.calculateHRCost(projId);

            System.out.println("\n=== TASK 2: getProjectsByDepartment ===");
            projCtrl.getProjectsByDepartment(deptId, "budget");

            System.out.println("\n=== TASK 3: findClientsByUpcomingProjectDeadline ===");
            clientCtrl.findByUpcomingDeadline(300);

            System.out.println("\n=== TASK 4: transferEmployeeToDepartment ===");
            Department dept2 = new Department(0, "Marketing", "Building B", 200000.0);
            deptCtrl.create(dept2);
            empCtrl.transfer(empId, dept2.getDepartmentId());
            empCtrl.getById(empId);

            try {
                empCtrl.transfer(empId, dept2.getDepartmentId());
            } catch (IllegalArgumentException e) {
                System.out.println("Expected error: " + e.getMessage());
            }

            System.out.println("\n=== CLEANUP (Delete) ===");
            epRepo.remove(empId, projId);
            dpRepo.remove(deptId, projId);
            pcRepo.remove(projId, clientId);
            clientCtrl.delete(clientId);
            projCtrl.delete(projId);
            empCtrl.delete(empId);

            try {
                deptCtrl.delete(deptId);
            } catch (SQLException e) {
                System.out.println("Expected FK error on dept delete: " + e.getMessage());
            }

            System.out.println("\nAll tests completed successfully.");

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
