package ee.bcs.valiit.kodusedharjutused;

import java.util.Arrays;

public class LihtsaltNäited {

    public static void main(String[] args) {
        //System.out.print(Arrays.toString(tekitaMassiv(5)));
        //System.out.print(Arrays.toString(tagastaKõik3(5)));
        //System.out.print(Arrays.toString(tagastaTagurpidiMassiv(5)));
        //System.out.println(min(new int[]{4,2,6,1,9}));
        //System.out.println(tagastaMassiiviSumma(new int[]{1,2,3,4,5}));
        //korrutusTabel(5, 5);
    }

    public static int[] tekitaMassiv(int n) {
        int[] massiiv = new int[n];
        for (int i = 0; i < n; i++) {
            massiiv[i] = i + 1;
        }
        return massiiv;
    }

    public static int[] tagastaKõik3(int n) {
        int[] tagastatavadNumbrid = new int[n];
        for (int i = 0; i < n; i++) {
            tagastatavadNumbrid[i] = 3;
        }
        return tagastatavadNumbrid;
    }

    public static int min(int[] arrayNimi) { //4 2 6 1 9
        //salvesta mahasalvestatud muutuja järgmise muutujaga
        int smallestNumber = arrayNimi[0];  //def alguses, et väikseima elemendi väärtus on 4, kuna on 1. element. Teisi võrdleb selle vastu
        for (int i = 0; i < arrayNimi.length; i++) { // i = 0 -> 4
            if (arrayNimi[i] < smallestNumber) { // kas arrayNimi kohal 0 on väiksem kui minElement? (arrayNimi[0] < minElement) // teen nii ühe tsükli rohkem
                smallestNumber = arrayNimi[i];
            }
        }
        return smallestNumber;
    }

    public static int tagastaMassiiviSumma(int[] x) {
        int summa = x[0];
        for (int i = 1; i < x.length; i++) {
            summa = summa + x[i];
        }
        return summa;
    }

    // TODO trüki välja numbrid stringis
    // s = 5 (string)
    // return 5*4*3*2*1 = 120
    //Naturaalarvu n faktoriaal on n esimese positiivse täisarvu KORRUTIS.
    public static int factorial(int x) {
        int faktoriaal = x;                //tekitan ühe uue muutuja nimega faktoriaal, mis on x = sout määratud, et "5" (mitte jada)
        for (int i = 1; i < x; i++) {      //i-d ei saa 0ga läbi korrutada, kuna 5*0=0//(i=1)muutuja/loopide arv i, mille algväärtus 1
            faktoriaal = faktoriaal * i;   //korruta seda numbrit, mis on x-na määratud, i-ga ja korrutada saab alates 1, kuna 0-ga korrutades on alati 0
        }
        return faktoriaal;                  //tagastad ühe numbri, kuna FORiga loopides kasutad eelmist faktoriaali tulemust
    }
}