package ee.bcs.valiit.tasks;

public class Lesson2 {

    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks
        //multiplyTable(5,5);
        //System.out.println(sum(new int[]{2,4,5,-2,-1}));
        //System.out.println(fibonacci(21));
        //System.out.println(sequence3n(10, 20 ));
    }

    // TODO loe funktsiooni sisendiks on täisarvude massiiv
    // TODO tagasta massiiv mille elemendid on vastupidises järiekorras
    public static int[] reverseArray(int[] inputArray) {
        //looge uus array, return array, mis on sama pikk kui input array
        int[] returnArray = new int[inputArray.length];
        for (int i = inputArray.length - 1; i >= 0; i--) {  //tsükkel algab suurima positsiooniga arvust ja lahutab -1
            returnArray[i] = inputArray[inputArray.length - 1 - i];
        }
        return returnArray;
    }
    // TODO tagasta massiiv mis sisaldab n esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    //palju erinevaid lahendusi.
    public static int[] evenNumbers(int n) {
        int[] paarisArv = new int[n];           //tahame luua uut arrayd!, lihtsalt nii on selline syntax
        for (int i = 0; i < n; i++) {            //1.positsioon arrays on 0
            paarisArv[i] = (i + 1) * 2;             //number positsioonis = ()
        }
        //        paarisArv [0] = 2; // i=0 // [0] saab asendada i-ga // (i+1)*2 ja vastus on 0
        //        paarisArv [1] = 2; // i=1 // [1] saab asendada i-ga // (i+1)*2 ja vastus on 2
        //        paarisArv [2] = 2; // i=2 // [2] saab asendada i-ga // (i+1)*2 ja vastus on 4
        //        paarisArv [3] = 2; // i=3 // [3] saab asendada i-ga // (i+1)*2 ja vastus on 6
        //        paarisArv [4] = 2; // i=4 // [4] saab asendada i-ga // (i+1)*2 ja vastus on 8
        //        paarisArv [5] = 2; // i=5 // [5] saab asendada i-ga // (i+1)*2 ja vastus on 10
        return paarisArv;
    }

    // TODO, leia massiivi kõige väiksem element
    public static int min(int[] arrayNimi) { //4 2 6 1 9
        //salvesta mahasalvestatud muutuja järgmise muutujaga
        int smallestNumber = arrayNimi[0];  //min elemendi väärtus on 4, kuna on 1. element
        for (int i = 0; i < arrayNimi.length; i++) { // i = 0 -> 4
            if (arrayNimi[i] < smallestNumber) { // kas arrayNimi kohal 0 on väiksem kui minElement? (arrayNimi[0] < minElement) // teen nii ühe tsükli rohkem
                smallestNumber = arrayNimi[i];
            }
        }
        return smallestNumber;
    }

    // TODO, leia massiivi kõige suurem element
    public static int max(int[] arrayNimi) {
        int biggestNumber = arrayNimi[0];               // [0] määrab, et positsioonil "0" olev number on hetkel väikseim
        for (int i = 0; i < arrayNimi.length; i++) {
            if (arrayNimi[i] > biggestNumber) {
                biggestNumber = arrayNimi[i];
            }
        }
        return biggestNumber;
    }

    // TODO, leia massiivi kõigi elementide summa
    public static int sum(int[] arrayNimi) {
        //liida kõik kokku
        int arrayNimiElements = arrayNimi.length;      //kui palju elemente on arrays?
        int total = 0;                                 //[0] siia salvestub esimene summa, mis on positsioonil 0
        for (int i = 0; i < arrayNimiElements; i++) {   //loop x arv elemente
            total = total + arrayNimi[i];              //uus total on eelmine total + uue array positsiooni 0 väärtus
        }
        return total;
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
        //System.out.println(x);
        for (int i = 1; i <= x; i++) {       //x defineeritud 5 ja y defineeritud 5
            for (int j = 1; j <= y; j++) {       //loop hakkab 1-st
                System.out.print(i * j + " ");    //prindib üksteise järel
            }
            System.out.println();               //teeb reavahetuse
        }
    }

    // TODO
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2); eel
    // 0, 1, 1, 2, 3, 5, 8, 13, 21
    // Tagasta fibonacci jada n element. Võid eeldada, et n >= 0
    public static int fibonacci(int n) { // viga sees
        int a = 0;
        int b = 1;
        int c = 1;                  //saab teha ka nii, et c-d ei defineeri. Sissepoole parem, kuna vaja ianult korraks tsükli sees.
        //System.out.print(a + " " + b);
        if (n == 0) {               //kui n on väärtusega 0
            return 0;               //tagasta 0
        }
        for (int i = 1; i < n; i++) {   //alustad esimesest positsioonist
            c = a + b;
            System.out.print(" " + b);  //nüüd lisab positsiooni c numbrti, mis on 0+1=1
            a = b;                      //et positsioon 1st saaks positsioon 2 - määra ära
            b = c;                      //et positsioon 2st saaks positsioon 3(tekkis eelmise loopiga) - määra ära
        }
        return b;                       //tagastad c uue väärtuse
    }

    //golden ratio valem
    //0 ja 1 / 0+1=1
    //1 ja 1 / 1+1=2
    //1 ja 2 / 1+2=3
    //2 ja 3 / 2+3=5
    //3 ja 5 / 3+5=8
    //5 ja 8 / 5+8=13
    //8 ja 13 / 8+13=21

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
