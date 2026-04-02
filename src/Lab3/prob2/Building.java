package Lab3.prob2;

public class Building {
    private Apartment[] apartments;
    private double maintenanceCost;
    private int count = 0;

    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    public Building(int capacity, double maintenanceCost) {
        apartments = new Apartment[capacity];
        this.maintenanceCost = maintenanceCost;
    }

    public void addApartment(Apartment apartment) {
        this.apartments[count++] = apartment;
    }

    public Apartment[] getApartments(){
        return apartments;
    }
}
