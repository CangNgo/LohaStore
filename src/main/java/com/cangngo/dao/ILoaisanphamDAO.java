package com.cangngo.dao;

import java.util.List;

import com.cangngo.model.LoaiSanPham;

public interface ILoaisanphamDAO {
	void insertLoaiSP(LoaiSanPham loaisanpham);

	List<LoaiSanPham> findAll();

	void updateCategory(LoaiSanPham loaisanpham);

	LoaiSanPham findByID(int idLoaiSP);

	void updateCategory(int idCategory);

	void remove(int idLoai);
}
