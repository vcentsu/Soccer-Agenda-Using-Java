package com.company;

import java.io.Serializable;

public class Manusia implements Serializable {

    private String nama;
    private int usia;

    public Manusia(String nama, int usia) {
        this.nama = nama;
        this.usia = usia;
    }

    //getter
    public String getNama() {
        return nama;
    }

    public int getUsia() {
        return usia;
    }
}