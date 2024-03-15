package RailroadCars;

import RailroadCars.HeavyFreight;

public class ExplosiveCar extends HeavyFreight {
boolean explosive;
String type;
double amount;
    public ExplosiveCar(double netWeight, double grossWeight, double maxWeight, String type) {
        super(netWeight, grossWeight, maxWeight);
        this.type = type;
        this.electrical = false;
        this.explosive = false;
        this.amount = 0;
    }

    @Override
    public String toString() {
        return "ExplosiveCar{" +
                "explosive=" + explosive +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", maxWeight=" + maxWeight +
                ", netWeight=" + netWeight +
                ", grossWeight=" + grossWeight +
                ", electrical=" + electrical +
                '}';
    }

    public void loadExplosives(double amount){
            this.explosive = true;
            this.grossWeight = this.netWeight + amount;
            this.amount += amount;
    }
    public void unloadExplosives(double amount){
        if(this.amount >= amount){
            this.amount = this.amount - amount;
            if(this.amount == 0){
                this.explosive = false;
            }
        }else System.out.println("There is not enough explosives. Asking for too much");
    }
}
