package com.cangngo.dao.impl;

import java.util.List;

import com.cangngo.dao.IChitietdonhangDAO;
import com.cangngo.model.CartItem;
import com.cangngo.model.Chitietdonhang;
import com.cangngo.model.Donhang;
import com.cangngo.model.SanPham;
import com.cangngo.utils.JpaUtils;

import jakarta.persistence.EntityManager;

public class ChitietdonhangDAO implements IChitietdonhangDAO {

	public ChitietdonhangDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insertCTDonhang(int idDonhang, List<CartItem> listCart) {
		EntityManager entity = JpaUtils.getEntityManager();
		try {
			entity.getTransaction().begin();
			Donhang donhang = entity.find(Donhang.class, idDonhang);
			for (CartItem cartItem : listCart) {
				Chitietdonhang ctDonhang = new Chitietdonhang();
				SanPham sanpham = entity.find(SanPham.class, cartItem.getIdSanpham());
				ctDonhang.setIdDonhang(donhang);
				ctDonhang.setIdSanpham(sanpham);
				ctDonhang.setSoluong(cartItem.getSoLuong());
				ctDonhang.setGiaTaiThoiDiemMua(cartItem.getSoLuong() * cartItem.getGia());
				entity.merge(ctDonhang);
			}
			entity.getTransaction().commit();
		} catch (Exception e) {
			entity.getTransaction().rollback();
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

}
