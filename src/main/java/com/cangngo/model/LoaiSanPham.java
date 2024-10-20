package com.cangngo.model;

import java.io.Serializable;
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
@Table(name = "LoaiSanPham")
public class LoaiSanPham implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_LoaiSanPham")
	private int idLoaiSanpham;
	@Column(name = "TenLoai")
	private String tenloai;
	@Column(name = "MoTa")
	private String mota;

	public LoaiSanPham() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiSanPham(int idLoaiSanpham, String tenloai, String mota) {
		super();
		this.idLoaiSanpham = idLoaiSanpham;
		this.tenloai = tenloai;
		this.mota = mota;
	}

	public int getIdLoaiSanpham() {
		return idLoaiSanpham;
	}

	public void setIdLoaiSanpham(int idLoaiSanpham) {
		this.idLoaiSanpham = idLoaiSanpham;
	}

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void main(String[] args) {
		EntityManager entity = JpaUtils.getEntityManager();
		List<LoaiSanPham> listTK = entity.createQuery("select t from LoaiSanPham t", LoaiSanPham.class).getResultList();
		System.out.println(listTK.get(1).getTenloai());
	}

}
