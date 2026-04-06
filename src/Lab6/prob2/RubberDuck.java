package Lab6.prob2;

public class RubberDuck extends Duck{
    RubberDuck() {
        flyBehavior = new CannotFly();
        quackBehavior = new Squeak();
    }
    @Override
    public void display() {
        System.out.println("Rubber Duck:");
    }
}
