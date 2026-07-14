package com.het.practicalthree;

import java.util.Objects;

class Fraction {

    private int num;
    private int den;

    public Fraction(int num, int den) {

        if (den == 0)
            throw new IllegalArgumentException("Denominator cannot be zero.");

        int g = gcd(num, den);

        this.num = num / g;
        this.den = den / g;

        if (this.den < 0) {
            this.num = -this.num;
            this.den = -this.den;
        }
    }

    @Override
    public String toString() {
        return num + "/" + den;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return num == fraction.num && den == fraction.den;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, den);
    }

    private int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
}

public class FractionDemo {

    public static void main(String[] args) {

        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        Fraction f3 = new Fraction(3, 6);

        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);

        System.out.println();

        System.out.println("f1 equals f2 : " + f1.equals(f2));
        System.out.println("f2 equals f3 : " + f2.equals(f3));
        System.out.println("f1 equals f3 : " + f1.equals(f3));
    }
}
