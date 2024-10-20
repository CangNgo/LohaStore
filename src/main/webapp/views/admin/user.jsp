<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/taglib.jsp"%>
<div class="content">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-8">
				<div class="card">
					<div class="header">
						<h4 class="title">Thông tin cá nhân</h4>
					</div>
					<div class="content">
						<form class="container" action="user-profile" method="post">
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label>Tên đăng nhập</label> <input type="text"
											name="username" class="form-control"
											placeholder="Tên đăng nhập"
											value="${profile.idTaikhoan.taiKhoan }">
									</div>
								</div>
								<div class="col-md-3 ">
									<div class="form-group">
										<label for="exampleInputEmail1">Email</label> <input
											type="email" name="email" class="form-control"
											placeholder="Email" value="${profile.email }">
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label>Họ tên</label> <input type="text" class="form-control"
											name="hoten" placeholder="Họ tên" value="${profile.hoten }">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label>Số điện thoại</label> <input type="text"
											name="soDienthoai" class="form-control"
											placeholder="Số điện thoại" value="${profile.soDienthoai }">
									</div>
								</div>
								<div class="col-md-3">
									<div class="form-group">
										<label for="exampleInputEmail1">Ngày sinh</label> <input
											type="date" name="birthday" class="form-control"
											placeholder="2024-05-06" value="${profile.ngaysinh}">
									</div>
								</div>

							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label>Địa chỉ</label> <input type="text" class="form-control"
											name="diachi" placeholder="Địa chỉ" value="${profile.diachi}">
									</div>
								</div>
							</div>

							<div class="row">

								<div class="col-md-6">
									<div class="form-group">
										<label>Quốc gia</label> <input type="text"
											class="form-control" name="country" placeholder="Quốc gia"
											value="Việt Nam">
									</div>
								</div>

							</div>

							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label>Giới thiệu</label>
										<textarea rows="5" class="form-control"
											placeholder="Here can be your description" value="Mike">Cang muốn làm fullStack</textarea>
									</div>
								</div>
							</div>

							<button type="submit"
								class="btn btn-info btn-fill pull-right mt-2 mb-2">Cập
								nhật thông tin</button>
							<div class="clearfix"></div>
						</form>
						<form action="<c:url value ='/account/dang-xuat' />">
							<button type="submit"
								class="btn btn-info btn-fill pull-right mt-2 mb-2">Đăng
								xuất</button>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="card card-user">
					<div class="image">
						<img
							src="https://ununsplash.imgix.net/photo-1431578500526-4d9613015464?fit=crop&fm=jpg&h=300&q=75&w=400"
							alt="..." />
					</div>
					<div class="content">
						<div class="author">
							<a href="#"> <img class="avatar border-gray"
								src="<c:url value ='/template/admin/assets/img/faces/face-3.jpg' />"
								alt="..." />

								<h4 class="title"
									style="align-items: center; display: flex; flex-direction: column;">
									${profile.hoten }<br /> <small>${profile.diachi }</small>
								</h4>
							</a>
						</div>
						<p class="description text-center">
							"Lamborghini Mercy <br> Your chick she so thirsty <br>
							I'm in that two seat Lambo"
						</p>
					</div>
					<hr>
					<div class="text-center">
						<button href="#" class="btn btn-simple">
							<i class="fa fa-facebook-square"></i>
						</button>
						<button href="#" class="btn btn-simple">
							<i class="fa fa-twitter"></i>
						</button>
						<button href="#" class="btn btn-simple">
							<i class="fa fa-google-plus-square"></i>
						</button>
					</div>
				</div>
			</div>

		</div>
	</div>
</div>