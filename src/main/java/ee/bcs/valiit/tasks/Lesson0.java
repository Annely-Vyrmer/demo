package ee.bcs.valiit.tasks;

public class Lesson0 {
    public static void main(String[] args) {
        excersie1();
        excersie2();
        excersie3();
        excersie4();
    }

    // TODO
    // defineeri 3 muutujat a = 1, b = 1, c = 3
    // Prindi välja a==b, mitte "" kui string
    // Prindi välja a==c
    // Lisa rida a = c
    // Prindi välja a==b,
    // Prindi välja a==c, mis muutus???
    public static void excersie1(){
        int a = 1;  //l24 ütleb, et a on nüüd 3
        int b = 1;
        int c = 3;
        System.out.println(a==b); //"" ei kasuta, kuna prindid välja kas a võrdub b-ga, peab võrdlema, mitte kui tekst!
        System.out.println(a==c); //l22-23 ühel real ((a==b)+""+(a==c))
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
        int y1 = ++x1;
        int y2 = x2++;
        System.out.println(y1);
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
        int a = 18 % 3;
        int b = 19 % 3;
        int c = 20 % 3;
        int d = 21 % 3;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
    }

    // TODO
    // Defineeri String tüüpi muutuja mille sisu oleks "\"\\""
    // Trüki muutuja sisu välja
    public static void excersie4(){
        String a = "\"\"\\\"\\\\\"\"";  //" ja \ teema, kuna kasutatud tekstis. Tuleb escape-da, ehk iga sümboli ette tagurpidi kaldkriips \
        System.out.println(a);          //(\n) tähendab uut rida
    }
}
