package com.gerryron.pertemuan9.DiskusiKetiga;

public class Mahasiswa {

	private String nim;
	private String nama;
	private String prodi;
	private String matkul;
	private int	nilai;
	
	public Mahasiswa() {
	}
	
	public Mahasiswa(String nim, String nama, String prodi, String matkul, int nilai) {
		super();
		this.nim = nim;
		this.nama = nama;
		this.prodi = prodi;
		this.matkul = matkul;
		this.nilai = nilai;
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
	public String getMatkul() {
		return matkul;
	}
	public void setMatkul(String matkul) {
		this.matkul = matkul;
	}
	public int getNilai() {
		return nilai;
	}
	public void setNilai(int nilai) {
		this.nilai = nilai;
	}
	
}
