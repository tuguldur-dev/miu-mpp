package Lab3.prob4;

public abstract class Property {
    private String city;

    public Property(String address) {
        this.city = address;
    }

    public Property() {}

    public String getCity() {
        return city;
    }

    public abstract double computeRent();
}
