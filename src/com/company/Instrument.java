package com.company;

public class Instrument {
    String name;
    int amount;
    double cost;

    public Instrument(String name, int amount, double cost) {
        this.name = name;
        this.amount = amount;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", cost=" + cost +
                '}';
    }
}
