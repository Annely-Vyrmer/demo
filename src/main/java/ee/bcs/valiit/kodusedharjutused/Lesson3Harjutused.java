package ee.bcs.valiit.kodusedharjutused;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lesson3Harjutused {

    public static void main(String[] args) {
        //System.out.println(factorial(5));   //nr "5", aga mitte viis arvu 1-5(1,2,3,4,5)
        //reverseString("Annely");
        //System.out.println(isPrime(6));
        //System.out.println(Arrays.toString(sort(new int[]{6, 4, 7, 1,})));
        //System.out.println(Arrays.toString(sort1(new int[]{6, 4, 7, 1,})));
        //int [] a = {6,4,7,1};
        //System.out.println(Arrays.toString(sort2(a)));
        //System.out.println(Arrays.toString(sort2(new int[]{6, 4, 7, 1,})));
        //System.out.println(evenFibonacci(30));
    }

    // TODO tagasta x faktoriaal.
    // Näiteks
    // x = 5
    // return 5*4*3*2*1 = 120
    //Naturaalarvu n faktoriaal on n esimese positiivse täisarvu KORRUTIS.
    public static int factorial(int x) {
        int faktoriaalArvuSumma = x;
        for (int i = 1; i < x; i++) {
            faktoriaalArvuSumma = faktoriaalArvuSumma * i;
        }
        return faktoriaalArvuSumma;
    }

    // TODO tagasta string tagurpidi
    //tagasta mingi sõna tagurpidi, nt oma nimi
    public static String reverseString(String a) {
    String nimiTagurpidi = "";
        for (int i = 0; i< a.length(); i++){
            int ajutine = a.length()-i-1;
            nimiTagurpidi = nimiTagurpidi +a.charAt(ajutine);
            System.out.println(nimiTagurpidi);
        }
    return nimiTagurpidi;
    }

    // TODO tagasta kas sisestatud arv on primaar arv (jagub ainult 1 ja iseendaga)
    //Primaar number on ühest(1) suurem. Jaguneb ainult 1ga JA iseendaga (ei jagune 2,3,4..). 2 tingimust!
    //Numbrid on 2,3,5,7,11,13,17,19,23,29
    public static boolean isPrime(int x) {
        if ((x == 0) || (x == 1)) {
            return false;
        } else {
            for (int i = 2; i < x; i++) {
                if (x % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    // TODO sorteeri massiiv suuruse järgi väiksemast suuremaks.
    // TODO kasuta tsükleid, ära kasuta ühtegi olemasolevat sort funktsiooni
    //defineerisin main-is, et numbrid on: 6,4,7,1
    //sarnane korrutustabelile, erinevus võrdlusega
    public static int[] sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) { //Võrdluseid on ühe korra vähem kui elemente!
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {      //võrdlen pos.1 olevat väärtust j+1 kohal oleva väärtusega
                    int ajutine = a[j];     //uus muutuja võtab enda kohale j reas index0 kohal oleva numbri, mis on 6. See on ajutine hoiustamis koht!
                    a[j] = a[j + 1];        //6 on pos1. ajutisel kohal, 6 hakka olema 4// 7 kohal hakka olema hoopis 1
                    a[j + 1] = ajutine;     //[j+1] asukohale läheb 6 // 1 kohale indexis mine 7
                }                           //tsükli lõpp, läheb sisemise FOR (j) sisse ja hakkab uuesti tegema
                System.out.println(Arrays.toString(a));//tagastada on vaja kogu massiiv, mitte väikseim! i0 sees j1-4 loop
            }
            System.out.println(Arrays.toString(a)); //0.j FOR tsükli lõpp, hüppab 1.i tsüklisse
        }
        return a;               //FOR loopis sees ei saa the RETURNi
    }

    //tagastada massiivi jada alustades suurimast (Annely meetod)
    public static int[] sort1(int[] a) {
        for (int i = 0; i < a.length - 1; i++) { //Võrdluseid on ühe korra vähem kui elemente!
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] < a[j + 1]) {      //võrdlen pos.1 olevat väärtust j+1 kohal oleva väärtusega
                    int ajutine = a[j];     //uus muutuja võtab enda kohale j reas index0 kohal oleva numbri, mis on 6. See on ajutine hoiustamis koht!
                    a[j] = a[j + 1];        //6 on pos1. ajutisel kohal, 6 hakka olema 4// 7 kohal hakka olema hoopis 1
                    a[j + 1] = ajutine;     //[j+1] asukohale läheb 6 // 1 kohale indexis mine 7
                }                           //tsükli lõpp, läheb sisemise FOR (j) sisse ja hakkab uuesti tegema
                System.out.println(Arrays.toString(a));//tagastada on vaja kogu massiiv, mitte väikseim! i0 sees j1-4 loop
            }
            System.out.println(Arrays.toString(a)); //0.j FOR tsükli lõpp, hüppab 1.i tsüklisse
        }
        return a;               //FOR loopis sees ei saa the RETURNi
    }
    //tagastab massiivi jada suuremast kellegi teise meetoid!!!
    //nr on 6,4,7,1
    public static int[] sort2(int[] a) {
        int [] jadaSuurimast = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                int ajutine = 0;
                if (a[i] > jadaSuurimast[j]) {
                    ajutine = a[i];
                    a[i] = jadaSuurimast[j];
                    jadaSuurimast[j] = ajutine;
                }                                       //tsükli lõpp, läheb esimese FOR sisse ja hakkab uuesti tegema
                System.out.println(Arrays.toString(jadaSuurimast));//tagastada on vaja kogu massiiv, mitte väikseim!!!!
            }
            System.out.println(Arrays.toString(jadaSuurimast));
        }
        return jadaSuurimast;               //FOR loopis sees ei saa the RETURNi
    }
    // TODO liida kokku kõik paaris fibonacci arvud kuni numbrini x (nt 30, kõik paaris arvud, mille väärtus on väiksem kui 30)
    // Fibonacci jada on fib(n) = fib(n-1) + fib(n-2); eelmised positsioonid
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
    //sisend = 3, see sees on paarisnumbrid 2+8=10
    //leiad paarisarvud jadas kuni väärtuseni x.
    //kui nr 10, siis liida kokku 2 ja 8
    public static int evenFibonacci(int x) {
        int a = 0;
        int b = 1;
        int summa = 0;
        if (x == 0){
            return 0;
        }
        while (a+b<=x){
            int c = a+b;
            a=b;
            b=c;
            if (b%2==0){
                summa = summa + b;
            }
        }
        return summa;
    }

    public static String morseCode(String text) {
        // TODO kirjuta programm, mis tagastab sisestatud teksti morse koodis (https://en.wikipedia.org/wiki/Morse_code)
        // Kasuta sümboleid . ja - ning eralda kõik tähed tühikuga
//            Map<String, String> morseKood = new HashMap<>();
//            morseKood.put("a", ".-");
//            morseKood.put("n", "-.");
//            morseKood.put("n", "-.");
//            morseKood.put("e", ".");
//            morseKood.put("l", ".-..");
//            morseKood.put("y", "-.--");
//
//            for(){
//
//            }
//            for (String nameKey: morseKood.keySet()) {
//                System.out.println(nameKey + " a " + morseKood.get(nameKey));
//            }
//            return a.trim();
        return "";
    }
}


