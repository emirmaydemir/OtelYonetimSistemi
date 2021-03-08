package com.company;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.company.Odalar.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Scanner input = new Scanner(System.in);
        ArrayList<Odalar> konuk = new ArrayList<>();
        ArrayList<Konuk> konuklar = new ArrayList<>();
        ArrayList<Odalar> gorevli = new ArrayList<>();
        ResepsiyonGorevlisi resepsiyonGorevlisi = new ResepsiyonGorevlisi(1);
        int odaNo, girisTuru, gun, secim;
        String iptal;
        int devam = 1;
        System.out.println("Sayın konuklarımız rezervasyon ile yapılan kayıtlarda otel ücretimiz 50TL dir check in ile yapılan otel kayıtlanmalarında ödenecek tutar ise resepsiyon görevlisi tarafından belirlenmektedir. \n");
        while (devam != 0) {
            System.out.println(" Müşteri girişi için 1 //// Resepsiyon görevlisi girişi için 2'yi //// Rezervasyon iptali için 3'ü tuşlayınız ");
            girisTuru = input.nextInt();
            switch (girisTuru) {
                case 1:
                    System.out.println("Oda numarası giriniz 1-100 arasında");
                    odaNo = input.nextInt();
                    if (oda[odaNo]) {
                        System.out.println("Bu oda doludur");
                    } else {
                        rezervasyonYap(odaNo, konuklar);
                    }
                    break;
                //////////////////////////////////////////////////////////////////////////////
                case 2:
                    System.out.println("Müşteri rezervasyonu için (1) // Müşteri rezervasyon iptali için (2) // check in (rezervasyonsuz kayıt) için (3) // check out (otelde kalan süreyi uzatma) için (4)  // yeni bir resepsiyon görevlisini işe almak için (5) rakamını giriniz");
                    secim = input.nextInt();
                    switch (secim) {
                        case 1:
                            System.out.println("Rezervasyon yapmak istediğiniz müşterinin oda numarası giriniz [1-100] arasında");
                            odaNo = input.nextInt();
                            if (oda[odaNo]) {
                                System.out.println("Bu oda doludur");
                            } else {
                                rezervasyonYap(odaNo, konuklar);
                            }
                            break;
                        case 2:
                            rezervasyonIptal(konuklar);
                            break;
                        case 3:
                            System.out.println("Rezervasyonsuz kayıt yapmak istediğiniz müşterinin oda numarası giriniz [1-100] arasında");
                            int odaNo2 = input.nextInt();
                            if (oda[odaNo2]) {
                                System.out.println("Bu oda doludur");
                            } else {
                                resepsiyonGorevlisi.checkIn(odaNo2, konuklar);
                            }
                            break;
                        case 4:
                            resepsiyonGorevlisi.checkOut(konuklar);
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
            devam = input.nextInt();
        }
        for (Konuk k : konuklar)
            System.out.println("Musteri oda numarası " + k.getOdaNo() + " Musteri adi: " + k.getAd() + " Musteri soyadi: " + k.getSoyAd() + " Musteri TC: " + k.getTC() + " Musteri telefon numarası " + k.getTel() + " Musterinin kalacagi gün sayısı " + k.getKalicanakGun() + " Musterinin ödediği tutar " + k.getOdenecekTutar());

        BufferedWriter bWriter = null;
        try {
            File file = new File("Musteriler.txt");
            Desktop d = Desktop.getDesktop();
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                }
            }
            try {
                bWriter = new BufferedWriter(new FileWriter(file, false));
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bWriter.write(" Ad" + "  " + " Soyad" + "  " + " TC" + "  " + " No" + "  " + " Gün" + "  " + " Oda" + "  " + " OdenecekTutar" + "\n" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < konuklar.size(); i++) {
                String ad = konuklar.get(i).getAd();
                String soyad = konuklar.get(i).getSoyAd();
                int roomNo = konuklar.get(i).getOdaNo();
                String tc = konuklar.get(i).getTC();
                int day = konuklar.get(i).getKalicanakGun();
                int fiyat = konuklar.get(i).getOdenecekTutar();
                String tel = konuklar.get(i).getTel();
                bWriter.write(ad + " - " + soyad + " - " + tc + " - " + tel + " - " + day + " - " + roomNo + " - " + fiyat + "\n");
            }
            try {
                d.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
        } finally {
            try {
                bWriter.close();
            } catch (IOException ex) {

            }
        }
    }
}
