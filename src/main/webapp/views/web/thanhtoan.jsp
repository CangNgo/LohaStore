<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- content  -->
<div id="pay">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-4 col-sm-12 c-pay-left offset-md-1">
                <p class="h5">Đơn hàng ({{cartNumber}} Sản phẩm)</p>
                <table class="table text-center align-middle table-product">
                    <tbody class=" border-top border-bottom border-black">
                        <tr class="product-item" ng-repeat="item in cart">
                            <td>
                                <div class="box-information-product d-flex ms-3">
                                    <div class="box-img ms-2 me-2 c-img-cart">
                                        <img src="asset/img/{{item.image}}" class="rounded-4" alt="">
                                    </div>
                                    <div class="box-text ms-5 d-flex accordion flex-column">
                                        <label class="label-form fs-5 fw-bold align-self-start" for="choie-product">Hoa
                                            {{item.name}}</label>
                                        <div class="choice-color mt-2 mb-2">
                                            <select class="form-control-sm border-0 rounded-3">
                                                <option value="xanh dương">Xanh dương</option>
                                                <option value="hồng">Hồng</option>
                                                <option value="trắng">Trắng</option>
                                                <option value="tím">Tím</option>
                                            </select>
                                        </div>
                                        <div class="btn-group box-quantity justify-content-center">
                                            <p class="quantity">Số lượng {{item.quantity}}</p>
                                        </div>
                                    </div>
                                </div>
                            </td>
                            <td class="fs-5 box-temp-price-value">{{item.priceTotal|currency:'':0}}<span
                                    class="unit ">/cây</span>
                            </td>
                        </tr>

                    </tbody>
                </table>
                <div class="box-voucher d-flex justify-content-between flex-column">
                    <div class="col-md-12 d-flex box-apply-voucher">
                        <div class="col-md-8"><input type="text" class="form-control border-black c-input-pay"
                                placeholder="Mã giảm giá"></div>
                        <div class="col-md-4 d-flex justify-content-center">
                            <button class="btn btn-primary ps-4 pe-4">Áp dụng</button>
                        </div>
                    </div>
                    <hr class="col-md-12 col-sm-12">
                </div>
                <div class="box-temp-price ">
                    <div class="box-temp d-flex justify-content-between">
                        <p class="box-temp-price-text fw-bold m-0">Tạm tính:</p>
                        <p class="box-temp-price-value fw-bold fs-6 m-0">{{sumPrice | number}}<span>đ</span></p>
                    </div>
                    <hr class="col-md-12 col-sm-12">
                </div>
                <div class="box-sum-price ">
                    <div class="box-price d-flex justify-content-between">
                        <p class="box-price-text fw-bold m-0 fs-4">Tổng tiền:</p>
                        <p class="box-price-value fw-bold fs-5 m-0">{{sumPrice |number}}<span>đ</span></p>
                    </div>
                </div>
                <div class="box-pay ">
                    <div class="box-pay-item d-flex justify-content-between">
                        <p class="backtocart m-0 d-flex align-items-center fs-6">
                            <a href="#!/giohang"><i class="fa-solid fa-chevron-left "></i> Quay về giỏ hàng</a>
                        </p>
                        <form action="#!success">
                            <button type="{{address.$valid?'submit':'button'}}" ng-click="checkForm(address.$valid)"
                                class="btn text-uppercase fs-5 c-input-pay">Thanh toán</button>
                        </form>
                    </div>
                </div>

            </div>
            <div class="col-md-6 col-sm-12 ms-5">
                <p class="h5">Thông tin nhận hàng</p>
                <form action="" name="address">
                    <div class="address">
                        <div class="form-email mb-2">
                            <input type="email" id="email" name="email"
                                class="form-control {{address.email.$touched && address.email.$invalid?'box-input-input-invalid':''}}"
                                placeholder="Email" required ng-model="email">
                        </div>
                        <div class="form-name mb-2">
                            <input type="text" id="name" name="name"
                                class="form-control  {{address.name.$touched && address.name.$invalid?'box-input-input-invalid':''}}"
                                placeholder="Họ và tên" ng-model="name" required>
                        </div>
                        <div class="form-phoneNumber mb-2">
                            <input type="text" id="phoneNumber" name="phoneNumber"
                                class="form-control  {{address.phoneNumber.$touched && address.phoneNumber.$invalid?'box-input-input-invalid':''}}"
                                placeholder="Số điện thoại" ng-model="phoneNumber" required>
                        </div>
                        <div class="form-provine mb-2">
                            <select name="provine" id="provine" class="form-select" ng-model="selectedTinh"
                                ng-options="tinh.Name for tinh in listAddress">
                                <option value="" disabled selected hidden>Tỉnh/Thành phố</option>
                            </select>
                        </div>
                        <div class="form-district mb-2">
                            <select name="district" id="district" class="form-select" ng-model="selectedHuyen"
                                ng-options="huyen.Name for huyen in selectedTinh.Districts" ng-disabled="!selectedTinh">
                                <option value="" disabled selected hidden>Huyện/Quận</option>
                            </select>
                        </div>
                        <div class="form-ward mb-2">
                            <select name="ward" id="ward" class="form-select" ng-model="selectedXa"
                                ng-options="xa.Name for xa in selectedHuyen.Wards" ng-disabled="!selectedHuyen">
                                <option value="" disabled selected hidden>Xã/Phường</option>
                            </select>
                        </div>
                        <div class="form-address mb-2">
                            <input type="text" id="addressClient" name="addressClient" class="form-control"
                                placeholder="Địa chỉ (Tùy chọn)">
                        </div>
                        <div class="form-note form-floating">
                            <textarea name="" id="note" class="form-control" style="height: 100px;"></textarea>
                            <label for="note">Ghi chú</label>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- end content  -->