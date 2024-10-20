package com.cangngo.dao;

import java.util.List;

import com.cangngo.model.Donhang;

public interface IDonhangDAO {
	int insertDonhang(Donhang donhang);

	List<Donhang> findAll();
}
