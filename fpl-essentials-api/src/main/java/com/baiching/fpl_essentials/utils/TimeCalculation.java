package com.baiching.fpl_essentials.utils;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeCalculation {
    public ZonedDateTime covertToLocalTimeZone(String dateString) {
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(dateString);

        return offsetDateTime.atZoneSimilarLocal(ZoneId.systemDefault());
    }
}
