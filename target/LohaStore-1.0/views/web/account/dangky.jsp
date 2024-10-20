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
				<form action='<c:url value ="/account/dang-ky"/>' name="dangky"
					class="needs-validation" novalidate method="post">
					<h2 class="titleLogin text-center mb-2 fw-bold">Đăng ký</h2>
					<div class="box_name box_input mb-4 text-white">
						<label for="name" class="label-from"><i
							class="fa-solid fa-user"></i> Họ tên</label> <input type="text"
							name="name" id="name"
							class="form-control Username box_input_input border-0 border border-bottom border-2 rounded-0 text-white"
							ng-model="name">
						<c:if test="${not empty messageNameString}">
							<div class="position-absolute text-warning">${messageNameString}</div>
						</c:if>
					</div>
					<div class="box_username box_input mb-4 text-white">
						<label for="username" class="label-from"><i
							class="fa-solid fa-user"></i> Tên đăng nhập</label> <input type="text"
							name="username" id="username"
							class="form-control Username box_input_input border-0 border border-bottom border-2 rounded-0 text-white"
							ng-model="username">
						<c:if test="${not empty messageUsername}">
							<div class="position-absolute text-warning">${messageUsername}</div>
						</c:if>
					</div>

					<div class="box_password box_input mb-4 text-white">
						<label for="email" class="label-from"><i
							class="fa-solid fa-envelope"></i> Email</label>
						<div class="input-group has-validation">
							<input type="text" name="email" id="email"
								class="form-control Username box_input_input border-0 border border-bottom border-2 rounded-0 text-white"
								ng-model="email" placeholder="examp@gmail.com" > 
						</div>
						<c:if test="${not empty messageEmail}">
							<div class="position-absolute text-warning">${messageEmail}</div>
						</c:if>
					</div>

					<div class="box_password box_input mb-4 text-white">
						<div>
							<label for="password" class="label-from"><i
								class="fa-solid fa-lock"></i> Mật khẩu</label> <input type="password"
								name="password" id="password"
								class="form-control Username box_input_input border-0 border border-bottom border-2 rounded-0 text-white"
								ng-model="password">
							<c:if test="${not empty messagePassword}">
								<div class="position-absolute text-warning">${messagePassword}</div>
							</c:if>
						</div>
					</div>
					<div class="box_password box_input mb-4 text-white">
						<div>
							<label for="confirmPassword" class="label-from"><i
								class="fa-solid fa-lock"></i> Xác nhận mật khẩu</label> <input
								type="password" name="confirmPassword" id="confirmPassword"
								class="form-control Username box_input_input border-0 border border-bottom border-2 rounded-0 text-white"
								ng-model="confirmPassword">
							<c:if test="${not empty messageConfirmPassword}">
								<div class="position-absolute text-warning">${messageConfirmPassword}</div>
							</c:if>
						</div>
					</div>
					<div class="box_remember mb-4 box_input text-white">
						<div
							class="box_remember_label box_input_title d-flex justify-content-between">
							<a href="dang-nhap" class="text-decoration-none text-white">Quay
								lại đăng nhập</a>
						</div>
					</div>
					<c:if test="${not empty messageSignUp }">
						<div class="alert alert-${alert }">${messageSignUp }</div>
					</c:if>
					<input type="hidden" id="sign-up" name="action" value="sign-up">
					<div class="row  d-flex justify-content-center">
						<div class="col-md-9">
							<div class="box_login">
								<button type="submit" class="btn btn-lg w-100 fw-bold"
									ng-click="formSubmitted = true">Đăng ký</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>