package VPP.TheThingNamer3000;

import java.util.Scanner;

public class TheThingNamer3000 {
    public static void main(String[] args){
        System.out.println("What kind of thing are we talking about?");
        Scanner input = new Scanner(System.in);
        //the type of thing you want to be named. Ex: Computer
        String a = input.next();
        System.out.println("How would you describe it? Big? Azure? Tattered?");
        //the adjective you want to use on your "thing"
        String b = input.next();
        //the specification will always become "of Doom"
        String c = "of Doom";
        /*
        and this is the most important one.
        This is our trademark.
        Without this it's a fake.
         */
        String d = "3000";
        System.out.println("The " + b + " " + a + " " + c + " " + d + "!");
    }
}
/*
Aside from comments, what else could you do to make
this code more understandable?
Naming all variables appropriately
 */

/*
“You gotta help me figure it out!”
Objectives:
- Rebuild the program above on your computer.
- Add comments near each of the four variables that describe what they store.
You must use at least one of each comment type (// and /* ).
- Find the bug in the text displayed and fix it.
- Answer this question: Aside from comments, what else could you do to make
this code more understandable?
 */