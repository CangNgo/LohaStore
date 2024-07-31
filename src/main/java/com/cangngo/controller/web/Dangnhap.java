package com.cangngo.controller.web;

import java.io.IOException;

import com.cangngo.model.Taikhoan;
import com.cangngo.service.ITaikhoanService;
import com.cangngo.service.impl.TaikhoanService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Giohang
 */
@WebServlet({ "/account/dang-nhap" })
public class Dangnhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITaikhoanService taikhoanService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		taikhoanService = new TaikhoanService();

	}

	public Dangnhap() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/views/web/account/dangnhap.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Taikhoan user = taikhoanService.findUserByUsername(username, password);
		if (user != null && user.getMatKhau().equals(password)) {
			if (user.isVaitro()) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath() + "/admin-home");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect(request.getContextPath() + "/trang-chu");
			}

		} else {
			response.sendRedirect(request.getContextPath() + "/account/dang-nhap");
		}
	}

}
