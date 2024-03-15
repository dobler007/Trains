package RailroadCars;

import RailroadCars.Railroad;

public class PassangerCar extends Railroad {
    int seatsCap;
    String type;
    int currentPassangers;

    public PassangerCar(double netWeight, double grossWeight, int seatsCap, String type) {
        super(netWeight, grossWeight);
        this.seatsCap = seatsCap;
        this.type = type;
        this.electrical = true;
        this.currentPassangers = 0;
    }

    @Override
    public String toString() {
        return "PassangerCar{" +
                "seatsCap=" + seatsCap +
                ", type='" + type + '\'' +
                ", currentPassangers=" + currentPassangers +
                ", netWeight=" + netWeight +
                ", grossWeight=" + grossWeight +
                ", electrical=" + electrical +
                '}';
    }

    public void leave(int amount){
        if(this.currentPassangers > amount){
            this.currentPassangers += amount;
        } else this.currentPassangers = 0;
    }
    public void getOn(int amount){
        if(amount + this.currentPassangers > seatsCap){
            System.out.println("not enough seats");
        }else this.currentPassangers += amount;
    }



}
