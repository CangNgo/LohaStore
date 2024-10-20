function changeQuantity(productId, change, price) {
	const quantityInput = document.getElementById("quantity-" + productId);
	const totalPrice = document.getElementById("total-price-"+productId);

	let quantity = parseInt(quantityInput.value);
	quantity += change;

	// Đảm bảo số lượng không âm
	if (quantity < 0) quantity = 0;
	totalPrice.innerHTML = price * quantity;
	quantityInput.value = quantity;
	const url = window.location.href;
	const projectName = url.split("/")[3];
	const uri = "/" + projectName + "/update-quantity";
	// Sử dụng jQuery để gửi yêu cầu AJAX
	$.ajax({
		url: uri,
		type: "POST",
		data: { productId: productId, quantity: quantity },
		success: function(response) {
			console.log("Cập nhật thành công:", response);
			// Cập nhật giao diện người dùng ở đây
			// Ví dụ: Hiển thị thông báo, cập nhật tổng tiền
			$("#cart-total").text("Tổng tiền: " + response.total);
		},
		error: function(xhr, status, error) {
			console.error("Lỗi khi cập nhật:", status);
		},
	});
}

function addToCart(productId, price) {

	const cartNumberElement = document.getElementById("cart-number");	
	let cartNumber = parseInt(cartNumberElement.textContent); // Hoặc innerText
	cartNumber += 1;
	cartNumberElement.textContent = cartNumber;
	const url = window.location.href;
	const projectName = url.split("/")[3];
	const uri = "/" + projectName + "/them-moi-chi-tiet-giohang";
	//request

	// Sử dụng jQuery để gửi yêu cầu AJAX
	$.ajax({
		url: uri,
		type: "POST",
		data: { productId: productId, priceProduct: price },
		success: function(response) {
			console.log("Thêm vào thành công:", response);
			// Cập nhật giao diện người dùng ở đây
			// Ví dụ: Hiển thị thông báo, cập nhật tổng tiền
			$("#cart-total").text("Tổng tiền: " + response.total);
		},
		error: function(xhr, status, error) {
			console.error("Lỗi khi thêm mới:", error);
		},
	});
}

function removeCart(idChitietgiohang) {
	const itemInCart = document.querySelector("#product-item-" + idChitietgiohang)
	itemInCart.remove()
	//request
	const url = window.location.href;
	const projectName = url.split("/")[3];
	const uri = "/" + projectName + "/xoa-chi-tiet-san-pham";
	// Sử dụng jQuery để gửi yêu cầu AJAX
	$.ajax({
		url: uri,
		type: "POST",
		data: { idChitietgiohang: idChitietgiohang },
		success: function(response) {
			console.log("Xóa vào thành công:", response);

		},
		error: function(xhr, status, error) {
			console.error("Xóa khi thêm mới:", error);
		},
	});
}
//add To cart 
function productDetail(id) {
	document.getElementById("chitietsanpham").idProduct.value = id;
	document.getElementById("chitietsanpham").submit();
}

//check out
function checkOut() {
  // Lấy tất cả các checkbox được chọn
  var selectedCheckboxes = document.querySelectorAll('input[name="choie-product"]:checked');
  
  // Tạo một mảng để lưu trữ các ID của sản phẩm được chọn
  var selectedProducts = Array.from(selectedCheckboxes).map(checkbox => checkbox.id.split('-').pop());
  
  // Nếu không có sản phẩm nào được chọn, hiển thị thông báo và ngăn chặn chuyển hướng
  if (selectedProducts.length === 0) {
    alert('Vui lòng chọn ít nhất một sản phẩm để thanh toán.');
    event.preventDefault(); // Ngăn chặn hành vi mặc định của thẻ a
    return;
  }
  
  // Lấy thẻ a
  var checkoutLink = document.getElementById('checkout-link');
  
  // Tạo URL với các tham số
  var baseUrl = checkoutLink.getAttribute('href');
  var url = baseUrl + '?action=dat-hang&products=' + selectedProducts.join(',');
  
  // Cập nhật href của thẻ a
  checkoutLink.setAttribute('href', url);
}

