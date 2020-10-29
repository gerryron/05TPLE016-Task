package com.gerryron.pertemuan11.DiskusiKetiga.Model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.gerryron.pertemuan11.DiskusiKetiga.Entity.Transaction;

public class TransaksiPenjualanTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int KD_BARANG = 0;
	private static final int NAMA_BARANG = 1;
	private static final int HARGA_BARANG = 2;
	private static final int JUMLAH = 3;
	private static final int TOTAL = 4;
	
	private String[] columnNames = { "Kd Barang", "Nama Barang", "Harga Barang", "Jumlah", "Total"};
	private List<Transaction> listPenjualan;
	
	public TransaksiPenjualanTableModel(List<Transaction> listPenjualan) {
		this.listPenjualan = listPenjualan;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() {
		return listPenjualan.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		Transaction transaksiPenjualan = listPenjualan.get(row);

		switch (col) {
		case KD_BARANG:
			return transaksiPenjualan.getKodeBarang();
		case NAMA_BARANG:
			return transaksiPenjualan.getNamaBarang();
		case HARGA_BARANG:
			return transaksiPenjualan.getHargaBarang();
		case JUMLAH:
			return transaksiPenjualan.getJumlahBarang();
		case TOTAL:
			return transaksiPenjualan.getTotalHargaBarang();
		default:
			return transaksiPenjualan.getKodeBarang();
		}
	}
	
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
}
