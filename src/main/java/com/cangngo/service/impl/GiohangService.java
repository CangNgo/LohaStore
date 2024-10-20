package com.cangngo.service.impl;

import java.util.List;

import com.cangngo.dao.IGiohangDAO;
import com.cangngo.dao.impl.GiohangDAO;
import com.cangngo.model.CartItem;
import com.cangngo.service.IGiohangService;

public class GiohangService implements IGiohangService {
	private final IGiohangDAO giohangDAO;

	public GiohangService() {
		giohangDAO = new GiohangDAO();
	}

	@Override
	public List<CartItem> findAllByIdUser(int giohangid) {
		// TODO Auto-generated method stub
		return giohangDAO.findAllByIdUser(giohangid);
	}

}
