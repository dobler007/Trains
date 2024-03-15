package com.company;

import RailroadCars.Railroad;

import java.util.ArrayList;

public class TrainSet implements Runnable {
    Locomotive loc;
    ArrayList<Railroad> rCars;
    int maxCars;
    int maxElec;
    int currLoad;
    Station currentStation;
    Station home;
    Station dest;
    volatile boolean running;
    TrainSet(Locomotive loc, int maxCars, int maxElec, Station home, Station dest){
        this.loc = loc;
        this.rCars = new ArrayList<Railroad>();
        this.maxCars = maxCars;
        this.maxElec = maxElec;
        this.home = home;
        this.dest = dest;
        this.currLoad = 0;
        this.running = false;
        this.currentStation = home;
    }
    public void addRailCar(Railroad railroad){
        if(this.currLoad + railroad.getGrossWeight() >= this.loc.max_weight) {
            System.out.println("Cant add this Railroad. Maximum transporting weight is exceded!");
            return;
        }
        int elecs = 0;
        for(int i = 0; i < rCars.size(); i++){
            if(rCars.get(i).isElectrical()){
                elecs++;
            }
        }
        if(railroad.isElectrical()) elecs++;
        if(elecs > maxElec){
            System.out.println("maximum amount of connections to the electrical grid of " + this.loc.name + " is exceeded!");
            return;
        } else {
            this.rCars.add(railroad);
            this.currLoad += railroad.getGrossWeight();
        }
    }

    public void travelThroughStations() throws InterruptedException {
        this.running = true;
        System.out.println(this.loc.name + " has started it's journey from " + currentStation + "! ");
        while(running){
            double travelTime = Station.tripDistance(this.currentStation, this.currentStation.getNextStation()) / this.loc.speed * 1000;
            Thread.sleep(2000);
            System.out.println(this.loc.name + " is now leaving " + this.currentStation);
            Thread.sleep((long) (travelTime));
            this.currentStation = currentStation.getNextStation();
            System.out.println(this.loc.name + " has arrived to " + this.currentStation);

            if(currentStation == dest){
                System.out.println(this.loc.name + " has reached the destination!");
                Thread.sleep(30000);
                System.out.println(this.loc.name + " is now heading back to" + home);
                while(currentStation != home){
                    travelTime = currentStation.distance / this.loc.speed * 1000;
                    Thread.sleep(2000);
                    System.out.println(this.loc.name + " is now leaving " + this.currentStation);
                    Thread.sleep((long) (travelTime));
                    this.currentStation = currentStation.getPrevStation();
                    System.out.println(this.loc.name + " came back to " + this.currentStation);
                }
                System.out.println(this.loc.name + " came back home! ");
                Thread.sleep(30000);
            }
        }

    }

    public void stopper() {
        this.running = false;
        System.out.println(this.loc.name + " has stopped it's journey and is now currently in " + currentStation);
    }

    @Override
    public String toString() {
        return this.loc.name + "{" +
                "speed - " + this.loc.speed +
                " maxCars=" + maxCars +
                ", maxElec=" + maxElec +
                "," + " gross weight: " + currLoad + ", Railroad Cars: " + rCars +'}';
    }

    @Override
    public void run() {

        try{
            this.travelThroughStations();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
