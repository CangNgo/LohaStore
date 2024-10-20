package com.cangngo.service.impl;

import java.util.regex.Pattern;

import com.cangngo.dao.ITaikhoanDAO;
import com.cangngo.dao.impl.TaikhoanDAO;
import com.cangngo.model.UserModel;
import com.cangngo.service.ITaikhoanService;

public class TaikhoanService implements ITaikhoanService {
	private ITaikhoanDAO taikhoanDAO;

	public TaikhoanService() {
		taikhoanDAO = new TaikhoanDAO();
	}

	@Override
	public UserModel findUserByUsername(String username, String password) {
		// kiểm tra người dùng dựa trên username
		return taikhoanDAO.findUserByUsername(username, password);
	}

	@Override
	public String checkName(String name) {
		if (name.trim().isEmpty()) {
			return "Họ tên không được để trống";
		}
		// kiểm tra họ tên không được có ký tự đặc biệt
		String regex = "[0-9_+-=()*&^%$#@!]";
		if (name.matches(".*[" + regex + "].*")) {
			return "tên không được phép có ký tự đặc biệt";
		}
		return null;
	}

	@Override
	public String checkUsername(String tendangnhap) {

		if (tendangnhap.trim().isEmpty()) {
			return "Tên đăng nhập không được để trống";
		}

		// kiểm tra xem tài khoàn đã tồn tại trong db chưa
		if (taikhoanDAO.findUsernameAlreadyExists(tendangnhap)) {
			return "Tài khoản đã tồn tại";
		}
		return null;
	}

	@Override
	public String checkPassword(String matkhau, String xacnhanMatkhau) {
		if (matkhau.trim().isEmpty() || xacnhanMatkhau.isEmpty()) {
			return "Mật khẩu và xác nhận mật khẩu không giống nhau";
		}
		if (matkhau.length() < 8) {
			return "Mật khẩu phải lớn hơn 8 ký tự";
		}
		return null;
	}

	@Override
	public String checkEmail(String email) {
		if (email == null || email.trim().isEmpty()) {
			return "Email không được để trống";
		}

		// Không tự động thêm "@gmail.com"

		// Regex tổng quát hơn cho email
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		if (!Pattern.matches(regex, email)) {
			return "Vui lòng nhập đúng định dạng email";
		}

		// Nếu chỉ muốn chấp nhận địa chỉ Gmail
		if (!email.toLowerCase().endsWith("@gmail.com")) {
			return "Vui lòng sử dụng địa chỉ Gmail";
		}

		// Kiểm tra xem email đã tồn tại trong db chưa
		if (taikhoanDAO.findEmaiAlreadyExists(email)) {
			return "Email đã tồn tại";
		}

		return null; // Email hợp lệ
	}

	@Override
	public boolean InsertNewAccount(String name, String email, String username, String password) {
		// thêm tài khoản mới
		return taikhoanDAO.InsertNewAccount(name, email, username, password);
	}

	public static void main(String[] args) {
		TaikhoanService service = new TaikhoanService();
		System.out.println(service.checkUsername("cang"));
	}

}
