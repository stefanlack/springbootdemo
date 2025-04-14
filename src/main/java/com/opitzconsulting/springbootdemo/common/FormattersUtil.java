package com.opitzconsulting.springbootdemo.common;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class FormattersUtil {

    private static final DateTimeFormatter DATE_WITH_TIME_FORMATTER;

    public String formatDateWithTime(OffsetDateTime offsetDateTime) {
        return DATE_WITH_TIME_FORMATTER.format(offsetDateTime);
    }

    public static final String format(OffsetDateTime dateTime) {
        return Optional.ofNullable(offsetDateTimeToLocalDateTime(dateTime))
                .map(t -> t.format(DATE_WITH_TIME_FORMATTER))
                .orElse(null);
    }

    public static LocalDateTime offsetDateTimeToLocalDateTime(OffsetDateTime offsetDateTime) {
        return offsetDateTime == null
                ? null
                : LocalDateTime.ofInstant(offsetDateTime.toInstant(), ZoneId.systemDefault());
    }

    static {
        DATE_WITH_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }


}
