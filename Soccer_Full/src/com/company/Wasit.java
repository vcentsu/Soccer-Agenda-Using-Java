package com.company;


public class Wasit extends Manusia {

    private String posisi;

    public Wasit(String nama, int usia, String posisi) {
        super(nama, usia);
        this.posisi = posisi;
    }

    //getter
    @Override
    public String getNama() {
        return super.getNama();
    }

    @Override
    public int getUsia() {
        return super.getUsia();
    }

    public String getPosisi() {
        return posisi;
    }
}