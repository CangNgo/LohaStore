package com.cangngo.fillter;

import java.io.IOException;

import com.cangngo.constant.SystemConstant;
import com.cangngo.model.UserModel;
import com.cangngo.utils.SessionUtil;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenrizationFillter implements Filter {
	private ServletContext context;

	public AuthenrizationFillter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
		Filter.super.init(filterConfig);
	}

	@Override
	public void doFilter(ServletRequest servletRequeset, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequeset;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String url = request.getRequestURI();
		if (url.contains("/admin")) {
			UserModel usermodel = (UserModel) SessionUtil.getInstance().getValue(request, "userModel");
			if (usermodel != null) {
				if (usermodel.getVaitro().equals(SystemConstant.ADMIN)) {
					chain.doFilter(servletRequeset, servletResponse);
				} else if (usermodel.getVaitro().equals(SystemConstant.USER)) {
					response.sendRedirect(
							request.getContextPath()
									+ "/account/dang-nhap?action=login&message=not_permission&alert=danger");
				}
			} else {
				response.sendRedirect(
						request.getContextPath() + "/account/dang-nhap?action=login&message=not_login&alert=danger");
			}
		} else {
			chain.doFilter(servletRequeset, servletResponse);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		Filter.super.destroy();
	}

}
