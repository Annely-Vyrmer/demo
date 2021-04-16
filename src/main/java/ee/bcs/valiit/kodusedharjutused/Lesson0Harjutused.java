package ee.bcs.valiit.kodusedharjutused;

public class Lesson0Harjutused {

    public static void main(String[] args) {
        //excersie1();
        //excersie2();
        //excersie3();
        //excersie4();
        //ülesanne1();
        //ülesanne2();
        //ülesanne3();
        //ülesanne4();
    }

    // TODO
    // defineeri 3 muutujat a = 1, b = 1, c = 3
    // Prindi välja a==b, mitte "" kui string
    // Prindi välja a==c
    // Lisa rida a = c
    // Prindi välja a==b,
    // Prindi välja a==c, mis muutus???
    public static void excersie1(){
        int a = 1;
        int b = 1;
        int c = 3;
        System.out.println(a==b);
        System.out.println(a==c);
        a = c;
        System.out.println(a==b);
        System.out.println(a==c);
    }

    // TODO
    // Loo muutujad x1 = 10 ja x2 = 20, vali sobiv andmetüüp
    // Tekita muutuja y1 = ++x1, trüki välja nii x1 kui y1
    // Tekita muutuja y2 = x2++, trüki välja nii x2 ja y2
    // Analüüsi tulemusi
    public static void excersie2(){
        int x1 = 10;
        int x2 = 20;
        int y1 = ++x1;          //preincrement, suurendab x esmalt, ehk lisab 1 kümnele (x1=1+10=11) ja siis saab y1=x1 ehk y1=11
                                //sout: y1=11 //sout: x1=11
        int y2 = x2++;          //postincrement, esmalt saab y2=x2 (y2=20), siis suurendab x2 1 võrra, ehk x2=1+20=21.
                                //sout: y2=20 //sout: x2=21
        System.out.println(x1);
        System.out.println(y1);
        System.out.println(x2);
        System.out.println(y2);

    }

    // TODO
    // Loo arvulised muutujad
    // a = 18 % 3
    // b = 19 % 3
    // c = 20 % 3
    // d = 21 % 3
    // Prindi välja kõigi muutujate väärtused
    public static void excersie3(){
        int a = (18%3);
        int b = (19%3);
        int c = (20%3);
        int d = (21%3);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        //saab ka kokku liita, et alguses ei defineeri ja paned kohe print käsklusse, kuna arvutab seal:
        System.out.println(18%3);
        System.out.println(19%3);
        System.out.println(20%3);
        System.out.println(21%3);
    }


    // TODO
    // Defineeri String tüüpi muutuja mille sisu oleks "\"\\""
    // Trüki muutuja sisu välja
    public static void excersie4(){
        String muutuja = "\"\\\"\\\\\"\"";
        System.out.println(muutuja);
    }

    //!!!UUESTI HARJUTAMINE!!!
    // TODO
    // defineeri 3 muutujat a = 1, b = 1, c = 3
    // Prindi välja a==b, mitte "" kui string
    // Prindi välja a==c
    // Lisa rida a = c
    // Prindi välja a==b,
    // Prindi välja a==c, mis muutus???
    public static void ülesanne1(){
        int a = 1;
        int b = 1;
        int c = 3;
        System.out.println(a==b);
        System.out.println(a==c);
        a = c;
        System.out.println(a==b);
        System.out.println(a==c);
    }

    // TODO
    // Loo muutujad x1 = 10 ja x2 = 20, vali sobiv andmetüüp
    // Tekita muutuja y1 = ++x1, trüki välja nii x1 kui y1
    // Tekita muutuja y2 = x2++, trüki välja nii x2 ja y2
    // Analüüsi tulemusi
    public static void ülesanne2(){
        int x1 = 10;
        int x2 = 20;
        int y1 = ++x1;
        int y2 = x2++;
        System.out.println(y1 + " " + x1);
        System.out.println(y2 + " " + x2);
    }

    // TODO
    // Loo arvulised muutujad
    // a = 18 % 3
    // b = 19 % 3
    // c = 20 % 3
    // d = 21 % 3
    // Prindi välja kõigi muutujate väärtused
    public static void ülesanne3(){
        int a = 18 % 3;
        int b = 19 % 3;
        int c = 20 % 3;
        int d = 21 % 3;
        System.out.println(18%3);
        System.out.println(19%3);
        System.out.println(20%3);
        System.out.println(21%3);
    }


    // TODO
    // Defineeri String tüüpi muutuja mille sisu oleks "\"\\""
    // Trüki muutuja sisu välja
    public static void ülesanne4() {
        String muutuja = "\"\\\"\\\\\"\"";
        System.out.println(muutuja);
    }
}
