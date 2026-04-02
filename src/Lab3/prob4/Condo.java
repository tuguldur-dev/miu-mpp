package Lab3.prob4;

public class Condo extends Property {
    private int numFloors;

    public Condo(int numFloors) {
        super();
        this.numFloors = numFloors;
    }

    public int getNumFloors() {
        return numFloors;
    }

    @Override
    public double computeRent() {
        return 400 * numFloors;
    }
}