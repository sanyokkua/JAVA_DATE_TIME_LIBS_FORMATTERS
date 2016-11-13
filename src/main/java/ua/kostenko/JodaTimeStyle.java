package ua.kostenko;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import java.util.Locale;

import static ua.kostenko.utils.Utils.println;

public class JodaTimeStyle {
    public static void main(String[] args) {
        DateTimeFormatter fullDateTime = DateTimeFormat.fullDateTime();
        DateTimeFormatter shortDateTime = DateTimeFormat.shortDateTime();
        DateTimeFormatter fullDateTimeWithLocale = fullDateTime.withLocale(Locale.US);
        DateTimeFormatter fullDateTimePattern = DateTimeFormat.forPattern("G yyy:MMMM:dd 'Day of year' D 'time zone' z");
        println(fullDateTime.print(DateTime.now())); // 13 ноября 2016 г. 15:53:20 EET
        println(shortDateTime.print(DateTime.now()));// 13.11.16 15:53
        println(fullDateTimeWithLocale.print(DateTime.now()));// Sunday, November 13, 2016 3:53:20 PM EET
        println(fullDateTimePattern.print(DateTime.now()));// н.э. 2016:ноября:13 Day of year 318 time zone EET

        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        builder.appendEraText().appendLiteral(" ")
                .appendYear(4, 4).appendLiteral(':')
                .appendMonthOfYearText().appendLiteral(':')
                .appendDayOfMonth(2).appendLiteral(" Day of year ")
                .appendDayOfYear(3).appendLiteral(" time zone ")
                .appendTimeZoneShortName();
        println("Can build parser: " + builder.canBuildParser());// Can build parser: false
        println("Can build formatter: " + builder.canBuildFormatter());// Can build formatter: true
        println("Can build printer: " + builder.canBuildPrinter());// Can build printer: true
        DateTimeFormatter formatter = builder.toFormatter();
        println(formatter.print(DateTime.now())); // н.э. 2016:ноября:13 Day of year 318 time zone EET
    }
}
