package RailroadCars;


public class PostOffice extends Railroad {
    double maxMails;

    public PostOffice(double netWeight, double grossWeight, double maxMails) {
        super(netWeight, grossWeight);
        this.maxMails = maxMails;
        this.electrical = true;
    }

    @Override
    public String toString() {
        return "PostOffice{" +
                "maxMails=" + maxMails +
                ", netWeight=" + netWeight +
                ", grossWeight=" + grossWeight +
                ", electrical=" + electrical +
                '}';
    }
}
