package Project.model;

import java.time.LocalDate;

public class Employee {
    private int employeeId;
    private String fullName;
    private String title;
    private LocalDate hireDate;
    private double salary;
    private int departmentId;

    public Employee() {}

    public Employee(int employeeId, String fullName, String title, LocalDate hireDate, double salary, int departmentId) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.title = title;
        this.hireDate = hireDate;
        this.salary = salary;
        this.departmentId = departmentId;
    }

    public int getEmployeeId() { return employeeId; }
    public void setEmployeeId(int employeeId) { this.employeeId = employeeId; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDate getHireDate() { return hireDate; }
    public void setHireDate(LocalDate hireDate) { this.hireDate = hireDate; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public int getDepartmentId() { return departmentId; }
    public void setDepartmentId(int departmentId) { this.departmentId = departmentId; }

    @Override
    public String toString() {
        return "Employee{id=" + employeeId + ", name='" + fullName + "', title='" + title + "', salary=" + salary + ", deptId=" + departmentId + "}";
    }
}
