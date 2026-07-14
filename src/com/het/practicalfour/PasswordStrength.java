package com.het.practicalfour;

class PasswordChecker {

    public boolean hasLength(String password) {
        return password.length() >= 8;
    }

    public boolean hasUpperCase(String password) {
        return password.matches("^(?=.*[A-Z]).+$");
    }

    public boolean hasDigit(String password) {
        return password.matches("^(?=.*\\d).+$");
    }

    public boolean hasSpecial(String password) {
        return password.matches("^(?=.*[!@#$%^&*(),.?\":{}|<>]).+$");
    }

    public String strength(String password) {

        int count = 0;

        if (hasLength(password))
            count++;

        if (hasUpperCase(password))
            count++;

        if (hasDigit(password))
            count++;

        if (hasSpecial(password))
            count++;

        if (count <= 1)
            return "Weak";

        else if (count <= 3)
            return "Medium";

        else
            return "Strong";
    }
}

public class PasswordStrength {

    public static void main(String[] args) {

        PasswordChecker passwordChecker = new PasswordChecker();

        String[] passwords = {
                "abc",
                "password",
                "Password",
                "Password1",
                "Abcd1234!"
        };

        for (String password : passwords) {
            System.out.println("Password: " + password);
            System.out.println("Strength          : " + passwordChecker.strength(password));
        }
    }
}
