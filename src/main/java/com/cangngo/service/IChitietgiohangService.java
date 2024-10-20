package com.cangngo.service;

public interface IChitietgiohangService {
	void updateQuantityById(int idCTGiohang, int quantity);

	void insertChitietgiohang(int idGiohang, int idSanpham, double price);

	void removeChitietgiohang(int idChitietgiohang);
}
