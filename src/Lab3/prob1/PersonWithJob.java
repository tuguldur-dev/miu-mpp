package Lab3.prob1;

public class PersonWithJob {

	private Person person;
	private double salary;

	PersonWithJob(String n, double s) {
		this.person = new Person(n);
		this.salary = s;
	}

	public String getName() {
		return person.getName();
	}

	public double getSalary() {
		return salary;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;

		if (obj instanceof PersonWithJob) {
			PersonWithJob other = (PersonWithJob) obj;
			return this.person.equals(other.person);
		}
		if (obj instanceof Person) {
			return this.person.equals(obj);
		}
		return false;
	}

	public static void main(String[] args) {
		PersonWithJob p1 = new PersonWithJob("Joe", 30000);
		Person p2 = new Person("Joe");

		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}
}