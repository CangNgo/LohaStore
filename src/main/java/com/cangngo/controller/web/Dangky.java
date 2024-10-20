package com.cangngo.controller.web;

import java.io.IOException;

import com.cangngo.service.ITaikhoanService;
import com.cangngo.service.impl.TaikhoanService;
import com.cangngo.utils.SessionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Giohang
 */
@WebServlet({ "/account/dang-ky" })
public class Dangky extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ITaikhoanService taikhoanService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		taikhoanService = new TaikhoanService();
	}

	public Dangky() {
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
		String alert = request.getParameter("alert");
		String message = request.getParameter("message");
		message = "danger";
		message = "danger";
		if (action != null && action.equals("sign-up")) {
			if (alert != null && message != null) {
				request.setAttribute("alert", "");
				request.setAttribute("message", "");
			}
			request.getRequestDispatcher("/views/web/account/dangky.jsp").forward(request, response);
		} else {
			request.setAttribute("alert", "");
			request.setAttribute("message", "");
			request.getRequestDispatcher("/views/web/account/dangky.jsp").forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		if (action != null && action.equals("sign-up")) {
			String messageNameString = taikhoanService.checkName(name);
			String messageUsername = taikhoanService.checkUsername(username);
			String messagePassword = taikhoanService.checkPassword(password, confirmPassword);
			String messageEmail = taikhoanService.checkEmail(email);
			// Kiểm tra xem có bất kỳ trường nào trống hoặc null không
			if (messageNameString == null && messageUsername == null && messagePassword == null
					&& messageEmail == null) {

				// Nếu tất cả các trường đều hợp lệ, tiếp tục xử lý đăng ký
				// Thêm logic xử lý đăng ký ở đây
				boolean registrationSuccess = taikhoanService.InsertNewAccount(name, email, username, password);
				if (registrationSuccess) {
					response.sendRedirect(request.getContextPath() + "/account/dang-nhap?action=login");
				} else {
					response.sendRedirect(
							request.getContextPath() + "/account/dang-ky?action=sign-up");
				}
			} else {

				// Nếu có trường trống, set các thông báo lỗi
				// Lưu các thông báo lỗi vào session
				SessionUtil.getInstance().putValue(request, "messageNameString", messageNameString);
				SessionUtil.getInstance().putValue(request, "messageUsername", messageUsername);
				SessionUtil.getInstance().putValue(request, "messagePassword", messagePassword);
				SessionUtil.getInstance().putValue(request, "messageEmail", messageEmail);

				// Chuyển hướng lại trang đăng ký
				response.sendRedirect(request.getContextPath() + "/account/dang-ky?action=sign-up");

			}
		}
	}

	// Phương thức hỗ trợ để kiểm tra null hoặc chuỗi rỗng
	private boolean isNullOrEmpty(String str) {
		return str == null || str.trim().isEmpty();
	}
}
