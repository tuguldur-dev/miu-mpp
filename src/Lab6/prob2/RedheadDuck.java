package Lab6.prob2;

public class RedheadDuck extends Duck {
    RedheadDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("Redhead Duck:");
    }
}
