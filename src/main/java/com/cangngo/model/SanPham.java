package com.cangngo.model;

public class SanPham extends AbstractModel {
	private int idGiohang;
	private int idSanpham;
	private int soluong;
	private double giaTaiThoiDiemThem;

	public SanPham(int idGiohang, int idSanpham, int soluong, double giaTaiThoiDiemThem) {
		super();
		this.idGiohang = idGiohang;
		this.idSanpham = idSanpham;
		this.soluong = soluong;
		this.giaTaiThoiDiemThem = giaTaiThoiDiemThem;
	}

	public int getIdGiohang() {
		return idGiohang;
	}

	public void setIdGiohang(int idGiohang) {
		this.idGiohang = idGiohang;
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

	public double getGiaTaiThoiDiemThem() {
		return giaTaiThoiDiemThem;
	}

	public void setGiaTaiThoiDiemThem(double giaTaiThoiDiemThem) {
		this.giaTaiThoiDiemThem = giaTaiThoiDiemThem;
	}
	public SanPham() {
		// TODO Auto-generated constructor stub
	}

}
