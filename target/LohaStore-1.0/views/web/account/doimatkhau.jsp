<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="/common/taglib.jsp"%>
<div id="login" class="position-absolute top-0 bottom-0 end-0 start-0 ">
    <a href="<c:url value='/trang-chu' />" class="exit-form fs-2 text-decoration-none text-white"><i class="fa-solid fa-xmark"></i></a>
    <div class="container from-login">
        <div class="row d-flex justify-content-center c-from-login">
            <div class="col-md-4 col-sm-8 wrapper rounded-3">
                <form action="doi-mat-khau" name="forgotPassword" class="needs-validation" novalidate>
                    <h6 class="titleLogin text-center mb-5 fw-bold">Đổi mật khẩu</h6>
                    <div class="box_username box_input mb-4 text-white">
                        <label for="username" class="label-from"><i class="fa fa-user icon icon_username"></i>
                            Username</label>
                        <input type="text" name="username" id="username"
                            class="form-control {{forgotPassword.username.$touched && forgotPassword.username.$invalid?'box-input-input-invalid':''}} Username box_input_input border-0 border border-bottom border-2 rounded-0 text-white"
                            required ng-model="username">
                        <div class="valid-feedback">Looks good</div>
                        <div class="invalid-feedback">
                            Vui lòng nhập tên đăng nhấp
                        </div>
                    </div>
                    <div class="box_password box_input mb-4 text-white">
                        <div>
                            <label for="password" class="label-from"><i class="fa-solid fa-envelope"></i>
                                Email</label>
                            <div class="input-group has-validation">
                                <input type="text" name="email" id="email"
                                    class="form-control {{forgotPassword.email.$touched && forgotPassword.email.$invalid?'box-input-input-invalid':''}} Username box_input_input border-0 border border-bottom border-2 rounded-0 text-white"
                                    required minlength="8" ng-model="email">
                                <span
                                    class="input-group-text box_input_input border-0 border-2 border-bottom text-white {{forgotPassword.email.$touched && forgotPassword.email.$invalid?'box-input-input-invalid':''}}">@gmail.com</span>
                                <div class="invalid-feedback">
                                    Vui lòng nhập email
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="box_remember box_input mb-4 text-white">
                        <div class="box_remember_label box_input_title d-flex justify-content-between">
                            <a href="dang-nhap" class="text-decoration-none text-white">Quay lại đăng nhập</a>
                            <div class="box_remember_right">
                                <a href="dang-ky"
                                    class="forgotPassword box_input_label text-reset text-decoration-none">
                                    Đăng ký</a>
                            </div>
                        </div>
                    </div>

                    <div class="row  d-flex justify-content-center">
                        <div class="col-md-9">
                            <div class="box_login">
                                <button type="{{forgotPassword.$valid?'submid':'button'}}"
                                    ng-click="checkForm(forgotPassword.$valid)"
                                    class="btn btn-lg w-100 mb-4 fw-bold">Lấy mã</button>
                            </div>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>