package com.cangngo.service.impl;

import java.util.List;

import com.cangngo.dao.ILoaisanphamDAO;
import com.cangngo.dao.impl.LoaisanphamDAO;
import com.cangngo.model.LoaiSanPham;
import com.cangngo.service.ILoaisanphamService;

public class LoaisanphamService implements ILoaisanphamService {
	ILoaisanphamDAO loaisanphamdao;

	public LoaisanphamService() {
		loaisanphamdao = new LoaisanphamDAO();
	}

	@Override
	public void insertLoaiSP(LoaiSanPham loaiSanPham) {
		loaisanphamdao.insertLoaiSP(loaiSanPham);
	}

	@Override
	public List<LoaiSanPham> findAll() {
		// TODO Auto-generated method stub
		return loaisanphamdao.findAll();
	}

	@Override
	public void updateCategory(LoaiSanPham loaisanpham) {
		loaisanphamdao.updateCategory(loaisanpham);

	}

	@Override
	public LoaiSanPham findByID(int idLoaisp) {
		// TODO Auto-generated stub
		return loaisanphamdao.findByID(idLoaisp);
	}

	@Override
	public void remove(int idloai) {
		loaisanphamdao.remove(idloai);
		
	}

}
