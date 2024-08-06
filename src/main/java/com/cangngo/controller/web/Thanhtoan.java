package com.cangngo.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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

/**
 * Servlet implementation class Thanhtoan
 */

@WebServlet({ "/thanh-toan" })
public class Thanhtoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	IChitietgiohangService ctgiohangService;
	IGiohangService giohangService;

	@Override
	public void init() throws ServletException {
		super.init();
		ctgiohangService = new ChitietgiohangService();
		giohangService = new GiohangService();
	}

	public Thanhtoan() {
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
		String action = request.getParameter("action");
		String[] productIds;
		if (action.equals("dat-hang")) {
			String productsParam = request.getParameter("products");
			if (productsParam != null && !productsParam.isEmpty()) {
				productIds = productsParam.split(",");

				// Lấy sản phẩm từ giỏ hàng theo id
				UserModel usermodel = (UserModel) SessionUtil.getInstance().getValue(request, "userModel");
				if (usermodel != null) {
					int giohangid = usermodel.getIdGiohang();
					List<CartItem> cartItem = giohangService.findAllByIdUser(giohangid);

					// Xử lý các ID sản phẩm
					List<CartItem> cartItemInOrder = new ArrayList<>();
					for (String productId : productIds) {
						int idCTGiohang = Integer.parseInt(productId);
						for (CartItem item : cartItem) {
							if (item.getIdCTGioHang() == idCTGiohang) {
								cartItemInOrder.add(item);
							}
						}
					}
					// tính tổng tiền của đơn hàng
					double totalOrder = cartItemInOrder.stream()
							.mapToDouble(cartItemInorder -> cartItemInorder.getGia() * cartItemInorder.getSoLuong())
							.sum();

					request.getSession().setAttribute("cartItemInOrder", cartItemInOrder);
					request.getSession().setAttribute("totalOrder", totalOrder);
				} else {
					response.sendRedirect(request.getContextPath() + "/dang-nhap?action=login&message=not_login");
				}
			}
			request.getRequestDispatcher("/views/web/thanhtoan.jsp").forward(request, response);
		} else if (action.equals("thanh-toan")) {
			// hiển thị số lượng sản phẩm không có đủ số lượng
			String alert = request.getParameter("alert");
			String productNotEnough = request.getParameter("message");
			if (productNotEnough != null) {
				request.setAttribute("alert", alert);
				request.setAttribute("messageNotenough", productNotEnough);
			}
			response.sendRedirect(request.getContextPath() + "/thanh-toan?action=dat-hang");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/web/thanhtoan.jsp").forward(request, response);

	}

}