document.addEventListener('DOMContentLoaded', function() {
    const userIcon = document.querySelector('div.user-icon');
    
    userIcon.addEventListener('click', function(event) {
        event.preventDefault();
        
        fetch('/user-profile', {
            method: 'GET',
            headers: {
                'X-Requested-With': 'XMLHttpRequest'
            }
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(data => {
            // Xử lý phản hồi từ server ở đây
            console.log(data);
            // Ví dụ: cập nhật nội dung trang
            // document.getElementById('content').innerHTML = data;
        })
        .catch(error => {
            console.error('There was a problem with the fetch operation:', error);
        });
    });
});
var app = angular.module("myapp", ["ngRoute"]);
app.config(function ($routeProvider) {
  $routeProvider
	.when("/trang-chu", {
	  templateUrl: "/views/web/home.jsp ?" + Math.random(),
	  controller: "homeCtrl",
	})
	.when("/hoalen", {
	  templateUrl: "/views/web/hoalen.jsp ?" + Math.random(),
	  controller: "hoalenCtrl",
	})
	.when("/mockhoa", {
	  templateUrl: "/views/web/mockhoa.jsp ?" + Math.random(),
	  controller: "mockhoaCtrl",
	})
	.when("/lienhe", {
	  templateUrl: "/views/web/lienhe.jsp ?" + Math.random(),
	  controller: "lienheCtrl",
	})
	.when("/dangnhap", {
	  templateUrl: "/views/web/account/dangnhap.jsp ?" + Math.random(),
	  controller: "dangnhapCtrl",
	})
	.when("/dangky", {
	  templateUrl: "/views/web/account/dangky.jsp ?" + Math.random(),
	  controller: "dangkyCtrl",
	})
	.when("/doimatkhau", {
	  templateUrl: "/views/web/account/doimatkhau.jsp ?" + Math.random(),
	  controller: "doimatkhauCtrl",
	})
	.when("/layma", {
	  templateUrl: "/views/web/account/layma.jsp ?" + Math.random(),
	  controller: "laymaCtrl",
	})
	.when("/giohang", {
	  templateUrl: "/views/web/giohang.jsp ?" + Math.random(),
	  controller: "giohangCtrl",
	})
	.when("/trang-chu/chitietsanpham/:id", {
	  templateUrl: "/views/web/chitietsanpham.jsp ?" + Math.random(),
	  controller: "chitietsanphamCtrl",
	})
	.when("/thanhtoan", {
	  templateUrl: "/views/web/thanhtoan.jsp ?" + Math.random(),
	  controller: "thanhtoanCtrl",
	})
	.when("/success", {
	  templateUrl: "/views/web/success.jsp ?" + Math.random(),
	  controller: "successCtrl",
	})
	.otherwise({
	  templateUrl: "/views/web/home.jsp ?" + Math.random(),
	});
});/*
app.run(function ($rootScope) {
  $rootScope.$on("$routeChangeStart", function () {
	$rootScope.loading = true;
  });
  $rootScope.$on("$routeChangeSuccess", function () {
	$rootScope.loading = false;
  });
  $rootScope.$on("$routeChangeError", function () {
	$rootScope.loading = false;
	alert("Lỗi không tải được trang");
  });
});*/
app.service("sharedService", function() {
	this.searchText = {
		searchName: "",
	};
});
app.controller("myCtrl", function($scope, $rootScope, $http) {
	$rootScope.totalSP = [];
	$rootScope.hoalen = [];
	$rootScope.mockhoa = [];
	$http.get("/LohaStore/template/web/js/sanpham.json").then(
		function(response) {
			$rootScope.totalSP = response.data;
			for (let i = 0; i < $rootScope.totalSP.length; i++) {
				if ($rootScope.totalSP[i].loai == "hoalen") {
					$rootScope.hoalen.push($rootScope.totalSP[i]);
				} else {
					$rootScope.mockhoa.push($rootScope.totalSP[i]);
				}
			}
		},
		function(error) {
			console.log("Lỗi không lấy được sản phẩm", error);
		}
	);
	//addToCart
	$rootScope.cart = [];
	$scope.addToCart = function(sp) {
		let inCart = false;
		for (let i = 0; i < $rootScope.cart.length; i++) {
			if ($rootScope.cart[i].id == sp.id) {
				sp.quantity++;
				sp.priceTotal = sp.price * sp.quantity;
				inCart = true;
			}
		}
		if (!inCart) {
			sp.quantity = 1;
			sp.priceTotal = sp.price * sp.quantity;
			$rootScope.cart.push(sp);
			$rootScope.cartnumber();
		}
	};
	//cartNumber
	$rootScope.cartnumber = function() {
		$rootScope.cartNumber = $rootScope.cart.length;
	};

	$rootScope.cartnumber();
	
	console.log($rootScope.cart);
});
app.controller("headerCtrl", function($scope, sharedService) {
	$scope.searchText = sharedService.searchText;
});
app.controller("homeCtrl", function($scope, $rootScope, sharedService) {
	$rootScope.limit = 12;
	$rootScope.page = 1;
	$rootScope.start = ($rootScope.page - 1) * $rootScope.limit;
	$rootScope.totalPage = Math.ceil(
		$rootScope.totalSP.length / $rootScope.limit
	);
	$rootScope.pageList = [];
	for (let i = 1; i <= $rootScope.totalPage; i++) {
		$rootScope.pageList.push(i);
	}

	$rootScope.changePage = function(trang) {
		$rootScope.page = trang;
		$rootScope.start = ($rootScope.page - 1) * $rootScope.limit;
	};
	$scope.searchText = sharedService.searchText;
});
app.controller("hoalenCtrl", function($scope, sharedService) {
	$scope.limit = 8;
	$scope.page = 1;
	$scope.start = ($scope.page - 1) * $scope.limit;
	$scope.totalPage = Math.ceil($scope.hoalen.length / $scope.limit);
	$scope.pageList = [];
	for (let i = 1; i <= $scope.totalPage; i++) {
		$scope.pageList.push(i);
	}

	$scope.changePage = function(trang) {
		$scope.page = trang;
		$scope.start = ($scope.page - 1) * $scope.limit;
	};
	$scope.searchTextHoalen = sharedService.searchText;
});
app.controller("mockhoaCtrl", function($scope, sharedService) {
	$scope.searchTextMockhoa = sharedService.searchText;
	$scope.limit = 8;
	$scope.page = 1;
	$scope.start = ($scope.page - 1) * $scope.limit;
	$scope.totalPage = Math.ceil($scope.mockhoa.length / $scope.limit);
	$scope.pageList = [];
	for (let i = 1; i <= $scope.totalPage; i++) {
		$scope.pageList.push(i);
	}

	$scope.changePage = function(trang) {
		$scope.page = trang;
		$scope.start = ($scope.page - 1) * $scope.limit;
	};
});
app.controller("dangnhapCtrl", function($scope) { });
app.controller("laymaCtrl", function($scope) { });
app.controller("chitietsanphamCtrl", function($scope, $routeParams) {
	$scope.id = $routeParams.id;
	for (let i = 0; i < $scope.hoalen.length; i++) {
		if ($scope.hoalen[i].id == $scope.id) {
			$scope.item = $scope.hoalen[i];
		}
	}
	for (let i = 0; i < $scope.mockhoa.length; i++) {
		if ($scope.mockhoa[i].id == $scope.id) {
			$scope.item = $scope.mockhoa[i];
		}
	}
});

app.controller("giohangCtrl", function($scope, $rootScope) {
	//tăng số lượng
	$rootScope.upQuantity = function(item) {
		if (item.quantity >= 1) {
			item.quantity++;
			$scope.itemTotalPrice(item);
			$scope.totalPrice();
		}
	};
	//giảm số lượng
	$rootScope.downQuantity = function(item) {
		if (item.quantity > 1) {
			item.quantity--;
			$scope.itemTotalPrice(item);
			$scope.totalPrice();
		} else {
			var check = confirm("bạn có muốn xóa sản phẩm");
			if (check) {
				$scope.removeItem(item);
			}
		}
	};

	//tổng tiền từng sản phẩm
	$scope.itemTotalPrice = function(item) {
		item.priceTotal = item.price * item.quantity;
	};
	//tổng tiền tất cả sản phẩm
	$scope.totalPrice = function() {
		$rootScope.sumPrice = 0;
		$rootScope.cart.forEach((item) => {
			$rootScope.sumPrice += item.priceTotal;
		});
	};

	//remove
	$scope.removeItem = function(item) {
		for (let i = 0; i < $rootScope.cart.length; i++) {
			if ($rootScope.cart[i].id == item.id) {
				let index = i;
				$rootScope.cart.splice(index, 1);
				$scope.totalPrice();
				$rootScope.cartnumber();
			}
		}
	};
	//gọi hàm
	$scope.totalPrice();
});
app.controller("thanhtoanCtrl", function($scope, $http) {
	$scope.listAddress = [];
	$http
		.get(
			"https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json"
		)
		.then(
			function(response) {
				$scope.listAddress = response.data;
			},
			function(error) {
				console.log("Không thể lấy dữ liệu", error);
			}
		);
});
app.controller("lienheCtrl", function() { });
app.controller("doimatkhauCtrl", function() { });
app.controller("dangkyCtrl", function() { });
app.controller("successCtrl", function($rootScope) {
	$rootScope.cart = [];
	$rootScope.cartNumber = 0;
});
