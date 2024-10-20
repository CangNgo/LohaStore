package com.cangngo.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.cangngo.dao.IGiohangDAO;
import com.cangngo.model.CartItem;
import com.cangngo.utils.JpaUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class GiohangDAO implements IGiohangDAO {

	public GiohangDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CartItem> findAllByIdUser(int giohangid) {

		List<CartItem> cartItems = null;
		try (EntityManager entity = JpaUtils.getEntityManager()) {
			TypedQuery<Object[]> query = entity
					.createQuery("SELECT ctgh.id, ctgh.soluong, sp.tenSanpham, sp.gia, sp.hinh, sp.id "
							+ "FROM Chitietgiohang ctgh " + "INNER JOIN ctgh.idSanpham sp "
							+ "INNER JOIN ctgh.idGiohang gh " + "INNER JOIN gh.idKhachhang kh "
							+ "WHERE gh.id = :giohangid", Object[].class);
			query.setParameter("giohangid", giohangid);
			List<Object[]> results = query.getResultList();
			cartItems = results.stream().map(result -> new CartItem((Integer) result[0], (Integer) result[1],
					(String) result[2], (Double) result[3], (String) result[4], (Integer) result[5]))
					.collect(Collectors.toList());

		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return cartItems;
	}

	public static void main(String[] args) {
		GiohangDAO dao = new GiohangDAO();
		dao.findAllByIdUser(1);
	}
}
