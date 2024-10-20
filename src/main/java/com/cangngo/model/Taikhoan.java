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
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.StoredProcedureParameter;
import jakarta.persistence.Table;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "SP_InsertUser", procedureName = "SP_InsertUser", parameters = {
				@StoredProcedureParameter(name = "tenDangnhap", type = String.class),
				@StoredProcedureParameter(name = "email", type = String.class),
				@StoredProcedureParameter(name = "matkhau", type = String.class),
				@StoredProcedureParameter(name = "hoten", type = String.class) }) })

@Table(name = "TAIKHOAN")
@Entity
public class Taikhoan implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	@Column(name = "TAIKHOAN")
	private String taiKhoan;
	@Column(name = "MATKHAU")
	private String matKhau;
	@Column(name = "VAITRO")
	private boolean vaitro;

	public Taikhoan(int id, String taiKhoan, String matKhau, boolean vaitro) {
		super();
		this.id = id;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.vaitro = vaitro;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public boolean isVaitro() {
		return vaitro;
	}

	public void setVaitro(boolean vaitro) {
		this.vaitro = vaitro;
	}

	public Taikhoan() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		EntityManager entity = JpaUtils.getEntityManager();
		List<Taikhoan> listTK = entity.createQuery("select t from Taikhoan t", Taikhoan.class).getResultList();
		System.out.println(listTK.get(1).getId());
	}

}
