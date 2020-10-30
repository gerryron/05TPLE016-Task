package com.gerryron.pertemuan9.DiskusiKeempat;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class BarangTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ID_BARANG = 0;
	private static final int KATEGORI = 1;
	private static final int NAMA_BARANG = 2;
	
	private String[] columnNames = {"ID Barang", "Kategori", "Nama Barang"};
	private List<Barang> listBarang;
	
	public BarangTableModel(List<Barang> listBarang) {
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
		
		Barang barang = listBarang.get(row);

		switch (col) {
		case ID_BARANG:
			return barang.getIdBarang();
		case KATEGORI:
			return barang.getKategori();
		case NAMA_BARANG:
			return barang.getNamaBarang();
		default:
			return barang.getIdBarang();
		}
	}
	
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

}
