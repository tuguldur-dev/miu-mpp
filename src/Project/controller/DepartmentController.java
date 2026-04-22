package Project.controller;

import Project.model.Department;
import Project.service.DepartmentService;

import java.sql.SQLException;
import java.util.List;

public class DepartmentController {
    private final DepartmentService service = new DepartmentService();

    public void create(Department dept) throws SQLException {
        service.createDepartment(dept);
        System.out.println("Created: " + dept);
    }

    public Department getById(int id) throws SQLException {
        Department dept = service.getDepartmentById(id);
        System.out.println("Found: " + dept);
        return dept;
    }

    public List<Department> getAll() throws SQLException {
        List<Department> list = service.getAllDepartments();
        list.forEach(System.out::println);
        return list;
    }

    public void update(Department dept) throws SQLException {
        service.updateDepartment(dept);
        System.out.println("Updated: " + dept);
    }

    public void delete(int id) throws SQLException {
        service.deleteDepartment(id);
        System.out.println("Deleted department id=" + id);
    }
}
