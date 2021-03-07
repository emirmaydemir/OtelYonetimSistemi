package com.company;

import java.util.Scanner;

public class ResepsiyonGorevlisi extends Odalar implements Gorevli{
    private String ad;
    private String soyAd;
    Scanner input=new Scanner(System.in);

    public ResepsiyonGorevlisi(){
        System.out.println("Görevli adini giriniz");
        this.ad=input.nextLine();
        System.out.println("Görevli soyadini giriniz");
        this.soyAd=input.nextLine();
    }
    @Override
    public void checkIn() {

    }

    @Override
    public void checkOut() {

    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyAd() {
        return soyAd;
    }

    public void setSoyAd(String soyAd) {
        this.soyAd = soyAd;
    }
}
