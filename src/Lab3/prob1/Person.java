package Lab3.prob1;


public class Person {

	private String name;
	Person(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;

		if (obj instanceof Person) {
			return this.name.equals(((Person) obj).getName());
		}

		if (obj instanceof PersonWithJob) {
			return this.name.equals(((PersonWithJob) obj).getName());
		}

		return false;
	}
	public static void main(String[] args) {

	}

}
