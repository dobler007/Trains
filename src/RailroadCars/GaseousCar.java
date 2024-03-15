package RailroadCars;

import RailroadCars.BasicFreight;

public class GaseousCar extends BasicFreight {
    String gasType;
    boolean explosive;
    double gasWeight;
    public GaseousCar(double netWeight, double grossWeight,  double maxWeight, String gasType) {
        super(netWeight, grossWeight, maxWeight);
        this.gasType = gasType;
        this.electrical = false;
        this.explosive = false;
    }

    @Override
    public String toString() {
        return "GaseousCar{" +
                "maxWeight=" + maxWeight +
                ", gasType='" + gasType + '\'' +
                ", explosive=" + explosive +
                ", gasWeight=" + gasWeight +
                ", netWeight=" + netWeight +
                ", grossWeight=" + grossWeight +
                ", electrical=" + electrical +
                '}';
    }

    public void loadGas(double gasWeight){
        this.explosive = true;
        this.grossWeight = this.netWeight + gasWeight;
        this.gasWeight += gasWeight;
    }
    public void unloadGas(double gasWeight){
        if(this.gasWeight >= gasWeight){
            this.gasWeight = this.gasWeight - gasWeight;
            if(this.gasWeight == 0){
                this.explosive = false;
            }
        }else System.out.println("There is not enough gasWeight to unload");
    }
}
