package com.cangngo.controller.admin;

import java.io.IOException;
import java.util.List;

import com.cangngo.model.LoaiSanPham;
import com.cangngo.model.SanPham;
import com.cangngo.model.UserModel;
import com.cangngo.service.ILoaisanphamService;
import com.cangngo.service.ISanphamService;
import com.cangngo.service.impl.LoaisanphamService;
import com.cangngo.service.impl.SanphamService;
import com.cangngo.utils.SessionUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/admin-products" })
public class ProductsController extends HttpServlet {
	ISanphamService sanphamService;
	ILoaisanphamService loaisanphamService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		sanphamService = new SanphamService();
		loaisanphamService = new LoaisanphamService();
	}
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserModel usermodel = (UserModel) SessionUtil.getInstance().getValue(request, "userModel");
		if (usermodel != null) {
			List<SanPham> listProducts = sanphamService.findAll();
			List<LoaiSanPham> listCategory = loaisanphamService.findAll();
			request.setAttribute("listProducts", listProducts);
			request.setAttribute("listCategory", listCategory);
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/products.jsp");
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
