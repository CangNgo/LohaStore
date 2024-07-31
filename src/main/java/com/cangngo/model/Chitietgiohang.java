package com.cangngo.model;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.cangngo.utils.JpaUtils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TypedQuery;

@Entity
@Table(name = "ChiTietGioHang")
public class Chitietgiohang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ChiTietGioHang")
	private int id;

	@ManyToOne
	@JoinColumn(name = "ID_GioHang")
	private Giohang idGiohang;

	@ManyToOne
	@JoinColumn(name = "ID_SanPham")
	private SanPham idSanpham;
	@Column(name = "SoLuong")
	private int soluong;
	@Column(name = "GiaTaiThoiDiemThem")
	private double giaTaiThoiDiemThem;

	public Chitietgiohang(int id, Giohang idGiohang, SanPham idSanpham, int soluong, double giaTaiThoiDiemThem) {
		super();
		this.id = id;
		this.idGiohang = idGiohang;
		this.idSanpham = idSanpham;
		this.soluong = soluong;
		this.giaTaiThoiDiemThem = giaTaiThoiDiemThem;
	}

	public Chitietgiohang(int id, Giohang idGiohang, SanPham idSanpham, int soluong) {
		super();
		this.id = id;
		this.idGiohang = idGiohang;
		this.idSanpham = idSanpham;
		this.soluong = soluong;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Giohang getIdGiohang() {
		return idGiohang;
	}

	public void setIdGiohang(Giohang idGiohang) {
		this.idGiohang = idGiohang;
	}

	public SanPham getIdSanpham() {
		return idSanpham;
	}

	public void setIdSanpham(SanPham idSanpham) {
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

	public Chitietgiohang() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		EntityManager entity = JpaUtils.getEntityManager();
		TypedQuery<Object[]> query = entity.createQuery("SELECT ctgh.id, ctgh.soluong, sp.tenSanpham, sp.gia, sp.hinh "
				+ "FROM Chitietgiohang ctgh " + "INNER JOIN ctgh.idSanpham sp " + "INNER JOIN ctgh.idGiohang gh "
				+ "INNER JOIN gh.idKhachhang kh " + "WHERE kh.id = :khachHangId", Object[].class);
		query.setParameter("khachHangId", 2);
		List<Object[]> results = query.getResultList();
		List<CartItem> cartItems = results.stream().map(result -> new CartItem((Integer) result[0], (Integer) result[1],
				(String) result[2], (Double) result[3], (String) result[4])).collect(Collectors.toList());
//		cartItems.forEach(p -> {
//			System.out.println(p.getGia());
//		});
	}
}
