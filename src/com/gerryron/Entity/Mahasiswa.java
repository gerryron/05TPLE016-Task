package com.gerryron.Entity;

public class Mahasiswa {
	
	private String nim;
	private String nama;
	private String prodi;
	
	public Mahasiswa() {
		
	}
	
	public Mahasiswa(String nim, String nama, String prodi) {
		super();
		this.nim = nim;
		this.nama = nama;
		this.prodi = prodi;
	}
	
	public String getNim() {
		return nim;
	}
	public void setNim(String nim) {
		this.nim = nim;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getProdi() {
		return prodi;
	}
	public void setProdi(String prodi) {
		this.prodi = prodi;
	}
	
}
