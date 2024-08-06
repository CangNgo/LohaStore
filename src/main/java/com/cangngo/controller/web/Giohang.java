package com.cangngo.controller.web;

import java.io.IOException;
import java.util.List;

import com.cangngo.model.CartItem;
import com.cangngo.model.UserModel;
import com.cangngo.service.IChitietgiohangService;
import com.cangngo.service.IGiohangService;
import com.cangngo.service.impl.ChitietgiohangService;
import com.cangngo.service.impl.GiohangService;
import com.cangngo.utils.SessionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Giohang
 */
@WebServlet({ "/gio-hang", "/update-quantity", "/them-moi-chi-tiet-giohang", "/xoa-chi-tiet-san-pham" })
public class Giohang extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IGiohangService giohangService;
	private IChitietgiohangService ctGiohangService;
	private IChitietgiohangService ctgiohangService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		giohangService = new GiohangService();
		ctGiohangService = new ChitietgiohangService();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Giohang() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("gio-hang")) {
			UserModel usermodel = (UserModel) SessionUtil.getInstance().getValue(request, "userModel");
			if (usermodel != null) {
				int giohangid = usermodel.getIdGiohang();
				List<CartItem> cartItem = giohangService.findAllByIdUser(giohangid);
				request.setAttribute("cartItem", cartItem);
			}
			request.getRequestDispatcher("/views/web/giohang.jsp").forward(request, response);
		} else if (uri.contains("update-quantity")) {
			int productId = Integer.parseInt(request.getParameter("productId"));
			int quantity = Integer.parseInt(request.getParameter("quantity"));

			ctGiohangService.updateQuantityById(productId, quantity);

			// Call service layer to update quantity
//			giohangService.updateQuantity(chiTietGioHangId, quantity, action);

			// Redirect back to cart page
		} else if (uri.contains("/them-moi-chi-tiet-giohang")) {
			// lấy thông tin đăng nhập từ session
			UserModel usermodel = (UserModel) SessionUtil.getInstance().getValue(request, "userModel");
			if(usermodel!= null) {
				try {
					int productId = Integer.parseInt(request.getParameter("productId"));
					double price = Double.parseDouble(request.getParameter("priceProduct"));
					int idGiohang;
					// kiểm tra xem đã đăng nhập chưa
					if (usermodel != null) {
						// lấy id giỏ hàng từ thông tin đăng nhạp
						idGiohang = usermodel.getIdGiohang();
						ctgiohangService.insertChitietgiohang(idGiohang, productId, price);
						// cập nhật lại số lượng sản phẩm trong giỏ hàng
						HttpSession session = request.getSession();
						String cartNumber = (String) session.getAttribute("cartNumber");
						List<CartItem> listCart = giohangService.findAllByIdUser(idGiohang);
						String totalItemInCart = String.valueOf(listCart.size());
						session.setAttribute("cartNumber", totalItemInCart);
					}
				} catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}else {
				response.sendRedirect(
						request.getContextPath() + "/account/dang-nhap?action=login&message=not_login&alert=danger");
			}
		} else if (uri.contains("/xoa-chi-tiet-san-pham")) {
			try {
				int idChitietgiohang = Integer.parseInt(request.getParameter("idChitietgiohang"));
				ctgiohangService.removeChitietgiohang(idChitietgiohang);
				UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(request, "userModel");
				if (userModel != null) {

					// cập nhật lại số lượng sản phẩm có trong giỏ hàng
					int idGiohang = userModel.getIdGiohang();
					HttpSession session = request.getSession();
					String cartNumber = (String) session.getAttribute("cartNumber");
					if (cartNumber == null) {
						List<CartItem> listCart = giohangService.findAllByIdUser(idGiohang);
						String totalItemInCart = String.valueOf(listCart.size());
						session.setAttribute("cartNumber", totalItemInCart);
					} else {
						session.setAttribute("cartNumber", cartNumber);
					}
				}
				request.getRequestDispatcher("/views/web/giohang.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else {
			request.getRequestDispatcher("/views/web/giohang.jsp").forward(request, response);
		}
	}

}
