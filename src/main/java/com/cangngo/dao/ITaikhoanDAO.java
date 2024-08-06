package com.cangngo.dao;

import com.cangngo.model.UserModel;

public interface ITaikhoanDAO {
	UserModel findUserByUsername(String username, String password);

	boolean InsertNewAccount(String name, String email, String username, String password);

	boolean findEmaiAlreadyExists(String email);

	boolean findUsernameAlreadyExists(String usename);

}
