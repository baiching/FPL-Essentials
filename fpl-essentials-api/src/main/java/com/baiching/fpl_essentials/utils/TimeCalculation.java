package com.baiching.fpl_essentials.utils;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeCalculation {
    public ZonedDateTime convertToLocalTimeZone(String dateString) {
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateString);

        return offsetDateTime.atZoneSimilarLocal(ZoneId.systemDefault());
    }

    public Duration getTimeLeft(ZonedDateTime futureDateTime){
        /*
        To access values correctly:
        *duration.toDays();
        *duration.toHours() % 24;
        *duration.toMinutes() % 60;
        *duration.getSeconds() % 60;
         */

        return Duration.between(ZonedDateTime.now(), futureDateTime);
    }
}
