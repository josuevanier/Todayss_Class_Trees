package org.example;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

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
        DateFormat germanDateTimeFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, deLocale);

        // Format the date and time using the German locale
        String formattedDateTimeDE = germanDateTimeFormat.format(now);
        System.out.println("Formatted Date and Time (German): " + formattedDateTimeDE);

        // Attempting to format the date and time using the NumberFormat instance meant for the German locale
        // This will throw an exception because NumberFormat is not meant for formatting dates and times
        // String formattedDateTimeWithNumberFormat = deNumberFormat.format(now);
        // System.out.println("Formatted Date and Time with NumberFormat (German): " + formattedDateTimeWithNumberFormat);
    }

}class LocaleDemo {

    public static void main(String[] args) {
        // Creating Locale objects using constructors
        Locale deLocale = new Locale("de", "DE"); // German locale
        Locale usLocale = new Locale("en", "US"); // US English locale

        // Creating Locale objects using forLanguageTag() method
        Locale deLocaleTag = Locale.forLanguageTag("de-DE"); // German locale
        Locale usLocaleTag = Locale.forLanguageTag("en-US"); // US English locale

        long number = 1234567890L;

        // Formatting numbers based on locale
        NumberFormat deNumberFormat = NumberFormat.getInstance(deLocale);
        NumberFormat usNumberFormat = NumberFormat.getInstance(usLocale);

        // Printing formatted numbers
        System.out.println("Formatted number in German locale: " + deNumberFormat.format(number));
        System.out.println("Formatted number in US English locale: " + usNumberFormat.format(number));

        // Creating NumberFormat objects using getInstance() method
        NumberFormat deNumberFormatShort = NumberFormat.getInstance(deLocale);
        NumberFormat usNumberFormatShort = NumberFormat.getInstance(usLocale);

        // Printing formatted numbers
        System.out.println("Short formatted number in German locale: " + deNumberFormatShort.format(number));
        System.out.println("Short formatted number in US English locale: " + usNumberFormatShort.format(number));

        // Creating Date object
        Date now = new Date();

        // Formatting date based on locale
        DateFormat usDateTimeFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, deLocale);
        System.out.println("Formatted date and time in German locale: " + usDateTimeFormat.format(now));

        // Formatting date and time in default locale (German)
        System.out.println("Formatted date and time in default locale (German): " + deNumberFormat.format(now));

        // Getting currency instances for locales
        Currency deCurrency = Currency.getInstance(deLocale);
        Currency usCurrency = Currency.getInstance(usLocale);

        // Printing currency symbols
        System.out.println("Currency symbol for German locale: " + deCurrency.getSymbol());
        System.out.println("Currency symbol for US English locale: " + usCurrency.getSymbol());
    }

}
class LocaleDemos {

    public static void main(String[] args) {
        LocaleDemos demo = new LocaleDemos();
        demo.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        // Ask user for input format
        System.out.print("Enter input format (e.g., 'de-DE', 'en-US'): ");
        String inputFormat = scanner.nextLine();

        // Parse user input to create locale
        Locale userLocale = parseLocale(inputFormat);

        // Format number and date based on user locale
        formatNumberAndDate(userLocale);
    }

    private Locale parseLocale(String inputFormat) {
        String[] parts = inputFormat.split("-");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid input format. Expected format: language-country");
        }
        String language = parts[0];
        String country = parts[1];
        return new Locale(language, country);
    }

    private void formatNumberAndDate(Locale userLocale) {
        long number = 1234567890L;

        // Format number based on user locale
        NumberFormat numberFormat = NumberFormat.getInstance(userLocale);
        System.out.println("Formatted number in user locale: " + numberFormat.format(number));

        // Format date based on user locale
        Date now = new Date();
        DateFormat dateTimeFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, userLocale);
        System.out.println("Formatted date and time in user locale: " + dateTimeFormat.format(now));
    }
}
class eXAPLE{
    public static void main(String[] args) {
        Locale enLocale = Locale.forLanguageTag("en-US");
        Locale deLocale = Locale.GERMANY; // constant
        Locale deLocaleForUS = Locale.forLanguageTag("de-Germany");
        long number = 12345989898L;
        NumberFormat enNumberFormat = NumberFormat.getInstance(enLocale);
        NumberFormat deNumberFormat = NumberFormat.getInstance(deLocale);
        NumberFormat deNumberFormatForUS = NumberFormat.getInstance(deLocaleForUS);
        NumberFormat enNumberFormatForUS = NumberFormat.getInstance(enLocale);
        System.out.println(deNumberFormat.format(number));
        System.out.println(enNumberFormat.format(number));
    }
}
