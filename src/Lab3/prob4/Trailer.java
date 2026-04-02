package Lab3.prob4;

public class Trailer extends Property {
    public Trailer() {
        super();
    }

    public Trailer(String trailerParkAddress) {
        super(trailerParkAddress);
    }


    @Override
    public double computeRent() {
        return 500;
    }
}