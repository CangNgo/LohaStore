package com.cangngo.controller.admin;

import java.io.IOException;
import java.util.List;

import com.cangngo.model.Donhang;
import com.cangngo.model.UserModel;
import com.cangngo.service.IDonhangService;
import com.cangngo.service.impl.DonhangService;
import com.cangngo.utils.SessionUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/admin-orders" })
public class OrderController extends HttpServlet {
	IDonhangService donhangService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		donhangService = new DonhangService();
	}
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserModel usermodel = (UserModel) SessionUtil.getInstance().getValue(request, "userModel");
		if (usermodel != null) {
			List<Donhang> listOrders = donhangService.findAll();
			request.setAttribute("listOrders", listOrders);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/orders.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_login");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
