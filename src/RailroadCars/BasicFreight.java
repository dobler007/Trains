package RailroadCars;

import RailroadCars.Railroad;

public class BasicFreight extends Railroad {

    double maxWeight;
    public BasicFreight(double netWeight, double grossWeight, double maxWeight) {
        super(netWeight, grossWeight);
        this.maxWeight = maxWeight;

        this.electrical = false;
    }

}
