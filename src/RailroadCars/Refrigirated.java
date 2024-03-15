package RailroadCars;

public class Refrigirated extends BasicFreight {




    public Refrigirated(double netWeight, double grossWeight, double maxWeight) {
        super(netWeight, grossWeight, maxWeight);
        this.electrical = true;
    }

    @Override
    public String toString() {
        return "Refrigirated{" +
                "maxWeight=" + maxWeight +
                ", netWeight=" + netWeight +
                ", grossWeight=" + grossWeight +
                ", electrical=" + electrical +
                '}';
    }
}
