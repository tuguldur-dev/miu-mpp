package Lab11b;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Address add1 = new Address("500 E Broadway Ave", "Fairfield", "IA", 52556);
        Address add2 = new Address("103 W Adams Ave", "Fairfield", "IA", 52556);

        Section cs545_1 = new Section(900, "CS545");
        Section cs545_2 = new Section(901, "CS545");
        Section cs401 = new Section(902, "CS401");
        Section cs221 = new Section(903, "CS221");

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(111, "Yasmeen", new ArrayList<>(Arrays.asList(3.9, 4.0, 3.7)), add1,
                        new ArrayList<>(Arrays.asList(cs545_1, cs401))),
                new Student(112, "Mira", new ArrayList<>(Arrays.asList(4.0, 4.0, 3.9)), add1,
                        new ArrayList<>(Arrays.asList(cs545_2, cs401, cs221))),
                new Student(113, "Zaina", new ArrayList<>(Arrays.asList(3.6, 3.3, 3.7)), add1,
                        new ArrayList<>(Arrays.asList(cs221, cs401))),
                new Student(114, "Khaled", new ArrayList<>(Arrays.asList(3.0, 2.8, 3.1)), add2)
        ));


        // Find all the students that are taking a given course
        System.out.println("All student taking course " + students.stream().filter(e -> e.sections != null && !e.sections.isEmpty()).toList());

        // Get the address of any student that is taking a given course (e.g., "CS401")
        System.out.println("CS401 address: " + students.stream()
                .filter(e -> e.sections != null && e.sections.stream()
                        .anyMatch(s -> s.getCourseCode().equals("CS401")))
                .map((e) -> e.address.toString())
                .toList());

        // Calculate the GPA for a given student

        double grades = students.stream()
                .filter(e -> e.id == 111)
                .findFirst()
                .map(s -> s.grades.stream()
                        .mapToDouble(e -> e)
                        .average()
                        .orElse(0.0))
                .orElse(0.0);
        System.out.println("Grade: " + grades);

        // Find the student with the highest GPA

        Student maxGrad = students.stream().max(Comparator.comparing(s ->
                s.grades.stream().mapToDouble(e -> e).average().orElse(0.0))).orElse(null);

        System.out.println("Highest GPU student: " + maxGrad);

        // Get a list of all unique courses taken by students
        List<Section> sections = students.stream()
                .flatMap(e -> e.sections != null ? e.sections.stream() : Stream.empty())
                .distinct().toList();
        System.out.println("Unique courses: " + Arrays.toString(sections.toArray()));

        // Find all students who live in a given city (e.g., "Fairfield") sorted in alphabetical order

        List<Student> studentsLivedInFairfield = students.stream()
                .filter(e -> e.address.city.equals("Fairfield"))
                .sorted(Comparator.comparing(s -> s.name))
                .toList();
        System.out.println("Fairfield's students: " + studentsLivedInFairfield);
        // Count the number of students enrolled in a specific course (e.g., "CS401")

        double studentsCS401 = students.stream()
                .filter(e -> e.sections != null &&
                        e.sections.stream()
                                .anyMatch(d -> d.getCourseCode()
                                        .equals("CS401"))).count();
        System.out.println("Students learning CS401: " + studentsCS401);

        // Get a list of students in a specific section

        List<Student> specificSectionStudent = students.stream()
                .filter(e -> e.sections != null && e.sections.stream()
                        .anyMatch(s -> s.getCourseCode().equals("CS401"))).toList();

        System.out.println("Students list learning CS401: " + Arrays.toString(specificSectionStudent.toArray()));
        //  Get the names of students who have enrolled in more than a given number of courses (e.g., more than 2 courses)
        List<String> namesEnrolledMore = students.stream()
                .filter(e -> e.sections != null && e.sections.size() > 2)
                .map(d -> d.name).toList();
        System.out.println("Students who enrolled more than 2 courses: " + Arrays.toString(namesEnrolledMore.toArray()));
        // Get a list of unique course names taken by students who live in a given city (e.g., "Fairfield")
        List<String> coursesWhoLivedFairfield = students.stream()
                .filter(e -> e.address.city.equals("Fairfield"))
                .filter(d -> d.sections != null)
                .flatMap(e -> e.sections.stream())
                .map(Section::getCourseCode)
                .distinct().toList();
        System.out.println("Courses which taken by Fairfield: " + coursesWhoLivedFairfield);
        // Get a list of distinct addresses of students who are taking a specific course (e.g., "CS401")
        List<Address> addresses = students.stream()
                .filter(e -> e.sections != null && e.sections.stream()
                        .anyMatch(d -> d.getCourseCode().equals("CS401")))
                .map(d -> d.address).distinct().toList();
        System.out.println("Address of student who taking CS401: " + addresses);
        // Get a mapping of students' names to the list of courses they are taking
        Map<String, List<String>> courseMap = students.stream().filter(e -> e.sections != null)
                .collect(Collectors.toMap(
                        Student::getName,
                        s -> s.sections.stream()
                                .map(Section::getCourseCode)
                                .toList()
                ));
        System.out.println("Mapping: " + courseMap);

    }
}
