package com.company;

public class Trumpet extends Instrument {

    public Trumpet(String name, int amount, double cost) {
        super(name, amount, cost);
    }

    @Override
    public String toString() {
        return "Trumpet{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", cost=" + cost +
                '}';
    }
}
