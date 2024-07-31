<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/views/web/Slider.jsp"%>
<div id="content">
	<div class="top_product-pay ">
		<div class="container">
			<div class="row top_product-pay-text c-product-title c-product-line">
				<div
					class="col-md-4 col-sm-4 me-0 p-0 d-flex justify-content-md-end align-middle">
					<hr class="m-3 w-75 mt-5 ">
				</div>
				<div class="col-md-4 col-sm-4">
					<p class="h2 text-uppercase text-center fw-bolder mt-4 mb-4">sản
						phẩm bán chạy</p>
				</div>
				<div
					class="col-md-4 col-sm-4  p-0 d-flex justify-content-md-start align-middle ">
					<hr class="m-3 w-75 mt-5 ">
				</div>
			</div>
		</div>
		<div class="top_product_content position-relative">
			<div class="container">
				<div class="row">
					<div class="col-md-6 col-sm-6 offset-1">
						<div class="row">
							<div class="text-banner mt-5">
								<p class="text-banner-title fw-bolder mb-0">Hoa len Handmade</p>
								<p class="slogan-banner">Tặng em một bó hoa không tàn cùng
									một mối tình không phai</p>
							</div>
						</div>
						<div class="row list-item">
							<div class="col-md-4 col-sm-4">
								<div class="banner-item">
									<div class="box-img mb-1">
										<img src="/LohaStore/template/web/img/HOACUCHOAMI .jpg" alt=""
											class="rounded-4">
									</div>
									<p class="name-item text-center fs-5">Hoa tu lip</p>
								</div>
							</div>
							<div class="col-md-4 col-sm-4">
								<div class="banner-item">
									<div class="box-img mb-1">
										<img src="/LohaStore/template/web/img/HOACUCHOAMI .jpg" alt=""
											class="rounded-4">
									</div>
									<p class="name-item text-center fs-5">Hoa tu lip</p>
								</div>
							</div>
							<div class="col-md-4 col-sm-4">
								<div class="banner-item">
									<div class="box-img mb-1">
										<img src="/LohaStore/template/web/img/HOACUCHOAMI .jpg" alt=""
											class="rounded-4">
									</div>
									<p class="name-item text-center fs-5">Hoa tu lip</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="background-img position-absolute">
				<img src="/LohaStore/template/web/img/HOAHONGTRANG.jpg" alt="">
			</div>
			<div class="background-logo position-absolute">
				<img src="/LohaStore/template/web/img/logoremove.png" alt="">
			</div>
		</div>
	</div>
	<div class="top_product-hot">
		<div class="container" data-ng-hide="searchText.searchName !=''">
			<div class="row top_product-pay-text c-product-title c-product-line">
				<div
					class="col-md-4 col-sm-4 me-0 p-0 d-flex justify-content-md-end align-middle">
					<hr class="m-3 w-75 mt-5 ">
				</div>
				<div class="col-md-4 col-sm-4">
					<p class="h2 text-uppercase text-center fw-bolder mt-4 mb-4">sản
						phẩm nổi bật</p>
				</div>
				<div
					class="col-md-4 col-sm-4  p-0 d-flex justify-content-md-start align-middle ">
					<hr class="m-3 w-75 mt-5 ">
				</div>
			</div>
		</div>
		<div class="container">
			<div class="banner-product-hot"
				data-ng-hide="searchText.searchName !=''">
				<div class="row banner-product-list">
					<div class="col-md-6 col-sm-6 banner-product-item">
						<img src="/LohaStore/template/web/img/HOAHONGGHEPCANH.jpg"
							class="rounded-5" alt="">
					</div>
					<div class="col-md-6 col-sm-6 banner-product-item">
						<img src="/LohaStore/template/web/img/HOAHONGGHEPCANH.jpg"
							class="rounded-5" alt="">
					</div>
				</div>
			</div>
			<div class="product-hot-list">
				<div class="row mt-5">
					<c:forEach var="item" items="${listSanPham }">
						<div
							class="col-md-3 col-sm-6 card border-0 rounded-5 product-hot-item mb-3">
							<jsp:include page="/common/web/item.jsp">
								<jsp:param name="id" value="${item.id}" />
								<jsp:param name="name" value="${item.tenSanpham}" />
								<jsp:param name="price" value="${item.gia}" />
								<jsp:param name="image"
									value="${item.hinh}" />
							</jsp:include>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="page container">
			<div class="row">
				<ul
					class="pagination col-md-4 col-sm-4 offset-4 d-flex justify-content-center">
					<li
						class="page-item me-3 {{page==1?'disabled':''}} c-btn-pagination"
						ng-click="changePage(page-1)">
						<button class="page-link rounded-5" aria-label="Previous">
							<span aria-hidden="true">&laquo;</span>
						</button>
					</li>
					<li
						class="page-item  {{page == trang ? 'background-page' : ''}} me-3 c-btn-pagination"
						ng-repeat="trang in pageList"><a class="page-link rounded-5"
						ng-click="changePage(trang)">{{trang}}</a></li>
					<li class="page-item me-3 c-btn-pagination"
						ng-click="changePage(page +1)">
						<button
							class="page-link {{page ==totalPage?'disabled':''}} rounded-5"
							aria-label="Next">
							<span aria-hidden="true" class="">&raquo;</span>
						</button>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="infomation-ship ">
		<div class="container">
			<div class="row mb-5">
				<div class="col-md-6 col-sm-12 offset-md-2">
					<div class="row mt-5 free-ship rounded-pill ps-2 pt-4 pb-4">
						<div class="col-md-4 col-sm-4 box-icon">
							<i class="fa-solid  fa-truck-fast ps-4 icon-truck-freeship"></i>
						</div>
						<div class="col-md-8 col-sm-8 free-shiop-content">
							<p class="h2 fw-bold free-ship-content-title text-start">Giao
								hàng miễn phí</p>
							<p class="fs-2 free-ship-content-text">Cho đơn hàng từ 400k</p>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-sm-12 offset-md-4">
					<div class="row mt-5 free-ship rounded-pill ps-2 pt-4 pb-4">
						<div
							class="col-md-8 col-sm-8 free-shiop-content pe-0 ps-5 text-end">
							<p class=" h2 fw-bold free-ship-content-title">Đổi trả hàng</p>
							<p class="fs-2 free-ship-content-text">Trong 3 ngày đầu tiên</p>
						</div>
						<div class="col-md-4 col-sm-4 pe-0 ps-5">
							<div class="boxdoitra rounded-4">
								<img src="/LohaStore/template/web/img/doitra.jpg"
									class="rounded-pill" alt="">
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-sm-12 offset-md-2">
					<div class="row mt-5 free-ship rounded-pill ps-2 pt-4 pb-4">
						<div class="col-md-4 col-sm-4  box-icon">
							<i class="fa-solid fa-headphones icon-truck-freeship"></i>
						</div>
						<div class="col-md-8 col-sm-8 free-shiop-content text-start">
							<p class="h2 fw-bold free-ship-content-title">Tư vấn 24/7</p>
							<p class="fs-2 free-ship-content-text">Hỗ trợ mọi thắc mắc</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
