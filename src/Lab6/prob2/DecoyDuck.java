package Lab6.prob2;

public class DecoyDuck extends Duck {
    DecoyDuck() {
        flyBehavior = new CannotFly();
        quackBehavior = new MuteQuack();
    }
    @Override
    public void display() {
        System.out.println("Decoy Duck:");
    }
}
