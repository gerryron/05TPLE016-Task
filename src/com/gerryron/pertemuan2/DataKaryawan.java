package com.gerryron.pertemuan2;

import java.util.Scanner;

public class DataKaryawan {
    public static void main(String[] args) {
        String nama, alamat;
        int usia, IP;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("### Pendataan Mahasiswa UNPAMe ###");
        System.out.print("Nama Mahasiswa: ");
        nama = keyboard.nextLine();
        System.out.print("Alamat: ");
        alamat = keyboard.nextLine();
        System.out.print("Usia: ");
        usia = keyboard.nextInt();
        System.out.print("Index Prestasi: ");
        IP = keyboard.nextInt();
        System.out.println("--------------------");
        System.out.println("Nama Mahasiswa: " + nama);
        System.out.println("Alamat: " + alamat);
        System.out.println("Usia: " + usia + " tahun");
        System.out.println("Index Prestasi: Rp " + IP);
    } }