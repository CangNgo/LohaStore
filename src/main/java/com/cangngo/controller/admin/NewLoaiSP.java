package com.cangngo.controller.admin;

import java.io.IOException;

import com.cangngo.model.LoaiSanPham;
import com.cangngo.model.UserModel;
import com.cangngo.service.ILoaisanphamService;
import com.cangngo.service.impl.LoaisanphamService;
import com.cangngo.utils.SessionUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewLoaiSP
 */

@WebServlet({ "/admin-newCategory" })
public class NewLoaiSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ILoaisanphamService loaisanphamService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		loaisanphamService = new LoaisanphamService();
	}

	public NewLoaiSP() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserModel usermodel = (UserModel) SessionUtil.getInstance().getValue(request, "userModel");
		if (usermodel != null) {
			String id = request.getParameter("id");
			if (id != null) {
				int idCategory = Integer.parseInt(id);
				LoaiSanPham category = loaisanphamService.findByID(idCategory);
				if (category != null) {
					request.setAttribute("category", category);
				}
			}
			RequestDispatcher rd = request.getRequestDispatcher("/views/admin/NewLoaiSanPham.jsp");
			rd.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_login");
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		String name = request.getParameter("category");
		String describe = request.getParameter("describe");
		String idCategory = request.getParameter("idCategory");
		if (idCategory != null && action.equals("update")) {
			LoaiSanPham lsp = new LoaiSanPham();
			lsp.setIdLoaiSanpham(Integer.parseInt(idCategory));
			lsp.setTenloai(name);
			lsp.setMota(describe);
			loaisanphamService.updateCategory(lsp);
		} else if(idCategory!= null && action.equals("new")){

			if (action.equals("new")) {

				if (name != null && describe != null) {
					LoaiSanPham loaisanpham = new LoaiSanPham();
					loaisanpham.setTenloai(name);
					loaisanpham.setMota(describe);

					loaisanphamService.insertLoaiSP(loaisanpham);
					response.sendRedirect(request.getContextPath() + "/admin-newCategory");
				} else {
					response.sendRedirect(request.getContextPath() + "/admin-newCategory");
				}
			} else if (action.equals("update")) {
				String id = request.getParameter("id");

			} else if (action.equals("remove")) {

			}
		}else if(idCategory !=null && action.equals("remove")) {
			int idLoaisp = Integer.parseInt(idCategory);
			loaisanphamService.remove(idLoaisp);

			request.getRequestDispatcher("/views/admi/products.jsp").forward(request, response);
		}

	}

}
