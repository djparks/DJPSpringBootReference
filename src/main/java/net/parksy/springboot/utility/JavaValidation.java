package net.parksy.springboot.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class JavaValidation {
    private static String DATE_FORMATTER = "MM-dd-yyyy HH:mm:ss.SSS";

    public static void main(String[] args) {
        DateTimeFormatter validationFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
        String[] exampleInputStrings = { "07-01-2013 12:59:30.123", "07-32-2013 12:59:30", "07-01-2013", "07-01-017",
                "07-01-2ooo", "32-01-2017", "7-1-2013", "07-01-2013 blabla" };

        for (String inputDate : exampleInputStrings) {
            try {
                LocalDateTime date = LocalDateTime.parse(inputDate, validationFormatter);
                System.out.println(inputDate + ": valid date: " + date );
            } catch (DateTimeParseException dtpe) {
                System.out.println(inputDate + ": invalid date: " + dtpe.getMessage());
            }
        }
    }
}
