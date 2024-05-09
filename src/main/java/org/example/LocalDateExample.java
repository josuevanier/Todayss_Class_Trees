package org.example;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class LocalDateExample {
    public static void main(String[] args) {
        // Create a Locale for German language in Germany
        Locale deLocale = new Locale("de", "DE");

        // Create a Locale for English language in the United States
        Locale usLocale = new Locale("en", "US");

        // Create a NumberFormat instance for the German locale
        NumberFormat deNumberFormat = NumberFormat.getInstance(deLocale);

        // Create a NumberFormat instance for the US locale
        NumberFormat usNumberFormat = NumberFormat.getInstance(usLocale);

        // Number to be formatted
        long number = 12345989898L;

        // Format the number using the German locale
        String formattedNumberDE = deNumberFormat.format(number);
        System.out.println("Formatted Number (German): " + formattedNumberDE);

        // Format the number using the US locale
        String formattedNumberUS = usNumberFormat.format(number);
        System.out.println("Formatted Number (US): " + formattedNumberUS);

        // Create another NumberFormat instance for the German locale
        NumberFormat deNumberFormat2 = NumberFormat.getInstance(deLocale);

        // Create another NumberFormat instance for the US locale
        NumberFormat usNumberFormat2 = NumberFormat.getInstance(usLocale);

        // Format the number again using the German locale
        String formattedNumberDE2 = deNumberFormat2.format(number);
        System.out.println("Formatted Number (German 2nd): " + formattedNumberDE2);

        // Format the number again using the US locale
        String formattedNumberUS2 = usNumberFormat2.format(number);
        System.out.println("Formatted Number (US 2nd): " + formattedNumberUS2);


        // Get the current date and time
        Date now = new Date();

        // Create a DateFormat instance for displaying date and time in long format for the German locale
        DateFormat germanDateTimeFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, deLocale);

        // Format the date and time using the German locale
        String formattedDateTimeDE = germanDateTimeFormat.format(now);
        System.out.println("Formatted Date and Time (German): " + formattedDateTimeDE);

        // Attempting to format the date and time using the NumberFormat instance meant for the German locale
        // This will throw an exception because NumberFormat is not meant for formatting dates and times
        // String formattedDateTimeWithNumberFormat = deNumberFormat.format(now);
        // System.out.println("Formatted Date and Time with NumberFormat (German): " + formattedDateTimeWithNumberFormat);
    }
}
