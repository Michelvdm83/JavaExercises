package vpp.DisplayCheck;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DisplayCheck {
    public static void main(String[] args){
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter newFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss.SSS");
        String currentDateTimeFormatted = currentDateTime.format(newFormat);
        System.out.println("Now: " + currentDateTimeFormatted);

    }
}

/*
Write a Java program to display the current date time in specific format.
Sample Output:

Now: 2017/06/16 08:52:03.066
*/