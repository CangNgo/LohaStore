package com.cangngo.model;

public class CartItem {
	private int idCTGioHang;
	private int soLuong;
	private String tenSanpham;
	private double gia;
	private String hinhanh;

	public CartItem(int idCTGioHang, int soLuong, String tenSanpham, double gia,
			String hinhanh) {
		super();
		this.idCTGioHang = idCTGioHang;
		this.soLuong = soLuong;
		this.tenSanpham = tenSanpham;
		this.gia = gia;
		this.hinhanh = hinhanh;
	}

	public int getIdCTGioHang() {
		return idCTGioHang;
	}

	public void setIdCTGioHang(int idCTGioHang) {
		this.idCTGioHang = idCTGioHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getTenSanpham() {
		return tenSanpham;
	}

	public void setTenSanpham(String tenSanpham) {
		this.tenSanpham = tenSanpham;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public CartItem() {
		// TODO Auto-generated constructor stub
	}

}
