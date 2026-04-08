package Lab8.probC.repository;

import Lab8.probC.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {
    final String url = "jdbc:postgresql://localhost:5432/postgres";
    final String user = "postgres";
    final String password = "mysecretpassword";

    public List<Employee> findAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM employee";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int empId = resultSet.getInt("emp_id");
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                int address_id = resultSet.getInt("address_id");
                int dept_id = resultSet.getInt("dept_id");
                Employee employee = new Employee(empId, name, salary, address_id, dept_id);
                employees.add(employee);
            }
        }
        return employees;
    }

    public Employee findById(int empId) throws SQLException {
        Employee employee = null;
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM employee where emp_id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, empId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("emp_id");
                String name = resultSet.getString("name");
                int salary = resultSet.getInt("salary");
                int address_id = resultSet.getInt("address_id");
                int dept_id = resultSet.getInt("dept_id");
                employee = new Employee(empId, name, salary, address_id, dept_id);
            }
        }
        return employee;
    }

    public void create(Employee employee) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "INSERT INTO employee (name, salary, address_id, dept_id) values (?, ?, ?,?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getSalary());
            statement.setInt(3, employee.getAddress_id());
            statement.setInt(4, employee.getDept_id());
            statement.executeUpdate();
        }
    }

    public void update(Employee employee) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "UPDATE employee SET name=?, salary=?, address_id=?, dept_id=? WHERE emp_id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, employee.getName());
            statement.setInt(2, employee.getSalary());
            statement.setInt(3, employee.getAddress_id());
            statement.setInt(4, employee.getDept_id());
            statement.setInt(5, employee.getEmp_id());
            statement.executeUpdate();
        }
    }

    public void delete(int empId) throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String query = "DELETE FROM employee WHERE emp_id=?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, empId);
            statement.executeUpdate();
        }
    }
}
