package vpp.SimilarBread;

public class SimilarBread {
    public static void main(String[] args){
        System.out.println(hasSameBread(
                new String[]{"white bread", "lettuce", "white bread"},
                new String[]{"white bread", "tomato", "white bread"}
        ));

        System.out.println(hasSameBread(
                new String[]{"brown bread", "chicken", "brown bread"},
                new String[]{"white bread", "chicken", "white bread"}
        ));

        System.out.println(hasSameBread(
                new String[]{"toast", "cheese", "toast"},
                new String[]{"brown bread", "cheese", "toast"}
        ));
    }

    private static boolean hasSameBread(String[] sandwich1, String[] sandwich2){
        return (sandwich1[0].equalsIgnoreCase(sandwich2[0]) && sandwich1[2].equalsIgnoreCase(sandwich2[2]));
    }
}
/*
Similar Bread
Given two arrays, which represent two sandwiches, return whether both
sandwiches use the same type of bread.
 The bread will always be found at the start and end of the array.

Examples
hasSameBread(
  new String[]{"white bread", "lettuce", "white bread"},
  new String[]{"white bread", "tomato", "white bread"}
) ➞ true

hasSameBread(
  new String[]{"brown bread", "chicken", "brown bread"},
  new String[]{"white bread", "chicken", "white bread"}
) ➞ false

hasSameBread(
  new String[]{"toast", "cheese", "toast"},
  new String[]{"brown bread", "cheese", "toast"}
) ➞ false

Notes
The arrays will always be three elements long.
The first piece of bread on one sandwich must be the same as the first piece of
bread on the other sandwich.
 The same goes for the last piece of bread.
 */