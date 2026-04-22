package Project.repository;

import Project.model.Department;
import Project.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentRepository {

    public void create(Department dept) throws SQLException {
        String sql = "INSERT INTO department (name, location, budget) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, dept.getName());
            ps.setString(2, dept.getLocation());
            ps.setDouble(3, dept.getBudget());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) dept.setDepartmentId(keys.getInt(1));
            }
        }
    }

    public Department findById(int id) throws SQLException {
        String sql = "SELECT * FROM department WHERE department_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        }
        return null;
    }

    public List<Department> findAll() throws SQLException {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM department ORDER BY department_id";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) list.add(mapRow(rs));
        }
        return list;
    }

    public void update(Department dept) throws SQLException {
        String sql = "UPDATE department SET name=?, location=?, budget=? WHERE department_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, dept.getName());
            ps.setString(2, dept.getLocation());
            ps.setDouble(3, dept.getBudget());
            ps.setInt(4, dept.getDepartmentId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM department WHERE department_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try {
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new SQLException("Cannot delete department " + id + ": employees or projects still reference it.", e);
            }
        }
    }

    private Department mapRow(ResultSet rs) throws SQLException {
        return new Department(
            rs.getInt("department_id"),
            rs.getString("name"),
            rs.getString("location"),
            rs.getDouble("budget")
        );
    }
}
