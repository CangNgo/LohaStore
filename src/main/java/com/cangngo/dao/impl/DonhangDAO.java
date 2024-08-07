package com.cangngo.dao.impl;

import java.util.List;

import com.cangngo.dao.IDonhangDAO;
import com.cangngo.model.Donhang;
import com.cangngo.utils.JpaUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class DonhangDAO implements IDonhangDAO {

	public DonhangDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int insertDonhang(Donhang donhang) {
		EntityManager entity = JpaUtils.getEntityManager();
		try {
			entity.getTransaction().begin();
			Donhang resultInsert = entity.merge(donhang);
			entity.getTransaction().commit();
			if (resultInsert != null) {
				return resultInsert.getId();
			}
		} catch (Exception e) {
			entity.getTransaction().rollback();
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return 0;
	}

	@Override
	public List<Donhang> findAll() {

		EntityManager entity = JpaUtils.getEntityManager();
		try {
			entity.getTransaction().begin();
			TypedQuery<Donhang> query = entity.createQuery("SELECT dh from Donhang dh", Donhang.class);
			List<Donhang> listOrders = query.getResultList();
			entity.getTransaction().commit();
			return listOrders;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return null;
	}

}
