package com.gerryron.pertemuan2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ContohBufferReader {
	
    public static void main(String[] args) throws IOException {
        String nama;
        InputStreamReader isr = new InputStreamReader(System.in);
       BufferedReader br = new BufferedReader(isr);
        System.out.print("Inputkan nama: ");
        nama = br.readLine();
        System.out.println("Nama kamu adalah " + nama);
    }
}