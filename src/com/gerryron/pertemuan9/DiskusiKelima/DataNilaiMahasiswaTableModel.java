package com.gerryron.pertemuan9.DiskusiKelima;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DataNilaiMahasiswaTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private static final int NIM = 0;
	private static final int NAMA_MAHASISWA = 1;
	private static final int SEMESTER = 2;
	private static final int MATA_KULIAH = 3;
	private static final int KEHADIRAN = 4;
	private static final int TUGAS = 5;
	private static final int UTS = 6;
	private static final int UAS = 7;
	
	private String[] columnNames = {"NIM", "Nama", "Semester", "Mata Kuliah", "Kehadiran", "Tugas", "UTS", "UAS"};
	private List<DataNilaiMahasiswa> listNilai;
	
	public DataNilaiMahasiswaTableModel(List<DataNilaiMahasiswa> listNilai) {
		this.listNilai = listNilai;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() {
		return listNilai.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		DataNilaiMahasiswa nilai = listNilai.get(row);

		switch (col) {
		case NIM:
			return nilai.getNim();
		case NAMA_MAHASISWA:
			return nilai.getNamaMahasiswa();
		case SEMESTER:
			return nilai.getSemester();
		case MATA_KULIAH:
			return nilai.getMatkul();
		case KEHADIRAN:
			return nilai.getKehadiran();
		case TUGAS:
			return nilai.getTugas();
		case UTS:
			return nilai.getUts();
		case UAS:
			return nilai.getUas();
		default:
			return nilai.getNim();
		}
	}
	
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	
}
