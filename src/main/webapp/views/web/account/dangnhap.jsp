<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/common/taglib.jsp"%>
<div id="login" class="position-absolute top-0 bottom-0 end-0 start-0 ">
	<a href="<c:url value='/trang-chu'/>"
		class="exit-form fs-2 text-decoration-none text-white"><i
		class="fa-solid fa-xmark"></i></a>
	<div class="container from-login">
		<div class="row d-flex justify-content-center c-from-login">
			<div class="col-md-4 col-sm-8 wrapper rounded-3">
				<form action=" <c:url value ="/account/dang-nhap" />" method="post" name="login"
					class="needs-validation" novalidate>
					<h2 class="titleLogin text-center mb-5 fw-bold">Đăng nhập</h2>
					<div class="box_username box_input mb-4 text-white">
						<label for="username" class="label-from "><i
							class="fa fa-user icon icon_username "></i> Username</label> <input
							type="text" name="username" id="username"
							class="form-control Username box_input_input {{login.username.$touched && login.username.$invalid?'box-input-input-invalid':''}} border-0 border border-bottom border-2 rounded-0 text-white"
							required minlength="8" ng-model="username"> <span
							ng-show="login.username.$touched && login.username.$invalid"
							class="text-warning position-absolute"> Vui lòng nhập tên
							đăng nhập </span>
					</div>
					<div class="box_password box_input mb-4 text-white">
						<div>
							<label for="password" class="label-from"><i
								class="fa-solid fa-lock"></i> Password</label> <input type="password"
								name="password" id="password"
								class="form-control password box_input_input {{login.password.$touched && login.password.$invalid?'box-input-input-invalid':''}} border-0 border border-bottom border-2 rounded-0 text-white"
								required minlength="8" ng-model="password"> <span
								ng-show="login.password.$touched && login.password.$invalid"
								class="text-warning position-absolute"> Vui lòng nhập mật
								khẩu </span>
						</div>
					</div>
					<div class="box_remember box_input mb-4 text-white">
						<div
							class="box_remember_label box_input_title d-flex justify-content-between">
							<a href="dang-ky" class="text-decoration-none text-white">Đăng
								ký</a>
							<div class="box_remember_right">
								<a href="doi-mat-khau"
									class="forgotPassword box_input_label text-reset text-decoration-none">Quên
									mật khẩu</a>
							</div>
						</div>
					</div>
					
					<input type="hidden" value="login" name="action" />
					<div class="row  d-flex justify-content-center">
						<div class="col-md-9">
							<div class="box_login">
								<button type="{{login.$valid?'submit':'button'}}"
									ng-click="checkForm(login.$valid)"
									class="btn btn-lg w-100 mb-4 fw-bold">Login</button>
							</div>
						</div>
					</div>
					<p class="or d-flex justify-content-center text-white">or</p>
					<div class="box-login-different d-flex justify-content-center mb-4">
						<img
							src="<c:url value='/template/web/img/icon _facebook icon_.png' />"
							alt="" class="me-2"> <img
							src="<c:url value='/template/web/img/google.png' />" alt="">
					</div>
				</form>
			</div>
		</div>
	</div>
</div>