package com.pavel.flex;

public class ParsedData {
    private final TimeKey timeKey;
    private final FileAndValue value;

    public ParsedData(TimeKey timeKey, FileAndValue value) {
        this.timeKey = timeKey;
        this.value = value;
    }

    public TimeKey getTimeKey() {
        return timeKey;
    }

    public FileAndValue getValue() {
        return value;
    }
}
