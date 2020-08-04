package com.pavel.flex;

import java.util.Comparator;
import java.util.List;

public class ValuesComparator implements Comparator<FileAndValue> {
    private List<String> values;

    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public int compare(FileAndValue o1, FileAndValue o2) {
        return values.indexOf(o1.getValue()) - values.indexOf(o2.getValue());
    }
}
