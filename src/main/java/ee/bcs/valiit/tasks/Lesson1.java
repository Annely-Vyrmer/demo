package ee.bcs.valiit.tasks;

import java.util.Scanner;

// TODO kasuta if/else. Ära kasuta Math librarit
public class Lesson1 {
    //5.04 esimesed ülesanded
//    public static void main(String[] args) {
//        // Siia sisse võid sa kirjutada koodi, et testida kas su meetodid töötavad ilusti
//        // Katseta IntelliJ shortcuti. Olles intelliJ kirjuta "sout" ja siis vajuta enter
//        System.out.println(min(1, 3)); // trükib miinimumi 1 ja 3
//    }
public static void main(String[] args) {
    //6.04 ülesanded: meetodite harjutused konsooli input/output
    Scanner scanner = new Scanner(System.in);
    System.out.println("Vali ülesander number, mida soovid lahendada:");
    System.out.println("1.min; 2.max; 3.abs; 4.min3; 5.max");

    int num = scanner.nextInt();        //aktiveerid scanneri, et võtab num aluseks
    if ((num == 1)) {                   //defineerid, et soovid kasutada num 1 ülesannet
        System.out.println("Sisesta 2 numbrit, mida tahad võrrelda");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        //Tagasta a ja b väiksem väärtus
        System.out.println("See on a ja b väikseim number: " + min(a, b));
    } else if ((num == 2)) {
        System.out.println("Sisesta 2 numbrit, mida tahad võrrelda");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        //Tagasta a ja b suurim väärtus
        System.out.println("Siia tuli a ja b suurim number: " + max(a, b));
    } else if ((num == 3)) {
        System.out.println("Sisesta number, mille absoluutarvu soovid kuvada");
        int a = scanner.nextInt();
        //tagasta absoluut arv
        System.out.println("Nüüd kuvab a absoluutarvu: " + abs(a));
    } else if ((num == 4)) {
        System.out.println("Sisesta number mida soovid võrrelda, kas on paarisnumber");
        int a = scanner.nextInt();
        if(isEven(a)) {
            //tagasta true, kui a on paaris arv
            System.out.println("Tegu on paarisnumbriga: " + isEven(a));
        } else{
                System.out.println("Tegemist on paaritu arvuga");
            }
    } else if ((num == 5 )) {
        System.out.println("Sisesta 3 numbrit, millest valid kõige väiskema numbri");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        //tagasta kolmest arvust kõige väiksem
        System.out.println("Kuva komest arvust kõige väiksem number: " + min3(a, b, c));
    } else {
        System.out.println("Sisesta 3 numbrit, millest valid kõige suuremaa numbri");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        //tagasta kolmest arvust kõige suurem
        System.out.println("Kuva kolmest arvust kõige suurem number: " + max3(a, b, c));
    }
    return;
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
        if (a % 2 == 0) {      //jagad a 2-ga, jääk on 0, siis on tegu paaris arvuga
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
//        if (a >= b && a >= c) {
//            return a;
//        } else if (b >= a && b >= c) {
//            return b;
//        } else {
//            return c;
//        }
        return max(max(a, b), c);
    }
}