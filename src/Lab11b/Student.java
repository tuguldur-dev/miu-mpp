package Lab11b;

import java.util.List;

public class Student {

    public int id;
    public String name;
    public List<Double> grades;
    public List<Section> sections;
    public Address address;


    public Student(int id, String name, List<Double> grades, Address address) {
        this.id = id;
        this.name = name;
        this.grades = grades;
        this.address = address;
    }

    public Student(int id, String name, List<Double> grades, Address address, List<Section> sections) {
        this.id = id;
        this.name = name;
        this.grades = grades;
        this.address = address;
        this.sections = sections;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
