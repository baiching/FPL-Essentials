package com.baiching.fpl_essentials.utilsTests;

import com.baiching.fpl_essentials.utils.TimeCalculation;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TimeCalculationTests {

    @Test
    void testConvertToLocalTimeZone() {
        TimeCalculation timeCalculation = new TimeCalculation();
        String dateString = "2025-02-05T10:15:30+01:00";
        ZoneId zoneId = ZoneId.systemDefault();

        ZonedDateTime result = timeCalculation.convertToLocalTimeZone(dateString);

        assertNotNull(result, "Result should not be null");
        assertEquals(zoneId, result.getZone(), "Result should be in the default time zone");
        assertEquals(2025, result.getYear(), "Year should match");
        assertEquals(2, result.getMonthValue(), "Month should match");
        assertEquals(5, result.getDayOfMonth(), "Day should match");
        assertEquals(10, result.getHour(), "Hour should match");
        assertEquals(15, result.getMinute(), "Minute should match");
        assertEquals(30, result.getSecond(), "Second should match");
    }

    @Test
    void testGetTimeLeft() {
        TimeCalculation timeCalculation = new TimeCalculation();
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime futureDateTime = now.plusHours(2).plusMinutes(30);

        Duration result = timeCalculation.getTimeLeft(futureDateTime);

        assertNotNull(result, "Result should not be null");
        assertTrue(result.toHours() >= 2, "Duration should be at least 2 hours");
        assertTrue(result.toMinutes() >= 149, "Duration should be at least 150 minutes");
    }
}
