package de.swm;

import java.security.SecureRandom;

public class Konto {
    private String kontoinhaber;
    private String IBAN;
    private double kontostand;
    private String bankPIN;

    public Konto(String kontoinhaber, String IBAN, double kontostand, String bankPIN) {
        this.kontoinhaber = kontoinhaber;
        this.IBAN = IBAN;
        this.kontostand = kontostand;
        this.bankPIN = bankPIN;
    }


    public boolean istAuthtifiziert(String bankPIN) {
        if(this.bankPIN.equals(bankPIN)) {
          return true;
        }
        return false;


    }
    public String getKontoinhaber() {
        return kontoinhaber;
    }
    public String getIBAN() {
        return IBAN;
    }
    public double getKontostand() {
        return kontostand;
    }

    public static String randomString(int len){
        String AB = "0123456789";
        StringBuilder sb = new StringBuilder(len);
        for(int i = 0; i < len; i++)
            sb.append(AB.charAt(new SecureRandom().nextInt(AB.length())));
        return sb.toString();
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }1



}
