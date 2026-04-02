package Lab3.prob3;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Part A: Inheritance ===");
        Lab3.prob3.PartA.Circle circleA = new Lab3.prob3.PartA.Circle(5.0);
        System.out.println("Circle Area: " + circleA.computeArea());

        Lab3.prob3.PartA.Cylinder cylinderA = new Lab3.prob3.PartA.Cylinder(5.0, 10.0);
        System.out.println("Cylinder Volume: " + cylinderA.computeVolume());

        System.out.println("=== Part B: Composition ===");
        Lab3.prob3.PartB.Circle circleB = new Lab3.prob3.PartB.Circle(5.0);
        System.out.println("Circle Area: " + circleB.computeArea());

        Lab3.prob3.PartB.Cylinder cylinderB = new Lab3.prob3.PartB.Cylinder(5.0, 10.0);
        System.out.println("Cylinder Volume: " + cylinderB.computeVolume());
    }
}
