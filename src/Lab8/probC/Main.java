package Lab8.probC;

import Lab8.probC.model.Employee;
import Lab8.probC.repository.EmployeeRepository;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeRepository repo = new EmployeeRepository();

        try {
            Employee newEmp = new Employee(0, "Dorj", 85000, 1, 2);
            repo.create(newEmp);

            List<Employee> list = repo.findAll();
            for (Employee e : list) {
                System.out.println(e.getEmp_id() + " | " + e.getName() + " | " + e.getSalary());
            }

            if (!list.isEmpty()) {
                int idToTest = list.get(0).getEmp_id();

                Employee found = repo.findById(idToTest);
                if (found != null) {
                    found.setName("Dorj Updated");
                    repo.update(found);

                    Employee updated = repo.findById(idToTest);
                    System.out.println("Updated Name: " + updated.getName());
                }

                repo.delete(idToTest);
                System.out.println("Deleted ID: " + idToTest);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}