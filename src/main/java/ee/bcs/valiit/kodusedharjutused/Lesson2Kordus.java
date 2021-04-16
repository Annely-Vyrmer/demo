package ee.bcs.valiit.kodusedharjutused;

import java.util.Arrays;

public class Lesson2Kordus {

    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks
        //multiplyTable(3, 3);
        //System.out.println(reverseArray(new int[]{1,2,3,4,5,6}));
        //System.out.println(evenNumbers(5));
        //System.out.println(min(new int[]{4, 2, 1, 6, 9}));
        //System.out.println(max(new int[]{4, 2, 6, 1, 9}));
        //System.out.println(sum(new int[]{2,4,5,2,1}));
        //fibonacci(21);
        //fibonacci2(5);
        //System.out.println(sequence3n(10, 20 ));
    }

    // TODO loe funktsiooni sisendiks täisarvude massiiv
    // TODO tagasta massiiv mille elemendid on vastupidises järiekorras
    public static int[] reverseArray(int[] inputArray) {
        int[] tagurpidiMassiiv = new int[inputArray.length];
        for (int i = 0; i <= inputArray.length - 1; i++) {
            tagurpidiMassiiv[i] = inputArray[inputArray.length - i - 1];
        }
        return tagurpidiMassiiv;
    }

    // TODO tagasta massiiv mis sisaldab n esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    //palju erinevaid lahendusi.
    public static int[] evenNumbers(int n) {
        int[] paarisArvud = new int[n];
        for (int i = 0; i < n; i++) {
            paarisArvud[i] = (i + 1) * 2;
            System.out.print(i);
        }
        return paarisArvud;
    }

    // TODO, leia massiivi kõige väiksem element
    public static int min(int[] arrayNimi) { //4 2 6 1 9
        int smallestNumber = arrayNimi[0];
        for (int i = 1; i < arrayNimi.length; i++) {
            if (arrayNimi[i] < smallestNumber) {
                smallestNumber = arrayNimi[i];
            }
        }
        return smallestNumber;
    }

    // TODO, leia massiivi kõige suurem element
    public static int max(int[] arrayNimi) { //4 2 6 1 9
        int biggestNumber = arrayNimi[0];
        for (int i = 1; i < arrayNimi.length; i++) {
            if (arrayNimi[i] > biggestNumber) {
                biggestNumber = arrayNimi[i];
            }
        }
        return biggestNumber;
    }

    // TODO, leia massiivi kõigi elementide summa
    public static int sum(int[] arrayNimi) { //2,4,5,2,1
        int elementideSumma = arrayNimi[0];
        for (int i = 1; i < arrayNimi.length; i++) {
            elementideSumma = elementideSumma + arrayNimi[i];
        }
        return elementideSumma;
    }

    // TODO trüki välja korrutustabel mis on x ühikut lai ja y ühikut kõrge
    // TODO näiteks x = 3 y = 3
    // TODO väljund
    // 1 2 3
    // 2 4 6
    // 3 6 9
    // TODO 1 trüki korrutustabeli esimene rida (numbrid 1 - x)
    // TODO 2 lisa + " " print funktsiooni ja kasuta print mitte println
    // TODO 3 trüki seda sama rida y korda
    // TODO 4 Kuskile võiks kirjutada System.out.println(),
    //  et saada taebli kuju
    // TODO 5 võrdle ridu. Kas on mingi seaduspärasus ridade vahel,
    // mis on ja mis võiks olla. Äkki tuleb mõni idee
    public static void multiplyTable(int x, int y) {
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                System.out.print(i * j + " ");
            }
            System.out.println();
        }
    }

    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2);
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element. Võid eeldada, et n >= 0
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        int a = 0;
        int b = 1;
        System.out.print(a+ " ");
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
            System.out.print(a + " ");
        }
        return b;
    }

//        public static int fibonacci2 ( int n){ // Debug?!?!
//            if (n == 0) {
//                return 0;
//            } else if (n == 1) {
//                return 1;
//            } else {
//                return fibonacci2(n - 1) + fibonacci2(n - 1);
//            }
//        }

    // TODO
    // Kujutame ette numbrite jada, kus juhul kui number on paaris arv siis me jagame selle 2-ga
    // Kui number on paaritu arv siis me korrutame selle 3-ga ja liidame 1. (3n+1)
    // Seda tegevust teeme me niikaua kuni me saame vastuseks 1
    // Näiteks kui sisend arv on 22, siis kogu jada oleks:
    // 22 -> 11 -> 34 -> 17 -> 52 -> 26 -> 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
    // Sellise jada pikkus on 16
    // Kirjutada programm, mis peab leidma kõige pikema jada pikkuse mis jääb kahe täis arvu vahele
    // Näiteks:
    // Sisend 10 20
    // Siis tuleb vaadata, kui pikk jada tuleb kui esimene numbr on 10. Järgmisen tuleb arvutada number 11 jada pikkus.
    // jne. kuni numbrini 20
    // Tagastada tuleb kõige pikem number
    // Näiteks sisendi 10 ja 20 puhul on vastus 20
    public static int sequence3n(int x, int y) {

        return 0;
    }
}


