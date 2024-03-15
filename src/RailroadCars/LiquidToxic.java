package RailroadCars;

public class LiquidToxic extends LiquidCar {

    public LiquidToxic(double netWeight, double grossWeight, double maxWeight) {
        super(netWeight, grossWeight, maxWeight);
        this.electrical = false;
    }

    @Override
    public String toString() {
        return "LiquidToxic{" +
                "maxWeight=" + maxWeight +
                ", netWeight=" + netWeight +
                ", grossWeight=" + grossWeight +
                ", electrical=" + electrical +
                '}';
    }
}
