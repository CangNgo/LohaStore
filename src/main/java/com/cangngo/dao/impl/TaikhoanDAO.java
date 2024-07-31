package com.cangngo.dao.impl;

import java.util.List;

import com.cangngo.dao.ITaikhoanDAO;
import com.cangngo.model.Taikhoan;
import com.cangngo.utils.JpaUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class TaikhoanDAO implements ITaikhoanDAO {

	public TaikhoanDAO() {
	}

	@Override
	public Taikhoan findUserByUsername(String username, String password) {
		List<Taikhoan> taikhoan = null;
		try (EntityManager entity = JpaUtils.getEntityManager()) {
			String sql = "SELECT t FROM Taikhoan t WHERE t.taiKhoan = :taikhoan";
			TypedQuery<Taikhoan> query = entity.createQuery(sql, Taikhoan.class);
			query.setParameter("taikhoan", username);
			taikhoan = query.getResultList();
			if (taikhoan.size() == 1) {
				return taikhoan.get(0);
			}else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
