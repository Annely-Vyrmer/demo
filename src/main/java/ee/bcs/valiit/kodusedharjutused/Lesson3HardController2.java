package ee.bcs.valiit.kodusedharjutused;

import java.util.Random;

public class Lesson3HardController2 {
    static Random random = new Random();
    static int randomNumber = (int) (Math.random() * 100);

    public static int getRandomNumber() {
        return randomNumber;
    }

    public static Random getRandom() {
        return random;
    }

    public static void setRandom(Random random) {
        Lesson3HardController2.random = random;
    }

    public static void setRandomNumber(int randomNumber) {
        Lesson3HardController2.randomNumber = randomNumber;
    }

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