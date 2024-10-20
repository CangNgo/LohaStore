package com.cangngo.dao;

import java.util.List;

import com.cangngo.model.CartItem;

public interface IGiohangDAO {
	List<CartItem> findAllByIdUser(int giohangid);

}
