package com.cangngo.model;

public class UserModel extends AbstractModel {
	private String taikhoan;
	private String matkhau;
	private boolean vaitro;

	public UserModel(String taikhoan, String matkhau, boolean vaitro) {
		super();
		this.taikhoan = taikhoan;
		this.matkhau = matkhau;
		this.vaitro = vaitro;
	}

	public UserModel() {
		super();
	}

	public String getTaikhoan() {
		return taikhoan;
	}

	public void setTaikhoan(String taikhoan) {
		this.taikhoan = taikhoan;
	}

	public String getMatkhau() {
		return matkhau;
	}

	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}

	public boolean isVaitro() {
		return vaitro;
	}

	public void setVaitro(boolean vaitro) {
		this.vaitro = vaitro;
	}

}
