package com.cangngo.controller.web;

import java.io.IOException;

import com.cangngo.model.SanPham;
import com.cangngo.service.ISanphamService;
import com.cangngo.service.impl.SanphamService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Chitietsanpham
 */

@WebServlet({ "/chi-tiet-san-pham" })
public class Chitietsanpham extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ISanphamService sanphamService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		sanphamService = new SanphamService();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chitietsanpham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter("idProduct");
		try {
			int id = Integer.parseInt(idStr);
			SanPham product = sanphamService.findByIdProduct(id);
			if (product != null) {
				request.setAttribute("product", product);
			}
			request.getRequestDispatcher("/views/web/chitietsanpham.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
