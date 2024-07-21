package com.cangngo.model;

import java.util.Date;

public class Donhang extends AbstractModel {
	private int idKhachhang;
	private Date ngayDatHang;
	private double tongTien;
	private String trangThaiDonHang;
	private String diaChiGiaoHang;
	private String phuongThucThanhToan;

	public Donhang(int idKhachhang, Date ngayDatHang, double tongTien, String trangThaiDonHang, String diaChiGiaoHang,
			String phuongThucThanhToan) {
		super();
		this.idKhachhang = idKhachhang;
		this.ngayDatHang = ngayDatHang;
		this.tongTien = tongTien;
		this.trangThaiDonHang = trangThaiDonHang;
		this.diaChiGiaoHang = diaChiGiaoHang;
		this.phuongThucThanhToan = phuongThucThanhToan;
	}

	public int getIdKhachhang() {
		return idKhachhang;
	}

	public void setIdKhachhang(int idKhachhang) {
		this.idKhachhang = idKhachhang;
	}

	public Date getNgayDatHang() {
		return ngayDatHang;
	}

	public void setNgayDatHang(Date ngayDatHang) {
		this.ngayDatHang = ngayDatHang;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public String getTrangThaiDonHang() {
		return trangThaiDonHang;
	}

	public void setTrangThaiDonHang(String trangThaiDonHang) {
		this.trangThaiDonHang = trangThaiDonHang;
	}

	public String getDiaChiGiaoHang() {
		return diaChiGiaoHang;
	}

	public void setDiaChiGiaoHang(String diaChiGiaoHang) {
		this.diaChiGiaoHang = diaChiGiaoHang;
	}

	public String getPhuongThucThanhToan() {
		return phuongThucThanhToan;
	}

	public void setPhuongThucThanhToan(String phuongThucThanhToan) {
		this.phuongThucThanhToan = phuongThucThanhToan;
	}
	public Donhang() {
		// TODO Auto-generated constructor stub
	}

}
