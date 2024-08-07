package com.cangngo.service;

import java.util.List;

import com.cangngo.model.CartItem;

public interface IChitietdonhangService {
	boolean insertCTDonhang(int idDonhang, List<CartItem> listCart);
}
