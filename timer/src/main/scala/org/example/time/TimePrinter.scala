package org.example.time

import java.time.format.DateTimeFormatter
import java.time.{ZoneId, ZonedDateTime}

class TimePrinter(formatter: DateTimeFormatter) {
    def now(timezone: String): String = {
        val datetime = currentDateTime(timezone)
        dateTimeToString(datetime)
    }

    private def currentDateTime(timezone: String): ZonedDateTime = {
        val zoneId = ZoneId.of(timezone)
        ZonedDateTime.now(zoneId)
    }

    private def dateTimeToString(datetime: ZonedDateTime): String = {
        formatter.format(datetime)
    }
}
