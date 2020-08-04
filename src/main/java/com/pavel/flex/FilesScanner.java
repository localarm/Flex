package com.pavel.flex;

import java.io.File;
import java.util.*;

public class FilesScanner {
    private  NameParser nameParser;
    private  TimeKeyComparator timeKeyComparator;
    private String fileExtension;
    private  String imgdir;
    private ValuesComparator valuesComparator;

    public void setNameParser(NameParser nameParser) {
        this.nameParser = nameParser;
    }

    public void setTimeKeyComparator(TimeKeyComparator timeKeyComparator) {
        this.timeKeyComparator = timeKeyComparator;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public void setImgdir(String imgdir) {
        this.imgdir = imgdir;
    }

    public void setValuesComparator(ValuesComparator valuesComparator) {
        this.valuesComparator = valuesComparator;
    }

    public Map<TimeKey, SortedSet<FileAndValue>> scanDirectory() {
        File[] files = new File(imgdir).listFiles();
        if (files == null) {
            System.out.println("Empty directory");
            System.exit(1);
        } else {
            Map<TimeKey, SortedSet<FileAndValue>> sortedFiles = new TreeMap<>(timeKeyComparator);
            for (File file : files) {
                String name = file.getName();
                System.out.println(name);
                if (name.contains(".") && name.substring(name.lastIndexOf(".") +1).equals(fileExtension)) {
                    ParsedData parsedData = nameParser.parse(file);
                    if (parsedData != null) {
                        TimeKey key = parsedData.getTimeKey();
                        if (sortedFiles.containsKey(key)) {
                            Set<FileAndValue> fileNames = sortedFiles.get(key);
                            fileNames.add(parsedData.getValue());
                        } else {
                            SortedSet<FileAndValue> sortedFilesByValue = new TreeSet<>(valuesComparator);
                            sortedFilesByValue.add(parsedData.getValue());
                            sortedFiles.put(key, sortedFilesByValue);
                        }
                    }
                }
            }
            return sortedFiles;
        }
        return null;//non reachable
    }
}
