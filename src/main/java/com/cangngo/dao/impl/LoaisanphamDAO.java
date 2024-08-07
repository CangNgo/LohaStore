package com.cangngo.dao.impl;

import java.util.List;

import com.cangngo.dao.ILoaisanphamDAO;
import com.cangngo.model.LoaiSanPham;
import com.cangngo.utils.JpaUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class LoaisanphamDAO implements ILoaisanphamDAO {

	public LoaisanphamDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertLoaiSP(LoaiSanPham loaisanpham) {
		EntityManager entity = JpaUtils.getEntityManager();
		try {
			entity.getTransaction().begin();
			entity.persist(loaisanpham);
			entity.getTransaction().commit();

		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	@Override
	public List<LoaiSanPham> findAll() {
		List<LoaiSanPham> listCategory = null;
		EntityManager entity = JpaUtils.getEntityManager();

		try {
			entity.getTransaction().begin();
			TypedQuery<LoaiSanPham> query = entity.createQuery("SELECT lsp FROM LoaiSanPham lsp", LoaiSanPham.class);
			listCategory = query.getResultList();
			entity.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listCategory;
	}

	@Override
	public void updateCategory(int idCategory) {
		EntityManager entity = JpaUtils.getEntityManager();

		try {
			entity.getTransaction().begin();
			LoaiSanPham loaisanpham = entity.find(LoaiSanPham.class, idCategory);
			entity.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Override
	public LoaiSanPham findByID(int idLoaiSP) {
		EntityManager entity = JpaUtils.getEntityManager();
		try {
			entity.getTransaction().begin();
			LoaiSanPham loaisp = entity.find(LoaiSanPham.class, idLoaiSP);
			entity.getTransaction().commit();
			if (loaisp != null) {
				return loaisp;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public void updateCategory(LoaiSanPham loaisanpham) {
		EntityManager entity = JpaUtils.getEntityManager();
		try {
			entity.getTransaction().begin();
			entity.merge(loaisanpham);

			entity.getTransaction().commit();

		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
	}

	@Override
	public void remove(int idLoai) {
		EntityManager entity = JpaUtils.getEntityManager();
		try {
			entity.getTransaction().begin();
			LoaiSanPham loaisp = entity.find(LoaiSanPham.class, idLoai);
			entity.remove(loaisp);
			entity.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

}
