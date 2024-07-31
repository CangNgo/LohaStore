<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-sm-6 mb-4">
				<div class="box-img">
					<img src="<c:url value = "/template/web/img/${product.hinh }" />"
						class="rounded-4" alt="">
				</div>
			</div>
			<div class="col-md-4 col-sm-6 ">
				<div class="box-title mb-4">
					<p class="h1">${product.tenSanpham }</p>
				</div>
				<div class="box-brand mb-4">
					<p class="h5 ">
						<strong>Phân loại: </strong>Hoa len
					</p>
				</div>
				<div class="choice-color mt-2 mb-2 d-flex justify-content-centerv ">
					<p class="m-0 text-center d-flex align-items-center fw-bold">Màu
						sắc:</p>
					<select class="form-control-sm border-0 rounded-3">
						<option value="xanh dương">Xanh dương</option>
						<option value="hồng">Hồng</option>
						<option value="trắng">Trắng</option>
						<option value="tím">Tím</option>
					</select>
				</div>
				<div class="fw-bold c-text-price mb-4">
					<p class="m-0">
					<p class="fs-3 m-0">
						${product.gia }<span>đ</span>
					</p>
					<p class="text-decoration-line-through m-0 fs-5 ps-2">
						${product.gia +10000 } <span>đ</span>
					</p>
				</div>
				<div class="box-note mb-4">
					<p class="h5">
						<strong>Ghi chú: </strong>Lorem, ipsum dolor sit amet consectetur
						adipisicing elit. Quod, adipisci.
					</p>
				</div>

				<div class="box-pay">
					<div class="btn fw-bold box-btn-addtocart mb-4">
						<p class="m-0">
							<i class="fa-solid fa-cart-shopping"></i> Thêm vào giỏ hàng
						</p>
					</div>
					<div class="btn fw-bold box-btn-price mb-4">
						<p class="m-0">Mua ngay</p>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-6 border-start">
				<div
					class="related-product d-flex justify-content-center flex-column   ">
					<p class="h4">Sản phẩm liên quan</p>
					<div class="box-related-product ">
						<div class="row">
							<div class="col-md-4">
								<div class="box-item-releted">
									<div class="box-item-img">
										<img src="/ASM/asset/img/GAUVALAVENDER.jpg" alt=""
											class="w-100 rounded-5">
									</div>
									<div class="box-item-info text-center">
										<p class="name m-0 p-0">Hoa gấu</p>
										<p class="price m-0 p-0 ">15000</p>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="box-item-releted">
									<div class="box-item-img">
										<img src="/ASM/asset/img/GAUVALAVENDER.jpg" alt=""
											class="w-100 rounded-5">
									</div>
									<div class="box-item-info text-center">
										<p class="name m-0 p-0">Hoa gấu</p>
										<p class="price m-0 p-0 ">15000</p>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="box-item-releted">
									<div class="box-item-img">
										<img src="/ASM/asset/img/GAUVALAVENDER.jpg" alt=""
											class="w-100 rounded-5">
									</div>
									<div class="box-item-info text-center">
										<p class="name m-0 p-0">Hoa gấu</p>
										<p class="price m-0 p-0 ">15000</p>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="box-item-releted">
									<div class="box-item-img">
										<img src="/ASM/asset/img/GAUVALAVENDER.jpg" alt=""
											class="w-100 rounded-5">
									</div>
									<div class="box-item-info text-center">
										<p class="name m-0 p-0">Hoa gấu</p>
										<p class="price m-0 p-0 ">15000</p>
									</div>
								</div>
							</div>

							<div class="col-md-4">
								<div class="box-item-releted">
									<div class="box-item-img">
										<img src="/ASM/asset/img/GAUVALAVENDER.jpg" alt=""
											class="w-100 rounded-5">
									</div>
									<div class="box-item-info text-center">
										<p class="name m-0 p-0">Hoa gấu</p>
										<p class="price m-0 p-0 ">15000</p>
									</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="box-item-releted">
									<div class="box-item-img">
										<img src="/ASM/asset/img/GAUVALAVENDER.jpg" alt=""
											class="w-100 rounded-5">
									</div>
									<div class="box-item-info text-center">
										<p class="name m-0 p-0">Hoa gấu</p>
										<p class="price m-0 p-0 ">15000</p>
									</div>
								</div>
							</div>
						</div>
						<p class="h5 more-product text-center mt-2">Xem thêm...</p>
					</div>
				</div>
			</div>
		</div>
	</div>




