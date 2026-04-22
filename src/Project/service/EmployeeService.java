package Project.service;

import Project.model.Employee;
import Project.repository.DepartmentRepository;
import Project.repository.EmployeeRepository;
import Project.util.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    private final EmployeeRepository empRepo = new EmployeeRepository();
    private final DepartmentRepository deptRepo = new DepartmentRepository();

    public void createEmployee(Employee emp) throws SQLException {
        if (emp.getFullName() == null || emp.getFullName().isBlank())
            throw new IllegalArgumentException("Employee name cannot be empty.");
        if (emp.getSalary() < 0)
            throw new IllegalArgumentException("Salary cannot be negative.");
        if (deptRepo.findById(emp.getDepartmentId()) == null)
            throw new IllegalArgumentException("Department not found: " + emp.getDepartmentId());
        empRepo.create(emp);
    }

    public Employee getEmployeeById(int id) throws SQLException {
        Employee emp = empRepo.findById(id);
        if (emp == null) throw new IllegalArgumentException("Employee not found: " + id);
        return emp;
    }

    public List<Employee> getAllEmployees() throws SQLException {
        return empRepo.findAll();
    }

    public void updateEmployee(Employee emp) throws SQLException {
        getEmployeeById(emp.getEmployeeId());
        if (emp.getSalary() < 0)
            throw new IllegalArgumentException("Salary cannot be negative.");
        empRepo.update(null, emp);
    }

    public void deleteEmployee(int id) throws SQLException {
        getEmployeeById(id);
        empRepo.delete(id);
    }

    // Task 4: Employee Transfer Transaction
    public void transferEmployeeToDepartment(int employeeId, int newDepartmentId) throws SQLException {
        Employee emp = getEmployeeById(employeeId);
        if (deptRepo.findById(newDepartmentId) == null)
            throw new IllegalArgumentException("Target department not found: " + newDepartmentId);
        if (emp.getDepartmentId() == newDepartmentId)
            throw new IllegalArgumentException("Employee is already in department " + newDepartmentId);

        Connection conn = DBConnection.getConnection();
        boolean prev = conn.getAutoCommit();
        try {
            conn.setAutoCommit(false);
            emp.setDepartmentId(newDepartmentId);
            empRepo.update(conn, emp);
            conn.commit();
            System.out.println("Transferred employee " + employeeId + " to department " + newDepartmentId);
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            conn.setAutoCommit(prev);
        }
    }
}
