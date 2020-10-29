package com.gerryron.pertemuan9.DiskusiKedua.Entity;

import java.math.BigDecimal;

public class Karyawan {
	
	private String nik;
	private String namaKaryawan;
	private String jenisKelamin;
	private String jabatan;
	private BigDecimal gajiPokok;
	private Short jamLembur;
	private BigDecimal upahLembur;
	private BigDecimal totalGaji;
	
	public Karyawan() {
	}
	
	public Karyawan(String nik, String namaKaryawan, String jenisKelamin, String jabatan, BigDecimal gajiPokok,
			Short jamLembur, BigDecimal upahLembur, BigDecimal totalGaji) {
		super();
		this.nik = nik;
		this.namaKaryawan = namaKaryawan;
		this.jenisKelamin = jenisKelamin;
		this.jabatan = jabatan;
		this.gajiPokok = gajiPokok;
		this.jamLembur = jamLembur;
		this.upahLembur = upahLembur;
		this.totalGaji = totalGaji;
	}

	public String getNik() {
		return nik;
	}
	public void setNik(String nik) {
		this.nik = nik;
	}
	public String getNamaKaryawan() {
		return namaKaryawan;
	}
	public void setNamaKaryawan(String namaKaryawan) {
		this.namaKaryawan = namaKaryawan;
	}
	public String getJenisKelamin() {
		return jenisKelamin;
	}
	public void setJenisKelamin(String jenisKelamin) {
		this.jenisKelamin = jenisKelamin;
	}
	public String getJabatan() {
		return jabatan;
	}
	public void setJabatan(String jabatan) {
		this.jabatan = jabatan;
	}
	public BigDecimal getGajiPokok() {
		return gajiPokok;
	}
	public void setGajiPokok(BigDecimal gajiPokok) {
		this.gajiPokok = gajiPokok;
	}
	public Short getJamLembur() {
		return jamLembur;
	}
	public void setJamLembur(Short jamLembur) {
		this.jamLembur = jamLembur;
	}
	public BigDecimal getUpahLembur() {
		return upahLembur;
	}
	public void setUpahLembur(BigDecimal upahLembur) {
		this.upahLembur = upahLembur;
	}
	public BigDecimal getTotalGaji() {
		return totalGaji;
	}
	public void setTotalGaji(BigDecimal totalGaji) {
		this.totalGaji = totalGaji;
	}

}
