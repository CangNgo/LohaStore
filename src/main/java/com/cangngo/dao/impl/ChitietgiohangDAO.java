package com.cangngo.dao.impl;

import java.util.List;

import com.cangngo.dao.IChitietgiohangDAO;
import com.cangngo.model.Chitietgiohang;
import com.cangngo.model.Giohang;
import com.cangngo.model.SanPham;
import com.cangngo.utils.JpaUtils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class ChitietgiohangDAO implements IChitietgiohangDAO {

	public ChitietgiohangDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void updateQuantityById(int idCTgiohang, int quantity) {
		EntityManager em = JpaUtils.getEntityManager();
		try {
			em.getTransaction().begin(); // Begin transaction

			Chitietgiohang chitietgiohang = em.find(Chitietgiohang.class, idCTgiohang);
			if (chitietgiohang != null) {
				chitietgiohang.setSoluong(quantity);
				em.merge(chitietgiohang); // Update the entity
			}

			em.getTransaction().commit(); // Commit the transaction
		} catch (Exception e) {
			e.printStackTrace();
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback(); // Rollback if any error occurs
			}
		} finally {
			em.close(); // Close the entity manager
		}

	}

	@Override
	public void insertChitietgiohang(int idGiohang, int idSanpham, double price) {

		try (EntityManager entity = JpaUtils.getEntityManager()) {
			SanPham sanpham = entity.find(SanPham.class, idSanpham);
			if (sanpham != null) {
				Giohang giohang = entity.find(Giohang.class, idGiohang);
				TypedQuery<Chitietgiohang> query = entity.createQuery(
						"SELECT ctgiohang from Chitietgiohang ctgiohang where ctgiohang.idSanpham = :idSanpham and ctgiohang.idGiohang = :idGiohang",
						Chitietgiohang.class);
				query.setParameter("idSanpham", sanpham);
				query.setParameter("idGiohang", giohang);
				List<Chitietgiohang> ctgiohanginDB = query.getResultList();
				if (giohang != null) {
					if (ctgiohanginDB.size() == 0) {
						Chitietgiohang ctgiohang = new Chitietgiohang();
						ctgiohang.setIdGiohang(giohang);
						ctgiohang.setIdSanpham(sanpham);
						ctgiohang.setSoluong(1);

						entity.getTransaction().begin();
						entity.persist(ctgiohang);
						entity.getTransaction().commit();
						
						
					} else {
						Chitietgiohang ctgiohangUpdateQuantity = ctgiohanginDB.get(0);
						updateQuantityById(ctgiohangUpdateQuantity.getId(), ctgiohangUpdateQuantity.getSoluong() + 1);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void removeChitietgiohang(int idChitietgiohang) {
		EntityManager entity = JpaUtils.getEntityManager();
		EntityTransaction transaction = entity.getTransaction();

		try {
			transaction.begin();
			Chitietgiohang ctgiohang = entity.find(Chitietgiohang.class, idChitietgiohang);
			if (ctgiohang != null) {
				entity.remove(ctgiohang);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			// Xử lý ngoại lệ
		} finally {
			entity.close();
		}
	}

}
