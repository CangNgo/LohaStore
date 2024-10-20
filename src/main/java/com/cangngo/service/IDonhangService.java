package com.cangngo.service;

import java.util.List;

import com.cangngo.model.Donhang;

public interface IDonhangService {
	int insertDonhang(Donhang donhang);

	List<Donhang> findAll();
}
