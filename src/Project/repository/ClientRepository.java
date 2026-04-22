package Project.repository;

import Project.model.Client;
import Project.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {

    public void create(Client client) throws SQLException {
        String sql = "INSERT INTO client (name, industry, contact_name, contact_phone, contact_email) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, client.getName());
            ps.setString(2, client.getIndustry());
            ps.setString(3, client.getContactName());
            ps.setString(4, client.getContactPhone());
            ps.setString(5, client.getContactEmail());
            ps.executeUpdate();
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) client.setClientId(keys.getInt(1));
            }
        }
    }

    public Client findById(int id) throws SQLException {
        String sql = "SELECT * FROM client WHERE client_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }
        }
        return null;
    }

    public List<Client> findAll() throws SQLException {
        List<Client> list = new ArrayList<>();
        String sql = "SELECT * FROM client ORDER BY client_id";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) list.add(mapRow(rs));
        }
        return list;
    }

    public List<Client> findByProjectIds(List<Integer> projectIds) throws SQLException {
        if (projectIds.isEmpty()) return new ArrayList<>();
        StringBuilder placeholders = new StringBuilder();
        for (int i = 0; i < projectIds.size(); i++) {
            if (i > 0) placeholders.append(",");
            placeholders.append("?");
        }
        String sql = "SELECT DISTINCT c.* FROM client c " +
                     "JOIN project_client pc ON c.client_id = pc.client_id " +
                     "WHERE pc.project_id IN (" + placeholders + ")";
        List<Client> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < projectIds.size(); i++) ps.setInt(i + 1, projectIds.get(i));
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }
        }
        return list;
    }

    public void update(Client client) throws SQLException {
        String sql = "UPDATE client SET name=?, industry=?, contact_name=?, contact_phone=?, contact_email=? WHERE client_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, client.getName());
            ps.setString(2, client.getIndustry());
            ps.setString(3, client.getContactName());
            ps.setString(4, client.getContactPhone());
            ps.setString(5, client.getContactEmail());
            ps.setInt(6, client.getClientId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM client WHERE client_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try {
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new SQLException("Cannot delete client " + id + ": project links still exist.", e);
            }
        }
    }

    private Client mapRow(ResultSet rs) throws SQLException {
        return new Client(
            rs.getInt("client_id"),
            rs.getString("name"),
            rs.getString("industry"),
            rs.getString("contact_name"),
            rs.getString("contact_phone"),
            rs.getString("contact_email")
        );
    }
}
