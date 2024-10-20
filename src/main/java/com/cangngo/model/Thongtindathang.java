package com.cangngo.model;

public class Thongtindathang {
	private String email;
	private String hoten;
	private String sodienthoai;
	private String tinh;
	private String quan;
	private String xa;
	private String tuychon;
	private String ghichu;

	public Thongtindathang(String email, String hoten, String sodienthoai, String tinh, String quan, String xa) {
		super();
		this.email = email;
		this.hoten = hoten;
		this.sodienthoai = sodienthoai;
		this.tinh = tinh;
		this.quan = quan;
		this.xa = xa;
	}

	public Thongtindathang(String email, String hoten, String sodienthoai, String tinh, String quan, String xa,
			String tuychon, String ghichu) {
		super();
		this.email = email;
		this.hoten = hoten;
		this.sodienthoai = sodienthoai;
		this.tinh = tinh;
		this.quan = quan;
		this.xa = xa;
		this.tuychon = tuychon;
		this.ghichu = ghichu;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getSodienthoai() {
		return sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}

	public String getTinh() {
		return tinh;
	}

	public void setTinh(String tinh) {
		this.tinh = tinh;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	public String getXa() {
		return xa;
	}

	public void setXa(String xa) {
		this.xa = xa;
	}

	public String getTuychon() {
		return tuychon;
	}

	public void setTuychon(String tuychon) {
		this.tuychon = tuychon;
	}

	public String getGhichu() {
		return ghichu;
	}

	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}

	public Thongtindathang() {
		// TODO Auto-generated constructor stub
	}

}
