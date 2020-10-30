package com.gerryron.pertemuan11.DiskusiKeempat;

public class DataPegawai {

	private int idPegawai;
	private String namaPegawai;
	private char jenisKelamin;
	
	public DataPegawai() {
	}
	
	public DataPegawai(int idPegawai, String namaPegawai, char jenisKelamin) {
		super();
		this.idPegawai = idPegawai;
		this.namaPegawai = namaPegawai;
		this.jenisKelamin = jenisKelamin;
	}

	public int getIdPegawai() {
		return idPegawai;
	}

	public void setIdPegawai(int idPegawai) {
		this.idPegawai = idPegawai;
	}

	public String getNamaPegawai() {
		return namaPegawai;
	}

	public void setNamaPegawai(String namaPegawai) {
		this.namaPegawai = namaPegawai;
	}

	public char getJenisKelamin() {
		return jenisKelamin;
	}

	public void setJenisKelamin(char jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	
}
