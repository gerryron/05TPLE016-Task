package com.gerryron.pertemuan11.DiskusiKeempat;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DataPegawaiTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private static final int ID_PEGAWAI = 0;
	private static final int NAMA_PEGAWAI = 1;
	private static final int JENIS_KELAMIN = 2;
	
	private String[] columnNames = {"ID Pegawai", "Nama Pegawai", "Jenis Kelamin"};
	private List<DataPegawai> listPegawai;
	
	public DataPegawaiTableModel(List<DataPegawai> listPegawai) {
		this.listPegawai = listPegawai;
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	@Override
	public int getRowCount() {
		return listPegawai.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		
		DataPegawai pegawai = listPegawai.get(row);

		switch (col) {
		case ID_PEGAWAI:
			return pegawai.getIdPegawai();
		case NAMA_PEGAWAI:
			return pegawai.getNamaPegawai();
		case JENIS_KELAMIN:
			return pegawai.getJenisKelamin();
		default:
			return pegawai.getIdPegawai();
		}
	}
	
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
}
