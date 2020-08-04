import com.pavel.flex.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class FileScannerTest {
    private final static String IMGDIR = "src/test/resources/testImgDir";
    private final static String EXT = "jpeg";
    private final static String dataformat= "\\d\\d\\.\\d\\d";
    private FilesScanner filesScanner;

    @Before
    public void setup() {
        ArrayList<String> values = new ArrayList<>();
        values.add("test1");
        values.add("test2");
        ArrayList<String> daytimes = new ArrayList<>();
        daytimes.add("morning");
        daytimes.add("evening");

        TimeKeyComparator timeKeyComparator = new TimeKeyComparator();
        timeKeyComparator.setDaytimes(daytimes);
        ValuesComparator valuesComparator = new ValuesComparator();
        valuesComparator.setValues(values);
        NameParser nameParser = new NameParser();
        nameParser.setValues(values);
        nameParser.setDaytimes(daytimes);
        nameParser.setDateFormat(dataformat);
        filesScanner = new FilesScanner();
        filesScanner.setNameParser(nameParser);
        filesScanner.setTimeKeyComparator(timeKeyComparator);
        filesScanner.setFileExtension(EXT);
        filesScanner.setImgdir(IMGDIR);
        filesScanner.setValuesComparator(valuesComparator);
    }

    @Test
    public void test() {
        Map<TimeKey, SortedSet<FileAndValue>> actualMap = filesScanner.scanDirectory();
        TimeKey expectedKey = new TimeKey("12.04", "morning");
        Assert.assertTrue(actualMap.containsKey(expectedKey));
        Assert.assertEquals(2,actualMap.get(expectedKey).size());
        SortedSet<FileAndValue> actualSet = actualMap.get(expectedKey);


        System.out.println(actualSet.first().getFile());
        System.out.println(actualSet.last().getFile());

    }


}
