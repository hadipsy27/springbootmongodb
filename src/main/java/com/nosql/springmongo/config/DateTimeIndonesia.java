package com.nosql.springmongo.config;

import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Configuration
public class DateTimeIndonesia {

    public String dateTimeIndo;

    public String getDateTimeIndo() {
        ZoneId zoneId = ZoneId.of("Asia/Jakarta");
        LocalDateTime todayTime = LocalDateTime.now(zoneId);
        return todayTime.toString();
    }

}
