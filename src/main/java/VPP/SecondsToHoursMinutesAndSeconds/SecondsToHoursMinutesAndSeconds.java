package VPP.SecondsToHoursMinutesAndSeconds;

import java.util.Scanner;
public class SecondsToHoursMinutesAndSeconds {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Input seconds: ");
        int secondsTotal = input.nextInt();
        int seconds = secondsTotal%60;
        int minutes = secondsTotal/60%60;
        int hours = secondsTotal/3600;
        System.out.printf("%d:%d:%d",hours,minutes,seconds);
    }
}
/*
Write a Java program to convert seconds to hour, minute and seconds.
Sample Output:

Input seconds: 86399
23:59:59
 */