package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int opt =0;
        //save able :
        ArrayList<Tim> tims = new ArrayList<>();
        ArrayList<Pemain> pemains = new ArrayList<>();
        ArrayList<Wasit> wasits = new ArrayList<>();
        ArrayList<Pertandingan> pertandingans = new ArrayList<>();

        String fileTims = "tims.txt";
        String filePemains = "pemains.txt";
        String fileWasits = "wasits.txt";
        String filePertansingans = "pertandingans.txt";


        System.out.println(" _______   _______   _______   _______");
        System.out.println("|   __  | |   __  | |   _   | |       |");
        System.out.println("|  |__| | |  |__| | |  |_|  | |    ___|");
        System.out.println("|   ____| |   ____| |       | |   |___ ");
        System.out.println("|  |      |  |      |   _   | |____   |");
        System.out.println("|  |      |  |      |  | |  |  ____|  |");
        System.out.println("|__|      |__|      |__| |__| |_______|");

        //load DATAA
        //load DATAA
        try {
            //teams
            ObjectInputStream inTims = new ObjectInputStream(new FileInputStream(fileTims));
            tims = (ArrayList<Tim>) inTims.readObject();
            inTims.close();

            //pemains
            ObjectInputStream inPemains = new ObjectInputStream(new FileInputStream(filePemains));
            pemains = (ArrayList<Pemain>) inPemains.readObject();
            inPemains.close();

            //wasits
            ObjectInputStream inWasits = new ObjectInputStream(new FileInputStream(fileWasits));
            wasits = (ArrayList<Wasit>) inWasits.readObject();
            inWasits.close();

            //pertandingan
            ObjectInputStream inPertandingan = new ObjectInputStream(new FileInputStream(filePertansingans));
            pertandingans = (ArrayList<Pertandingan>) inPertandingan.readObject();
            inPertandingan.close();
            System.out.println("LOAD SUCCESS\n");

        } catch(IOException ex) {
            System.out.println("NO DATA\n");
        } catch(ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

        //end save able
        Scanner read = new Scanner(System.in);
        String namaPetugas, password;

        System.out.println("   *Created By Vincentius Sutanto (2301879583), Daniel Alferian (2301885900), I Made Krishna (2301947376)");
        System.out.println("============================================================================================================\n");


        System.out.println("\nLOGIN");
        System.out.print("Nama Petugas : ");
        namaPetugas = read.nextLine();
        do{
            System.out.print("Password : ");
            password = read.next();  //Input password MUST BE "admin" or "Admin"
            if(!password.equals("admin") && !password.equals("Admin"))
                System.out.println("Password SALAH");
        }while(!password.equals("admin") && !password.equals("Admin"));
        read.nextLine();

        System.out.println("\n");
        //interface
        do{
            System.out.println("╔═╦═╦═╦═╦═╦═╗ ╔╦╦╗");
            System.out.println("║╚╣║║╔╣╔╣═╣╚╣ ║║║║");
            System.out.println("╠╗║║║╚╣╚╣═╣║║ ╠╬╬╣");
            System.out.println("╚═╩═╩═╩═╩═╩╩╝ ╚╩╩╝");
            System.out.println("+=====================+");
            System.out.println("|      MENU LIST      |");
            System.out.println("+=====================+");
            System.out.println("| 1. Input Data       |");
            System.out.println("| 2. View Data        |");
            System.out.println("| 3. Tournament Score |");
            System.out.println("| 4. Save and Exit    |");
            System.out.println("+=====================+");
            System.out.print("Choice [1-4] >> ");
            try{
                opt = read.nextInt();
            }catch (Exception e){
                System.out.print("wrong input");
                opt = 0;
            }
            String dummy=read.nextLine();

            switch (opt){
                //pendataan
                case 1 :{
                    pendataan(tims, pemains, wasits, pertandingans);
                    //pendataan
                    break;
                }
                //view data
                case 2 : {
                    viewMenu(tims, pemains, wasits, pertandingans);
                    //view data
                    break;
                }
                //standing
                case 3 : {
                    if (tims.size()>0){
                        viewStanding(tims);
                    }else System.out.println("\nNO DATA\n");
                    break;
                }
                //exit & save
                case 4 : {
                    String pilihan;
                    do{
                        System.out.print("Save Data? [ya/tidak]");
                        pilihan = read.nextLine();
                    }while (!pilihan.equals("ya") && !pilihan.equals("tidak"));
                    if (pilihan.equals("ya")){
                        saveExit(tims, pemains, wasits, pertandingans, fileTims, filePemains, fileWasits, filePertansingans);
                    }
                    // exit and save
                    break;
                }
                default : {
                    System.out.println("\nPilihan tidak ada\n");
                    break;
                }
            }
        } while (opt != 4);
    }

    //save data
    private static void saveExit(ArrayList<Tim> tims, ArrayList<Pemain> pemains, ArrayList<Wasit> wasits, ArrayList<Pertandingan> pertandingans, String fileTims, String filePemains, String fileWasits, String filePertansingans) {
        try
        {
            //Saving of object in a file
            //tims
            ObjectOutputStream outTims = new ObjectOutputStream(new FileOutputStream(fileTims));
            outTims.writeObject(tims);

            //pemain
            ObjectOutputStream outPemains = new ObjectOutputStream(new FileOutputStream(filePemains));
            outPemains.writeObject(pemains);

            //wasit
            ObjectOutputStream outWasits = new ObjectOutputStream(new FileOutputStream(fileWasits));
            outWasits.writeObject(wasits);

            //pertandingan
            ObjectOutputStream outPertandingans = new ObjectOutputStream(new FileOutputStream(filePertansingans));
            outPertandingans.writeObject(pertandingans);

            System.out.println("\nDONE SAVE");

        }
        catch(IOException ex)
        {
            System.out.println("Error SAVE DATA");
        }
    }

    //menu1
    private static void pendataan(ArrayList<Tim> tims, ArrayList<Pemain> pemains, ArrayList<Wasit> wasits, ArrayList<Pertandingan> pertandingans) {
        int opt = 0;
        Scanner read = new Scanner(System.in);

        //interface
        System.out.println();
        System.out.println("+=======================+");
        System.out.println("|       MENU INPUT      |");
        System.out.println("+=======================+");
        System.out.println("| 1. Add Tim dan Pemain |");
        System.out.println("| 2. Add Wasit          |");
        System.out.println("| 3. Add Pertandingan   |");
        System.out.println("+=======================+");
        System.out.print("Choice [1-3] >> ");

        try{
            opt = read.nextInt();
        }catch (Exception e){
            System.out.print("wrong input");
        }
        String dummy=read.nextLine();

        switch (opt){
            //input pemain
            case 1 : {
                //team dan pemain
                String namaTim,alamatTim, pelatih;
                String pilihan, namaPemain, posisi;
                int usiaPemain;

                //interface
                //nama tim
                System.out.println("\n");
                do{
                    System.out.print("Masukkan nama tim [maksimal 20 character] : ");
                    namaTim = read.nextLine();
                }while (namaTim.length()<1 || namaTim.length()>20);

                //alamat tim
                do{
                    System.out.print("Masukkan alamat tim [maksimal 20 character] : ");
                    alamatTim = read.nextLine();
                }while (alamatTim.length()<1 || alamatTim.length()>20);

                //pelatih tim
                do{
                    System.out.print("Masukkan pelatih tim [maksimal 20 character] : ");
                    pelatih = read.nextLine();
                }while (pelatih.length()<1 || pelatih.length()>20);


                //
                System.out.println("\nDATA PEMAIN");
                int counter=1;
                //pemain tim
                do{
                    //nama pemain
                    do{
                        System.out.print("Masukkan nama pemain [masksimal 20 character] : ");
                        namaPemain = read.nextLine();
                    }while (namaPemain.length()<1 || namaPemain.length()>20);

                    //usia pemain
                    do{
                        System.out.print("Masukkan usia pemain [angka]: ");
                        try{
                            usiaPemain = read.nextInt();
                        }catch (Exception e){
                            System.out.print("wrong input");
                            usiaPemain=0;
                        }
                        dummy=read.nextLine();
                    }while (usiaPemain<1);

                    //posisi pemain
                    do{
                        System.out.print("Masukkan posisi pemain pemain [masksimal 20 character] : ");
                        posisi = read.nextLine();
                    }while (posisi.length()<1 || posisi.length()>20);

                    do{
                        System.out.print("Ada tambahan pemain lagi? [ya/tidak]");
                        pilihan = read.nextLine();
                    }while (!pilihan.equals("ya") && !pilihan.equals("tidak"));

                    //add pada array <> pemain
                    pemains.add(new Pemain(namaPemain, usiaPemain, posisi, namaTim));
                    counter++;
                }while (pilihan.equals("ya"));

                //add pada array <> tim
                tims.add(new Tim(namaTim, alamatTim, pelatih));


                try {
                    System.out.println("\nTeam berhasil ditambahkan");
                    Thread.sleep(500);
                }catch (Exception e) {
                    System.out.println("Exception is caught");
                }

                for (int i=0; i<counter; i++){
                    try {
                        System.out.println("Pemain berhasil ditambahkan");
                        Thread.sleep(500);
                    } catch (Exception e) {
                        System.out.println("Exception is caught");
                    }
                }
                break;
            }
            //input wasit
            case 2 : {
                //wasit
                String namaWasit, posisiWasit;
                int usiawasit;

                //interface
                System.out.println("\n");
                do{
                    System.out.print("Masukkan nama wasit [maksimal 20 character] : ");
                    namaWasit = read.nextLine();
                }while (namaWasit.length()<1 || namaWasit.length()>20);

                do{
                    System.out.print("Masukkan usia wasit [angka]: ");
                    try{
                        usiawasit = read.nextInt();
                    }catch (Exception e){
                        System.out.print("wrong input");
                        usiawasit=0;
                    }
                    dummy=read.nextLine();
                }while (usiawasit<1);

                do{
                    System.out.print("Masukkan posisi wasit [maksimal 20 character] : ");
                    posisiWasit = read.nextLine();
                }while (posisiWasit.length()<1 || posisiWasit.length()>20);

                //add pada array<> wasit
                wasits.add(new Wasit(namaWasit, usiawasit, posisiWasit));

                System.out.println("Wasit berhasil ditambahkan\n\n");
                break;
            }
            //input pertandingan
            case 3 : {
                //menghindari pertandingan tanpa peserta dan wasit
                if (tims.size()>1 && !wasits.isEmpty()){
                    int tanggal, bulan, tahun;
                    String namaKota, stadion;
                    String homeTim, awayTim, wasit;
                    int xHometim, yAwayTim;
                    int xwasit;
                    String pilihan;

                    System.out.println("\nDATA PERTANDINGAN");
                    //nama kota
                    do{
                        System.out.print("Masukkan nama kota [maksimal 20 character] : ");
                        namaKota = read.nextLine();
                    }while (namaKota.length()<1 || namaKota.length()>20);

                    //stadion
                    do{
                        System.out.print("Masukkan nama stadion [maksimal 20 character] : ");
                        stadion = read.nextLine();
                    }while (stadion.length()<1 || stadion.length()>20);

                    //tanggal
                    do{
                        System.out.print("Masukkan tanggal pertandingan [angka| 1-31] : ");
                        try{
                            tanggal = read.nextInt();
                        }catch (Exception e){
                            System.out.print("wrong input\n");
                            tanggal=0;
                        }
                        dummy=read.nextLine();
                    }while (tanggal<1 || tanggal>31);

                    //bulan
                    do{
                        System.out.print("Masukkan bulan pertandingan [angka | 1-12] : ");
                        try{
                            bulan = read.nextInt();
                        }catch (Exception e){
                            System.out.print("wrong input\n");
                            bulan=0;
                        }
                        dummy=read.nextLine();
                    }while (bulan<1 || bulan>12);

                    //tahun
                    do{
                        System.out.print("Masukkan tahun pertandingan [angka <3000]: ");
                        try{
                            tahun = read.nextInt();
                        }catch (Exception e){
                            System.out.print("wrong input\n");
                            tahun=0;
                        }
                        dummy=read.nextLine();
                    }while (tahun<1 || tahun>3000);

                    tamplianTim(tims);
                    //memilih home team
                    do{
                        System.out.print("Masukkan pilihan HOME tim [angka nomer urut] : ");
                        try{
                            xHometim = read.nextInt();
                        }catch (Exception e){
                            System.out.print("wrong input");
                            xHometim=0;
                        }
                        dummy=read.nextLine();
                    }while (xHometim<1 || xHometim>tims.size());

                    //memilih away team
                    do{
                        System.out.print("Masukkan pilihan AWAY tim [angka nomer urut] : ");
                        try{
                            yAwayTim = read.nextInt();
                        }catch (Exception e){
                            System.out.print("wrong input");
                            yAwayTim=0;
                        }
                        dummy=read.nextLine();
                    }while (yAwayTim<1 || yAwayTim>tims.size() || yAwayTim==xHometim);
                    //
                    //get nama team dari array team
                    //
                    xHometim=xHometim-1;
                    yAwayTim=yAwayTim-1;
                    //home team
                    Tim xx  = tims.get(xHometim);
                    homeTim = xx.getNamaTim();
                    //away team
                    Tim yy = tims.get(yAwayTim);
                    awayTim = yy.getNamaTim();


                    //pemain yang sedang pelanggaran
                    for (Pemain p : pemains){
                        if (p.getTim().equals(homeTim) || p.getTim().equals(awayTim)){
                            if (p.getSanksi()>0){
                                System.out.println("Pemain dengan nama " +p.getNama() + " Sedang dalam pelanggaran dan tidak dapat bermain");
                                p.kurangSanksi();
                            }
                        }
                    }

                    //pendataan score :
                    int scoreHome, scoreAway;
                    System.out.println("\nDATA SCORE PERTANDINGAN");
                    System.out.println(homeTim + " VS " + awayTim);
                    do{
                        System.out.print("Masukkan score HOME tim : ");
                        try{
                            scoreHome = read.nextInt();
                        }catch (Exception e){
                            System.out.print("wrong input\n");
                            scoreHome=-1;
                        }
                        dummy=read.nextLine();
                    }while (scoreHome<0);

                    do{
                        System.out.print("Masukkan score AWAY tim : ");
                        try{
                            scoreAway = read.nextInt();
                        }catch (Exception e){
                            System.out.print("wrong input\n");
                            scoreAway=-1;
                        }
                        dummy=read.nextLine();
                    }while (scoreAway<0);



                    //update score team
                    for (Tim t : tims){
                        //home team update
                        if (t.getNamaTim().equals(homeTim)){
                            t.tambahPertandingan();

                            if (scoreHome>scoreAway){
                                t.tMenang();
                            } else if (scoreHome<scoreAway){
                                t.tKalah();
                            } else {
                                t.tDraw();
                            }
                        }
                        if (t.getNamaTim().equals(awayTim)){
                            t.tambahPertandingan();
                            if (scoreHome>scoreAway){
                                t.tKalah();
                            }else if (scoreHome<scoreAway){
                                t.tMenang();
                            }else {
                                t.tDraw();
                            }
                        }
                    }



                    //memilih wasit
                    tamplianWasit(wasits);
                    do{
                        System.out.print("Masukkan pilihan wasit [angka] : ");
                        try{
                            xwasit = read.nextInt();
                        }catch (Exception e){
                            System.out.print("wrong input");
                            xwasit=0;
                        }
                        dummy=read.nextLine();
                    }while (xwasit<1 || xwasit>wasits.size());

                    xwasit = xwasit-1;
                    //get nama team dari array wasit
                    Wasit xw = wasits.get(xwasit);
                    wasit = xw.getNama();


                    String timPelanggar, pilihanPelanggaran, namaPelanggar;
                    boolean namaBenar;
                    int jumlahKuning=0, jumlahMerah=0;


                    //pendataan pelanggaran
                    System.out.println("\nDATA PELANGGARAN");
                    do{
                        System.out.print("Ada pelanggaran ? [ya/tidak] : ");
                        pilihan = read.nextLine();
                    }while (!pilihan.equals("ya") && !pilihan.equals("tidak"));

                    while (pilihan.equals("ya")){
                        namaBenar = false;
                        //memilih pemain yang dapet sanksi
                        //show pemain yang teamnya bermain

                        pemainPelanggar(pemains, homeTim, awayTim);

                        do {
                            System.out.print("Masukkan nama team [sesuai team yang bermain] : ");
                            timPelanggar = read.nextLine();
                        }while (!timPelanggar.equals(homeTim) && !timPelanggar.equals(awayTim));

                        do {
                            System.out.print("Masukkan jenis pelanggaran [merah/kuning] : ");
                            pilihanPelanggaran = read.nextLine();
                        }while (!pilihanPelanggaran.equals("merah") && !pilihanPelanggaran.equals("kuning"));

                        do {
                            System.out.print("Masukkan nama pemain yang melanggar : ");
                            namaPelanggar = read.nextLine();

                            for (Pemain ppp : pemains){
                                if (ppp.getTim().equals(timPelanggar)){
                                    if (ppp.getNama().equals(namaPelanggar)){
                                        if (pilihanPelanggaran.equals("merah")){
                                            ppp.pelanggaranMerah();
                                            jumlahMerah = jumlahMerah+1;
                                        }
                                        if (pilihanPelanggaran.equals("kuning")){
                                            ppp.pelanggaranKuning();
                                            jumlahKuning = jumlahKuning+1;
                                        }
                                        namaBenar = true;
                                    }
                                }
                            }

                        }while (!namaBenar);

                        do{
                            System.out.print("Ada tambahan pelanggaran lagi? [ya/tidak] : ");
                            pilihan = read.nextLine();
                        }while (!pilihan.equals("ya") && !pilihan.equals("tidak"));
                    }

                    //array pertandingan
                    pertandingans.add(new Pertandingan(homeTim, awayTim, scoreHome, scoreAway, wasit, namaKota, stadion, tanggal, bulan, tahun, jumlahKuning, jumlahMerah));
                    //bisa
                } else {
                    System.out.println("\nMasukkan minimal 2 tim dan 1 wasit terlebih dahulu\n");
                }
                //pertandingan
                break;
            }

            default:{
                System.out.println("Pilihan tidak ada\n\n");
                break;
            }
        }
    }

    //sub menu 1
    private static void pemainPelanggar(ArrayList<Pemain> pemains, String homeTim, String awayTim) {
        System.out.println("\nDATA PEMAIN TIM");

        System.out.println("Tim : " + homeTim);
        System.out.println("+=============================================+");
        System.out.println("| Nama Pemain          | Posisi               |");
        System.out.println("+=============================================+");
        for (Pemain pp : pemains){
            if (pp.getTim().equals(homeTim)){

                System.out.printf("| %-20s | %-20s |\n", pp.getNama(), pp.getPosisi());
            }
        }
        System.out.println("+=============================================+");

        System.out.println("\nTim : " + awayTim);
        System.out.println("+=============================================+");
        System.out.println("| Nama Pemain          | Posisi               |");
        System.out.println("+=============================================+");
        for (Pemain pp : pemains){
            if (pp.getTim().equals(awayTim)){
                System.out.printf("| %-20s | %-20s |\n", pp.getNama(), pp.getPosisi());
            }
        }
        System.out.println("+=============================================+");
    }

    //menu3
    private static void viewStanding(ArrayList<Tim> tims) {
        int no =1;
        System.out.println("\n                                                 ╔═╦═╦═╦╗╔╦╦╗  ╔═╦═╦═╦╗╔╦╦╗  ╔═╦═╦═╦╗╔╦╦╗");
        System.out.println("                                                 ║╚╣║║║║║║║║║  ║╚╣║║║║║║║║║  ║╚╣║║║║║║║║║");
        System.out.println("                                                 ║║║║║╦║╚╬╬╬╣  ║║║║║╦║╚╬╬╬╣  ║║║║║╦║╚╬╬╬╣");
        System.out.println("                                                 ╚═╩═╩╩╩═╩╩╩╝  ╚═╩═╩╩╩═╩╩╩╝  ╚═╩═╩╩╩═╩╩╩╝\n");

        System.out.println("+============================================================================================================================+");
        System.out.println("| No  | Nama Tim             | Alamat               | Pelatih              | Pertandingan |Menang | Kalah  | Draw   | Poin   |");
        System.out.println("+============================================================================================================================+");

        Collections.sort(tims);
        for (Tim t : tims){
            System.out.printf( "| %-3d | %-20s | %-20s | %-20s | %-12d |%-6d | %-6d | %-6d | %-6d |\n", no,t.getNamaTim(), t.getAlamatTim(), t.getPelatih(), t.getJumlahPertandingan(),t.getMenang(), t.getKalah(), t.getDraw(), t.getPoin());
            no++;
        }
        System.out.println("+============================================================================================================================+");

        System.out.println("Press Enter key to continue...\n");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
        //menampilkan seluruh tim
    }

    //menu2
    private static void viewMenu(ArrayList<Tim> tims, ArrayList<Pemain> pemains, ArrayList<Wasit> wasits, ArrayList<Pertandingan> pertandingans) {
        int x=0;
        Scanner read = new Scanner(System.in);

        System.out.println("\n+===========================+");
        System.out.println("|         MENU VIEW         |");
        System.out.println("+===========================+");
        System.out.println("| 1. View Data Tim          |");
        System.out.println("| 2. View Data Pemain       |");
        System.out.println("| 3. View Data Wasit        |");
        System.out.println("| 4. View Data Pertandingan |");
        System.out.println("+===========================+");
        System.out.print("Choice [1-3] >> ");

        try{
            x = read.nextInt();
        }catch (Exception e){
            System.out.print("wrong input");
            x = 0;
        }
        String dummy=read.nextLine();

        switch (x){
            case 1 : {
                if (tims.size()>0){
                    tamplianTim(tims);
                    System.out.println("Press Enter key to continue...\n");
                    try
                    {
                        System.in.read();
                    }
                    catch(Exception e)
                    {}
                }else System.out.println("\n[ There is No Team Registered ]\n");
                break;
            }

            case 2 : {
                if (pemains.size()>0){
                    tampilanPemain(pemains);
                    System.out.println("Press Enter key to continue...\n");
                    try
                    {
                        System.in.read();
                    }
                    catch(Exception e)
                    {}
                }else System.out.println("\n[ There is No Player Registered ]\n");
                break;
            }

            case 3 : {
                if (wasits.size()>0){
                    tamplianWasit(wasits);
                    System.out.println("Press Enter key to continue...\n");
                    try
                    {
                        System.in.read();
                    }
                    catch(Exception e)
                    {}
                }else System.out.println("\n[ There is No Referee Registered ]\n");
                break;
            }

            case 4 : {
                if (pertandingans.size()>0){
                    tampilanPertandingan(pertandingans);
                    System.out.println("Press Enter key to continue...\n");
                    try
                    {
                        System.in.read();
                    }
                    catch(Exception e)
                    {}
                }else System.out.println("\n[ There is No Game Registered ]\n");
                break;
            }

            default:{
                System.out.println("\nPilihan tidak ada\n");
                break;
            }
        }
        
    }

    //sub menu 2
    private static void tampilanPertandingan(ArrayList<Pertandingan> pertandingans) {
        int no =1;
        System.out.println("\nDATA PERTANDINGAN");

        for (Pertandingan p : pertandingans){
            System.out.println("\nPertandingan KE " + no);
            System.out.println("HOME                       VS                       AWAY");
            System.out.printf("%-20s | %-3d VS %3d | %20s\n\n", p.getHomeTeam(), p.getScoreHome(), p.getScoreAway(), p.getAwayTeam());
            System.out.println("| Wasit                | Stadion              | Kota                 | tgl-bln-thn    | Kuning | Merah  |");
            System.out.println("+=======================================================================================================+");
            System.out.printf("| %-20s | %-20s | %-20s | %-2d - %-2d - %-4d | %-6d | %-6d |\n\n", p.getWasit(), p.getStadion(), p.getKota(), p.getTanggal(), p.getBulan(), p.getTahun(), p.getKartuKuning(), p.getKartuMerah());
            no++;
        }
    }

    //sub menu 2
    private static void tampilanPemain(ArrayList<Pemain> pemains) {
        int no =1;
        System.out.println("\nDATA PEMAIN\n");
        System.out.println("+===================================================================================================+");
        System.out.println("| No  | Nama Pemain          | Usia | Posisi               | Kuning | Merah  | Tim                  |");
        System.out.println("+===================================================================================================+");

        for (Pemain p : pemains){
            System.out.printf( "| %-3d | %-20s | %-4d | %-20s | %-6d | %-6d | %-20s |\n", no,p.getNama(), p.getUsia(), p.getPosisi(), p.getKartuKuning(), p.getKartuMerah(), p.getTim());
            no++;
        }
        System.out.println("+===================================================================================================+");
    }

    //sub menu 2
    private static void tamplianTim(ArrayList<Tim> tims) {
        int no =1;
        System.out.println("\nDATA TIM\n");

        System.out.println("+==========================================================================+");
        System.out.println("| No  | Nama Tim             | Alamat               | Pelatih              |");
        System.out.println("+==========================================================================+");

        for (Tim t : tims){
            System.out.printf( "| %-3d | %-20s | %-20s | %-20s |\n", no,t.getNamaTim(), t.getAlamatTim(), t.getPelatih());
            no++;
        }
        System.out.println("+==========================================================================+");
    }

    //sub menu 2
    private static void tamplianWasit(ArrayList<Wasit> wasits) {
        int no =1;
        System.out.println("\nDATA WASIT\n");
        System.out.println("+==========================================================+");
        System.out.println("| No  | Nama Wasit           | Usia | Posisi               |");
        System.out.println("+==========================================================+");

        for (Wasit w : wasits){
                System.out.printf("| %-3d | %-20s | %-4d | %-20s |\n", no,w.getNama(), w.getUsia(), w.getPosisi());
                no++;
        }
        System.out.println("+==========================================================+");
        //menampilkan seluruh wasit
    }

}