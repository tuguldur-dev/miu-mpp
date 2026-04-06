package Lab6.prob2;

public class Main {
    static void main() {
        Duck[] ducks = {new MallardDuck(), new DecoyDuck(), new RedheadDuck(), new RubberDuck()};
        for(Duck d: ducks){
            System.out.println(d.getClass().getSimpleName() + ":");
            d.display();
            d.fly();
            d.quack();
            d.swim();
        }

    }
}
