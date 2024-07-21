<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div
	class="box-product-img border border-1 border-bottom-0 rounded-top-5">
	<img data-ng-src="/LohaStore/template/web/img/{{item.image}}"
		class="rounded-5  " alt="">
</div>
<div
	class="box-product-text border border-1 rounded-bottom-5 border-top-0 card-body d-flex
                                flex-column">
	<p class="card-title text-center fs-5 fw-bold mb-0 c-item-title">
		<a href="#!/chitietsanpham/{{item.id}}"
			class="text-decoration-none text-reset
                                    ">{{item.name}}</a>
	</p>
	<p class="text-center fs-5 m-0 product-price fw-bold">
		{{item.price | currency: '' : 0}}<span class="unit">/cây</span>
	</p>
	<button class="btn c-btn-pay rounded-4 fw-medium">
		Mua ngay<i class="fa-solid fa-cart-shopping"
			data-ng-click="addToCart(item)"></i>
	</button>
</div>