package com.gerryron.pertemuan9.DiskusiKeempat;

public class Barang {

	private int idBarang;
	private String kategori;
	private String namaBarang;
	
	public Barang() {
	}
	
	public Barang(int idBarang, String kategori, String namaBarang) {
		super();
		this.idBarang = idBarang;
		this.kategori = kategori;
		this.namaBarang = namaBarang;
	}

	public int getIdBarang() {
		return idBarang;
	}

	public void setIdBarang(int idBarang) {
		this.idBarang = idBarang;
	}

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	public String getNamaBarang() {
		return namaBarang;
	}

	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}
	
}
