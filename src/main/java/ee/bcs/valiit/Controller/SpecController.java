package ee.bcs.valiit.Controller;

import ee.bcs.valiit.kodusedharjutused.Lesson3HardController2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SpecController {
    public String Lesson3HardController;
    static Random random = new Random();
    static int randomNumber = (int) (Math.random() * 100);

    //http://localhost:8080/random?guess=50
    @GetMapping("random")
    public String guessNumber(@RequestParam("guess") int guess) {
        if (guess < randomNumber) {
            return ("It´s greater than " + guess + ". \n" +
                    "Guess again.");
        } else if (guess > randomNumber) {
            return ("It´s smaller than " + guess + ". \n" +
                    "Guess again.");
        }
        return (randomNumber + " IS CORRECT, YOU WIN!!!");
    }

    //http://localhost:8080/lesson3HardController
    @GetMapping("lesson3HardController")
    public Lesson3HardController2 getRandom() {
        return getRandom();
    }
}
