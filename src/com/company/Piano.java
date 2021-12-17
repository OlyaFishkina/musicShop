package com.company;

public class Piano extends Instrument {
    String color;

    public Piano(String name, int amount, double cost, String color) {
        super(name, amount, cost);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Piano{" +
                "color='" + color + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", cost=" + cost +
                '}';
    }
}
