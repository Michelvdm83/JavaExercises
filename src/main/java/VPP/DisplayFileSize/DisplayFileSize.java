package VPP.DisplayFileSize;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
public class DisplayFileSize {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Give the name of a file: ");
        String file = input.next();
        try{
            long fileSize = Files.size(Path.of(file));
            System.out.println(file + " : " + fileSize + " bytes");
        }catch(IOException ioe){
            System.out.println("File not found");
        }
    }
}
/*
Write a Java program to find the size of a specified file.
Sample Output:

Give the name of a file: C:\config.ini
C:\config.ini : 153 bytes

ideally, also handle the case that the file is not found.
HINT: For many utility methods around files, look at the Files API! (or google
how to find the size of a file in Java :))
 */