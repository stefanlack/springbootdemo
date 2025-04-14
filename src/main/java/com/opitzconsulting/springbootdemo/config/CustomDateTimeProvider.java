package com.opitzconsulting.springbootdemo.config;

import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.time.OffsetDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Optional;

@Component("dateTimeProvider")
public class CustomDateTimeProvider implements DateTimeProvider {

    private Clock clock = Clock.systemUTC();

    @Override
    public Optional<TemporalAccessor> getNow() {
        return Optional.of(OffsetDateTime.now(clock));
    }
}
