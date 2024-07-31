package com.cangngo.controller.web;

import java.io.IOException;
import java.util.List;

import com.cangngo.model.CartItem;
import com.cangngo.model.SanPham;
import com.cangngo.service.IGiohangService;
import com.cangngo.service.ISanphamService;
import com.cangngo.service.impl.GiohangService;
import com.cangngo.service.impl.SanphamService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Home
 */
@WebServlet({ "/trang-chu" })
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ISanphamService sanphamService;
	private IGiohangService giohangService;

    /**
     * @see HttpServlet#HttpServlet()
     */
	@Override
	public void init() throws ServletException {
		super.init();
		sanphamService = new SanphamService();
		giohangService = new GiohangService();
	}
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<SanPham> listSanPham = sanphamService.findAll();
		HttpSession session = request.getSession();
		String cartNumber = (String) session.getAttribute("cartNumber");
		if (cartNumber == null) {
			List<CartItem> listCart = giohangService.findAllByIdUser(2);
			String totalItemInCart = String.valueOf(listCart.size());
			session.setAttribute("cartNumber", totalItemInCart);
		}else {
			session.setAttribute("cartNumber", cartNumber);
		}
		request.getSession().setAttribute("listSanPham", listSanPham);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
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
