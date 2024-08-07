package com.cangngo.dao;

import com.cangngo.model.KhachHang;

public interface IKhachhangDAO {
	public KhachHang findKhachhangByid(int idKhachhang);

	KhachHang updateProfile(KhachHang kh);
}
