package RailroadCars;

public class ToxicCar extends HeavyFreight {



    public ToxicCar(double netWeight, double grossWeight, double maxWeight) {
        super(netWeight, grossWeight, maxWeight);
        this.electrical = false;
    }

    @Override
    public String toString() {
        return "ToxicCar{" +
                "maxWeight=" + maxWeight +
                ", netWeight=" + netWeight +
                ", grossWeight=" + grossWeight +
                ", electrical=" + electrical +
                '}';
    }
}
