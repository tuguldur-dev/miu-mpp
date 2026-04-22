package Project.model;

public class EmployeeProject {
    private int employeeId;
    private int projectId;
    private double allocationPct;

    public EmployeeProject() {}

    public EmployeeProject(int employeeId, int projectId, double allocationPct) {
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.allocationPct = allocationPct;
    }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public int getProjectId() { return projectId; }
    public void setProjectId(int projectId) { this.projectId = projectId; }

    public double getAllocationPct() { return allocationPct; }
    public void setAllocationPct(double allocationPct) { this.allocationPct = allocationPct; }

    @Override
    public String toString() {
        return "EmployeeProject{empId=" + employeeId + ", projId=" + projectId + ", allocation=" + allocationPct + "%}";
    }
}
