package com.pavel.flex;

import java.io.File;
import java.util.List;

public class NameParser {
    private String dateFormat;
    private List<String> daytimes;
    private List<String> values;

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public void setDaytimes(List<String> daytimes) {
        this.daytimes = daytimes;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public ParsedData parse(File file) {
        String[] parsedName = file.getName().split(" ");
        String lastWord =parsedName[parsedName.length-1];
        parsedName[parsedName.length-1] =  lastWord.substring(0, lastWord.lastIndexOf("."));
        boolean dateFlag = false;
        boolean daytimeFlag = false;
        boolean valueFlag = false;
        String[] array = new String[3];

        for (String s : parsedName) {
            if (!dateFlag && s.matches(dateFormat) ) {
                dateFlag = true;
                array[0] = s;
            } else if (!daytimeFlag && daytimes.contains(s)) {
                daytimeFlag = true;
                array[1] = s;
            } else if(!valueFlag && values.contains(s) ) {
                valueFlag = true;
                array[2] = s;
            }
        }

        if (array[0]!=null && array[1]!=null && array[2]!=null) {
            return new ParsedData(new TimeKey(array[0], array[1]), new FileAndValue(file, array[2]));
        }
        return null;
    }


}
