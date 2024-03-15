package com.company;


public class Station {
     String name;
     Station prevStation;
     Station nextStation;
     int distance;

    public Station(String name, Station prevStation, int distance) {
        this.name = name;
        this.prevStation = prevStation;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public Station getPrevStation() {
        return prevStation;
    }

    public Station getNextStation() {
        return nextStation;
    }

    public int getDistance() {
        return distance;
    }
    public int getDistanceToNext() {
        return nextStation == null ? 0 : distance;
    }                                   //0             1
    public static int tripDistance(Station start, Station end) {
        int distance = 0;
        Station currentStation = end;

        while(currentStation != start){
            if(currentStation != start && currentStation != null) distance += currentStation.distance;
            currentStation = currentStation.prevStation;
        }
        return distance;
    }

    public void setNextStation(Station nextStation) {
        this.nextStation = nextStation;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Station " + name;
    }

    public boolean isEndOfLine() {
        return this.nextStation == null;
    }
}
