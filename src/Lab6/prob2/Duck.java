package Lab6.prob2;

public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;
    void quack() { quackBehavior.quack(); }
    void swim()  { System.out.println("  Swimming"); }
    void fly()   { flyBehavior.fly(); }
    public abstract void display();
}
