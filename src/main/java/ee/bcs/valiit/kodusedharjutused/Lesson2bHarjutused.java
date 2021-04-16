package ee.bcs.valiit.kodusedharjutused;

import java.util.Arrays;

public class Lesson2bHarjutused {
    public static void main(String[] args) {
        exercise1(5);
        System.out.println(Arrays.toString(sampleArray()));
        System.out.println(Arrays.toString(generateArray(5)));
        System.out.println(Arrays.toString(decreasingArray(5)));
        System.out.println(Arrays.toString(yl3(5)));
    }
    // TODO trüki välja n arvu
    // kasuta tsüklit
    // näiteks
    // sisend: 5
    // trüki välja: 1 2 3 4 5
    public static void exercise1(int n) {
        for(int i = 1; i <= n; i++) {
            System.out.println(i + " ");
        }
    }

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray() {
        int [] massiiv = new int[]{1,2,3,4,5};
        return massiiv;
    }

    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem (+1)
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}
    public static int[] generateArray(int n){
        int[] massiiv = new int[n];
        for (int i = 0; i < n; i++) {
            massiiv[i] = i+1;
        }
        return massiiv;
    }

    // TODO
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0
    public static int[] decreasingArray(int n){
        int[] massiiv = new int[Math.abs(n) + 1];   //+1 kuna on vaja, et oleks 1 number rohkem kui arrays
        int index = 0;

        while (n !=0) {
            massiiv[index] = n;     //see jäi segaseks
            if (n > 0) {
                n = n - 1;
            } else {
                n = n + 1;
            }
            index++;
        }
        return massiiv;
    }

    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n){
        int[] massiiv = new int[n];
        for (int i = 0; i<n; i++) {
            massiiv [i] = 3;
        }
        return massiiv;
    }
}
