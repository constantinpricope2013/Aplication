package com.example.pricopeconstantin.aplication;

/**
 * Created by Pricope Constantin on 6/27/2018.
 */

public class Produse {
    private static long ID;
    private static int pretProdus;

    public static long getID() {
        return ID;
    }

    public static void setID(long ID) {
        Produse.ID = ID;
    }

    private static String numeProdus;
    private static String categorieProdus;

    public static String getNumeProdus() {
        return numeProdus;
    }

    public static void setNumeProdus(String numeProdus) {
        Produse.numeProdus = numeProdus;
    }

    public static String getCategorieProdus() {
        return categorieProdus;
    }

    public static void setCategorieProdus(String categorieProdus) {
        Produse.categorieProdus = categorieProdus;
    }


    public static int getPretProdus() {
        return pretProdus;
    }

    public static void setPretProdus(int pretProdus) {
        Produse.pretProdus = pretProdus;
    }

    @Override
    public String toString() {
        return numeProdus;
    }
}

