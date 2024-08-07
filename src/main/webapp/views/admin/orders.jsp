<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="header">
						<h4 class="title">Quản lý đơn hàng</h4>
						<p class="category">Here is a subtitle for this table</p>
					</div>
					<div class="content table-responsive table-full-width">
						<table class="table table-hover table-striped">
							<thead>
								<th>ID ĐƠN HÀNG</th>
								<th>ID khách hàng</th>
								<th>NGÀY ĐẶT HÀNG</th>
								<th>TỔNG TIỀN</th>
								<th>TRẠNG THÁI ĐƠN HÀNG</th>
								<th>ĐỊA CHỈ GIAO HÀNG</th>
								<th>PHƯƠNG THỨC THANH TOÁN</th>
							</thead>
							<tbody>
								<c:forEach var="item" items="${listOrders }">
									<tr>
										<td>${item.id }</td>
										<td>${item.idKhachhang}</td>
										<td>${item.ngayDathang }</td>
										<td>${item.tongTien }</td>
										<td>${item.trangthaiDonhang }</td>
										<td>${item.diachiGiaohang }</td>
										<td>${item.phuongThucThanhToan }</td>
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
						<h4 class="title">Quản lý chi tiết đơn hàng</h4>
						<p class="category">Here is a subtitle for this table</p>
					</div>
					<div class="content table-responsive table-full-width">
						<table class="table table-hover">
							<thead>
								<th>ID</th>
								<th>Name</th>
								<th>Salary</th>
								<th>Country</th>
								<th>City</th>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>Dakota Rice</td>
									<td>$36,738</td>
									<td>Niger</td>
									<td>Oud-Turnhout</td>
								</tr>
								<tr>
									<td>2</td>
									<td>Minerva Hooper</td>
									<td>$23,789</td>
									<td>Curaçao</td>
									<td>Sinaai-Waas</td>
								</tr>
								<tr>
									<td>3</td>
									<td>Sage Rodriguez</td>
									<td>$56,142</td>
									<td>Netherlands</td>
									<td>Baileux</td>
								</tr>
								<tr>
									<td>4</td>
									<td>Philip Chaney</td>
									<td>$38,735</td>
									<td>Korea, South</td>
									<td>Overland Park</td>
								</tr>
								<tr>
									<td>5</td>
									<td>Doris Greene</td>
									<td>$63,542</td>
									<td>Malawi</td>
									<td>Feldkirchen in Kärnten</td>
								</tr>
								<tr>
									<td>6</td>
									<td>Mason Porter</td>
									<td>$78,615</td>
									<td>Chile</td>
									<td>Gloucester</td>
								</tr>
							</tbody>
						</table>

					</div>
				</div>
			</div>


		</div>
	</div>
</div>