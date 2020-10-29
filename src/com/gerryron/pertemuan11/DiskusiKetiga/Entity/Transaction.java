package com.gerryron.pertemuan11.DiskusiKetiga.Entity;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
	private int idTransaction; 
	private String noJual;
	private Date tanggal;
	private String kodeBarang;
	private String namaBarang;
	private BigDecimal hargaBarang;
	private int jumlahBarang;
	private BigDecimal totalHargaBarang;
	
	public Transaction() {
	}
	
	public Transaction(String kodeBarang, String namaBarang, BigDecimal hargaBarang, int jumlahBarang,
			BigDecimal totalHargaBarang) {
		super();
		this.kodeBarang = kodeBarang;
		this.namaBarang = namaBarang;
		this.hargaBarang = hargaBarang;
		this.jumlahBarang = jumlahBarang;
		this.totalHargaBarang = totalHargaBarang;
	}

	public Transaction(int idTransaction, String noJual, Date tanggal, String kodeBarang, String namaBarang, BigDecimal hargaBarang,
			int jumlahBarang, BigDecimal totalHargaBarang) {
		super();
		this.idTransaction = idTransaction;
		this.noJual = noJual;
		this.tanggal = tanggal;
		this.kodeBarang = kodeBarang;
		this.namaBarang = namaBarang;
		this.hargaBarang = hargaBarang;
		this.jumlahBarang = jumlahBarang;
		this.totalHargaBarang = totalHargaBarang;
	}
	
	public int getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(int idTransaction) {
		this.idTransaction = idTransaction;
	}
	public String getNoJual() {
		return noJual;
	}
	public void setNoJual(String noJual) {
		this.noJual = noJual;
	}
	public Date getTanggal() {
		return tanggal;
	}
	public void setTanggal(Date tanggal) {
		this.tanggal = tanggal;
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
	public int getJumlahBarang() {
		return jumlahBarang;
	}
	public void setJumlahBarang(int jumlahBarang) {
		this.jumlahBarang = jumlahBarang;
	}
	public BigDecimal getTotalHargaBarang() {
		return totalHargaBarang;
	}
	public void setTotalHargaBarang(BigDecimal totalHargaBarang) {
		this.totalHargaBarang = totalHargaBarang;
	}
	
}
