package com.het.practicaltwo;

public class ParkingLot {

    private int twoWheelers;
    private int fourWheelers;

    private final int twoCap;
    private final int fourCap;

    private static long revenue = 0;

    public ParkingLot(int twoCap, int fourCap) {
        this.twoCap = twoCap;
        this.fourCap = fourCap;
    }

    public int getTwoWheelers() {
        return twoWheelers;
    }

    public int getFourWheelers() {
        return fourWheelers;
    }

    public static long getRevenue() {
        return revenue;
    }

    public void park(String type) {

        if (type.equalsIgnoreCase("two")) {

            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue += 20;
                System.out.println("Two-wheeler parked.");

            } else
                System.out.println("Full");

        } else if (type.equalsIgnoreCase("four")) {

            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue += 40;
                System.out.println("Four-wheeler parked.");

            } else
                System.out.println("Full");

        } else
            System.out.println("Invalid vehicle type.");
    }

    public void leave(String type) {

        if (type.equalsIgnoreCase("two")) {

            if (twoWheelers > 0) {
                twoWheelers--;
                System.out.println("Two-wheeler left.");
            }

        } else if(type.equalsIgnoreCase("four")) {

            if (fourWheelers > 0) {
                fourWheelers--;
                System.out.println("Four-wheeler left.");
            }
        }
    }

    public static void main(String[] args) {

        ParkingLot lot = new ParkingLot(2, 1);

        lot.park("two");
        lot.park("two");
        lot.park("two");      // Full

        lot.park("four");
        lot.park("four");     // Full

        lot.leave("two");

        lot.park("two");

        System.out.println();

        System.out.println("Two-wheelers: " + lot.getTwoWheelers());
        System.out.println("Four-wheelers: " + lot.getFourWheelers());
        System.out.println("Revenue: " + ParkingLot.getRevenue());
    }
}
