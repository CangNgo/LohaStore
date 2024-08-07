package com.cangngo.controller.web;

import java.io.IOException;

import com.cangngo.model.KhachHang;
import com.cangngo.model.UserModel;
import com.cangngo.service.IKhachhangService;
import com.cangngo.service.impl.KhachhangService;
import com.cangngo.utils.FormUtil;
import com.cangngo.utils.SessionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet({ "/user-profile" })
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IKhachhangService khService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		khService = new KhachhangService();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel usermodel = (UserModel) SessionUtil.getInstance().getValue(request, "userModel");
		if (usermodel != null) {
			KhachHang kh = khService.findKhachhangByid(usermodel.getIdKhachhang());
			request.setAttribute("profile", kh);
			request.getRequestDispatcher("/views/web/user.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/account/dang-nhap?action=login&message=not_login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserModel usermodel = (UserModel) SessionUtil.getInstance().getValue(request, "userModel");
		if (usermodel != null) {
			// lấy thông tin từ form
			String username = request.getParameter("idTaikhoan");
			java.sql.Date ngaysinh = java.sql.Date.valueOf(request.getParameter("birthday"));
			KhachHang kh = new KhachHang();
			kh = FormUtil.toModel(KhachHang.class, request);
			kh.setNgaysinh(ngaysinh);
			kh.setId(usermodel.getIdKhachhang());
			khService.updateProfile(kh);
			response.sendRedirect(request.getContextPath() + "/user-profile");
		} else {
			response.sendRedirect(request.getContextPath() + "/account/dang-nhap?action=login&message=not_login");
		}
	}

}
