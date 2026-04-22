package Project.model;

public class Department {
    private int departmentId;
    private String name;
    private String location;
    private double budget;

    public Department() {}

    public Department(int departmentId, String name, String location, double budget) {
        this.departmentId = departmentId;
        this.name = name;
        this.location = location;
        this.budget = budget;
    }

    public int getDepartmentId() { return departmentId; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public double getBudget() { return budget; }
    public void setBudget(double budget) { this.budget = budget; }

    @Override
    public String toString() {
        return "Department{id=" + departmentId + ", name='" + name + "', location='" + location + "', budget=" + budget + "}";
    }
}
