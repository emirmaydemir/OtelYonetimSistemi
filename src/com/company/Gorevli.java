package com.company;

import java.util.ArrayList;

public interface Gorevli {
    public void checkIn(int odaNo,ArrayList<Konuk> konuklar);

    public void checkOut(ArrayList<Konuk> konuklar);
}
