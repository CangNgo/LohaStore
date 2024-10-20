package com.cangngo.service.impl;

import java.util.List;

import com.cangngo.dao.IDonhangDAO;
import com.cangngo.dao.impl.DonhangDAO;
import com.cangngo.model.Donhang;
import com.cangngo.service.IDonhangService;

public class DonhangService implements IDonhangService {
	IDonhangDAO donhangDAO;
	public DonhangService() {
		donhangDAO = new DonhangDAO();
	}

	@Override
	public int insertDonhang(Donhang donhang) {
		// TODO Auto-generated method stub
		return donhangDAO.insertDonhang(donhang);
	}

	@Override
	public List<Donhang> findAll() {
		// TODO Auto-generated method stub
		return donhangDAO.findAll();
	}


}
