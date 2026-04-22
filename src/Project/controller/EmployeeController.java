package Project.controller;

import Project.model.Employee;
import Project.service.EmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeController {
    private final EmployeeService service = new EmployeeService();

    public void create(Employee emp) throws SQLException {
        service.createEmployee(emp);
        System.out.println("Created: " + emp);
    }

    public Employee getById(int id) throws SQLException {
        Employee emp = service.getEmployeeById(id);
        System.out.println("Found: " + emp);
        return emp;
    }

    public List<Employee> getAll() throws SQLException {
        List<Employee> list = service.getAllEmployees();
        list.forEach(System.out::println);
        return list;
    }

    public void update(Employee emp) throws SQLException {
        service.updateEmployee(emp);
        System.out.println("Updated: " + emp);
    }

    public void delete(int id) throws SQLException {
        service.deleteEmployee(id);
        System.out.println("Deleted employee id=" + id);
    }

    public void transfer(int employeeId, int newDepartmentId) throws SQLException {
        service.transferEmployeeToDepartment(employeeId, newDepartmentId);
    }
}
