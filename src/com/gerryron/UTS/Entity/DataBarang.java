package com.gerryron.UTS.Entity;

import java.math.BigDecimal;

public class DataBarang {

	private String kodeBarang;
	private String namaBarang;
	private String jenisBarang;
	private BigDecimal jumlah;
	private BigDecimal pembelian;
	private BigDecimal penjualan;
	
	public DataBarang() {
	}
	
	public DataBarang(String kodeBarang, String namaBarang, String jenisBarang, BigDecimal jumlah, BigDecimal pembelian,
			BigDecimal penjualan) {
		super();
		this.kodeBarang = kodeBarang;
		this.namaBarang = namaBarang;
		this.jenisBarang = jenisBarang;
		this.jumlah = jumlah;
		this.pembelian = pembelian;
		this.penjualan = penjualan;
	}

	public String getKodeBarang() {
		return kodeBarang;
	}

	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}

	public String getNamaBarang() {
		return namaBarang;
	}

	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}

	public String getJenisBarang() {
		return jenisBarang;
	}

	public void setJenisBarang(String jenisBarang) {
		this.jenisBarang = jenisBarang;
	}

	public BigDecimal getJumlah() {
		return jumlah;
	}

	public void setJumlah(BigDecimal jumlah) {
		this.jumlah = jumlah;
	}

	public BigDecimal getPembelian() {
		return pembelian;
	}

	public void setPembelian(BigDecimal pembelian) {
		this.pembelian = pembelian;
	}

	public BigDecimal getPenjualan() {
		return penjualan;
	}

	public void setPenjualan(BigDecimal penjualan) {
		this.penjualan = penjualan;
	}
	
}
