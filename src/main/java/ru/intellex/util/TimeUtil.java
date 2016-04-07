package ru.intellex.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by b.istomin on 22.05.2015.
 */
public class TimeUtil {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    public static String toString(LocalDateTime ldt) {
        return ldt == null ? "null" : ldt.format(DATE_TIME_FORMATTER);
    }

}
