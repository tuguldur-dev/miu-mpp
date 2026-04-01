package Lab2.prob2A;

public class GradeReport {
    private Student student;

    @Override
    public String toString() {
        return "GradeReport{student=" + student.getName() + "}";
    }

    public GradeReport(Student student){
        this.student = student;
    }
}
