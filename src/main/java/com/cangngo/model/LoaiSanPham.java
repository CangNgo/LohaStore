package com.cangngo.model;

public class LoaiSanPham extends AbstractModel {
	private String tenLoai;
	private String moTa;

	public LoaiSanPham(String tenLoai, String moTa) {
		super();
		this.tenLoai = tenLoai;
		this.moTa = moTa;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public LoaiSanPham() {
		// TODO Auto-generated constructor stub
	}

}
