package com.cangngo.controller.web;

import java.io.IOException;
import java.util.List;

import com.cangngo.model.SanPham;
import com.cangngo.service.ISanphamService;
import com.cangngo.service.impl.SanphamService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Giohang
 */
@WebServlet({ "/moc-khoa" })
public class Mockhoa extends HttpServlet {
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
    public Mockhoa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
//		System.out.println(category);
		List<SanPham> listProductMockhoa = sanphamService.findByCategoryByProduct(category);
		request.setAttribute("listProductMockhoa", listProductMockhoa);
		request.getRequestDispatcher("/views/web/mockhoa.jsp").forward(request, response);
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
