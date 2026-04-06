package Lab6.prob2;

public class CannotFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("  Cannot fly!");
    }
}
