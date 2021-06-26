package com.company;

import java.io.Serializable;

public class Pertandingan implements Serializable {
    private String homeTeam;
    private String awayTeam;
    private int scoreHome;
    private int scoreAway;
    private String wasit;
    private String kota;
    private String stadion;
    private int tanggal;
    private int bulan;
    private int tahun;
    private int kartuKuning;
    private int kartuMerah;

    public Pertandingan(String homeTeam, String awayTeam,int scoreHome, int scoreAway ,String wasit ,String kota, String stadion, int tanggal, int bulan, int tahun, int kartuKuning, int kartuMerah){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.scoreHome = scoreHome;
        this.scoreAway = scoreAway;
        this.wasit = wasit;
        this.kota = kota;
        this. stadion = stadion;
        this.tanggal = tanggal;
        this.bulan = bulan;
        this.tahun = tahun;
        this.kartuKuning = kartuKuning;
        this.kartuMerah = kartuMerah;
    }

    //getter
    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getScoreHome() {
        return scoreHome;
    }

    public int getScoreAway() {
        return scoreAway;
    }

    public String getWasit() {
        return wasit;
    }

    public String getStadion() {
        return stadion;
    }

    public String getKota() {
        return kota;
    }

    public int getTanggal() {
        return tanggal;
    }

    public int getBulan() {
        return bulan;
    }

    public int getTahun() {
        return tahun;
    }

    public int getKartuKuning() {
        return kartuKuning;
    }

    public int getKartuMerah() {
        return kartuMerah;
    }
}