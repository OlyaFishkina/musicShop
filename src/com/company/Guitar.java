package com.company;

public class Guitar extends Instrument {
    int amountOfStrings;

    public Guitar(String name, int amount, double cost, int amountOfStrings) {
        super(name, amount, cost);
        this.amountOfStrings = amountOfStrings;
    }

    @Override
    public String toString() {
        return "Guitar{" +
                "amountOfStrings=" + amountOfStrings +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", cost=" + cost +
                '}';
    }
}
