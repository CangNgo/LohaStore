package com.cangngo.service;

import com.cangngo.model.KhachHang;

public interface IKhachhangService {
	public KhachHang findKhachhangByid(int idKhachhang);

	KhachHang updateProfile(KhachHang kh);
}
