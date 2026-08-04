package com.het.practicalfour;

import java.util.Scanner;

class ChatFilter {

    public static String filterLogs(String[] logs, String keyword) {

        StringBuilder report = new StringBuilder();
        int count = 0;

        for (String line : logs) {
            String[] parts = line.split(" ", 3);

            if (parts.length < 3)
                continue;

            String time = parts[0];
            String user = parts[1];
            String message = parts[2];

            if (message.toLowerCase().contains(keyword.toLowerCase())) {
                count++;

                report.append(time)
                        .append(" ")
                        .append(user)
                        .append(": ")
                        .append(message)
                        .append("\n");
            }
        }

        return "Matches: " + count + "\n" + report;
    }
}

public class ChatLogFilter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] logs = {
                "10:05 Alice Hello there",
                "10:10 Bob How are you?",
                "10:15",
                "10:20 Charlie Nice to say hello again"
        };

        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();

        String result = ChatFilter.filterLogs(logs, keyword);
        System.out.println(result);

        scanner.close();
    }
}
