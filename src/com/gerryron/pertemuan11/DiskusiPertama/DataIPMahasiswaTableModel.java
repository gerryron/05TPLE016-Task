package com.gerryron.pertemuan11.DiskusiPertama;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DataIPMahasiswaTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private static final int NIM = 0;
	private static final int NAMA = 1;
	private static final int PRODI = 2;
	private static final int INDEX_PRESTASI = 3;
	private static final int EMAIL = 4;
	private static final int TELP = 5;
	
	private String[] columnNames = {"NIM", "Nama", "Prodi", "I.P", "Email", "Telp"};
	private List<DataIPMahasiswa> listIndex;
	
	public DataIPMahasiswaTableModel(List<DataIPMahasiswa> listIndex) {
		this.listIndex = listIndex;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() {
		return listIndex.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		DataIPMahasiswa index = listIndex.get(row);

		switch (col) {
		case NIM:
			return index.getNim();
		case NAMA:
			return index.getNama();
		case PRODI:
			return index.getProdi();
		case INDEX_PRESTASI:
			return index.getIndexPrestasi();
		case EMAIL:
			return index.getEmail();
		case TELP:
			return index.getTelp();
		default:
			return index.getNim();
		}
	}
	
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
}
