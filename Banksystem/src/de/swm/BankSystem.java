package de.swm;

import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {

    ArrayList<Konto> kontos = new ArrayList<Konto>();

     Konto eingeloggtesKonto = null;

    public void hauptmenue() {
        if (eingeloggtesKonto != null) {
            menueWhenLoggedin();
        }
        System.out.println("Banksystem Fabi");
        System.out.println("1] einloggen");
        System.out.println("2] regestrieren");
        System.out.println("3] exit");
        Scanner scanner = new Scanner(System.in);
        int readLine = scanner.nextInt();

        switch (readLine) {
            case 1:
             einloggen();
             break;
            case 2:
                regestrieren();
                break;
            case 3:
                System.exit(0);
                eingeloggtesKonto = null;
                break;

        }
        hauptmenue();

    }
    public void einloggen() {
        System.out.println("Bitte Nutzername und PIN eigeben.");
        Scanner scanner = new Scanner(System.in);
        String nutzername = scanner.nextLine();
        String bankPIN = scanner.nextLine();
        for (Konto konto: kontos) {
            if (konto.getKontoinhaber().equalsIgnoreCase(nutzername)) {
                if (konto.istAuthtifiziert(bankPIN)) {
                    eingeloggtesKonto = konto;
                }
            }
        }

    }

    public void regestrieren() {
        System.out.println("Bitte geben Sie einen Nutzernamen ein.");
        Scanner scanner = new Scanner(System.in);
        String kontoinhaber = scanner.nextLine();
        System.out.println("IBAN wird genariert.");
        String IBAN = Konto.randomString(20);
        System.out.println("Bitte setzen Sie eine vierstellige PIN");
        String bankPIN = scanner.nextLine();
        double Kontostand = 0;
        kontos.add(new Konto(kontoinhaber, IBAN,Kontostand, bankPIN));


    }

    public void menueWhenLoggedin() {
        System.out.println("Hallo");

        System.out.println("Banksystem Fabi");
        System.out.println("1] einzahlen");
        System.out.println("2] überweisung");
        System.out.println("3] logout");
        Scanner scanner = new Scanner(System.in);
        int readLine = scanner.nextInt();

        switch (readLine) {
            case 1:
                einzahlen();
                break;
            case 2:
                regestrieren();
                break;
            case 3:
                hauptmenue();
                break;

        }
        menueWhenLoggedin();
    }

    public void einzahlen() {
        System.out.println("Geben Sie den Betrag ein, den Sie einzahlen möchten");
        Scanner scanner = new Scanner(System.in);
        double betrag = scanner.nextDouble();
       eingeloggtesKonto.setKontostand(eingeloggtesKonto.getKontostand()+ betrag);
        System.out.println("Es wurde der folgende Betrag eingezahlt:" + betrag);
        System.out.println("Akktuleller Kontostand: " + eingeloggtesKonto.getKontostand());
    }

}
