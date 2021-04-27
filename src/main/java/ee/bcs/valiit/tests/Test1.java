package ee.bcs.valiit.tests;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        //System.out.println(jagamine(-3));
//        System.out.println(jagamine(5));
//        System.out.println(jagamine(3));
//        System.out.println(jagamine(7));
//        System.out.println(jagamine(21));
        //System.out.println(Arrays.toString(addToArray(new int[]{1, 2, 3}, 3)));
        //System.out.println(Arrays.toString(lisaÜlesanne(new int[]{1,2,3})));
    }

    //    ÜL 1
//    Tee funktsioon, mis tagastab boolean väärtuse ja võtab sisse ühe parameetri
//    funktsioon peab tagastama
//		true: kui sisend parameeter jagub 3 või 7 (aga ei jagu mõlema numbriga)
//      false: kui sisend parameeter ei jagu 3 ega 7 või jagub mõlema numbriga
    public static boolean jagamine(int a) {
        if ((a % 3 == 0) && (a % 7 == 0)) {
            return false;
        } else {
            for (int i = 3; i <= a; i++) {
                if (a % i == 0) {
                    return true;
                } else return a % 7 == 0;
            }
        }
        return false;
    }

    // ÜL2
    // lisa x igale array elemendile
    // Näiteks
    // sisend [1,2,3], 5
    // vastus [6,7,8]
    public static int[] addToArray(int[] array, int x) {
        for (int i = 0; i < array.length; i++) {    //Array PIKKUS!!!!!!
            array[i] = array[i] + x;            //Määrasin sout real x//System.out.println(Arrays.toString(addToArray(new int[]{1,2,3}, 3)));
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    //tagastaks int array ja võtaks sisse int array
    //kirjuta 1. element üle 0-ga
    public static int[] lisaÜlesanne(int[] array) {
        array[0] = 0;
        return array;
    }
}
