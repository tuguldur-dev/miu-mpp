package Lab2.prob2A;

public class Student {
    private String name;
    private GradeReport gradeReport;

    @Override
    public String toString() {
        return "Student{name='" + name + "'}";
    }

    public String getName() {
        return name;
    }

    public Student(String name){
        this.name = name;
        gradeReport = new GradeReport(this);
    }
}
