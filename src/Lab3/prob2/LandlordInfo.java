package Lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class LandlordInfo {
    List<Building> buildings;

    public LandlordInfo() {
        buildings = new ArrayList<>();
    }

    public double calcProfits() {
        double profits = 0;
        for (Building building : buildings) {
            Apartment[] apartments = building.getApartments();
            for (Apartment apartment : apartments) {
                if (apartment != null) {
                    profits += apartment.getRent();
                }
            }
            profits -= building.getMaintenanceCost();
        }
        return profits;
    }

    public void addBuilding(Building building) {
        this.buildings.add(building);
    }
}
