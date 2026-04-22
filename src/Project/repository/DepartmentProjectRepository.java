package Project.repository;

import Project.model.DepartmentProject;
import Project.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentProjectRepository {

    public void add(DepartmentProject dp) throws SQLException {
        String sql = "INSERT INTO department_project (department_id, project_id) VALUES (?, ?) ON CONFLICT DO NOTHING";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, dp.getDepartmentId());
            ps.setInt(2, dp.getProjectId());
            ps.executeUpdate();
        }
    }

    public void remove(int departmentId, int projectId) throws SQLException {
        String sql = "DELETE FROM department_project WHERE department_id=? AND project_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, departmentId);
            ps.setInt(2, projectId);
            ps.executeUpdate();
        }
    }

    public List<DepartmentProject> findByDepartmentId(int departmentId) throws SQLException {
        String sql = "SELECT * FROM department_project WHERE department_id=?";
        List<DepartmentProject> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, departmentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }
        }
        return list;
    }

    public List<DepartmentProject> findByProjectId(int projectId) throws SQLException {
        String sql = "SELECT * FROM department_project WHERE project_id=?";
        List<DepartmentProject> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, projectId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }
        }
        return list;
    }

    private DepartmentProject mapRow(ResultSet rs) throws SQLException {
        return new DepartmentProject(
            rs.getInt("department_id"),
            rs.getInt("project_id")
        );
    }
}
