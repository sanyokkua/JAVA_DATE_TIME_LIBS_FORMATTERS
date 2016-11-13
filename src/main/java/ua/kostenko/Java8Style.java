package ua.kostenko;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

import static ua.kostenko.utils.Utils.println;

public class Java8Style {
    public static void main(String[] args) {
        dateTimeFormatterExample();
        dateTimeFormatterBuilderExample();
    }

    private static void dateTimeFormatterBuilderExample() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("G yyy:MMMM:dd 'Day of year' D 'time zone' z");
        DateTimeFormatter patternLocale = DateTimeFormatter.ofPattern("G yyy:MMMM:dd 'Day of year' D 'time zone' z", Locale.US);

        LocalDateTime localDateTime = LocalDateTime.now(Clock.systemUTC());
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Europe/Kiev"));

        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        builder.appendPattern("G")
                .appendLiteral(" ")
                .appendValue(ChronoField.YEAR).appendLiteral(':')
                .appendText(ChronoField.MONTH_OF_YEAR).appendLiteral(':')
                .appendValue(ChronoField.DAY_OF_MONTH)
                .appendLiteral(" Day of year ")
                .appendValue(ChronoField.DAY_OF_YEAR)
                .appendLiteral(" time zone ")
                .appendZoneText(TextStyle.SHORT);
        DateTimeFormatter built = builder.toFormatter();
        DateTimeFormatter builtWithLocale = builder.toFormatter(Locale.US);

        println(pattern.format(zonedDateTime));// н.э. 2016:ноября:13 Day of year 318 time zone EET
        println(patternLocale.format(zonedDateTime));// AD 2016:November:13 Day of year 318 time zone EET

        println(built.format(zonedDateTime));// н.э. 2016:ноября:13 Day of year 318 time zone EET
        println(builtWithLocale.format(zonedDateTime));// AD 2016:November:13 Day of year 318 time zone EET
    }

    private static void dateTimeFormatterExample() {
        DateTimeFormatter full = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        DateTimeFormatter shortf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("G yyy:MMMM:dd 'Day of year' D 'time zone' z");
        DateTimeFormatter patternLocale = DateTimeFormatter.ofPattern("G yyy:MMMM:dd 'Day of year' D 'time zone' z", Locale.US);
        DateTimeFormatter iso = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter withZone = iso.withZone(ZoneId.of("America/New_York"));
        DateTimeFormatter withZoneAndLocale = iso.withZone(ZoneId.of("Europe/Berlin")).withLocale(Locale.GERMANY);

        LocalDateTime localDateTime = LocalDateTime.now(Clock.systemUTC());
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("Europe/Kiev"));

        println(full.format(zonedDateTime));// 13 ноября 2016 г. 17:19:25 EET
        println(shortf.format(zonedDateTime));// 13.11.16 17:19
        println(pattern.format(zonedDateTime));// н.э. 2016:ноября:13 Day of year 318 time zone EET
        println(patternLocale.format(zonedDateTime));// AD 2016:November:13 Day of year 318 time zone EET
        println(iso.format(zonedDateTime));// 2016-11-13T17:19:25.979+02:00[Europe/Kiev]
        println(withZone.format(zonedDateTime));// 2016-11-13T10:19:25.979-05:00[America/New_York]
        println(withZoneAndLocale.format(zonedDateTime));// 2016-11-13T16:19:25.979+01:00[Europe/Berlin]
    }
}
