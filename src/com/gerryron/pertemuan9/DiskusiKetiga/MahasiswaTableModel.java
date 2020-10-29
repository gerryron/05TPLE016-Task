package com.gerryron.pertemuan9.DiskusiKetiga;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.gerryron.pertemuan9.DiskusiKetiga.Mahasiswa;

public class MahasiswaTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int NIM = 0;
	private static final int NAMA = 1;
	private static final int PRODI = 2;
	private static final int MATKUL = 3;
	private static final int NILAI = 4;
	
	private String[] columnNames = { "NIM", "Nama", "Prodi", "Mata Kuliah", "Nilai"};
	private List<Mahasiswa> listMahasiswa;
	
	public MahasiswaTableModel(List<Mahasiswa> listMahasiswa) {
		this.listMahasiswa = listMahasiswa;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() {
		return listMahasiswa.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		Mahasiswa mahasiswa = listMahasiswa.get(row);

		switch (col) {
		case NIM:
			return mahasiswa.getNim();
		case NAMA:
			return mahasiswa.getNama();
		case PRODI:
			return mahasiswa.getProdi();
		case MATKUL:
			return mahasiswa.getMatkul();
		case NILAI:
			return mahasiswa.getNilai();
		default:
			return mahasiswa.getNim();
		}
	}
	
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

}
