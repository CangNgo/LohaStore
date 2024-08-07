package com.cangngo.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DonHang")
public class Donhang implements Serializable {
	/**
	 * 
	 */
	@Serial
    private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DonHang")
    private int id;
    @Column(name = "ID_KhachHang")
    private int idKhachhang;
    @Column(name = "NgayDatHang")
	private Date ngayDathang;
    @Column(name = "TongTien")
    private double tongTien;
    @Column(name = "TrangThaiDonHang")
	private String trangthaiDonhang;
	@Column(name = "DiaChiGiaoHang")
    private String diachiGiaohang;
	@Column(name = "PhuongThucThanhToan")
    private String phuongThucThanhToan;

	public Donhang(int id, int idKhachhang, Date ngayDatHang, double tongTien, String trangthaiDonhang,
			String diachiGiaohang,
                   String phuongThucThanhToan) {
        super();
        this.id = id;
        this.idKhachhang = idKhachhang;
		this.trangthaiDonhang = trangthaiDonhang;
        this.tongTien = tongTien;
		this.trangthaiDonhang = trangthaiDonhang;
        this.diachiGiaohang = diachiGiaohang;
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdKhachhang() {
		return idKhachhang;
	}

	public void setIdKhachhang(int idKhachhang) {
		this.idKhachhang = idKhachhang;
	}

	public Date getNgayDathang() {
		return ngayDathang;
	}

	public void setNgayDathang(Date ngayDathang) {
		this.ngayDathang = ngayDathang;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public String getTrangthaiDonhang() {
		return trangthaiDonhang;
	}

	public void setTrangthaiDonhang(String trangthaiDonhang) {
		this.trangthaiDonhang = trangthaiDonhang;
	}

	public String getDiachiGiaohang() {
		return diachiGiaohang;
	}

	public void setDiachiGiaohang(String diachiGiaohang) {
		this.diachiGiaohang = diachiGiaohang;
	}

	public String getPhuongThucThanhToan() {
		return phuongThucThanhToan;
	}

	public void setPhuongThucThanhToan(String phuongThucThanhToan) {
		this.phuongThucThanhToan = phuongThucThanhToan;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Donhang() {
        // TODO Auto-generated constructor stub
    }
}
