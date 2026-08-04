package com.het.practicalone;

import java.util.Scanner;

enum Coin {
    ONE, TWO, FIVE, TEN
}

public class VendingMachine {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int snackPrice = 15;
        int runningTotal = 0;

        while(runningTotal < snackPrice){
            System.out.print("Enter coin name: ");
            String input = scanner.nextLine().toUpperCase();

            Coin coin = Coin.valueOf(input);

            int value = switch (coin) {

                case ONE -> 1;
                case TWO -> 2;
                case FIVE -> 5;
                case TEN -> 10;
            };

            runningTotal += value;
            System.out.println("Total: " + runningTotal);
        }

        int change = runningTotal - snackPrice;
        System.out.println("Change: " + change);

        scanner.close();
    }
}
