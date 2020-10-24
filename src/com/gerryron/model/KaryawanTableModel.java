package com.gerryron.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.gerryron.Entity.Karyawan;

public class KaryawanTableModel extends AbstractTableModel{

	private static final int NIK = 0;
	private static final int NAMA_KARYAWAN = 1;
	private static final int JENIS_KELAMIN = 2;
	private static final int JABATAN = 3;
	private static final int GAJI_POKOK = 4;
	private static final int JAM_LEMBUR = 5;
	private static final int UPAH_LEMBUR = 6;
	private static final int TOTAL_GAJI = 7;
	
	private String[] columnNames = { "NIK", "Nama Karyawan", "Jenis Kelamin", "Jabatan", 
			"Gaji Pokok", "Jam Lembur", "Upah Lembur", "Total Gaji"};
	private List<Karyawan> listKaryawan;
	
	public KaryawanTableModel(List<Karyawan> listKaryawan) {
		this.listKaryawan = listKaryawan;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() {
		return listKaryawan.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		Karyawan karyawan = listKaryawan.get(row);

		switch (col) {
		case NIK:
			return karyawan.getNik();
		case NAMA_KARYAWAN:
			return karyawan.getNamaKaryawan();
		case JENIS_KELAMIN:
			return karyawan.getJenisKelamin();
		case JABATAN:
			return karyawan.getJabatan();
		case GAJI_POKOK:
			return karyawan.getGajiPokok();
		case JAM_LEMBUR:
			return karyawan.getJamLembur();
		case UPAH_LEMBUR:
			return karyawan.getUpahLembur();
		case TOTAL_GAJI:
			return karyawan.getTotalGaji();
		default:
			return karyawan.getNik();
		}
	}
	
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
