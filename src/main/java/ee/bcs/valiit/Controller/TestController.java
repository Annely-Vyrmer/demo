package ee.bcs.valiit.Controller;

import ee.bcs.valiit.kodusedharjutused.Employees;
import ee.bcs.valiit.kodusedharjutused.Lesson3HardController;
import ee.bcs.valiit.tasks.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController {
    public List<Employees> employeesList = new ArrayList<>();

    //http://localhost:8080/hello-world/Annely
    @GetMapping("hello-world/{nameInUrl}")
    public String helloWorld(@PathVariable("nameInUrl") String name,
                             @RequestParam("action") String action) {
        return action + " " + name;
    }
    //http://localhost:8080/min/2/6
    @GetMapping("min/{a}/{b}")
    public int min(@PathVariable("a") int a, @PathVariable("b") int b) {
                return Lesson1.min(a, b);
    }
    //http://localhost:8080/max?a=7&b=8
    @GetMapping("max")
    public int max(@RequestParam("a") int a, @RequestParam("b") int b) {
        return Lesson1.max(a, b);
    }
    //http://localhost:8080/abs?a=-7
    @GetMapping("abs")
    public int abs(@RequestParam("a") int a) {
        return Lesson1.abs(a);
    }
    //http://localhost:8080/isEven?a=7
    @GetMapping("isEven")
    public boolean isEven(@RequestParam("a") int a) {
        return Lesson1.isEven(a);
    }
    //http://localhost:8080/min3?a=7&b=8&c=9
    @GetMapping("min3")
    public int min3(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) {
        return Lesson1.min3(a, b, c);
    }
    //http://localhost:8080/max3?a=7&b=8&c=9
    @GetMapping("max3")
    public int max3(@RequestParam("a") int a, @RequestParam("b") int b, @RequestParam("c") int c) {
        return Lesson1.max3(a, b, c);
    }
    //***************************************************
    //http://localhost:8080/reverseArray/0,1,2,3,4,5    //Vastus; [5,4,3,2,1,0]
    @GetMapping("reverseArray/{a}")
    public int[] reverseArray(@PathVariable("a") int[] returnArray) {
        return Lesson2.reverseArray(returnArray);
    }
    //http://localhost:8080/evenNumbers/5    //Vastus: [2,4,6,8,10]
    @GetMapping("evenNumbers/{a}")
    public int[] evenNumbers(@PathVariable("a") int a) {
        return Lesson2.evenNumbers(a);
    }
    //http://localhost:8080/min2?a=4,2,6,1,9    //Vastus: 1
    @GetMapping("min2")
    public int min2(@RequestParam("a") int[] a) {
        return Lesson2.min(a);
    }
    //http://localhost:8080/max2?a=4,2,6,1,9    //Vastus: 9
    @GetMapping("max2")
    public int max2(@RequestParam("a") int[] a) {
        return Lesson2.max(a);
    }
    //http://localhost:8080/sum2/2,4,5,2,1      //Vastus: 14
    @GetMapping("sum2/{a}")
    public int sum2(@PathVariable("a") int[] a) {
        return Lesson2.sum(a);
    }
    //http://localhost:8080/fibonacci?a=7       //Vastus: 13
    @GetMapping("fibonacci")
    public int fibonacci(@RequestParam("a") int a) {
        return Lesson2.fibonacci(a);
    }
    //***************************************************
    //http://localhost:8080/exercise1?a=5   //Vastus: 6
    @GetMapping("exercise1")
    public int exercise1(@RequestParam("a") int a) {
        return Lesson2b.exercise1(a);
    }
    //http://localhost:8080/sampleArray         //Vastus: [1,2,3,4,5]
    @GetMapping("sampleArray")
    public int[] sampleArray() {
        return Lesson2b.sampleArray();
    }
    //http://localhost:8080/generateArray/5     //Vastus: [1,2,3,4,5]
    @GetMapping("generateArray/{a}")
    public int[] generateArray(@PathVariable("a") int a) {
        return Lesson2b.generateArray(a);
    }
    //http://localhost:8080/decreasingArray/7   //Vastus: [7,6,5,4,3,2,1,0]
    @GetMapping("decreasingArray/{a}")
    public int[] decreasingArray(@PathVariable("a") int a) {
        return Lesson2b.decreasingArray(a);
    }
    //http://localhost:8080/yl3?a=4             //Vastus: [3,3,3,3]
    @GetMapping("yl3")
    public int[] yl3(@RequestParam("a") int a) {
        return Lesson2b.yl3(a);
    }
    //***************************************************
    //http://localhost:8080/sequence3n/10/20    //Vastus: 21
    @GetMapping("sequence3n/{a}/{b}")
    public int sequence3n(@PathVariable("a") int a, @PathVariable("b") int b) {
        return Lesson2c.sequence3n(a, b);
    }
    //http://localhost:8080/getSeqLength?a=22   //Vastus: 16
    @GetMapping("getSeqLength")
    public int getSeqLength(@RequestParam("a") int a) {
        return Lesson2c.getSeqLength(a);
    }
    //http://localhost:8080/nextElement/22    //Vastus: 11
    @GetMapping("nextElement/{a}")
    public int nextElement(@PathVariable("a") int a) {
        return Lesson2c.nextElement(a);
    }
    //***************************************************
    //http://localhost:8080/factorial?a=5   //Vastus: 120
    @GetMapping("factorial")
    public int factorial(@RequestParam("a") int a) {
        return Lesson3.factorial(a);
    }
    //http://localhost:8080/reverseString/annely    //Vastus: ylenna
    @GetMapping("reverseString/{a}")
    public String reverseString(@PathVariable("a") String a) {
        return Lesson3.reverseString(a);
    }
    //http://localhost:8080/isPrime/8               //Vastus:5 - true; 8 - false
    @GetMapping("isPrime/{a}")
    public boolean isPrime(@PathVariable("a") int a) {
        return Lesson3.isPrime(a);
    }
    //http://localhost:8080/sort/6,4,7,1            //Vastus:[1,4,6,7]
    @GetMapping("sort/{a}")
    public int[] sort(@PathVariable("a") int[] returnArray) {
        return Lesson3.sort(returnArray);
    }
    //http://localhost:8080/evenFibonacci/30        //Vastus: 10
    @GetMapping("evenFibonacci/{a}")
    public int evenFibonacci(@PathVariable("a") int a) {
        return Lesson3.evenFibonacci(a);
    }
    //http://localhost:8080/morseCode/hello         //Vastus: .... . .-.. .-.. ---
    @GetMapping("morseCode/{a}")
    public String morseCode(@PathVariable("a") String a) {
        return Lesson3.morseCode(a);
    }

    //***************************************************
    //14.04.20201 POSTMAN
    //    //http://localhost:8080/employee            //localhostis küsin "employee"
//    @GetMapping("employee")
//    public Employees employees(){               //Tagasta andmetüüp Employees!!!
//        Employees employees = new Employees();       //Loome muutuja, mis on andmetüübiga Employees ja nimega name
//        employees.setName("Annely");
//        employees.setAddress("Võru, Eesti");
//        return employees;                       //Vastus: {"name":"Annely","address":"Võru, Eesti"}
//    }
    //http://localhost:8080/stuff
//    @GetMapping("stuff")
//    public List<Employees> employees(){               //Tagasta andmetüüp Employees, mis on LIST!!!
//        Employees employee1 = new Employees();       //Loome muutuja, mis on andmetüübiga Employees ja nimega employee1
//        employee1.setName("Annely");
//        employee1.setAddress("Võru, Eesti");
//        Employees employee2 = new Employees();       //Loome muutuja, mis on andmetüübiga Employees ja nimega employee2
//        employee2.setName("Tauno");
//        employee2.setAddress("Võru, Eesti");
//        Employees employee3 = new Employees();       //Loome muutuja, mis on andmetüübiga Employees ja nimega employee3
//        employee3.setName("Timo");
//        employee3.setAddress("Helsinki, Soome");
//        List<Employees> employeeList = new ArrayList<Employees>();
//        employeeList.add(employee1);
//        employeeList.add(employee2);
//        employeeList.add(employee3);
//        return employeeList;                        //Vastus:[{"name":"Annely","address":"Võru, Eesti"},
//                                                    // {"name":"Tauno","address":"Võru, Eesti"},
//                                                    // {"name":"Timo","address":"Helsinki, Soome"}]
//    }
    //Lood listi põhja ja küsid kõiki töötajaid
    //http://localhost:8080/stuff
    @GetMapping("stuff")
    public List<Employees> getEmployees() {
        return employeesList;
    }

    //Sisendiks REQUEST BODY
    //Väljund puudub (salvestab info listi)
    //http://localhost:8080/stuff                       //Lisad töötajaid juurde (add) BODYS {"name": "Annely","address": "Võru, Eesti"}
    @PostMapping("stuff")
    public void addEmployee(@RequestBody Employees employees){
        employeesList.add(employees);                   //ADD ehk LISA listi veel ...
    }
    //Sisendiks PathVariable (id=index)
    //Tagastab ühe töötaja vastavalt indeksile
    //http://localhost:8080/stuff/1                     //Võtan välja töötaja, kes on positsioonil 1
    @GetMapping("stuff/{id}")                           //soovin muutuja {id} kasutada ja pean meetodisse tooma int index!!!
    public Employees oneEmployee(@PathVariable("id") int index){    //Classi all (public List<Employees> employeesList = new ArrayList<>();)
        return employeesList.get(index);
    }
    //Sisend RequestBody ja PathVariable (id=index)
    //Väljund puudub kuna kirjutab üle vastaval indeksil töötaja request body sisuga
    //http://localhost:8080/stuff/2
    @PutMapping("stuff/{id}")
    public void replaceEmployee(@PathVariable("id") int index, @RequestBody Employees employees){
        employeesList.set(index, employees);            //SET; ehk kirjuta üle vastaval väärtusel olev kogu info.
    }
    //Sisendiks ainult PathVariable (id = index)
    //Väljund puudub(kustutab listist vastavalt indeksil elemendi)
    //http://localhost:8080/stuff/1
    @DeleteMapping("stuff/{id}")
    public Employees deleteEmployee(@PathVariable("id") int index) {
        return employeesList.remove(index);             //REMOVE, ehk kustuta kogu info, mis selle IDga seotud on.
    }
    //***************************************************
    //Lesson4 CONTROLLERISSE ja BROWSERisse.

    //***************************************************
    //Lesson3HardController CONTROLLERISSE ja BROWSERisse.
    //http://localhost:8080/guessNumber/50                          //Vastus1: It´s smaller than 50. Guess again.
    @GetMapping("/guessNumber/{guess}")                             //(http://localhost:8080/guessNumber/25) Vastus2: It´s greater than 25. Guess again.
    public String guessNumber(@PathVariable("guess") int guess) {   //(http://localhost:8080/guessNumber/35) Vastus3: It´s smaller than 35. Guess again.
        return Lesson3HardController.guessNumber(guess);            //(http://localhost:8080/guessNumber/30) Vastus4: It´s greater than 30. Guess again.
    }                                                               //(http://localhost:8080/guessNumber/33) Vastus5: 33 IS CORRECT, YOU WIN!!!
}


