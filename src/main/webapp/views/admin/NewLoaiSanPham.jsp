<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<form action="admin-newCategory?action=new&idCategory=${category.idLoaiSanpham }" method="post">
	<div class="row">
		<div class="col-md-4">
			<div class="form-group">
				<label for="exampleInputEmail1">Tên loại sản phẩm</label> <input
					type="text" name="category" value="${category.tenloai }" class="form-control" placeholder="Email">
			</div>
		</div>
		<div class="col-md-4">
			<div class="form-group">
				<label for="exampleInputEmail1">Mô tả</label> <input
					type="text" name="describe" value ="${category.mota }" class="form-control" placeholder="Email">
			</div>
		</div>
	</div>

	<button type="submit" class="btn btn-info btn-fill pull-right">
		Cập nhật(Thêm mới)</button>
	<div class="clearfix"></div>
</form>