package com.pavel.flex;

import java.io.File;
import java.util.Objects;

public class FileAndValue {
    private final File file;
    private final String value;

    public FileAndValue(File file, String value) {
        this.file = file;
        this.value = value;
    }

    public File getFile() {
        return file;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FileAndValue that = (FileAndValue) o;
        return file.equals(that.file) &&
                value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, value);
    }
}
