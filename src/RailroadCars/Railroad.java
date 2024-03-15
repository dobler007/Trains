package RailroadCars;

public class Railroad {
 double netWeight;
 double grossWeight;
 protected boolean electrical;

 public Railroad(double netWeight, double grossWeight) {
  this.netWeight = netWeight;
  this.grossWeight = grossWeight;
  this.electrical = false;
 }
 public void setToGrid(){
  this.electrical = true;
 }

 public double getGrossWeight() {
  return grossWeight;
 }

 public boolean isElectrical() {
  return electrical;
 }
}
