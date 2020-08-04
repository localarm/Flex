package com.pavel.flex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TimeKeyComparator implements Comparator<TimeKey> {
    private final DateComparator dateComparator = new DateComparator();
    private  DaytimeComparator daytimeComparator;

    public void setDaytimes(List<String> daytimes) {
        daytimeComparator = new DaytimeComparator(daytimes);
    }

    @Override
    public int compare(TimeKey o1, TimeKey o2) {
        int dateCompareResult = dateComparator.compare(o1.getDate(), o2.getDate());
        if (dateCompareResult ==0 ) {
            return daytimeComparator.compare(o1.getDaytime(), o2.getDaytime());
        }
        return dateCompareResult;
    }

    private static class DateComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int[] firstDate = Arrays.stream(o1.split("\\.")).mapToInt(Integer::parseInt).toArray();
            int[] secondDate = Arrays.stream(o2.split("\\.")).mapToInt(Integer::parseInt).toArray();
            int monthCompare = firstDate[1] - secondDate[1];
            if (monthCompare == 0) {
                return firstDate[0] - secondDate[0];
            }
            return monthCompare;
        }
    }

    private static class DaytimeComparator implements Comparator<String> {
        private final List<String> daytimes;

        public DaytimeComparator(List<String> daytimes) {
            this.daytimes = daytimes;
        }

        @Override
        public int compare(String o1, String o2) {
            return daytimes.indexOf(o1) - daytimes.indexOf(o2);
        }

    }
}
