package vpp.DisplayCurrentTimeAndDateInFormat;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class DisplayCurrentTimeAndDateInFormat {
    public static void main(String[] args){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter totalFormat = DateTimeFormatter.ofPattern("uuuu/MM/dd HH:mm:ss.SSS");
        System.out.println(totalFormat.format(date));
    }

}
/*
Write a Java program to display the current date time in specific format.
Sample Output:

Now: 2017/06/16 08:52:03.066
HINTS: Googling Java formatting DateTime gives https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
as well as https://www.baeldung.com/java-datetimeformatter
 */