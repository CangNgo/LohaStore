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
				<form action="account/dang-ky" name="dangky" class="needs-validation"
					novalidate>
					<h2 class="titleLogin text-center mb-5 fw-bold">Đăng ký</h2>
					<div class="box_username box_input mb-4 text-white">
						<label for="username" class="label-from"><i
							class="fa-solid fa-user"></i> Tên đăng nhập</label> <input type="text"
							name="username" id="username"
							class="form-control Username {{signUp.username.$touched &&
                            signUp.username.$invalid?'box-input-input-invalid':''}} box_input_input border-0 border border-bottom border-2 rounded-0 text-white"
							required ng-model="username">
						<div class="position-absolute text-warning"
							ng-show="signUp.username.$touched && signUp.username.$invalid">
							Vui lòng nhập tên đăng nhập</div>
					</div>
					<div>
						<div class="box_password box_input mb-4 text-white">
							<label for="password" class="label-from"><i
								class="fa-solid fa-envelope"></i> Email</label>
							<div class="input-group has-validation">
								<input type="text" name="email" id="email"
									class="form-control Username {{signUp.email.$touched &&
                            signUp.email.$invalid?'box-input-input-invalid':''}} box_input_input border-0 border border-bottom border-2 rounded-0 text-white"
									required ng-model="email"> <span
									class="input-group-text {{signUp.email.$touched &&
                            signUp.email.$invalid?'box-input-input-invalid':''}} box_input_input border-0 border-2 border-bottom text-white">@gmail.com</span>
							</div>
							<div class="position-absolute text-warning"
								ng-show="signUp.email.$touched && signUp.email.$invalid">
								Vui lòng nhập email</div>
						</div>
						<div class="box_password box_input mb-4 text-white">
							<div>
								<label for="password" class="label-from"><i
									class="fa-solid fa-lock"></i> Mật khẩu</label> <input type="password"
									name="password" id="password"
									class="form-control Username {{signUp.password.$touched &&
                            signUp.password.$invalid?'box-input-input-invalid':''}} box_input_input border-0 border border-bottom border-2 rounded-0 text-white"
									required minlength="8" ng-model="password">
								<div class="position-absolute text-warning"
									ng-show="signUp.password.$touched && signUp.password.$invalid">
									Vui lòng nhập mật khẩu</div>
							</div>
						</div>
						<div class="box_password box_input mb-4 text-white">
							<div>
								<label for="password" class="label-from"><i
									class="fa-solid fa-lock"></i> Xác nhận mật khẩu</label> <input
									type="password" name="confirmPassword" id="password"
									class="form-control Username {{signUp.confirmPassword.$touched &&
                            signUp.confirmPassword.$invalid?'box-input-input-invalid':''}} box_input_input border-0 border border-bottom border-2 rounded-0 text-white"
									required minlength="8" ng-model="confirmPassword">
								<div class="position-absolute text-warning"
									ng-show="signUp.confirmPassword.$touched && signUp.confirmPassword.$invalid">
									Vui lòng nhập lại mật khẩu</div>
							</div>
						</div>
						<div class="box_remember mb-4 box_input text-white">
							<div
								class="box_remember_label box_input_title d-flex justify-content-between">
								<a href="dang-nhap" class="text-decoration-none text-white">Quay
									lại đăng nhập</a>
							</div>
						</div>
						<div class="row  d-flex justify-content-center">
							<div class="col-md-9">
								<div class="box_login">
									<button type="{{signUp.$valid?'submit':'button'}}"
										ng-click="checkForm(signUp.$valid)"
										class="btn btn-lg w-100 fw-bold">Đăng ký</button>
								</div>
							</div>
						</div>
						<p class="or d-flex justify-content-center">or</p>
						<div
							class="box-login-different mb-1 d-flex justify-content-center">
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