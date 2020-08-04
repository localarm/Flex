package com.pavel.flex;

import java.util.Objects;

public class TimeKey{
    private final String date;
    private final String daytime;

    public TimeKey(String date, String daytime) {
        this.date = date;
        this.daytime = daytime;
    }

    public String getDate() {
        return date;
    }

    public String getDaytime() {
        return daytime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeKey timeKey = (TimeKey) o;
        return date.equals(timeKey.date) &&
                daytime.equals(timeKey.daytime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, daytime);
    }

    @Override
    public String toString() {
        return date + " " + daytime;
    }
}
