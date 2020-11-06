package com.gerryron.UTS.Entity;

import java.math.BigDecimal;

public class DataSupplier {
	
	private String kodeSupplier;
	private String namaSupplier;
	private String namaBarang;
	private BigDecimal banyakBarang;
	
	public DataSupplier() {
	}
	
	public DataSupplier(String kodeSupplier, String namaSupplier, String namaBarang, BigDecimal banyakBarang) {
		super();
		this.kodeSupplier = kodeSupplier;
		this.namaSupplier = namaSupplier;
		this.namaBarang = namaBarang;
		this.banyakBarang = banyakBarang;
	}

	public String getKodeSupplier() {
		return kodeSupplier;
	}

	public void setKodeSupplier(String kodeSupplier) {
		this.kodeSupplier = kodeSupplier;
	}

	public String getNamaSupplier() {
		return namaSupplier;
	}

	public void setNamaSupplier(String namaSupplier) {
		this.namaSupplier = namaSupplier;
	}

	public String getNamaBarang() {
		return namaBarang;
	}

	public void setNamaBarang(String namaBarang) {
		this.namaBarang = namaBarang;
	}

	public BigDecimal getBanyakBarang() {
		return banyakBarang;
	}

	public void setBanyakBarang(BigDecimal banyakBarang) {
		this.banyakBarang = banyakBarang;
	}

}
