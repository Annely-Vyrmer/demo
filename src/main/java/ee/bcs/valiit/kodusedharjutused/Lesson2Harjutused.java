package ee.bcs.valiit.kodusedharjutused;
import java.util.Arrays;
public class Lesson2Harjutused {

    public static void main(String[] args) {
        // TODO siia saab kirjutada koodi testimiseks
        //multiplyTable(5,5);
        //System.out.println(sum(new int[]{2,4,5,-2,-1}));
    }

    // TODO loe funktsiooni sisendiks on täisarvude massiiv
    // TODO tagasta massiiv mille elemendid on vastupidises järjekorras
    public static int[] reverseArray(int[] inputArray) {
        int [] returnArray = new int[inputArray.length];    //teen kindlaks kui pikk on array
        for(int i = inputArray.length -1; i >= 0 ; i--){    //tsükkel algab tagurpidi (suurimast positsioonist, lahutan -1) ja niikaua kui i jõuab 0
            returnArray[i] = inputArray[inputArray.length -i-1];    //???
        }
        return returnArray;
    }

    // TODO tagasta massiiv mis sisaldab n esimest paaris arvu
    // Näide:
    // Sisend 5
    // Väljund 2 4 6 8 10
    //palju erinevaid lahendusi.
    public static int[] evenNumbers(int n) {
        int [] paarisArv = new int[n];
        for (int i = 0; i < n; i++) {
            paarisArv[i] = (i+1)*2;         //???
        }
        return paarisArv;
    }

    // TODO, leia massiivi kõige väiksem element
    public static int min(int[] arrayNimi){ //4 2 6 1 9
        //salvesta mahasalvestatud muutuja järgmise muutujaga
        int smallestNumber = arrayNimi[0];  //min elemendi väärtus on 4, kuna on 1. element
        for(int i = 0; i < arrayNimi.length; i++) { // i = 0 -> 4
            if(arrayNimi[i] < smallestNumber) { // kas arrayNimi kohal 0 on väiksem kui minElement? (arrayNimi[0] < minElement) // teen nii ühe tsükli rohkem
                smallestNumber = arrayNimi[i];
            }
        }
        return smallestNumber;
    }

    // TODO, leia massiivi kõige suurem element
    public static int max(int[] arrayNimi){
        int biggestNumber = arrayNimi[0];               // [0] määrab, et positsioonil "0" olev number on hetkel väikseim
        for(int i = 0; i < arrayNimi.length; i++) {
            if(arrayNimi[i] > biggestNumber) {
                biggestNumber = arrayNimi[i];
            }
        }
        return biggestNumber;
    }

    // TODO, leia massiivi kõigi elementide summa
    public static int sum(int[] arrayNimi){
        //liida kõik kokku
        int arrayNimiElements = arrayNimi.length;      //kui palju elemente on arrays?
        int total = 0;                                 //[0] siia salvestub esimene summa, mis on positsioonil 0
        for(int i = 0; i < arrayNimiElements; i++) {   //loop x arv elemente
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
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j<= y; j++) {
                System.out.print(i*j + " ");
            }
        }
        System.out.println();
    }
}
