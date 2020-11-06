package com.gerryron.UTS.Model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.gerryron.UTS.Entity.DataSupplier;

public class DataSupplierTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private static final int KODE_SUPPLIER = 0;
	private static final int NAMA_SUPPLIER = 1;
	private static final int NAMA_BARANG = 2;
	private static final int BANYAK_BARANG = 3;
	
	private String[] columnNames = {"Kode Supplier", "Nama Supplier", "Nama Barang", "Banyak Barang"};
	private List<DataSupplier> listSupplier;
	
	public DataSupplierTableModel(List<DataSupplier> listSupplier) {
		this.listSupplier = listSupplier;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() {
		return listSupplier.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		DataSupplier dataSupplier = listSupplier.get(row);

		switch (col) {
		case KODE_SUPPLIER:
			return dataSupplier.getKodeSupplier();
		case NAMA_SUPPLIER:
			return dataSupplier.getNamaSupplier();
		case NAMA_BARANG:
			return dataSupplier.getNamaBarang();
		case BANYAK_BARANG:
			return dataSupplier.getBanyakBarang();
		default:
			return dataSupplier.getKodeSupplier();
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
}
