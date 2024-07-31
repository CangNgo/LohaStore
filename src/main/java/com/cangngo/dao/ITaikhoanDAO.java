package com.cangngo.dao;

import com.cangngo.model.Taikhoan;

public interface ITaikhoanDAO {
	Taikhoan findUserByUsername(String username, String password);

}
