package com.het.practicalfour;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class TemplateFiller {

    public static String fillTemplate(String template, String[] names, String[] values) {

        Pattern pattern = Pattern.compile("\\{(\\w+)}");
        Matcher matcher = pattern.matcher(template);

        StringBuilder result = new StringBuilder();
        int lastIndex = 0;

        while (matcher.find()) {

            result.append(template.substring(lastIndex, matcher.start()));

            String placeholder = matcher.group();
            String replacement = "[?]";

            for (int i = 0; i < names.length; i++) {
                if (names[i].equals(placeholder)) {
                    replacement = values[i];
                    break;
                }
            }

            result.append(replacement);
            lastIndex = matcher.end();
        }

        result.append(template.substring(lastIndex));

        return result.toString();
    }
}

public class Template {

    public static void main(String[] args) {

        String template = "Dear{name}, order{id} ships{date}.";

        String[] names = {"name", "id"};
        String[] values = {"Riya", "A07"};

        String output = TemplateFiller.fillTemplate(template, names, values);

        System.out.println(output);
    }
}
