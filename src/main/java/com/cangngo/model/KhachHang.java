package com.cangngo.model;

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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_KhachHang")
    private int id;
    @OneToOne
    @JoinColumn(name = "ID_TAIKHOAN")
    private Taikhoan idTaikhoan;
    @Column(name = "HoTen")
    private String hoten;
    @Column(name = "Email")
    private String email;
    @Column(name = "SoDienThoai")
	private String soDienthoai;
    @Column(name = "DiaChi")
	private String diachi;
	@Temporal(TemporalType.DATE)
    @Column(name = "NgaySinh")
    private Date ngaysinh;
	@Temporal(TemporalType.DATE)
    @Column(name = "NgayDangKy")
	private Date ngayDangky;

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHang(int id, Taikhoan idTaikhoan, String hoten, String email, String soDienthoai, String diachi,
			Date ngaysinh, Date ngayDangky) {
        this.id = id;
        this.idTaikhoan = idTaikhoan;
        this.hoten = hoten;
        this.email = email;
		this.soDienthoai = soDienthoai;
		this.diachi = diachi;
        this.ngaysinh = ngaysinh;
		this.ngayDangky = ngayDangky;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Taikhoan getIdTaikhoan() {
		return idTaikhoan;
	}

	public void setIdTaikhoan(Taikhoan idTaikhoan) {
		this.idTaikhoan = idTaikhoan;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSoDienthoai() {
		return soDienthoai;
	}

	public void setSoDienthoai(String soDienthoai) {
		this.soDienthoai = soDienthoai;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public Date getNgayDangky() {
		return ngayDangky;
	}

	public void setNgayDangky(Date ngayDangky) {
		this.ngayDangky = ngayDangky;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void main(String[] args) {
		EntityManager entity = JpaUtils.getEntityManager();
		List<Object[]> listKhachHang = entity
				.createQuery("select t, k, g from KhachHang k join k.idTaikhoan t join g.idKhachhang g", Object[].class)
				.getResultList();

	}

}
