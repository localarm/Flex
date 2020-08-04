package com.pavel.flex;

import java.io.File;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AppConfig {

    public void configure(HashMap<String, String> props, FilesScanner filesScanner, TimeKeyComparator timeKeyComparator,
                          ValuesComparator valuesComparator, NameParser nameParser, Word word) {
        List<String> parsedValues = parse(props.get("values"));
        valuesComparator.setValues(parsedValues);
        List<String> daytimes = parse(props.get("daytime"));
        timeKeyComparator.setDaytimes(daytimes);

        nameParser.setDateFormat(props.get("dateformat"));
        nameParser.setDaytimes(daytimes);
        nameParser.setValues(parsedValues);

        filesScanner.setValuesComparator(valuesComparator);
        filesScanner.setImgdir(props.get("imagesdir"));
        filesScanner.setFileExtension(props.get("imgexc"));
        filesScanner.setTimeKeyComparator(timeKeyComparator);
        filesScanner.setNameParser(nameParser);

        File file = new File(props.get("word"));
        System.out.println(file.getAbsolutePath());
        if (!file.exists() || !file.isFile()) {
            System.out.println("Wrong word document path");
            System.exit(1);
        }
        word.setWordDocument(file);
    }

    private List<String> parse(String values) {
        return Arrays.asList(values.split("/"));
    }
}
