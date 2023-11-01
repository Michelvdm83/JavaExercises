package VPP.ShowSystemData;

public class ShowSystemData {
    public static void main(String[] args){
//        System.getProperties().list(System.out);
        // first version with all separate lines
/*          System.out.println("Java Version: " + System.getProperty("java.version"));
          System.out.println("Java Runtime Version: " + System.getProperty("java.runtime.version"));
          System.out.println("Java Home: " + System.getProperty("java.home"));
          System.out.println("Java Vendor: " + System.getProperty("java.vendor"));
          System.out.println("Java Vendor URL: " + System.getProperty("java.vendor.url"));
          System.out.println("Java Class Path: " + System.getProperty("java.class.path"));
*/
        //second version with 2 arrays to contain all strings
/*        String[] tryIt = {"Java Version: ", "Java Runtime Version: ", "Java Home: "
                , "Java Vendor: ", "Java Vendor URL: ", "Java Class Path: "};
        String[] tryIt2 = {"java.version", "java.runtime.version", "java.home"
                , "java.vendor", "java.vendor.url", "java.class.path"};
        for(int i = 0; i < tryIt.length; i++){
            if (i < tryIt2.length){
                System.out.println(tryIt[i] + System.getProperty(tryIt2[i]));
            }
        }*/

        //third version with 1 multidimensional array to contain all strings
        String[][] tryIt = {
                {"Java Version: ", "Java Runtime Version: ", "Java Home: ",
                 "Java Vendor: " , "Java Vendor URL: "     , "Java Class Path: "},

                {"java.version"  , "java.runtime.version"  , "java.home",
                 "java.vendor"   , "java.vendor.url"       , "java.class.path"}
        };

        for(int i = 0; i < tryIt[0].length;i++){
            System.out.println(tryIt[0][i] + System.getProperty(tryIt[1][i]));
        }
    }
}
/*
Get the java data from the Java runtime system (Hint: System.getProperty())

Should result in something like
Java Version: 17.0.1
Java Runtime Version: 17.0.1+12-39
Java Home: D:\Program Files\Java\jdk-17.0.1
Java Vendor: Oracle Corporation
Java Vendor URL: https://java.oracle.com/
Java Class Path: D:\Development\ITvitae\JavaExercises\target\classes

 */