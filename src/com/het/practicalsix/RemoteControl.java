package com.het.practicalsix;

interface Switchable {

    void on();

    void off();

    default void toggle() {
        on();
        off();
    }
}

class Fan implements Switchable {

    @Override
    public void on() {
        System.out.println("Fan is On.");
    }

    @Override
    public void off() {
        System.out.println("Fan is Off.");
    }
}

class Light implements Switchable {

    @Override
    public void on() {
        System.out.println("Light is On.");
    }

    @Override
    public void off() {
        System.out.println("Light is Off.");
    }
}

@FunctionalInterface
interface SwitchPermission {
    boolean maySwitchOn(Switchable device, int hour);
}

public class RemoteControl {

    public static void main(String[] args) {

        Switchable[] devices = {
                new Fan(),
                new Light()
        };

        System.out.println("Toggling Devices:");
        for (Switchable device : devices) {
            device.toggle();
        }

        // Anonymous Class
        SwitchPermission permission = new SwitchPermission() {
            @Override
            public boolean maySwitchOn(Switchable device, int hour) {
                return hour >= 6 && hour <= 22;
            }
        };

        System.out.println("Fan at 10:00 a.m." +
                           permission.maySwitchOn(new Fan(), 10));

        // Lambda Expression
        SwitchPermission permission1 = (device, hour) -> (hour >= 6 && hour <= 22);

        System.out.println("Light at 2:00 a.m." +
                           permission1.maySwitchOn(new Light(), 2));
    }
}
