package com.cangngo.controller.admin;

import java.io.IOException;

import com.cangngo.utils.SessionUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/admin-home", "/admin-dang-xuat" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("/admin-dang-xuat")) {
			// xóa thông tin đăng nhập
			SessionUtil.getInstance().removeValue(request, "userModel");
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/ProductManager.jsp");
		rd.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}

}
