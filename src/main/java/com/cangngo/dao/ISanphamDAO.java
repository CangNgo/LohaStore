package com.cangngo.dao;

import java.util.List;

import com.cangngo.model.SanPham;

public interface ISanphamDAO {
	List<SanPham> findAll();

	List<SanPham> findByCategoryByProduct(String tenLoai);

	SanPham findByIdProduct(int id);
}
