package com.cangngo.dao.impl;

import java.util.List;

import com.cangngo.dao.ISanphamDAO;
import com.cangngo.model.SanPham;
import com.cangngo.utils.JpaUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class SanphamDAO implements ISanphamDAO {

	public SanphamDAO() {
		// Constructor
	}

	@Override
	public List<SanPham> findAll() {
		List<SanPham> listProduct = null;
		try {
			EntityManager sanpham = JpaUtils.getEntityManager();
			listProduct = sanpham.createQuery("SELECT product FROM SanPham product ", SanPham.class).getResultList();
			return listProduct;
		} catch (Exception e) {

			return listProduct;
		}

	}

	@Override
	public List<SanPham> findByCategoryByProduct(String tenLoai) {
		List<SanPham> listProductByCategory = null;
		try (EntityManager sanpham = JpaUtils.getEntityManager()) {
			TypedQuery<SanPham> query = sanpham.createQuery(
					"SELECT product FROM SanPham product JOIN product.idLoaiSanPham loaiSanPham WHERE loaiSanPham.tenLoai = :tenLoai",
					SanPham.class);
			query.setParameter("tenLoai", tenLoai);
			listProductByCategory = query.getResultList();
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
		return listProductByCategory;
	}

	@Override
	public SanPham findByIdProduct(int id) {
		SanPham product = null;
		try (EntityManager sanpham = JpaUtils.getEntityManager()) {
			product = sanpham.find(SanPham.class, id);
		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return product;
	}
}
