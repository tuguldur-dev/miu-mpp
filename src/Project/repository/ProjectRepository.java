package Project.repository;

import Project.model.Project;
import Project.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    public void create(Project project) throws SQLException {
        String sql = "INSERT INTO project (name, description, start_date, end_date, budget, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, project.getName());
            ps.setString(2, project.getDescription());
            ps.setDate(3, Date.valueOf(project.getStartDate()));
            ps.setDate(4, Date.valueOf(project.getEndDate()));
            ps.setDouble(5, project.getBudget());
            ps.setString(6, project.getStatus());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) project.setProjectId(keys.getInt(1));
            }
        }
    }

    public Project findById(int id) throws SQLException {
        String sql = "SELECT * FROM project WHERE project_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        }
        return null;
    }

    public List<Project> findAll() throws SQLException {
        List<Project> list = new ArrayList<>();
        String sql = "SELECT * FROM project ORDER BY project_id";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) list.add(mapRow(rs));
        }
        return list;
    }

    public List<Project> findActiveByDepartment(int departmentId, String sortBy) throws SQLException {
        String column = resolveColumn(sortBy);
        String sql = "SELECT p.* FROM project p " +
                     "JOIN department_project dp ON p.project_id = dp.project_id " +
                     "WHERE dp.department_id = ? AND p.status = 'Active' " +
                     "ORDER BY p." + column;
        List<Project> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, departmentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }
        }
        return list;
    }

    public List<Project> findByEndDateRange(java.time.LocalDate from, java.time.LocalDate to) throws SQLException {
        String sql = "SELECT * FROM project WHERE end_date BETWEEN ? AND ?";
        List<Project> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, Date.valueOf(from));
            ps.setDate(2, Date.valueOf(to));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }
        }
        return list;
    }

    public void update(Project project) throws SQLException {
        String sql = "UPDATE project SET name=?, description=?, start_date=?, end_date=?, budget=?, status=? WHERE project_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, project.getName());
            ps.setString(2, project.getDescription());
            ps.setDate(3, Date.valueOf(project.getStartDate()));
            ps.setDate(4, Date.valueOf(project.getEndDate()));
            ps.setDouble(5, project.getBudget());
            ps.setString(6, project.getStatus());
            ps.setInt(7, project.getProjectId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM project WHERE project_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try {
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new SQLException("Cannot delete project " + id + ": assignments still reference it.", e);
            }
        }
    }

    private String resolveColumn(String sortBy) {
        return switch (sortBy == null ? "" : sortBy.toLowerCase()) {
            case "budget", "project_budget" -> "budget";
            case "end_date" -> "end_date";
            case "name" -> "name";
            default -> "project_id";
        };
    }

    private Project mapRow(ResultSet rs) throws SQLException {
        return new Project(
            rs.getInt("project_id"),
            rs.getString("name"),
            rs.getString("description"),
            rs.getDate("start_date").toLocalDate(),
            rs.getDate("end_date").toLocalDate(),
            rs.getDouble("budget"),
            rs.getString("status")
        );
    }
}
