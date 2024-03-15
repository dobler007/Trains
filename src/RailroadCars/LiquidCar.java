package RailroadCars;

public class LiquidCar extends BasicFreight {

    public LiquidCar(double netWeight, double grossWeight, double maxWeight) {


        super(netWeight, grossWeight, maxWeight);
        this.electrical = false;
    }

    @Override
    public String toString() {
        return "LiquidCar{" +
                "maxWeight=" + maxWeight +
                ", netWeight=" + netWeight +
                ", grossWeight=" + grossWeight +
                ", electrical=" + electrical +
                '}';
    }
}
