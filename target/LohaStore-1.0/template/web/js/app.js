var app = angular.module("myapp", ["ngRoute"]);
/*app.config(function ($routeProvider) {
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
});
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
app.service("sharedService", function () {
  this.searchText = {
    searchName: "",
  };
});
app.controller("myCtrl", function ($scope, $rootScope, $http) {
  $rootScope.totalSP = [];
  $rootScope.hoalen = [];
  $rootScope.mockhoa = [];
  $http.get("/LohaStore/template/web/js/sanpham.json").then(
    function (response) {
      $rootScope.totalSP = response.data;
      for (let i = 0; i < $rootScope.totalSP.length; i++) {
        if ($rootScope.totalSP[i].loai == "hoalen") {
          $rootScope.hoalen.push($rootScope.totalSP[i]);
        } else {
          $rootScope.mockhoa.push($rootScope.totalSP[i]);
        }
      }
    },
    function (error) {
      console.log("Lỗi không lấy được sản phẩm", error);
    }
  );

  //addToCart

  $rootScope.cart = [];
  $scope.addToCart = function (sp) {
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
  $rootScope.cartnumber = function () {
    $rootScope.cartNumber = $rootScope.cart.length;
  };

  $rootScope.cartnumber();
  $rootScope.checkForm = function (check) {
    if (!check) {
      alert("Vui lòng nhập thông tin đăng nhập");
    }
  };
  console.log($rootScope.cart);
});
app.controller("headerCtrl", function ($scope, sharedService) {
  $scope.searchText = sharedService.searchText;
});
app.controller("homeCtrl", function ($scope, $rootScope, sharedService) {
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

  $rootScope.changePage = function (trang) {
    $rootScope.page = trang;
    $rootScope.start = ($rootScope.page - 1) * $rootScope.limit;
  };
  $scope.searchText = sharedService.searchText;
});
app.controller("hoalenCtrl", function ($scope, sharedService) {
  $scope.limit = 8;
  $scope.page = 1;
  $scope.start = ($scope.page - 1) * $scope.limit;
  $scope.totalPage = Math.ceil($scope.hoalen.length / $scope.limit);
  $scope.pageList = [];
  for (let i = 1; i <= $scope.totalPage; i++) {
    $scope.pageList.push(i);
  }

  $scope.changePage = function (trang) {
    $scope.page = trang;
    $scope.start = ($scope.page - 1) * $scope.limit;
  };
  $scope.searchTextHoalen = sharedService.searchText;
});
app.controller("mockhoaCtrl", function ($scope, sharedService) {
  $scope.searchTextMockhoa = sharedService.searchText;
  $scope.limit = 8;
  $scope.page = 1;
  $scope.start = ($scope.page - 1) * $scope.limit;
  $scope.totalPage = Math.ceil($scope.mockhoa.length / $scope.limit);
  $scope.pageList = [];
  for (let i = 1; i <= $scope.totalPage; i++) {
    $scope.pageList.push(i);
  }

  $scope.changePage = function (trang) {
    $scope.page = trang;
    $scope.start = ($scope.page - 1) * $scope.limit;
  };
});
app.controller("dangnhapCtrl", function ($scope) {});
app.controller("laymaCtrl", function ($scope) {});
app.controller("chitietsanphamCtrl", function ($scope, $routeParams) {
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

app.controller("giohangCtrl", function ($scope, $rootScope) {
  //tăng số lượng
  $rootScope.upQuantity = function (item) {
    if (item.quantity >= 1) {
      item.quantity++;
      $scope.itemTotalPrice(item);
      $scope.totalPrice();
    }
  };
  //giảm số lượng
  $rootScope.downQuantity = function (item) {
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
  $scope.itemTotalPrice = function (item) {
    item.priceTotal = item.price * item.quantity;
  };
  //tổng tiền tất cả sản phẩm
  $scope.totalPrice = function () {
    $rootScope.sumPrice = 0;
    $rootScope.cart.forEach((item) => {
      $rootScope.sumPrice += item.priceTotal;
    });
  };

  //remove
  $scope.removeItem = function (item) {
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
app.controller("thanhtoanCtrl", function ($scope, $http) {
  $scope.listAddress = [];
  $http
    .get(
      "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json"
    )
    .then(
      function (response) {
        $scope.listAddress = response.data;
      },
      function (error) {
        console.log("Không thể lấy dữ liệu", error);
      }
    );
});
app.controller("lienheCtrl", function () {});
app.controller("doimatkhauCtrl", function () {});
app.controller("dangkyCtrl", function () {});
app.controller("successCtrl", function ($rootScope) {
  $rootScope.cart = [];
  $rootScope.cartNumber = 0;
});
