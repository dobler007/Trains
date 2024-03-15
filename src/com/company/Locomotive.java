package com.company;

import java.util.ArrayList;
public class Locomotive {
    String name;
    double speed;
    double max_weight;
    boolean running;

    public Locomotive(String name, double speed, double max_weight) {
        this.name = name;
        this.speed = speed;
        this.max_weight = max_weight;
        this.running = false;
    }
    public Locomotive(){
        this.name = "";
        this.speed = 0;
        this.max_weight = 0;
        this.running = false;
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", max_weight=" + max_weight +
                '}';
    }
}