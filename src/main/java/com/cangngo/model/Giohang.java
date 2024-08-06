package com.cangngo.model;

import java.io.Serializable;
import java.util.Date;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TypedQuery;

@Entity
@Table(name = "GioHang")
public class Giohang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_GioHang")
	private int id;

	@OneToOne
	@JoinColumn(name = "ID_KhachHang")
	private KhachHang idKhachhang;

	@Column(name = "NgayTao")
	private Date ngaytao;

	@Column(name = "TrangThai")
	private String trangthai;

	public Giohang(int id, KhachHang idKhachhang) {
		this.id = id;
		this.idKhachhang = idKhachhang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public KhachHang getIdKhachhang() {
		return idKhachhang;
	}

	public void setIdKhachhang(KhachHang idKhachhang) {
		this.idKhachhang = idKhachhang;
	}

	public Date getNgayTao() {
		return ngaytao;
	}

	public void setNgayTao(Date ngaytao) {
		this.ngaytao = ngaytao;
	}

	public String getTrangThai() {
		return trangthai;
	}

	public void setTrangThai(String trangthai) {
		this.trangthai = trangthai;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Giohang() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("hello");
		EntityManager entity = JpaUtils.getEntityManager();
		List<Object[]> results = null;
		TypedQuery<Object[]> objects = entity.createQuery("SELECT t.taiKhoan, t.matKhau, k.hoten, k.id,g.id, t.vaitro "
				+ "FROM KhachHang k " + "JOIN k.idTaikhoan t " + "LEFT JOIN Giohang g ON k.id = g.idKhachhang.id "
				+ "where t.taiKhoan =:taikhoan "
				+ "GROUP BY t.taiKhoan, t.matKhau, k.hoten, k.id, g.id, t.vaitro", Object[].class);
		objects.setParameter("taikhoan", "cangadmin");
		results = objects.getResultList();
		List<UserModel> models = results.stream().map(result -> new UserModel((String) result[0], (String) result[1],
				(String) result[2], (Integer) result[3], (Integer) result[4], (Boolean) result[5] ? "ADMIN" : "USER"))
				.collect(Collectors.toList());

		models.forEach(c -> {
			System.out.println(c.getUsername());
		});
	}

}
