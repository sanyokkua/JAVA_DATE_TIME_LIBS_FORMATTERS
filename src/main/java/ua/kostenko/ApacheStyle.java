package ua.kostenko;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.FastDateFormat;

import java.util.Date;
import java.util.Locale;

import static ua.kostenko.utils.Utils.println;


public class ApacheStyle {

    public static void main(String[] args) {
        FastDateFormat dateTime = FastDateFormat.getInstance("G yyy:MMMM:dd 'Day of year' D 'time zone' z");
        println(dateTime.format(new Date())); //н.э. 2016:ноября:13 Day of year 318 time zone EET
        FastDateFormat dateTime2 = FastDateFormat.getDateTimeInstance(FastDateFormat.FULL, FastDateFormat.SHORT, Locale.CANADA);
        println(dateTime2.format(new Date())); //Sunday, November 13, 2016 3:37 PM
        println(DateFormatUtils.ISO_8601_EXTENDED_DATE_FORMAT.format(new Date()));//2016-11-13
        println(DateFormatUtils.ISO_8601_EXTENDED_DATETIME_TIME_ZONE_FORMAT.format(new Date()));//2016-11-13T15:37:15+02:00
        println(DateFormatUtils.SMTP_DATETIME_FORMAT.format(new Date()));//Sun, 13 Nov 2016 15:37:15 +0200
        println(DateFormatUtils.format(new Date(), "G yyy:MMMM:dd 'Day of year' D 'time zone' z"));//н.э. 2016:ноября:13 Day of year 318 time zone EET
        println(DateFormatUtils.format(new Date(), "G yyy:MMMM:dd 'Day of year' D 'time zone' z", Locale.CHINESE));//公元 2016:十一月:13 Day of year 318 time zone EET
        println(DateFormatUtils.formatUTC(new Date(), "G yyy:MMMM:dd 'Day of year' D 'time zone' z", Locale.US));//AD 2016:November:13 Day of year 318 time zone GMT
    }
}
