package com.cangngo.service;

import com.cangngo.model.UserModel;

public interface ITaikhoanService {
	UserModel findUserByUsername(String username, String password);

	boolean InsertNewAccount(String name, String email, String username, String password);
	String checkName(String name);

	String checkUsername(String tendangnhap);

	String checkPassword(String matkhau, String xacnhanMatkhau);

	String checkEmail(String email);
}
