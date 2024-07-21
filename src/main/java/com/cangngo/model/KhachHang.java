package com.cangngo.model;

import java.util.Date;

public class KhachHang extends AbstractModel {
	private int idTaikhoan;
	private String hoten;
	private String email;
	private String soDienThoai;
	private String diaChi;
	private Date ngaysinh;
	private Date ngayDangKy;

	public KhachHang(int idTaikhoan, String hoten, String email, String soDienThoai, String diaChi, Date ngaysinh,
			Date ngayDangKy) {
		super();
		this.idTaikhoan = idTaikhoan;
		this.hoten = hoten;
		this.email = email;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.ngaysinh = ngaysinh;
		this.ngayDangKy = ngayDangKy;
	}

	public int getIdTaikhoan() {
		return idTaikhoan;
	}

	public void setIdTaikhoan(int idTaikhoan) {
		this.idTaikhoan = idTaikhoan;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public Date getNgayDangKy() {
		return ngayDangKy;
	}

	public void setNgayDangKy(Date ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

}
