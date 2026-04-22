package Project.repository;

import Project.model.Employee;
import Project.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository {

    public void create(Employee emp) throws SQLException {
        String sql = "INSERT INTO employee (full_name, title, hire_date, salary, department_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, emp.getFullName());
            ps.setString(2, emp.getTitle());
            ps.setDate(3, Date.valueOf(emp.getHireDate()));
            ps.setDouble(4, emp.getSalary());
            ps.setInt(5, emp.getDepartmentId());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) emp.setEmployeeId(keys.getInt(1));
            }
        }
    }

    public Employee findById(int id) throws SQLException {
        String sql = "SELECT * FROM employee WHERE employee_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        }
        return null;
    }

    public List<Employee> findAll() throws SQLException {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employee ORDER BY employee_id";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) list.add(mapRow(rs));
        }
        return list;
    }

    public void update(Connection conn, Employee emp) throws SQLException {
        String sql = "UPDATE employee SET full_name=?, title=?, hire_date=?, salary=?, department_id=? WHERE employee_id=?";
        if (conn == null) {
            conn = DBConnection.getConnection();
        }
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, emp.getFullName());
        ps.setString(2, emp.getTitle());
        ps.setDate(3, Date.valueOf(emp.getHireDate()));
        ps.setDouble(4, emp.getSalary());
        ps.setInt(5, emp.getDepartmentId());
        ps.setInt(6, emp.getEmployeeId());
        ps.executeUpdate();

    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM employee WHERE employee_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try {
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new SQLException("Cannot delete employee " + id + ": project assignments still exist.", e);
            }
        }
    }

    private Employee mapRow(ResultSet rs) throws SQLException {
        return new Employee(
                rs.getInt("employee_id"),
                rs.getString("full_name"),
                rs.getString("title"),
                rs.getDate("hire_date").toLocalDate(),
                rs.getDouble("salary"),
                rs.getInt("department_id")
        );
    }
}
