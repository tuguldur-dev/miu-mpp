package Lab3.prob4;


public class House extends Property {
    private double lotSize;

    public House(double lotSize) {
        super();
        this.lotSize = lotSize;
    }

    public House(String address, double lotSize) {
        super(address);
        this.lotSize = lotSize;
    }

    public double getLotSize() {
        return lotSize;
    }

    @Override
    public double computeRent() {
        return  0.1 * lotSize;
    }
}
