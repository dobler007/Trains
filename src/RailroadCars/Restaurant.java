package RailroadCars;

import RailroadCars.Railroad;

public class Restaurant extends Railroad {
    String chef;
    int staffAmount;

    public Restaurant(double netWeight, double grossWeight, String chef, int staffAmount) {
        super(netWeight, grossWeight);
        this.chef = chef;
        this.staffAmount = staffAmount;
        this.electrical = true;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "netWeight=" + netWeight +
                ", grossWeight=" + grossWeight +
                ", electrical=" + electrical +
                ", chef='" + chef + '\'' +
                ", staffAmount=" + staffAmount +
                '}';
    }

    public void hireStaff(int amount){
        this.staffAmount += amount;
        this.grossWeight = this.netWeight + amount * 75;
        //75 is the average weight of the staff;
    }

    public void changeChef(String name){
        this.chef = name;
    }
}
