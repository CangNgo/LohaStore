<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file="/common/taglib.jsp"%>
<div id="login" class="position-absolute top-0 bottom-0 end-0 start-0 ">
    <a href="<c:url value ='/trang-chu' />" class="exit-form fs-2 text-decoration-none text-white"><i class="fa-solid fa-xmark"></i></a>
    <div class="container from-login">
        <div class="row d-flex justify-content-center c-from-login">
            <div class="col-md-4 col-sm-8 wrapper rounded-3">
                <form action="account/lay-ma" name="layma" class="needs-validation" novalidate>
                    <h2 class="titleLogin text-center mb-5 fw-bold">Đổi mật khẩu</h2>
                    <div class="box_username box_input mb-4 text-white">
                        <label for="username" class="label-from"><i class="fa-solid fa-check"></i>
                            Mã xác nhận</label>
                        <input type="text" name="code" id="code"
                            class="form-control Username {{layma.code.$touched &&
                            layma.code.$invalid?'box-input-input-invalid':''}} box_input_input border-0 border border-bottom border-2 rounded-0 text-white"
                            required ng-model="code">
                        <div class="position-absolute text-warning"
                            ng-show="layma.code.$iz`nvalid && layma.code.$touched">
                            Vui lòng nhập mã xác nhận
                        </div>
                    </div>
                    <div class="box_password box_input mb-4 text-white">
                        <div>
                            <label for="password" class="label-from"><i class="fa-solid fa-lock"></i>
                                Mật khẩu mới</label>
                            <input type="password" name="newPassword" id="newPassword"
                                class="form-control Username {{layma.newPassword.$touched &&
                            layma.newPassword.$invalid?'box-input-input-invalid':''}} box_input_input border-0 border border-bottom border-2 rounded-0 text-white" required
                                minlength="8" ng-model="newPassword">
                            <div class="position-absolute text-warning"
                                ng-show="layma.newPassword.$touched && layma.newPassword.$invalid">
                                Vui lòng nhập mật khẩu mới
                            </div>
                        </div>
                    </div>
                    <div class="box_password box_input mb-4 text-white">
                        <div>
                            <label for="password" class="label-from"><i class="fa-solid fa-lock"></i>
                                Xác nhận mật khẩu</label>
                            <input type="password" name="confirmPassword" id="confirmPassword"
                                class="form-control Username {{layma.confirmPassword.$touched &&
                            layma.confirmPassword.$invalid?'box-input-input-invalid':''}} box_input_input border-0 border border-bottom border-2 rounded-0 text-white" required
                                minlength="8" ng-model="confirmPassword">
                            <div class="position-absolute text-warning"
                                ng-show="layma.confirmPassword.$touched && layma.confirmPassword.$invalid">
                                Mật khẩu vừa nhập không khớp
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
                                <button type="{{layma.$valid?'submit':'button'}}" ng-click="checkForm(layma.$valid)"
                                    class="btn btn-lg w-100 mb-4 fw-bold">Đổi mật khẩu</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>