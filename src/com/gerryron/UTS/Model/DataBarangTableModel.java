package com.gerryron.UTS.Model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.gerryron.UTS.Entity.DataBarang;

public class DataBarangTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private static final int KODE_BARANG = 0;
	private static final int NAMA_BARANG = 1;
	private static final int JENIS_BARANG = 2;
	private static final int JUMLAH = 3;
	private static final int PEMBELIAN = 4;
	private static final int PENJUALAN = 5;
	
	private String[] columnNames = {"Kode Barang", "Nama Barang", "Jenis", "Jumlah", "Pembelian", "Penjualan"};
	private List<DataBarang> listBarang;
	
	public DataBarangTableModel(List<DataBarang> listBarang) {
		this.listBarang = listBarang;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() {
		return listBarang.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		DataBarang dataBarang = listBarang.get(row);

		switch (col) {
		case KODE_BARANG:
			return dataBarang.getKodeBarang();
		case NAMA_BARANG:
			return dataBarang.getNamaBarang();
		case JENIS_BARANG:
			return dataBarang.getJenisBarang();
		case JUMLAH:
			return dataBarang.getJumlah();
		case PEMBELIAN:
			return dataBarang.getPembelian();
		case PENJUALAN:
			return dataBarang.getPenjualan();
		default:
			return dataBarang.getKodeBarang();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
}
