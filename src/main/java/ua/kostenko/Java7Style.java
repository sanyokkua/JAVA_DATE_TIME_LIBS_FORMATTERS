package ua.kostenko;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static ua.kostenko.utils.Utils.println;


public class Java7Style {
    public static void main(String[] args) throws ParseException {
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        println(df.getClass().getSimpleName());// SimpleDateFormat
        println(DateFormat.getDateInstance(DateFormat.LONG).format(new Date()));// 13 ноября 2016 г.
        println(DateFormat.getDateInstance(DateFormat.SHORT).format(new Date()));// 13.11.16
        SimpleDateFormat dateFormat = new SimpleDateFormat("G yyy:MMMM:dd 'Day of year' D 'time zone' z", new DateFormatSymbols() {
            @Override
            public String[] getMonths() {
                return new String[]{"Пьянварь", "Фигвраль", "Кошмарт", "Сопрель", "Сымай", "Теплюнь", "Жарюль",
                        "Авгрусть", "Слюнтябрь", "Моктябрь", "Гноябрь", "Дубабрь"};
            }
        });
        println(dateFormat.format(new Date()));//н.э. 2016:Гноябрь:13 Day of year 318 time_zone EET
        dateFormat = new SimpleDateFormat("G yyy:MMMM:dd 'Day of year' D 'time zone' z", Locale.FRANCE);
        println(dateFormat.format(new Date()));//ap. J.-C. 2016:novembre:13 Day of year 318 time zone EET
        dateFormat = new SimpleDateFormat("G yyy:MMMM:dd 'Day of year' D 'time zone' z", Locale.ENGLISH);
        println(dateFormat.format(new Date()));//AD 2016:November:13 Day of year 318 time zone EET
    }
}
