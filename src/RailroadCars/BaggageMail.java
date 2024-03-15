package RailroadCars;

public class BaggageMail extends Railroad {
    double maxAmount;

    public BaggageMail(double netWeight, double grossWeight, double maxAmount) {
        super(netWeight,grossWeight);
        this.maxAmount = maxAmount;
        this.electrical = true;
    }

    @Override
    public String toString() {
        return "BaggageMail{" +
                "maxMails=" + maxAmount +
                ", netWeight=" + netWeight +
                ", grossWeight=" + grossWeight +
                ", electrical=" + electrical +
                '}';
    }
}
