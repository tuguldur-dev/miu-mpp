package Project.service;

import Project.model.Department;
import Project.repository.DepartmentRepository;

import java.sql.SQLException;
import java.util.List;

public class DepartmentService {
    private final DepartmentRepository deptRepo = new DepartmentRepository();

    public void createDepartment(Department dept) throws SQLException {
        if (dept.getName() == null || dept.getName().isBlank())
            throw new IllegalArgumentException("Department name cannot be empty.");
        if (dept.getBudget() < 0)
            throw new IllegalArgumentException("Budget cannot be negative.");
        deptRepo.create(dept);
    }

    public Department getDepartmentById(int id) throws SQLException {
        Department dept = deptRepo.findById(id);
        if (dept == null) throw new IllegalArgumentException("Department not found: " + id);
        return dept;
    }

    public List<Department> getAllDepartments() throws SQLException {
        return deptRepo.findAll();
    }

    public void updateDepartment(Department dept) throws SQLException {
        getDepartmentById(dept.getDepartmentId());
        if (dept.getBudget() < 0)
            throw new IllegalArgumentException("Budget cannot be negative.");
        deptRepo.update(dept);
    }

    public void deleteDepartment(int id) throws SQLException {
        getDepartmentById(id);
        deptRepo.delete(id);
    }
}
