package com.het.practicalsix;

@FunctionalInterface
interface Notifier {
    void send(String message);
}

interface Urgent {

}

class EmailSender implements Notifier, Urgent {

    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}

class SMSSender implements Notifier, Urgent {

    @Override
    public void send(String message) {
        System.out.println("SMS: " + message);
    }
}

public class NotificationSender {

    public static void main(String[] args) {

        Notifier email = message -> System.out.println("Email: " + message);

        Notifier sms = message -> System.out.println("SMS: " + message);

        Notifier[] senders = {email, sms};

        String message = "Message at 10 a.m.";

        for (Notifier sender : senders) {
            sender.send(message);

            if (sender instanceof Urgent)
                sender.send(message);
        }
    }
}
