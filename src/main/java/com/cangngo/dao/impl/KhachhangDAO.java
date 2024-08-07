package com.cangngo.dao.impl;

import com.cangngo.dao.IKhachhangDAO;
import com.cangngo.model.KhachHang;
import com.cangngo.utils.JpaUtils;

import jakarta.persistence.EntityManager;

public class KhachhangDAO implements IKhachhangDAO {

	public KhachhangDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public KhachHang findKhachhangByid(int idKhachhang) {
		EntityManager entity = JpaUtils.getEntityManager();
		try {
			entity.getTransaction().begin();
			KhachHang kh = entity.find(KhachHang.class, idKhachhang);
			entity.getTransaction().commit();
			if (kh != null) {
				return kh;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	@Override
	public KhachHang updateProfile(KhachHang kh) {
		EntityManager entity = JpaUtils.getEntityManager(); 
		try {
			entity.getTransaction().begin();

			KhachHang userHang = entity.find(KhachHang.class, kh.getId());

			userHang.setHoten(kh.getHoten());
			userHang.setEmail(kh.getEmail());
			userHang.setSoDienthoai(kh.getSoDienthoai());
			userHang.setNgaysinh(kh.getNgaysinh());
			userHang.setDiachi(kh.getDiachi());

			entity.merge(userHang);

			entity.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return null;
	}

}
