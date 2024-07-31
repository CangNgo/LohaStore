package com.cangngo.model;

import java.io.Serializable;
import java.util.List;

import com.cangngo.utils.JpaUtils;
import jakarta.persistence.*;

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
	private int idLoaiSanPham;
	@Column(name = "TenLoai")
	private String tenLoai;
	@Column(name = "MoTa")
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

	public static void main(String[] args) {
		EntityManager entity = JpaUtils.getEntityManager();
		List<LoaiSanPham> listTK = entity.createQuery("select t from LoaiSanPham t",LoaiSanPham.class).getResultList();
		System.out.println(listTK.get(1).getTenLoai());
	}

}
