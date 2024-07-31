package com.cangngo.model;

import java.io.Serializable;
import java.util.List;

import com.cangngo.utils.JpaUtils;
import jakarta.persistence.*;

@Entity
@Table(name = "ChiTietDonHang")
public class Chitietdonhang implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ChiTietDonHang")
	private int id;

	@ManyToOne
	@JoinColumn(name = "ID_DonHang")
	private Donhang idDonhang;

	@ManyToOne
	@JoinColumn(name = "ID_SanPham")
	private SanPham idSanpham;
	@Column(name = "SoLuong")
	private int soluong;
	@Column(name = "GiaTaiThoiDiemMua")
	private double giaTaiThoiDiemMua;

	public Chitietdonhang(int id, Donhang idDonhang, SanPham idSanpham, int soluong, double giaTaiThoiDiemMua) {
		super();
		this.id = id;
		this.idDonhang = idDonhang;
		this.idSanpham = idSanpham;
		this.soluong = soluong;
		this.giaTaiThoiDiemMua = giaTaiThoiDiemMua;
	}

	public Donhang getIdDonhang() {
		return idDonhang;
	}

	public void setIdDonhang(Donhang idDonhang) {
		this.idDonhang = idDonhang;
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

	public double getGiaTaiThoiDiemMua() {
		return giaTaiThoiDiemMua;
	}

	public void setGiaTaiThoiDiemMua(double giaTaiThoiDiemMua) {
		this.giaTaiThoiDiemMua = giaTaiThoiDiemMua;
	}

	public Chitietdonhang() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		EntityManager entity = JpaUtils.getEntityManager();
		List<Chitietdonhang> listTK = entity.createQuery("select t from Chitietdonhang t",Chitietdonhang.class).getResultList();
		System.out.println(listTK.get(1).getSoluong());
	}

}
