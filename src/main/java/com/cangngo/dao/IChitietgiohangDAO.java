package com.cangngo.dao;

public interface IChitietgiohangDAO {
	void updateQuantityById(int idCTgiohang, int quantity);

	void insertChitietgiohang(int idGiohang, int idSanpham, double price);

	void removeChitietgiohang(int idChitietgiohang);
}
