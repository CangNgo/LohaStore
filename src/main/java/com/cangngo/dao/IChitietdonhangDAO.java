package com.cangngo.dao;

import java.util.List;

import com.cangngo.model.CartItem;

public interface IChitietdonhangDAO {
	boolean insertCTDonhang(int idDonhang, List<CartItem> listCart);
}
