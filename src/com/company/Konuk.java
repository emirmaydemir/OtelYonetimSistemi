package com.company;

import java.util.Scanner;

public class Konuk extends Odalar{
    private String ad;
    private String soyAd;
    private String TC;
    private String tel;
    private int kalicanakGun;
    private int odaNo;
    Scanner input=new Scanner(System.in);

    public Konuk(int odaNo,int kalicanakGun){
        System.out.println("Musteri adini giriniz");
        this.ad=input.nextLine();
        System.out.println("Musteri soyadini giriniz");
        this.soyAd=input.nextLine();
        System.out.println("Musteri Tc giriniz");
        this.TC=input.nextLine();
        System.out.println("Musteri telefon numarasini giriniz");
        this.tel=input.nextLine();
        this.odaNo=odaNo;
        this.kalicanakGun=kalicanakGun;
    }
    public Konuk(){

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

    public String getTC() {
        return TC;
    }

    public void setTC(String TC) {
        this.TC = TC;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getOdaNo() {
        return odaNo;
    }

    public void setOdaNo(int odaNo) {
        this.odaNo = odaNo;
    }

    public int getKalicanakGun() {
        return kalicanakGun;
    }

    public void setKalicanakGun(int kalicanakGun) {
        this.kalicanakGun = kalicanakGun;
    }
}
