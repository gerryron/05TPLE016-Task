package com.gerryron.UTS.Model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class TransaksiPenjualanTableModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4056554955671012456L;
	private static final int NOTA = 0;
	private static final int KODE = 1;
	private static final int BARANG = 2;
	private static final int JENIS = 3;
	private static final int HARGA = 4;
	private static final int JUMLAH = 5;
	private static final int POTONGAN = 6;
	private static final int TOTAL= 7;
	
	private String[] columnNames = {"Nota", "Kode", "Barang", "Jenis", "Harga", "Jumlah", "Potongan", "Total"};
	private List<TransaksiPenjualan> listTransaksi;
	
	public TransaksiPenjualanTableModel(List<TransaksiPenjualan> listTransaksi) {
		this.listTransaksi = listTransaksi;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() {
		return listTransaksi.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		TransaksiPenjualan dataTransaksi = listTransaksi.get(row);

		switch (col) {
		case NOTA:
			return dataTransaksi.getNota();
		case KODE:
			return dataTransaksi.getKodeBarang();
		case BARANG:
			return dataTransaksi.getNamaBarang();
		case JENIS:
			return dataTransaksi.getJenisBarang();
		case HARGA:
			return dataTransaksi.getHargaBarang();
		case JUMLAH:
			return dataTransaksi.getJumlahBarang();
		case POTONGAN:
			return dataTransaksi.getPotongan();
		case TOTAL:
			return dataTransaksi.getTotal();
		default:
			return dataTransaksi.getNota();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
}
