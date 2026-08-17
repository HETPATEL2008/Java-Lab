package com.het.practicalfive;

abstract class Employee {

    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public abstract double monthlySalary();
}

class FullTimeEmployee extends Employee {

    double fixed;

    FullTimeEmployee(String name, int id, double fixed) {
        super(name, id);
        this.fixed = fixed;
    }

    @Override
    public double monthlySalary() {
        return fixed;
    }
}

class PartTimeEmployee extends Employee {

    double hours;
    double rate;

    PartTimeEmployee(String name, int id, double hours, double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double monthlySalary() {
        return hours * rate;
    }
}

class Intern extends Employee {

    double stipend;

    Intern(String name, int id, double stipend) {
        super(name, id);
        this.stipend = stipend;
    }

    @Override
    public double monthlySalary() {
        return stipend;
    }
}

public class Payroll {

    public static void main(String[] args) {

        Employee[] employees = {
                new FullTimeEmployee("Het", 101, 50000),
                new PartTimeEmployee("Rahul", 102, 80, 300),
                new Intern("Amit", 103, 15000),
                new FullTimeEmployee("Priya", 104, 60000)
        };

        double total = 0;

        for (Employee employee : employees) {
            double salary = employee.monthlySalary();

            System.out.println(
                    "Name: " + employee.name
                    + "\nID: " + employee.id
                    + "\nSalary: " + employee.monthlySalary()
            );

            if (employee instanceof  Intern)
                System.out.println("Note: This employee is an intern.");

            total += salary;
        }

        System.out.println("Total Payroll: " + total);
    }
}
