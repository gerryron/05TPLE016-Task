package com.gerryron.Entity;

public class Pertemuan11Mahasiswa {
	private String nim;
	private String nama;
	private String prodi;
	private float indexPrestasi;
	private String email;
	private String telp;
	
	public Pertemuan11Mahasiswa () {
			
	}
	
	public Pertemuan11Mahasiswa(String nim, String nama, String prodi, float indexPrestasi, String email, String telp) {
		super();
		this.nim = nim;
		this.nama = nama;
		this.prodi = prodi;
		this.indexPrestasi = indexPrestasi;
		this.email = email;
		this.telp = telp;
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
	public float getIndexPrestasi() {
		return indexPrestasi;
	}
	public void setIndexPrestasi(float indexPrestasi) {
		this.indexPrestasi = indexPrestasi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelp() {
		return telp;
	}
	public void setTelp(String telp) {
		this.telp = telp;
	}
}
