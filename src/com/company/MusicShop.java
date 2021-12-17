package com.company;


import java.util.*;

public class MusicShop {
    Instrument[] store;
    Scanner scan = new Scanner(System.in);

    public MusicShop() {
        this.store = new Instrument[]{
                new Piano("Piano", 2, 15000, "white"),
                new Guitar("Guitar", 16, 5000, 5),
                new Trumpet("Trumpet", 7, 4000)
        };
    }

    public void openMusicShop() {

        int choose = -1;
        System.out.println("Welcome dear seller");

        do {
            System.out.println("Enter: 1.Report,2.Sale,0.Exit");
            choose = scan.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Now in the store:");
                    for (int i = 0; i < store.length; i++) {
                        System.out.println(store[i]);
                    }
                    System.out.println();
                    break;
                case 2:
                    sale();
                    break;
                case 0:
                    System.out.println("The work is stop.");
                    break;
                default:
                    System.out.println("Error,incorrect choose");

            }

        } while (choose != 0);

    }

    public void sale() {
        Map<String, Integer> order = new HashMap<>();
        int choose = -1;
        do {
            System.out.print("Choose: 1-Piano, 2-Guitar, 3-Trumpet, 0-Finish component order: ");
            choose = scan.nextInt();
            switch (choose) {
                case 1:
                    System.out.print("Enter amount of piano: ");
                    int pianoAmount = scan.nextInt();
                    if (pianoAmount <= 0) {
                        System.out.println("You put amount that smaller then 1, try again!");
                        continue;
                    }
                    Integer oldPianoAmount = order.get("Piano");
                    if (oldPianoAmount != null) {
                        pianoAmount += oldPianoAmount;
                    }
                    order.put("Piano", pianoAmount);
                    break;
                case 2:
                    int guitarsAmount;
                    do {
                        System.out.print("Enter amount of guitars:");
                        guitarsAmount = scan.nextInt();
                        if (guitarsAmount < 1) {
                            System.out.println("You put amount that smaller then 1, try again!");
                        }
                    } while (guitarsAmount < 1);


                    Integer oldGuitarAmount = order.get("Guitar");
                    if (oldGuitarAmount != null) {
                        guitarsAmount += oldGuitarAmount;
                    }
                    order.put("Guitar", guitarsAmount);
                    break;
                case 3:
                    int trumpetsAmount;
                    do {
                        System.out.print("Enter amount of trumpets:");
                        trumpetsAmount = scan.nextInt();
                        if (trumpetsAmount < 1) {
                            System.out.println("You put amount,that smaller then 1, try again!");
                        }
                    } while (trumpetsAmount < 1);

                    Integer oldTrumpetsAmount = order.get("Trumpet");
                    if (oldTrumpetsAmount != null) {
                        trumpetsAmount += oldTrumpetsAmount;
                    }
                    order.put("Trumpet", trumpetsAmount);
                    break;
                case 0:
                    System.out.println("The order is completed");
                    break;
                default:
                    try {
                        throw new NotSuchKeyException(choose);
                    } catch (NotSuchKeyException n) {
                        n.printNotSuchKey();
                    }
            }
        } while (choose != 0);

        for (Map.Entry<String, Integer> e : order.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
        List<Instrument> list = prepareInstruments(order);

        if (list.isEmpty()) {
            System.out.println("Zakaz onulirovan");
        } else {
            System.out.println("The order is accepted");
            double orderCost = 0;
            for (Instrument e : list) {
                System.out.println(e);
                orderCost += e.cost;
            }
            System.out.println("The order cost is " + orderCost);
            System.out.println("Thank you for your order");
            for (int i = 0; i < store.length; i++) {
                for (int j = 0; j < list.size(); j++) {
                    if (store[i].name.equals(list.get(j).name)) {
                        store[i].amount -= list.get(j).amount;
                        break;
                    }
                }
            }
        }
    }

    public List<Instrument> prepareInstruments(Map<String, Integer> order) {
        List<Instrument> list = new ArrayList<>();

        for (Map.Entry<String, Integer> e : order.entrySet()) {
            for (Instrument storeE : store) {
                if (e.getKey().equals(storeE.name)) {
                    if (e.getValue() > storeE.amount) {
                        try {
                            throw new IllegalArgumentException("We don't have enough " + storeE.name);
                        } catch (IllegalArgumentException exception) {
                            System.out.println(exception.getMessage());
                        }
                        return new ArrayList<>();
                    } else {
                        list.add(new Instrument(e.getKey(), e.getValue(), storeE.cost));
                        break;
                    }
                }
            }
        }

        return list;
    }
}
