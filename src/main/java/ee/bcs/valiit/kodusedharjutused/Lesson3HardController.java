package ee.bcs.valiit.kodusedharjutused;

import java.util.Random;

public class Lesson3HardController {
    static Random random = new Random();
    static int randomNumber = (int) (Math.random() * 100);

    public static String guessNumber(int guess) {
        while (guess != randomNumber) {
            if (guess < randomNumber) {
                return ("It´s greater than " + guess + ". \n" +
                        "Guess again.");
            } else if (guess > randomNumber) {
                return ("It´s smaller than " + guess + ". \n" +
                        "Guess again.");
            }
        }
        return (randomNumber + " IS CORRECT, YOU WIN!!!");
    }
}