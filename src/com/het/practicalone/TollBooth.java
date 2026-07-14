package com.het.practicalone;

import java.util.Scanner;

public class TollBooth {

    public record Vehicle(String number, String type) {}

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int totalToll = 0;
        int bikeCount = 0;
        int carCount = 0;
        int truckCount = 0;

        while (true) {
            System.out.print("Enter vehicle number or 'done': ");
            String number = scanner.next();

            if (number.equalsIgnoreCase("done"))
                break;

            System.out.print("Enter vehicle type (Bike, Car, Truck): ");
            String type = scanner.next().toLowerCase();

            Vehicle vehicle = new Vehicle(number, type);

            int toll = switch (vehicle.type()) {

                case "bike" -> {
                    bikeCount++;
                    yield 20;
                }

                case "car" -> {
                    carCount++;
                    yield 50;
                }

                case "truck" -> {
                    truckCount++;
                    yield 150;
                }

                default -> {
                    System.out.println("Unknown vehicle type!");
                    yield 0;
                }
            };

            totalToll += toll;
            System.out.println("Toll charged: " + toll + ", Total toll: " + totalToll);
        }

        System.out.println("----- Summary Report -----");
        System.out.println("Total toll: " + totalToll);

        String mostFrequent = "None";
        int maxCount = 0;

        if (bikeCount > maxCount) {
            maxCount = bikeCount;
            mostFrequent = "Bike";
        }

        if (carCount > maxCount) {
            maxCount = carCount;
            mostFrequent = "Car";
        }

        if (truckCount > maxCount) {
            maxCount = truckCount;
            mostFrequent = "Truck";
        }

        if (maxCount > 0)
            System.out.println("Most frequent: " + mostFrequent);

        else
            System.out.println("Most frequent: No vehicle processed.");

        scanner.close();
    }
}
