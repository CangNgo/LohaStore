<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
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
						<c:forEach var="item" items="${listProductMockhoa }">
								<div
									class="col-md-4 col-sm-6 card border-0 rounded-5 product-hot-item mb-3">
									<jsp:include page="/common/web/item.jsp">
										<jsp:param name="id" value="${item.id}" />
										<jsp:param name="name" value="${item.tenSanpham}" />
										<jsp:param name="price" value="${item.gia}" />
										<jsp:param name="image" value="${item.hinh}" />
									</jsp:include>
								</div>
							</c:forEach>
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