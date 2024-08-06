package com.cangngo.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.cangngo.dao.ITaikhoanDAO;
import com.cangngo.model.UserModel;
import com.cangngo.utils.JpaUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.persistence.TypedQuery;


public class TaikhoanDAO implements ITaikhoanDAO {

	public TaikhoanDAO() {
	}

	@Override
	public UserModel findUserByUsername(String username, String password) {
		List<UserModel> models = null;
		UserModel usermodel = null;
		try (EntityManager entity = JpaUtils.getEntityManager()) {
			List<Object[]> results = null;
			TypedQuery<Object[]> objects = entity
					.createQuery("SELECT t.taiKhoan, t.matKhau, k.hoten, k.id,g.id, t.vaitro " + "FROM KhachHang k "
							+ "JOIN k.idTaikhoan t " + "LEFT JOIN Giohang g ON k.id = g.idKhachhang.id "
							+ "where t.taiKhoan =:taikhoan "
							+ "GROUP BY t.taiKhoan, t.matKhau, k.hoten, k.id, g.id, t.vaitro", Object[].class);
			objects.setParameter("taikhoan", username);
			results = objects.getResultList();
			// chuyen tu object mang usermodel

			if (!results.isEmpty()) {
				models = results.stream()
						.map(result -> new UserModel((String) result[0], (String) result[1], (String) result[2],
								(Integer) result[3], (Integer) result[4], (boolean) result[5] ? "ADMIN" : "USER"))
						.collect(Collectors.toList());
				return models.getFirst();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return null;
	}

	@Override
	public boolean InsertNewAccount(String name, String email, String username, String password) {
		EntityManager entity = null;
		try {
			entity = JpaUtils.getEntityManager();
			entity.getTransaction().begin();
			StoredProcedureQuery insert = entity.createNamedStoredProcedureQuery("SP_InsertUser");
			insert.setParameter("tenDangnhap", username);
			insert.setParameter("email", email);
			insert.setParameter("matkhau", password);
			insert.setParameter("hoten", name);

			// Thực thi stored procedure
			boolean result = insert.execute();

			entity.getTransaction().commit();
			if (!result) {
				// Stored procedure executed successfully
				return true;
			} else {
				// Handle any unexpected results
				return false;
			}
		} catch (Exception e) {
			if (entity != null && entity.getTransaction().isActive()) {
				entity.getTransaction().rollback();
			}
			// Ghi log ngoại lệ
			System.out.println(e.getMessage());
			return false;
		} finally {
			if (entity != null) {
				entity.close();
			}
		}
	}

	@Override
	public boolean findUsernameAlreadyExists(String usename) {
		try (EntityManager entity = JpaUtils.getEntityManager();) {
			TypedQuery<Long> query = entity.createQuery("SELECT COUNT(t) FROM Taikhoan t WHERE taiKhoan =:usename",
					Long.class);
			query.setParameter("usename", usename);
			Long count = query.getSingleResult();
			return count > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean findEmaiAlreadyExists(String email) {
		try (EntityManager entity = JpaUtils.getEntityManager();) {
			TypedQuery<Long> query = entity.createQuery("SELECT COUNT(t) FROM KhachHang t WHERE email=:email",
					Long.class);
			query.setParameter("email", email);
			Long count = query.getSingleResult();
			return count > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
