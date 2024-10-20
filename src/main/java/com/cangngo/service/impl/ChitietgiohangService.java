package com.cangngo.service.impl;

import com.cangngo.dao.IChitietgiohangDAO;
import com.cangngo.dao.impl.ChitietgiohangDAO;
import com.cangngo.service.IChitietgiohangService;

public class ChitietgiohangService implements IChitietgiohangService {
	private final IChitietgiohangDAO ctGiohangDAO;

	public ChitietgiohangService() {
		ctGiohangDAO = new ChitietgiohangDAO();
	}

	@Override
	public void updateQuantityById(int idCTGiohang, int quantity) {
		ctGiohangDAO.updateQuantityById(idCTGiohang, quantity);
    }

	@Override
	public void insertChitietgiohang(int idGiohang, int idSanpham, double price) {
		ctGiohangDAO.insertChitietgiohang(idGiohang, idSanpham, price);

	}

	@Override
	public void removeChitietgiohang(int idChitietgiohang) {
		ctGiohangDAO.removeChitietgiohang(idChitietgiohang);
		
	}

}
