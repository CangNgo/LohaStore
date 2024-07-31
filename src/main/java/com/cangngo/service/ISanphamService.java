package com.cangngo.service;

import java.util.List;

import com.cangngo.model.SanPham;

public interface ISanphamService {
	List<SanPham> findAll();

	List<SanPham> findByCategoryByProduct(String tenLoai);

	SanPham findByIdProduct(int id);
}
