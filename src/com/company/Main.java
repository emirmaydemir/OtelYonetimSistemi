package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.Odalar.*;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner input=new Scanner(System.in);
        ArrayList<Odalar>konuk=new ArrayList<>();
        ArrayList<Konuk>konuklar=new ArrayList<>();
        ArrayList<Odalar>gorevli=new ArrayList<>();
        int odaNo,girisTuru,gun,secim;
        String iptal;
        int devam=1;
        while (devam!=0){
            System.out.println(" Müşteri girişi için 1 //// Resepsiyon görevlisi girişi için 2'yi //// Rezervasyon iptali için 3'ü tuşlayınız \n");
            girisTuru=input.nextInt();
            switch (girisTuru){
                case 1:
                    System.out.println("Oda numarası giriniz 1-100 arasında");
                    odaNo=input.nextInt();
                        if(oda[odaNo]){
                            System.out.println("Bu oda doludur");}
                        else {
                              rezervasyonYap(odaNo,konuklar);
                             }
                    break;
                    //////////////////////////////////////////////////////////////////////////////

                case 2:
                    System.out.println("Müşteri rezervasyonu için (1) // Müşteri rezervasyon iptali için (2) // check in (rezervasyonsuz kayıt) için (3) // check out (otelde kalan süreyi uzatma) için (4)  // yeni bir resepsiyon görevlisini işe almak için (5) rakamını giriniz");
                    secim=input.nextInt();
                    switch (secim){
                        case 1:
                            System.out.println("Rezervasyon yapmak istediğiniz müşterinin oda numarası giriniz [1-100] arasında");
                            odaNo=input.nextInt();
                            if(oda[odaNo]){
                                System.out.println("Bu oda doludur");}
                            else {
                                rezervasyonYap(odaNo,konuklar);
                            }
                            break;
                        case 2:
                            rezervasyonIptal(konuklar);
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            gorevli.add(new ResepsiyonGorevlisi());
                            break;
                    }
                    break;
                //////////////////////////////////////////////////////////////////////////////
                case 3:
                    rezervasyonIptal(konuklar);
                    break;
            }
            System.out.println("Çıkış için 0'ı devam etmek için 1'i tuşlayınız");
            devam=input.nextInt();
        }


        for (Konuk k:konuklar)
            System.out.println("Musteri oda numarası " + k.getOdaNo() + " Musteri adi: " + k.getAd() + " Musteri soyadi: " + k.getSoyAd() + " Musteri TC: " + k.getTC() + " Musteri telefon numarası " + k.getTel());
    }
}
