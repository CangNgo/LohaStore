<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <header ng-controller="headerCtrl" class="position-fixed z-1 bg-white ">
        <div class="hello">
            <div class="container">
                <div class="row d-flex ">
                    <div class="col-md-6">
                        <div class="hello-left">
                            <p class="m-0 fw-bold ">Chào mừng bạn đến với LOHA</p>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="hello-right justify-content-end">
                            <i class="fa-solid fa-phone-volume me-1"></i>
                            <a href="#" class="m-0 text-decoration-none text-reset">0375663119</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <nav class="nav">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 ps-0 col-logo">
                        <div class="logo">
                            <img src="/LohaStore/template/web/img/Logo_removebackground.png" alt="">
                        </div>
                    </div>
                    <div class="col-md-6 col-sm-6">
                        <div class="row slogan">
                            <marquee behavior="" direction="left" scrolldelay="10" class="fw-bold">Chuyên sản
                                phẩm len
                                Handmade
                            </marquee>
                        </div>
                        <div class="row">
                            <nav class="navbar navbar-expand-lg ">
                                <button class="navbar-toggler" type="button" data-toggle="collapse"
                                    data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01"
                                    aria-expanded="false" aria-label="Toggle navigation">
                                    <span class="navbar-toggler-icon"></span>
                                </button>
                                <div class="collapse navbar-collapse c-nav-item justify-content-around"
                                    id="navbarTogglerDemo01">
                                    <ul class="navbar-nav mr-auto mt-2 mt-sm-0">
                                        <li class="nav-item active">
                                            <a class="nav-link" href="trang-chu">Trang chủ <span
                                                    class="sr-only">(current)</span></a>
                                        </li>
                                        <li class="nav-item active">
                                            <a class="nav-link" href="hoa-len?category=hoalen">Hoa len <span
                                                    class="sr-only">(current)</span></a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="moc-khoa?category=mockhoa">Móc khóa</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link " href="lien-he">Liên hệ</a>
                                        </li>
                                    </ul>

                                </div>
                            </nav>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-6 m-0 p-0 c-nav-right  position-relatives">
                        <div class="row user_cart d-flex justify-content-sm-end ">
                            <div class="col-md-6 col-sm-1 offset-sm-10 cart d-flex justify-content-end m-0">
                                <div class="cart-text">
                                    <a href="gio-hang" class="m-0 text-decoration-none">Giỏ hàng</a>
                                </div>
                                <div class="cart-icon">
                                    <i class="fa-solid fa-cart-shopping ms-1 position-relative"><span
                                            class="position-absolute cart-number" id="cart-number">${cartNumber
                                            }</span></i>
                                </div>
                            </div>
                            <div class="col-md-6 col-sm-1 user d-flex justify-content-end m-0">
                                <div class="user-text">
                                    <a href="account/dang-nhap?action=login" class="m-0 text-decoration-none">{{username
                                        || 'Đăng nhập'}}</a>
                                </div>
                                <div class="user-icon">
                                    <i class="fa-solid fa-user ms-2"></i>
                                </div>
                            </div>
                        </div>
                        <div class="row c_box-search">
                            <nav class="navbar navbar-light justify-content-end">
                                <form class="form-inline my-2 my-sm c-form-search position-relative">
                                    <input class="form-control mr-sm-2 rounded-5" type="search"
                                        placeholder="Nhập từ khóa tiềm kiếm ..." aria-label="Search"
                                        ng-model="searchText.searchName" name="search" value="">
                                    <i class="fa-solid fa-magnifying-glass position-absolute c-icon-search"></i>
                                </form>
                        </div>
                    </div>
                </div>
            </div>
        </nav>
    </header>