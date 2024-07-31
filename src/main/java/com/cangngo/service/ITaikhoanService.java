package com.cangngo.service;

import com.cangngo.model.Taikhoan;

public interface ITaikhoanService {
	Taikhoan findUserByUsername(String username, String password);
}
