package Project.model;

import java.time.LocalDate;

public class Project {
    private int projectId;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private double budget;
    private String status;

    public Project() {}

    public Project(int projectId, String name, String description, LocalDate startDate, LocalDate endDate, double budget, String status) {
        this.projectId = projectId;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
        this.status = status;
    }

    public int getProjectId() { return projectId; }
    public void setProjectId(int projectId) { this.projectId = projectId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Project{id=" + projectId + ", name='" + name + "', status='" + status + "', budget=" + budget + ", end=" + endDate + "}";
    }
}
