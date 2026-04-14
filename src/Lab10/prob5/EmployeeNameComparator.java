package Lab10.prob5;


import java.util.Comparator;

/* A functor, but not a closure */
public class EmployeeNameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		int nameCompare = e1.getName().compareTo(e2.getName());
		if(nameCompare != 0) {
			return nameCompare;
		}
		return Integer.compare(e1.getSalary(), e2.getSalary());
	}
}
