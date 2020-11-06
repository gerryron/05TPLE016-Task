package com.gerryron.UTS.Model;

import java.math.BigDecimal;

public class TransaksiPenjualan {

	private String nota;
	private String kodeBarang;
	private String namaBarang;
	private String jenisBarang;
	private BigDecimal hargaBarang;
	private BigDecimal jumlahBarang;
	private BigDecimal potongan;
	private BigDecimal total;
	
	public TransaksiPenjualan() {
	}
	
	public TransaksiPenjualan(String nota, String kodeBarang, String namaBarang, String jenisBarang,
			BigDecimal hargaBarang, BigDecimal jumlahBarang, BigDecimal potongan, BigDecimal total) {
		super();
		this.nota = nota;
		this.kodeBarang = kodeBarang;
		this.namaBarang = namaBarang;
		this.jenisBarang = jenisBarang;
		this.hargaBarang = hargaBarang;
		this.jumlahBarang = jumlahBarang;
		this.potongan = potongan;
		this.total = total;
	}
	
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
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
	public BigDecimal getHargaBarang() {
		return hargaBarang;
	}
	public void setHargaBarang(BigDecimal hargaBarang) {
		this.hargaBarang = hargaBarang;
	}
	public BigDecimal getJumlahBarang() {
		return jumlahBarang;
	}
	public void setJumlahBarang(BigDecimal jumlahBarang) {
		this.jumlahBarang = jumlahBarang;
	}
	public BigDecimal getPotongan() {
		return potongan;
	}
	public void setPotongan(BigDecimal potongan) {
		this.potongan = potongan;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}	
	
}
