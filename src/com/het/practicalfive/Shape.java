package com.het.practicalfive;

public abstract class Shape {

    public abstract double calculateArea();
}

class Circle extends Shape {

    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {

    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}


class Triangle extends Shape {

    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

class Main {

    public static void main(String[] args) {

        Shape[] shapes = {
                new Circle(5),
                new Rectangle(4, 6),
                new Triangle(8, 3),
                new Circle(3)
        };

        double total = 0;
        double largest = 0;

        for (Shape shape : shapes) {
            double area = shape.calculateArea();
            System.out.printf("Area: %.2f\n", area );
            total += area;

            if (area > largest)
                largest = area;
        }

        System.out.printf("Total area: %.2f\n", total);
        System.out.printf("Largest area: %.2f\n", largest);
    }
}
