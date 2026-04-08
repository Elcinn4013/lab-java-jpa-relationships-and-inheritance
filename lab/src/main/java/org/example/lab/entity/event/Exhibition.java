package org.example.lab.entity.event;

import java.time.LocalDate;

public class Exhibition extends Event{
    public Exhibition() {
    }

    public Exhibition(String title, LocalDate date, Integer duration, String location) {
        super(title, date, duration, location);
    }
}
