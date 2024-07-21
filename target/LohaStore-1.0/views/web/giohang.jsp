<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- content  -->
<div class="container">
    <div class="row">
        <div class="col-md-10 col-sm-12 offset-md-1">
            <table class="table text-center align-middle table-product">
                <thead>
                    <tr>
                        <th class="text-start ps-5">Thông tin sản phẩm</th>
                        <th>Đơn giá</th>
                        <th>Số lượng</th>
                        <th>Thành tiền</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="product-item" ng-repeat="item in cart">
                        <td>
                            <div class="box-information-product d-flex ms-3">
                                <input type="checkbox" name="choie-product" id="choie-product"
                                    class="align-self-start ">
                                <div class="box-img ms-2 me-2 c-img-cart">
                                    <img src="asset/img/{{item.image}}" class="rounded-4" alt="">
                                </div>
                                <div class="box-text ms-5 d-flex accordion flex-column">
                                    <label class="label-form fs-5 fw-bold align-self-start"
                                        for="choie-product">{{item.name}}</label>
                                    <div class="choice-color mt-2 mb-2">
                                        <select class="form-control-sm border-0 rounded-3">
                                            <option value="xanh dương">Xanh dương</option>
                                            <option value="hồng">Hồng</option>
                                            <option value="trắng">Trắng</option>
                                            <option value="tím">Tím</option>
                                        </select>
                                    </div>
                                    <div class="btn btn-remove border border-black" ng-click="removeItem(item)">Xóa
                                    </div>
                                </div>
                            </div>
                        </td>
                        <td class="fs-5">{{item.price |currency:'':0}}<span class="unit ">/cây</span></td>
                        <td>
                            <div class="btn-group">
                                <button type="butotn" class="btn btn-lg border border-black rounded-0"
                                    ng-click="downQuantity(item)">-</button>
                                <input type="number" disabled
                                    class="form-control border-black rounded-0 text-center bg-white border-start-0 c-input-quantity"
                                    value="{{item.quantity}}" style="text-align: center;">
                                <button type="butotn" class="btn btn-lg border border-black rounded-0"
                                    ng-click="upQuantity(item)">+</button>
                            </div>
                        </td>
                        <td class="fs-5">{{item.priceTotal|currency:'' :0}}</td>
                    </tr>
                </tbody>
            </table>
            <div class="row price-totle mb-3">
                <div class="col-md-4 col-sm-12 offset-md-8">
                    <div class="total d-flex justify-content-between">
                        <label for="" class="label-form fs-5 fw-bold">Tổng tiền:</label>
                        <p class="fs-5 total-text">{{sumPrice|currency:'' :0}}<span>đ</span></p>
                    </div>
                    <div class="row box-btn-pay">
                        <div class="col-md-12 col-sm-12">
                            <div class="btn btn-lg text-uppercase w-100 btn-pay">
                                <a href="#!/thanhtoan" class="text-black text-decoration-none">Thanh toán</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<!-- end content  -->
<!-- footer  -->