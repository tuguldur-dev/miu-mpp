package Project.model;

public class ProjectClient {
    private int projectId;
    private int clientId;

    public ProjectClient() {}

    public ProjectClient(int projectId, int clientId) {
        this.projectId = projectId;
        this.clientId = clientId;
    }

    public int getProjectId() { return projectId; }
    public void setProjectId(int projectId) { this.projectId = projectId; }

    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }

    @Override
    public String toString() {
        return "ProjectClient{projId=" + projectId + ", clientId=" + clientId + "}";
    }
}
