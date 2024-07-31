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

@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable {
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
    private String soDienThoai;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "NgaySinh")
    private Date ngaysinh;
    @Column(name = "NgayDangKy")
    private Date ngayDangKy;

    public KhachHang(int id, Taikhoan idTaikhoan, String hoten, String email, String soDienThoai, String diaChi, Date ngaysinh,
                     Date ngayDangKy) {
        this.id = id;
        this.idTaikhoan = idTaikhoan;
        this.hoten = hoten;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.ngaysinh = ngaysinh;
        this.ngayDangKy = ngayDangKy;
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

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public KhachHang() {
        // TODO Auto-generated constructor stub
    }

	public static void main(String[] args) {
		EntityManager entity = JpaUtils.getEntityManager();
		List<KhachHang> listKhachHang = entity.createQuery("SELECT k FROM KhachHang k", KhachHang.class)
				.getResultList();
		listKhachHang.forEach(c -> {
			System.out.println(c.getIdTaikhoan().getTaiKhoan());
		});
	}

}
