package RailroadCars;

import RailroadCars.Railroad;

public class HeavyFreight extends Railroad {

    double maxWeight;


    public HeavyFreight(double netWeight, double grossWeight, double maxWeight) {
        super(netWeight, grossWeight);
        this.maxWeight = maxWeight;
        this.electrical = false;
    }

}
