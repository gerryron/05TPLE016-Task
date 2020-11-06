package com.gerryron.UTS.Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class DataPenjualan {

	private String kodeBarang;
	private Timestamp tanggal;
	private BigDecimal totalBayar;
	private BigDecimal bayar;
	private BigDecimal jumlahBeli;
	private BigDecimal potongan;
	
	public DataPenjualan() {
	}
	
	public DataPenjualan(String kodeBarang, Timestamp tanggal, BigDecimal totalBayar, BigDecimal bayar,
			BigDecimal jumlahBeli, BigDecimal potongan) {
		super();
		this.kodeBarang = kodeBarang;
		this.tanggal = tanggal;
		this.totalBayar = totalBayar;
		this.bayar = bayar;
		this.jumlahBeli = jumlahBeli;
		this.potongan = potongan;
	}

	public String getKodeBarang() {
		return kodeBarang;
	}

	public void setKodeBarang(String kodeBarang) {
		this.kodeBarang = kodeBarang;
	}

	public Timestamp getTanggal() {
		return tanggal;
	}

	public void setTanggal(Timestamp tanggal) {
		this.tanggal = tanggal;
	}

	public BigDecimal getTotalBayar() {
		return totalBayar;
	}

	public void setTotalBayar(BigDecimal totalBayar) {
		this.totalBayar = totalBayar;
	}

	public BigDecimal getBayar() {
		return bayar;
	}

	public void setBayar(BigDecimal bayar) {
		this.bayar = bayar;
	}

	public BigDecimal getJumlahBeli() {
		return jumlahBeli;
	}

	public void setJumlahBeli(BigDecimal jumlahBeli) {
		this.jumlahBeli = jumlahBeli;
	}

	public BigDecimal getPotongan() {
		return potongan;
	}

	public void setPotongan(BigDecimal potongan) {
		this.potongan = potongan;
	}
	
}
