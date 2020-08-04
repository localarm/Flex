package com.pavel.flex;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        FilesScanner filesScanner = new FilesScanner();
        TimeKeyComparator timeKeyComparator = new TimeKeyComparator();
        ValuesComparator valuesComparator = new ValuesComparator();
        NameParser nameParser = new NameParser();
        Word word = new Word();
        HashMap<String, String> props = PropertiesReader.read();
        AppConfig thisConfig = new AppConfig();
        thisConfig.configure(props, filesScanner, timeKeyComparator, valuesComparator, nameParser, word);
        Map<TimeKey, SortedSet<FileAndValue>> images = filesScanner.scanDirectory();
        List<File> sortedFilesList = new LinkedList<>();
        for (Map.Entry<TimeKey, SortedSet<FileAndValue>> entry : images.entrySet()) {
            SortedSet<FileAndValue> set = entry.getValue();
            if (set.size() != 3) {
                System.out.println("Missing images for " + entry.getKey().toString());
            } else {
                for (FileAndValue file : set) {
                    sortedFilesList.add(file.getFile());
                }
            }
        }
        try {
            word.insert(sortedFilesList);
        } catch (Exception e) {
            System.out.println("Failed to add images, try again");
        }
    }
}
