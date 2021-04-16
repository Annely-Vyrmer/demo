package ee.bcs.valiit.tasks;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lesson3 {
    public static void main(String[] args) {
        //System.out.println(factorial(5));   //nr "5", aga mitte viis arvu 1-5(1,2,3,4,5)
        //reverseString("Annely");
        //System.out.println(isPrime(1));
        //System.out.println(Arrays.toString(sort(new int[]{6, 4, 7, 1})));
        //System.out.println(evenFibonacci(30));
        morseCode("hello sos");
    }

    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    //Naturaalarvu n faktoriaal on n esimese positiivse täisarvu KORRUTIS.
    public static int factorial(int x) {
        int faktoriaal = 1;                //tekitan ühe uue muutuja nimega faktoriaal, mis on x = sout määratud, et "5" (mitte jada)
        for (int i = 1; i <= x; i++) {      //i-d ei saa 0ga läbi korrutada, kuna 5*0=0//(i=1)muutuja/loopide arv i, mille algväärtus 1
            faktoriaal = faktoriaal * i;   //korruta seda numbrit, mis on x-na määratud, i-ga ja korrutada saab alates 1, kuna 0-ga korrutades on alati 0
        }                                   // sum *= i on sama mis faktoriaal = faktoriaal * i
        return faktoriaal;                  //tagastad ühe numbri, kuna FORiga loopides kasutad eelmist faktoriaali tulemust
    }

    // TODO tagasta string tagurpidi
    //tagasta mingi sõna tagurpidi, nt oma nimi
    public static String reverseString(String a) {
        String nimiTagurpidi = "";                  //reverseString("Annely"); ette määratud main-is. Siin määran Functioni.
        for (int i = 0; i < a.length(); i++) {      //alustan pos.0 ja teen niikaua kuini see string pikk on (a.length)
            int viimaneIndex = a.length() - i - 1;      //et trükiks välja
            System.out.println(viimaneIndex);
            nimiTagurpidi = nimiTagurpidi + a.charAt(viimaneIndex);  //charAt meetod tagastab characterid indexis stringina.
            System.out.println(nimiTagurpidi);          // võtab tagantpoolt char-i, lahutab ühe chari (-i), -1 kuna peab liikuma tagant ette
        }                                               //võtab loop 1-st eelmise jalahutab 1, et tagurpidi minema saada
        return nimiTagurpidi;
    }

    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
    //Primaar number on ühest(1) suurem. Jaguneb ainult 1ga JA iseendaga (ei jagune 2,3,4..). 2 tingimust!
    //Numbrid on 2,3,5,7,11,13,17,19,23,29
    public static boolean isPrime(int x) {
        if (x == 1) {
            return false;
        }
        for (int i = 2; i < x; i++) {   //alustab tsüklist 2-st, kuna 1 jaguneb alati x-ga. Teeb tsüklit kuni x väärtuseni
            if (x % i == 0) {       //kui x jaub i-ga (mis algas2-st) ja jääk on 0, siis ei ole see priimaararv
                return false;
            }
        }
        return true;                    //siin täituvad 2 tingimust: jaguneb iseendaga JA ainult ühega (1)
    }

    // TODO sorteeri massiiv suuruse järgi väiksemast suuremaks.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    //defineerisin main-is, et numbrid on: 6,4,7,1
    //sarnane korrutustabelile, erinevus võrdlusega
    public static int[] sort(int[] a) {
        for (int j = 1; j < a.length; j++) {    //Jooksutan array-d, alustades pos.1 kuni massiivi lõpuni. Võrdluseid on ühe korra vähem kui elemente!
            for (int i = 1; i < a.length; i++) {//võrdlen pos.1 olevat väärtust massiivi lõpuni
                if (a[i-1] > a[i]) {          //kui a[i-1] kohal #6 > kui a[i] kohal #4
                    int ajutine = a[i];       // ajutisel hoiustamiskohal on a[i] ehk #4
                    a[i] = a[i-1];            //#6 kohale mine koht, kus on #4
                    a[i-1] = ajutine;         //#4 kohal [i-1] on nüüd ajutine
                }                               //tsükli lõpp, läheb sisemise FOR sisse ja hakkab uuesti tegema
                System.out.println(Arrays.toString(a));
            }
            System.out.println(Arrays.toString(a));
        }
        return a;               //FOR loopis sees ei saa the RETURNi
    }

    public static int evenFibonacci(int x) {
        // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x (nt 30, kõik paaris arvud, mille väärtus on väiksem kui 30)
        // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2); eelmised positsioonid
        // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
        //sisend = 30 numbrid on 2+8=10
        //leiad paarisarvud jadas kuni väärtuseni x.
        //kui nr 10, siis liida kokku 2 ja 8
        //Õpetajal teine lahendus! Vaat SolutioniT!
        int a = 0;                      //muutuja 1, pos.0, mille väärtus on 0
        int b = 1;                      //muutuja 2, pos.1, mille väärtus on 1
        int summa = 0;                  //muutuja summa, mille väärtus alguses 0

        if (x == 0) {                   //juhul kui x väärtus on võrdne 0-ga, siis tagasta number
            return 0;
        }
        while (a + b <= x) {            //tee niikaua kuni a+b on väiksem või võrdne x-ga (x=30)
            int c = a + b;              //uus muutuja (3), mis tekib kui a+b (alguses 0+1=1)
            a = b;                      //muutuja 1 = uus väärtus muutub(omistan) muutuja 2-ks, e 0=1
            b = c;                      //muutuja 2 = uus väärtus muutub(omistan) muutuja 3-ks, e 1=1
            if (b % 2 == 0) {           //seejärel, kui WHILE loopi sees b summa jaguneb 2-ga ning jääk on 0, siis
                summa = summa + b;      //muutuja summa = algsumma 0+b
            }
        }
        return summa;                //tagastad summa
    }

    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga
        // Tee tsükkel ja anna see ette MAPile. Lööd laiali. Saad tähe ja tähtedega MAPi kallale ja tagasta String
        // hello sos

        //Õpetajal näide Characteriga (Map<Character, String> morseKood = new HashMap<>();)
        Map<String, String> morseKood = new HashMap<>();
        //Sisestan vajalikud tähed
        morseKood.put("h", "....");
        morseKood.put("e", ".");
        morseKood.put("l", ".-..");
        morseKood.put("o", "---");
        morseKood.put("s", "...");

        String morseRida = "";                  //Tekitan TÜHJA Stringi, kuhu salvestuvad järjepanu tähed
                                                //FOR EACH TSÜKKEL!!!
        for (char c : text.toCharArray()) {     //Tekitan character array, iga indexi i väärtus tagastatakse iga järgneva korraga järgmisel real (i=h, i+1=e).
            morseRida += morseKood.get((c + "")) + " "; //tsükkel käib array läbi ja lisab/salvestab tähed Stringile morseRida, iga tähe järel tühik
            System.out.println(morseRida);
        }
        return morseRida.trim();                //.trim võtab lõpust ebavajaliku tühiku ära!
    }
}

