package com.cangngo.model;

public class Chitietdonhang extends AbstractModel {
	private int idDonhang;
	private int idSanpham;
	private int soluong;
	private double giaTaiThoiDiemMua;

	public Chitietdonhang(int idDonhang, int idSanpham, int soluong, double giaTaiThoiDiemMua) {
		super();
		this.idDonhang = idDonhang;
		this.idSanpham = idSanpham;
		this.soluong = soluong;
		this.giaTaiThoiDiemMua = giaTaiThoiDiemMua;
	}

	public int getIdDonhang() {
		return idDonhang;
	}

	public void setIdDonhang(int idDonhang) {
		this.idDonhang = idDonhang;
	}

	public int getIdSanpham() {
		return idSanpham;
	}

	public void setIdSanpham(int idSanpham) {
		this.idSanpham = idSanpham;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public double getGiaTaiThoiDiemMua() {
		return giaTaiThoiDiemMua;
	}

	public void setGiaTaiThoiDiemMua(double giaTaiThoiDiemMua) {
		this.giaTaiThoiDiemMua = giaTaiThoiDiemMua;
	}

	public Chitietdonhang() {
		// TODO Auto-generated constructor stub
	}

}
