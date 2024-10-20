package com.cangngo.service.impl;

import com.cangngo.dao.IKhachhangDAO;
import com.cangngo.dao.impl.KhachhangDAO;
import com.cangngo.model.KhachHang;
import com.cangngo.service.IKhachhangService;

public class KhachhangService implements IKhachhangService {
	IKhachhangDAO khDAO;

	public KhachhangService() {
		khDAO = new KhachhangDAO();
	}

	@Override
	public KhachHang findKhachhangByid(int idKhachhang) {
		return khDAO.findKhachhangByid(idKhachhang);
	}

	@Override
	public KhachHang updateProfile(KhachHang kh) {
		return khDAO.updateProfile(kh);
	}

}
