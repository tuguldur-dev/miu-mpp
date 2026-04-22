package Project.repository;

import Project.model.EmployeeProject;
import Project.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeProjectRepository {

    public void add(EmployeeProject ep) throws SQLException {
        String sql = "INSERT INTO employee_project (employee_id, project_id, allocation_pct) VALUES (?, ?, ?) " +
                     "ON CONFLICT (employee_id, project_id) DO UPDATE SET allocation_pct = EXCLUDED.allocation_pct";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ep.getEmployeeId());
            ps.setInt(2, ep.getProjectId());
            ps.setDouble(3, ep.getAllocationPct());
            ps.executeUpdate();
        }
    }

    public void remove(int employeeId, int projectId) throws SQLException {
        String sql = "DELETE FROM employee_project WHERE employee_id=? AND project_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, employeeId);
            ps.setInt(2, projectId);
            ps.executeUpdate();
        }
    }

    public List<EmployeeProject> findByProjectId(int projectId) throws SQLException {
        String sql = "SELECT * FROM employee_project WHERE project_id=?";
        List<EmployeeProject> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, projectId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }
        }
        return list;
    }

    public List<EmployeeProject> findByEmployeeId(int employeeId) throws SQLException {
        String sql = "SELECT * FROM employee_project WHERE employee_id=?";
        List<EmployeeProject> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, employeeId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }
        }
        return list;
    }

    private EmployeeProject mapRow(ResultSet rs) throws SQLException {
        return new EmployeeProject(
            rs.getInt("employee_id"),
            rs.getInt("project_id"),
            rs.getDouble("allocation_pct")
        );
    }
}
