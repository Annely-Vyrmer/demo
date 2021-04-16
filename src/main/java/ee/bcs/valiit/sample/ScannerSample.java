package ee.bcs.valiit.sample;

import java.util.Scanner;

public class ScannerSample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   //konsoolilt info sisse lugemiseks
        //scanner.nextLine();                         //tagastab ühe rea kuni ...?
        //scanner.nextInt();                        //tagastab järgmise numbri, mis konsooli kirjutatakse
        System.out.println("Palun sisesta kaks numbrit");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Palun sisesta tekst");
        String s = scanner.nextLine();
        System.out.println("Sa sisestasid: " + a);
        System.out.println("Sa sisestasid: " +s);
    }
}
