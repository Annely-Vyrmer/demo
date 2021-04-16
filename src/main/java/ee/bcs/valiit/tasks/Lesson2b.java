package ee.bcs.valiit.tasks;

import java.util.Arrays;

public class Lesson2b {
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
    public static int exercise1(int n) {
        //while meetod
        int i = 1;
        while (i <= n) {
            System.out.println(i + " ");
            i++;
        }
        //Alternatiivne lahendus:
//        for (int = 1; i <= n; i++) {
//            System.out.println(i + " ");
//        }
        return i;
    }

    // TODO tagasta massiiv milles oleks numbrid 1,2,3,4,5
    public static int[] sampleArray() {
        //alternatiivne variant.2.
        int [] array = new int []{1,2,3,4,5};
        return array;
        //Lihtsaim lahendus .1.
        //return new int[]{1,2,3,4,5}   //teed massiivi ja paned arvud sisse. Anna mulle mälu ja pane 1.positsioonile 1, 2. positsioonile 2 JNE

        //Veel üks lahendus, aga keeruline .3.
//        int[] array = new int[5];   //5 arvu massiivis
//        for (int i = 0; i < array.length; i++){
//            array[i] = i + 1;       //tagasta massiiv
//        }
//        return array;
    }

    // TODO loo massiiv mis saab sisendiks n ja tagastab massiivi suurusega n
    // Kus esimene element on 1 ja iga järnev arv on 1 võrra suurem
    // näiteks:
    // sisend: 5
    // vastus: {1, 2, 3, 4, 5}
    public static int[] generateArray(int n){
            //Lahendus: 1
        int[] resultArray = new int[n];
            for (int i = 0; i < n; i++) {
                resultArray[i] = i + 1;
            }
        return resultArray;

            //Lahendus: 2
//        int[] array = new int[n];   //me ei tea mitu arvu seal on
//        for (int i = 0; i < array.length; i++) { // i=0 array on loopi algus,
//            array[i]  = i+1;         //siin salvestab selle hetke väärtuse, mis selle loopiga tekkis
//        }
//        return array;
    }

    // TODO
    // Tagastada massiiv kus oleks numbrid n-ist 0 ini
    // Näiteks: sisend: 5
    // Väljund: 5, 4, 3, 2, 1, 0
    // Näide2: siend: -3
    // Väljund: -3, -2, -1, 0
    public static int[] decreasingArray(int n){
        //Sellele on õpetajal parem lahendus Math.abs, index (ehk positsioonide asukoahd) ja while ning if-iga/else-ga

        if(n>=0) {                          //kui n-s olev number on suurem kui 0 (positiivne arv), tee...
            int[] massiivid = new int[n+1];   //me ei tea mitu arvu arrays on. +1 sellepärast, et ka 0 on vaja
                                              //int[] array = new int[Math.abs(n)+1]; loome uue array pikkusega absoluutväärtus n-st +1
            for (int i = 0; i <= n; i++) {  //tsükkel i käib numbrist 0 kuni n-1 kuna i<n
                massiivid[i] = n-i;
            }
            return massiivid;
        } else {                            //läheb tööle kui on negatiivne arv
            int[] massiivid = new int[-n+1];    //me ei tea mitu arvu arrays on
            for(int i = n; i <= 0; i++) {        //tsükkel i jookseb
                massiivid [-n+i] = i;
            }
//            massiivid [0] = -5;  massiivid [-n+i] //-(-5)+(-5) = -5 saab asendada i-ga    //kohal 0 on väärtus -5
//            massiivid [1] = -4;                           //kohal 1 on väärtus -4
//            massiivid [2] = -3;
//            massiivid [3] = -2;
//            massiivid [4] = -1;
//            massiivid [5] = 0;
            return massiivid;
        }
    }

    // TODO
    // tagasta massiiv pikkusega n, mille kõigi elementide väärtused on 3
    public static int[] yl3(int n){
        int[] massiiv = new int[n];
            for(int i = 0; i<n; i++) {
                massiiv[i] = 3;
            }
        return massiiv;
    }
}
