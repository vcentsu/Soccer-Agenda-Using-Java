package com.company;


public class Pemain extends Manusia implements PelanggaranPemain{

    private String tim;
    private String posisi;
    private int kartuKuning;
    private int kartuMerah;
    int sanksi=0;

    public Pemain(String nama, int usia, String posisi, String tim) {
        super(nama, usia);
        this.posisi = posisi;
        this.tim = tim;
    }

    //getter
    @Override
    public String getNama() {
        return super.getNama();
    }

    public String getPosisi() {
        return posisi;
    }

    public String getTim() {
        return tim;
    }

    @Override
    public int getUsia() {
        return super.getUsia();
    }

    public int getKartuKuning() {
        return kartuKuning;
    }

    public int getKartuMerah() {
        return kartuMerah;
    }

    public int getSanksi() {
        return sanksi;
    }

    //method
    public void kurangSanksi(){
        sanksi = sanksi -1;
    }

    //Interface pelanggaran untuk menjelaskan pelanggaran
    @Override
    public void pelanggaranMerah() {
        sanksi= sanksi+2;
        kartuMerah = kartuMerah+1;
    }

    @Override
    public void pelanggaranKuning() {
        sanksi = sanksi+1;
        kartuKuning = kartuKuning+1;
    }
}