package com.company;


import java.io.Serializable;

public class Tim implements Comparable<Tim>, Serializable {

    private String namaTim;
    private String alamatTim;
    private String pelatih;
    private int poin =0;
    private int menang;
    private int kalah;
    private int draw;
    private int jumlahPertandingan= 0;

    public Tim(String namaTim, String alamatTim, String pelatih) {
        this.namaTim = namaTim;
        this.alamatTim = alamatTim;
        this.pelatih = pelatih;
    }

    // method

    public void tMenang(){
        poin = poin+2;
        menang = menang+1;
    }

    public void tKalah(){
        kalah = kalah+1;
    }

    public void tDraw(){
        poin = poin+1;
        draw = draw+1;
    }

    public void tambahPertandingan(){
        jumlahPertandingan = jumlahPertandingan+1;
    }
    //setter

    //compare
    @Override
    public int compareTo(Tim o) {
        return o.poin - this.poin;
    }


    //getter

    public String getNamaTim() {
        return namaTim;
    }

    public String getAlamatTim() {
        return alamatTim;
    }

    public String getPelatih() {
        return pelatih;
    }

    public int getPoin() {
        return poin;
    }

    public int getMenang() {
        return menang;
    }

    public int getKalah() {
        return kalah;
    }

    public int getDraw() {
        return draw;
    }

    public int getJumlahPertandingan() {
        return jumlahPertandingan;
    }
}
