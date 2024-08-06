package com.cangngo.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import com.cangngo.constant.SystemConstant;
import com.cangngo.model.UserModel;
import com.cangngo.service.ITaikhoanService;
import com.cangngo.service.impl.TaikhoanService;
import com.cangngo.utils.FormUtil;
import com.cangngo.utils.SessionUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Giohang
 */
@WebServlet({ "/account/dang-nhap", "/account/dang-xuat" })
public class Dangnhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITaikhoanService taikhoanService;

	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");

	@Override
	public void init() throws ServletException {
		super.init();
		taikhoanService = new TaikhoanService();

	}

	public Dangnhap() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("/dang-nhap")) {
			String action = request.getParameter("action");
			String alert = request.getParameter("alert");
			// lấy thông tin thông báo từ filter
			String message = request.getParameter("message");
			if (action != null && action.equals("login")) {
				// thông báo
				if (alert != null && message != null) {
					request.setAttribute("alert", alert);
					request.setAttribute("message", resourceBundle.getString(message));
				}
				RequestDispatcher rd = request.getRequestDispatcher("/views/web/account/dangnhap.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/trang-chu");
			}
			// Nếu đăng xuất thì chuyển về request trang-chu
		} else if (uri.contains("/dang-xuat")) {
			// xóa thông tin đăng nhập
			SessionUtil.getInstance().removeValue(request, "userModel");
			response.sendRedirect(request.getContextPath() + "/trang-chu");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		String action = request.getParameter("action");
		if (action != null & action.equals("login")) {
			UserModel model = FormUtil.toModel(UserModel.class, request);
			if (!(model.getUsername().isEmpty() && model.getPassword().isEmpty())) {
				UserModel userModel = taikhoanService.findUserByUsername(model.getUsername(), model.getPassword());
				if (userModel != null && userModel.getPassword().equals(password)) {
					if (userModel.getVaitro().equals(SystemConstant.ADMIN)) {
						SessionUtil.getInstance().putValue(request, "userModel", userModel);
						response.sendRedirect(request.getContextPath() + "/admin-home");
					} else {
						SessionUtil.getInstance().putValue(request, "userModel", userModel);
						response.sendRedirect(request.getContextPath() + "/trang-chu");
					}
				} else {
					request.getSession().setAttribute("alert", "danger");
					request.getSession().setAttribute("message", "Tài khoản hoặc mật khẩu không đúng");
					response.sendRedirect(request.getContextPath() + "/account/dang-nhap?action=login");
				}
			} else {
				request.getSession().setAttribute("alert", "danger");
				request.getSession().setAttribute("message", "Tài khoản hoặc mật khẩu chưa được nhập ");
				response.sendRedirect(request.getContextPath() + "/account/dang-nhap?action=login");
			}
		}
	}
}
