package com.cangngo.service.impl;

import java.util.List;

import com.cangngo.dao.ISanphamDAO;
import com.cangngo.dao.impl.SanphamDAO;
import com.cangngo.model.SanPham;
import com.cangngo.service.ISanphamService;

public class SanphamService implements ISanphamService {
	private final ISanphamDAO sanphamDAO;
	public SanphamService() {
		sanphamDAO = new SanphamDAO();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<SanPham> findAll() {
		// TODO Auto-generated method stub
		return sanphamDAO.findAll();
	}

	@Override
	public List<SanPham> findByCategoryByProduct(String tenLoai) {

		return sanphamDAO.findByCategoryByProduct(tenLoai);
	}

	@Override
	public SanPham findByIdProduct(int id) {
		// TODO Auto-generated method stub
		return sanphamDAO.findByIdProduct(id);
	}
}
