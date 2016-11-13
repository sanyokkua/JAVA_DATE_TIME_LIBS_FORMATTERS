package ua.kostenko.utils;

public class Utils {
    interface Printer {
        <T> void println(T t);
    }

    public static <T> void println(T t) {
        Printer printer = System.out::println;
        printer.println(t);
    }
}
