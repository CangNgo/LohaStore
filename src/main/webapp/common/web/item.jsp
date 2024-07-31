<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@include file ="/common/taglib.jsp"%>
<div
	class="box-product-img border border-1 border-bottom-0 rounded-top-5">
	<img src="<c:url value="/template/web/img/${param.image}" />"
		class="rounded-5  " alt="">
</div>
<div
	class="box-product-text border border-1 r	ounded-bottom-5 border-top-0 card-body d-flex
                                flex-column">
	<p class="card-title text-center fs-5 fw-bold mb-0 c-item-title">
		<a href="<c:url value='/chi-tiet-san-pham?id=${param.id}' />" class="text-decoration-none ">${param.name }</a>

	</p>
	<p class="text-center fs-5 m-0 product-price fw-bold">
		${param.price }<span class="unit">/cây</span>
	</p>
	<button class="btn c-btn-pay rounded-4 fw-medium" onclick="addToCart(${param.id}, ${param.price })">
		Mua ngay<i class="fa-solid fa-cart-shopping"
			></i>
	</button>
</div>