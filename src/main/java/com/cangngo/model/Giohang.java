package com.cangngo.model;

public class Giohang extends AbstractModel {
	private int idKhachhang;
	private String trangthai;

	public Giohang(int idKhachhang, String trangthai) {
		super();
		this.idKhachhang = idKhachhang;
		this.trangthai = trangthai;
	}

	public int getIdKhachhang() {
		return idKhachhang;
	}

	public void setIdKhachhang(int idKhachhang) {
		this.idKhachhang = idKhachhang;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public Giohang() {
		// TODO Auto-generated constructor stub
	}

}
