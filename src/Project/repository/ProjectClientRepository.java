package Project.repository;

import Project.model.ProjectClient;
import Project.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectClientRepository {

    public void add(ProjectClient pc) throws SQLException {
        String sql = "INSERT INTO project_client (project_id, client_id) VALUES (?, ?) ON CONFLICT DO NOTHING";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pc.getProjectId());
            ps.setInt(2, pc.getClientId());
            ps.executeUpdate();
        }
    }

    public void remove(int projectId, int clientId) throws SQLException {
        String sql = "DELETE FROM project_client WHERE project_id=? AND client_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, projectId);
            ps.setInt(2, clientId);
            ps.executeUpdate();
        }
    }

    public List<ProjectClient> findByProjectId(int projectId) throws SQLException {
        String sql = "SELECT * FROM project_client WHERE project_id=?";
        List<ProjectClient> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, projectId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }
        }
        return list;
    }

    public List<Integer> findProjectIdsByClientId(int clientId) throws SQLException {
        String sql = "SELECT project_id FROM project_client WHERE client_id=?";
        List<Integer> ids = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, clientId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) ids.add(rs.getInt("project_id"));
            }
        }
        return ids;
    }

    private ProjectClient mapRow(ResultSet rs) throws SQLException {
        return new ProjectClient(
            rs.getInt("project_id"),
            rs.getInt("client_id")
        );
    }
}
