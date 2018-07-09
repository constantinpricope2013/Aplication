package com.example.pricopeconstantin.aplication;

/**
 * Created by Pricope Constantin on 6/27/2018.
 */

public class Produse {
    private  long ID;
    private  int pretProdus;

    public  long getID() {
        return ID;
    }

    public  void setID(long ID) {
        this.ID = ID;
    }

    private  String numeProdus;
    private  String categorieProdus;

    public  String getNumeProdus() {
        return numeProdus;
    }

    public  void setNumeProdus(String numeProdus) {
        this.numeProdus = numeProdus;
    }

    public  String getCategorieProdus() {
        return categorieProdus;
    }

    public  void setCategorieProdus(String categorieProdus) {
        this.categorieProdus = categorieProdus;
    }


    public  int getPretProdus() {
        return pretProdus;
    }

    public  void setPretProdus(int pretProdus) {
        this.pretProdus = pretProdus;
    }

    @Override
    public String toString() {
        return numeProdus;
    }
}

