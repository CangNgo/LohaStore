<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="header">
						<h4 class="title">Quản lý Sản phẩm</h4>
						<p class="category">Tổng toàn sản phẩm</p>
					</div>
					<div class="content table-responsive table-full-width">
						<table class="table table-hover table-striped">
							<thead>
								<th>Mã sản phẩm</th>
								<th>Tên sản phẩm</th>
								<th>Loại sản phẩm</th>
								<th>Mô tả</th>
								<th>Giá</th>
								<th>số lượng tồn kho</th>
								<th>hình</th>
							</thead>
							<tbody>
								<c:forEach var="product" items="${listProducts }">
									<tr>
										<td>${product.id }</td>
										<td>${product.tenSanpham }</td>
										<td>${product.idLoaiSanpham.tenloai }</td>
										<td>${product.mota }</td>
										<td>${product.gia }</td>
										<td>${product.soluong }</td>
										<td><img
											src="<c:url value='/template/web/img/${product.hinh }'/>"
											alt="" style="width: 30px; height: 30px;"></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="card card-plain">
					<div class="header">
						<h4 class="title">Quản lý loại sản phẩm</h4>
						<p class="category">Sản phẩm theo đơn hàng</p>
					</div>
					<div class="content table-responsive table-full-width">
						<table class="table table-hover" id="categoryTable">
							<thead>
								<th>ID</th>
								<th>Tên loại sản phẩm</th>
								<th>Mô tả</th>

							</thead>
							<tbody>

								<c:forEach var="category" items="${listCategory }">
									<tr>
										<td>${category.idLoaiSanpham }</td>
										<td>${category.tenloai }</td>
										<td>${category.mota }</td>
										<td><a href ="admin-newCategory?action=update&id=${category.idLoaiSanpham }">Sửa</a></td>
										<td><a href ="admin-newCategory?action=remove&id=${category.idLoaiSanpham }">Xóa</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
document.addEventListener('DOMContentLoaded', function() {
    var table = document.getElementById('categoryTable');
    var tbody = table.getElementsByTagName('tbody')[0];
    
    tbody.addEventListener('click', function(e) {
        var target = e.target;
        while (target && target.nodeName !== 'TR') {
            target = target.parentNode;
        }
        if (target) {
            var categoryId = target.getAttribute('data-id');
            if (categoryId) {
                window.location.href = '/admin-newCategory?id=' + encodeURIComponent(categoryId);
            }
        }
    });
});
</script>
</html>
