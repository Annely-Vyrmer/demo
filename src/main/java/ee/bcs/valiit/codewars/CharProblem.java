package ee.bcs.valiit.codewars;

import java.util.Scanner;

public class CharProblem {

    //Ask a small girl - "How old are you?". She always says strange things... Lets help her!
    //For correct answer program should return int from 0 to 9.
    //Assume test input string always valid and may look like "1 year old" or "5 years old", etc.. The first char is number only.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How old are you?");
        String reply = scanner.nextLine();
        System.out.println(howOld(reply));
            //howOld("5 years old");
    }

    //conversion using Character.getNumbericValue() - convert a char to an int
    public static int howOld(final String herOld) {
        int age = Character.getNumericValue(herOld.charAt(0)); //1st character in string
        return age;
        //System.out.println(age);
    }
}
