<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="wrapper">
	<div class="container-fluid">
		<div class="box-banner-hoalen">
			<div class="img-banner">
				<img src="/LohaStore/template/web/img/HOATLIPCANH.jpg" alt="">
			</div>
		</div>
	</div>
</div>
<!-- end banner  -->
<!-- content  -->
<div id="content">
	<div
		class="col-md-8 col-sm-8 offset-md-2 offset-sm-2 mt-5 c-product-line">
		<hr>
	</div>
	<div class="container list-product-hoalen">
		<div class="product-hot-list">
			<div class="row mt-5">
				<div class="col-md-3">
					<%@include file="/common/web/minimenu.jsp"%>
				</div>
				<div class="col-md-9">
					<div class="row">
						<div
							class="col-md-4 col-sm-6 card border-0 rounded-5 product-hot-item mb-3"
							ng-repeat="item in mockhoa |filter: {name : searchTextMockhoa.searchName} | limitTo:limit:start">
							<div
								class="box-product-img border border-1 border-bottom-0 rounded-top-5">
								<img ng-src="/LohaStore/template/web/img/{{item.image}}"
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
									{{item.price}}<span class="unit">/cây</span>
								</p>
								<button class="btn c-btn-pay rounded-4 fw-medium">
									Mua ngay<i class="fa-solid fa-cart-shopping"
										ng-click="addToCart(item)"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
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
					ng-click="changePage(page + 1)">
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