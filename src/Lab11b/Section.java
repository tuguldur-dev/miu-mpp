package Lab11b;

import java.util.Objects;

public class Section {
    private int id;
    private String courseCode;

    public Section(int id, String courseCode) {
        this.id = id;
        this.courseCode = courseCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return id == section.id && Objects.equals(courseCode, section.courseCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseCode);
    }
}
