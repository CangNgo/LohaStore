package com.cangngo.model;

import java.io.Serializable;
import java.util.List;

import com.cangngo.utils.JpaUtils;
import jakarta.persistence.*;

@Entity
@Table(name = "SanPham")
public class SanPham implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SanPham")
	private int id;

	@ManyToOne()
	@JoinColumn(name = "ID_LoaiSanPham")
	private LoaiSanPham idLoaiSanPham;

	@Column(name = "TenSanPham")
	private String tenSanpham;

	@Column(name = "MoTa")
	private String mota;

	@Column(name = "Gia")
	private double gia;

	@Column(name = "SoLuongTonKho")
	private int soluong;

	@Column(name = "HinhAnh")
	private String hinh;

	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LoaiSanPham getIdLoaiSanPham() {
		return idLoaiSanPham;
	}

	public void setIdLoaiSanPham(LoaiSanPham idLoaiSanPham) {
		this.idLoaiSanPham = idLoaiSanPham;
	}

	public String getTenSanpham() {
		return tenSanpham;
	}

	public void setTenSanpham(String tenSanpham) {
		this.tenSanpham = tenSanpham;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public static void main(String[] args) {
		EntityManager entity = JpaUtils.getEntityManager();
		List<SanPham> listTK = entity.createQuery("select t from SanPham t",SanPham.class).getResultList();
		System.out.println(listTK.get(1).getId());
	}
}
