package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ResepsiyonGorevlisi extends Odalar implements Gorevli{
    private String ad;
    private String soyAd;
    Scanner input=new Scanner(System.in);
    Scanner input2=new Scanner(System.in);

    public ResepsiyonGorevlisi(){
        System.out.println("Görevli adini giriniz");
        this.ad=input.nextLine();
        System.out.println("Görevli soyadini giriniz");
        this.soyAd=input.nextLine();
    }
    public ResepsiyonGorevlisi(int a){

    }
    @Override
    public void checkIn(int odaNo,ArrayList<Konuk> konuklar) {
        System.out.println("Resepsiyona gelen müşterinin ödediği tutarı giriniz");
        int odenecekTutar=input.nextInt();
        System.out.println("Resepsiyona gelen müşterinin adını giriniz");
        String ad=input2.nextLine();
        System.out.println("Resepsiyona gelen müşterinin soyadını giriniz");
        String soyAd=input2.nextLine();
        System.out.println("Resepsiyona gelen müşterinin TC sini giriniz");
        String TC=input2.nextLine();
        System.out.println("Resepsiyona gelen müşterinin telefon numarasını giriniz");
        String tel=input2.nextLine();
        System.out.println("Resepsiyona gelen müşterinin kalacağı gün sayısını giriniz");
        int kalınacakGun=input2.nextInt();
        int oda=odaNo;
        konuklar.add(new Konuk(ad,soyAd,TC,tel,kalınacakGun,oda,odenecekTutar));
    }

    @Override
    public void checkOut(ArrayList<Konuk> konuklar) {
        System.out.println("Otelde kalma süresini uzatacağınız müşterinin TC sini giriniz");
        String TC=input.nextLine();
        int sayac=0;
        for(Konuk ko:(ArrayList<Konuk>)konuklar.clone()){
            if(ko.getTC().equals(TC)){
                System.out.println("Uzatacağınız gün sayısını giriniz");
                int gun=input.nextInt();
                ko.setKalicanakGun(ko.getKalicanakGun()+gun);
                System.out.println("işlem başarılı "+ko.getAd()+" "+ko.getSoyAd()+" adlı kişinin otelde duracağı gün sayısı "+ko.getKalicanakGun());
                sayac=1;
            }
        }
        if(sayac!=1){
            System.out.println("Böyle bir TC bulunmamaktadır");
        }
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
