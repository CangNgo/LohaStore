package com.cangngo.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.cangngo.utils.JpaUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
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

    public int getIdKhachhang() {
        return idKhachhang;
    }

    public void setIdKhachhang(int idKhachhang) {
        this.idKhachhang = idKhachhang;
    }

    public Date getNgayDatHang() {
		return ngayDathang;
    }

	public void setNgayDatHang(Date ngayDathang) {
		this.ngayDathang = ngayDathang;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThaiDonHang() {
		return trangthaiDonhang;
    }

    public void setTrangThaiDonHang(String trangThaiDonHang) {
		this.trangthaiDonhang = trangThaiDonHang;
    }

    public String getDiaChiGiaoHang() {
		return diachiGiaohang;
    }

    public void setDiaChiGiaoHang(String diaChiGiaoHang) {
		this.diachiGiaohang = diaChiGiaoHang;
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

    public static void main(String[] args) {
        EntityManager entity = JpaUtils.getEntityManager();
        List<Donhang> listTK = entity.createQuery("select t from Donhang t",Donhang.class).getResultList();
        System.out.println(listTK.get(1).getDiaChiGiaoHang());
    }
}
