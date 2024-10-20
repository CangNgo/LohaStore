package com.cangngo.service;

import java.util.List;

import com.cangngo.model.LoaiSanPham;

public interface ILoaisanphamService {
	void insertLoaiSP(LoaiSanPham loaiSanPham);

	List<LoaiSanPham> findAll();

	void updateCategory(LoaiSanPham loaisanpham);

	LoaiSanPham findByID(int id);

	void remove(int idloai);
}
