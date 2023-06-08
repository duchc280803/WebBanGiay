<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/14/2023
  Time: 9:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/trang-chu/header.css">
</head>
<body>
<div class="header-top">
    <ul class="nav justify-content-end">
        <li class="nav-item">
            <a class="nav-link header" aria-current="page" href="#">Thông Báo</a>
        </li>
        <li class="nav-item">
            <a class="nav-link header" href="#">Hỗ Trợ</a>
        </li>
        <c:if test="${sessionScope.loggedInUser == null}">
            <li class="nav-item">
                <a class="nav-link header" href="/dang-nhap/view-register">Đăng Kí</a>
            </li>
            <li class="nav-item">
                <a class="nav-link header" href="/dang-nhap/form">Đăng Nhập</a>
            </li>
        </c:if>
        <c:if test="${sessionScope.loggedInUser != null}">
            <c:if test="${sessionScope.loggedInUser.name != 'admin'}">
                <li class="nav-item">
                    <a class="nav-link header" href="/customer/all-oder">Khách Hàng</a>
                </li>
            </c:if>
            <li class="nav-item">
                <a class="nav-link header" href="/dang-nhap/logout">Đăng Xuất</a>
            </li>
        </c:if>
    </ul>
</div>
<header class="bg-light sticky-top">
    <div class="container">
        <div class="row justify-content-end">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="col-4">
                    <ul class="navbar-nav">
                        <a class="navbar-brand" href="/product/hien-thi">Shoe Store</a>
                        <li class="nav-item">
                            <a class="nav-link" href="/product/hien-thi">Trang chủ</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/product/view-product">Sản phẩm</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/product/gioi-thieu">Giới thiệu</a>
                        </li>
                    </ul>
                </div>
                <div class="col-6">
                    <form class="form-inline" action="/product/search" method="get">
                        <div class="input-group find-product">
                            <input type="text" class="form-control " path="name" placeholder="Tìm kiếm">
                            <button type="submit" class="btn btn-warning">Tìm kiếm</button>
                        </div>
                    </form>
                </div>
                <div class="col-2">
                    <c:if test="${sessionScope.loggedInUser == null}">
                        <a href="/dang-nhap/form" class="header__cart menu-info">
                            <div class="box-cart">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-cart" viewBox="0 0 16 16">
                                    <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                </svg>
                                <i class="iconnewglobal-cart"></i>
                                <span class="cart-number"></span>
                            </div>
                            <span>Giỏ hàng</span>
                        </a>
                    </c:if>
                    <c:if test="${sessionScope.loggedInUser != null}">
                        <a href="/cart/hien-thi" class="header__cart menu-info">
                            <div class="box-cart">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                     class="bi bi-cart" viewBox="0 0 16 16">
                                    <path d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 1 0 2 1 1 0 0 1 0-2zm7 0a1 1 0 1 1 0 2 1 1 0 0 1 0-2z"/>
                                </svg>
                                <i class="iconnewglobal-cart"></i>
                                <span class="cart-number"></span>
                            </div>
                            <span>Giỏ hàng</span>
                        </a>
                    </c:if>
                </div>
            </nav>
        </div>
    </div>
</header>
<script src="/js/bootstrap.js"></script>
</body>
</html>