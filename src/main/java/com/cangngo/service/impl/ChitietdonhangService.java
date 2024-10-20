package com.cangngo.service.impl;

import java.util.List;

import com.cangngo.dao.IChitietdonhangDAO;
import com.cangngo.dao.impl.ChitietdonhangDAO;
import com.cangngo.model.CartItem;
import com.cangngo.service.IChitietdonhangService;

public class ChitietdonhangService implements IChitietdonhangService {
	IChitietdonhangDAO ctdhDAO;

	public ChitietdonhangService() {
		ctdhDAO = new ChitietdonhangDAO();
	}

	@Override
	public boolean insertCTDonhang(int idDonhang, List<CartItem> listCart) {

		return ctdhDAO.insertCTDonhang(idDonhang, listCart);
	}

}
