package com.cangngo.service;

import java.util.List;

import com.cangngo.model.CartItem;

public interface IGiohangService {
	List<CartItem> findAllByIdUser(int idKhacgiohangidhHang);

}
