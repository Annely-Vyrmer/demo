package ee.bcs.valiit.tasks;

import java.util.Random;
import java.util.Scanner;

public class Lesson3Hard {

    // TODO kirjuta mäng mis leiab suvalise numbri 0-99, mille kasutaja peab ära arvama
    // iga kord pärast kasutaja sisestatud täis arvu peab programm ütlema kas number oli suurem või väiksem
    // ja kasutaja peab saama uuesti arvata
    // numbri äraarvamise korral peab programm välja trükkima mitu katset läks numbri äraarvamiseks
    public static void main(String[] args) {
        //Math.random creates a number between 0 and 99
        //(int) makes it int, no fraction
        int randomNumber = (int) (Math.random() * 100);
        boolean hasWon = false;                         //Create another variable, boolean and set it to false (to start the game).
        System.out.println("I have randomly chosen a number between 0 and 99.");
        System.out.println("Try to guess it.");

        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (i < 100) {                               //cycle to count guessed times
            i++;
            //Inside loop store it in a variable "guess" (use scanner.nextInt).
            //It takes things you type in and it converts that into an integer.
            int guess = scanner.nextInt();
            if (randomNumber < guess) {
                System.out.println("It´s smaller than " + guess + ". \n" +
                        "Guess again.");
            } else if (randomNumber > guess) {
                System.out.println("It´s greater than " + guess + ". \n" +
                        "Guess again.");
            } else {
                hasWon = true;                          //if random number is TRUE, break out from cycle, not to guess again
                break;
            }
        }                                               //here, after } will display counted guesses in l45
        //Check if they have won "(hasWon == true)" or "(hasWon)"
        if (hasWon == true) {                           //another IF yo display text
            System.out.println("CORRECT NUMBER, YOU WIN!!!");
        } else {
            System.out.println("GAME OVER, YOU LOOSE!!!");
            System.out.println("The number was: " + randomNumber);
        }
        System.out.println("You have guessed: " +i+ " times.");
    }
}
