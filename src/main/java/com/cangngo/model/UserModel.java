package com.cangngo.model;

public class UserModel {
	private String name;
	private String username;
	private String password;
	private int idKhachhang;
	private int idGiohang;
	private String vaitro;
	private String email;

	public UserModel(String name, String username, String password, int idKhachhang, int idGiohang, String vaitro,
			String email) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.idKhachhang = idKhachhang;
		this.idGiohang = idGiohang;
		this.vaitro = vaitro;
		this.email = email;
	}

	public UserModel(String username, String password, String name, int idKhachhang, int idGiohang, String vaitro) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.idKhachhang = idKhachhang;
		this.idGiohang = idGiohang;
		this.vaitro = vaitro;
	}


	public UserModel() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getIdKhachhang() {
		return idKhachhang;
	}

	public void setIdKhachhang(int idKhachhang) {
		this.idKhachhang = idKhachhang;
	}

	public int getIdGiohang() {
		return idGiohang;
	}

	public void setIdGiohang(int idGiohang) {
		this.idGiohang = idGiohang;
	}

	public String getVaitro() {
		return vaitro;
	}

	public void setVaitro(String vaitro) {
		this.vaitro = vaitro;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



}
