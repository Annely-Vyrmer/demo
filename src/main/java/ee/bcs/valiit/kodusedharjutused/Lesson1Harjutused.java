package ee.bcs.valiit.kodusedharjutused;

import java.util.Scanner;

public class Lesson1Harjutused {
    // TODO kasuta if/else. Ära kasuta Math librarit
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Millist meetodit soovid kasutada?");
        System.out.println("1 = min");
        System.out.println("2 = max");
        System.out.println("3 = abs");
        System.out.println("4 = isEven");
        System.out.println("5 = min3");
        System.out.println("6 = max3");
        String functionNumber = scanner.nextLine();
        if (functionNumber.equalsIgnoreCase("min") || functionNumber.equals("1")) {
            System.out.println("Sisesta 2 numbrit");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Väikseim number on: " + min(a, b));
        } else if (functionNumber.equalsIgnoreCase("max") || functionNumber.equals("2")) {
            System.out.println("Sisesta 2 numbrit");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println("Suurim number on: " + max(a, b));
        } else if (functionNumber.equalsIgnoreCase("abs") || functionNumber.equals("3")){
            System.out.println("Sisesta 1 number");
            int a = scanner.nextInt();
            System.out.println("Number on: " + abs(a));
        } else if(functionNumber.equalsIgnoreCase("isEven") || functionNumber.equals("4")){
            System.out.println("Sisesta 1 number");
            int a = scanner.nextInt();
            if (isEven(a)){
                System.out.println(isEven(a) + " - see number on paarisarv");
            } else {
                System.out.println(isEven(a) + " - see number ei ole paarisarv");
            }
        } else if(functionNumber.equalsIgnoreCase("min3") || functionNumber.equals("5")){
            System.out.println("Sisesta 3 numbrit");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println("Väikseim number on: " + min3(a,b,c));
        } else if (functionNumber.equalsIgnoreCase("max3") || functionNumber.equals("6")) {
            System.out.println("Sisesta 3 numbrit");
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println("Suurim number on: " + max3(a,b,c));
        }
    }

    // TODO tagasta a ja b väikseim väärtus
    public static int min(int a, int b) {    //return 0;
        if (a < b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a ja b suurim väärtus
    public static int max(int a, int b) {   //return 0;
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    // TODO tagasta a absoluut arv  //alusta lahenduskäiku 0ga. kui numbri ees võiks olla -märk, tuleb see tulemuses ära korjata
    public static int abs(int a) {  //return 0;
        if (a > 0) {
            return a;
        } else if (a < 0) {
            return -a;
        }
        return 0;
    }

    // TODO tagasta true, kui a on paaris arv
    // tagasta false kui a on paaritu arv
    public static boolean isEven(int a) {
        if (a % 2 == 0) {
            return true;
        }
        return false;
    }

    // TODO tagasta kolmest arvust kõige väiksem
    public static int min3(int a, int b, int c) {
        if (a <= b && a <= c) {
            return a;
        } else if (b <= a && b <= c) {
            return b;
        } else {
            return c;
        }
    }

    // TODO tagasta kolmest arvust kõige suurem
    public static int max3(int a, int b, int c) {
        return max(max(a, b), c);
    }
}