package com.gerryron.pertemuan11.DiskusiKetiga.Entity;

import java.math.BigDecimal;

public class Product {

	private int idProduct;
	private String kodeBarang;
	private String namaBarang;
	private BigDecimal hargaBarang;
	
	public Product() {
	}
	
	public Product(int idProduct, String kodeBarang, String namaBarang, BigDecimal hargaBarang) {
		super();
		this.idProduct = idProduct;
		this.kodeBarang = kodeBarang;
		this.namaBarang = namaBarang;
		this.hargaBarang = hargaBarang;
	}
	
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
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
	public BigDecimal getHargaBarang() {
		return hargaBarang;
	}
	public void setHargaBarang(BigDecimal hargaBarang) {
		this.hargaBarang = hargaBarang;
	}
	
}
