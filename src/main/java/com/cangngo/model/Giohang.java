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
	private Date ngayTao;

	@Column(name = "TrangThai")
	private String trangThai;
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
		return ngayTao;
	}

	public void setNgayTao(Date ngayTao) {
		this.ngayTao = ngayTao;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
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
		List<Giohang> listGioHang = entity.createQuery("SELECT g FROM Giohang g", Giohang.class).getResultList();
		listGioHang.forEach(c -> {
			System.out.println(c.getIdKhachhang().getIdTaikhoan().getId());
		});
    }

}
