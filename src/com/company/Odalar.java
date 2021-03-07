package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Odalar {
    public static boolean [] oda=new boolean[100];

    public static void rezervasyonYap(int odaNo, ArrayList<Konuk> konuklar){
        Scanner input=new Scanner(System.in);
        System.out.println("Otelde konaklanacak gün sayısını giriniz");
        int gun=input.nextInt();
        konuklar.add(new Konuk(odaNo,gun));
        oda[odaNo]=true;
        System.out.println("İşlem başarılı");
    }

    public  static void rezervasyonIptal(ArrayList<Konuk> konuklar) throws CloneNotSupportedException {
        Scanner input2=new Scanner(System.in);
        System.out.println("İptal edilecek musteri TC giriniz");
        String iptal=input2.nextLine();
        int sayac=0;
        for(Konuk ko:(ArrayList<Konuk>)konuklar.clone()){
            if(ko.getTC().equals(iptal)){
                konuklar.remove(ko);
                oda[ko.getOdaNo()]=false;
                System.out.println("işlem başarılı");
                sayac=1;
            }
        }
        if(sayac!=1){
            System.out.println("Böyle bir TC bulunmamaktadır");
        }
    }
}
