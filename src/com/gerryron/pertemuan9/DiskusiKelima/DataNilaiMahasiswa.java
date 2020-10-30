package com.gerryron.pertemuan9.DiskusiKelima;

public class DataNilaiMahasiswa {

	private String nim;
	private String namaMahasiswa;
	private int semester;
	private String matkul;
	private int kehadiran;
	private int tugas;
	private int uts;
	private int uas;
	
	public DataNilaiMahasiswa() {
	}
	
	public DataNilaiMahasiswa(String nim, String namaMahasiswa, int semester, String matkul, int kehadiran, int tugas,
			int uts, int uas) {
		super();
		this.nim = nim;
		this.namaMahasiswa = namaMahasiswa;
		this.semester = semester;
		this.matkul = matkul;
		this.kehadiran = kehadiran;
		this.tugas = tugas;
		this.uts = uts;
		this.uas = uas;
	}

	public String getNim() {
		return nim;
	}

	public void setNim(String nim) {
		this.nim = nim;
	}

	public String getNamaMahasiswa() {
		return namaMahasiswa;
	}

	public void setNamaMahasiswa(String namaMahasiswa) {
		this.namaMahasiswa = namaMahasiswa;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getMatkul() {
		return matkul;
	}

	public void setMatkul(String matkul) {
		this.matkul = matkul;
	}

	public int getKehadiran() {
		return kehadiran;
	}

	public void setKehadiran(int kehadiran) {
		this.kehadiran = kehadiran;
	}

	public int getTugas() {
		return tugas;
	}

	public void setTugas(int tugas) {
		this.tugas = tugas;
	}

	public int getUts() {
		return uts;
	}

	public void setUts(int uts) {
		this.uts = uts;
	}

	public int getUas() {
		return uas;
	}

	public void setUas(int uas) {
		this.uas = uas;
	}
	
}
