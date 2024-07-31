package com.cangngo.service.impl;

import com.cangngo.dao.ITaikhoanDAO;
import com.cangngo.dao.impl.TaikhoanDAO;
import com.cangngo.model.Taikhoan;
import com.cangngo.service.ITaikhoanService;

public class TaikhoanService implements ITaikhoanService {
	private ITaikhoanDAO taikhoanDAO;

	public TaikhoanService() {
		taikhoanDAO = new TaikhoanDAO();
	}

	@Override
	public Taikhoan findUserByUsername(String username, String password) {
		// TODO Auto-generated method stub
		return taikhoanDAO.findUserByUsername(username, password);
	}

}
