<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/15/2023
  Time: 8:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="total" value="0"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="org.apache.struts.util.LocalStrings"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/admin/dashboard.css">
    <style>
        h6 {
            padding-top: 8px;
        }

        .col-3 {
            text-align: center;
        }

        header.navbar.navbar-dark.sticky-top.bg-dark.flex-md-nowrap.p-0.shadow {
            background-color: #0CBEF0 !important;
        }

        ul.nav.flex-column {
            width: 100%;
            line-height: 40px;
            padding: 0px 10px;
            color: #fff;
            font-size: 13px;
            font-weight: bold;
            text-transform: uppercase;
            position: relative;
            border: 0px;
            float: left;
        }

        a.nav-link:hover {
            color: coral;
        }

        img {
            width: 50px;
        }
    </style>
</head>
<body>
<header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
    <a class="navbar-brand col-md-3 col-lg-2 me-0 px-3" href="/product/hien-thi">Shoe Store</a>
    <div class="navbar-nav">
        <div class="nav-item text-nowrap">
            <a class="nav-link px-3" href="/dang-nhap/logout">Sign out</a>
        </div>
    </div>
</header>
<c:if test="${not empty message}">
    <div class="alert alert-danger">
            ${message}
        <c:remove var="message" scope="session"/>
    </div>
</c:if>
<c:if test="${not empty error}">
    <div class="alert alert-danger">
            ${error}
        <c:remove var="error" scope="session"/>
    </div>
</c:if>
<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
            <div class="position-sticky pt-3">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="/admin/dashboard">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-home" aria-hidden="true">
                                <path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path>
                                <polyline points="9 22 9 12 15 12 15 22"></polyline>
                            </svg>
                            Dashboard
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/oder/hien-thi">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-file" aria-hidden="true">
                                <path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path>
                                <polyline points="13 2 13 9 20 9"></polyline>
                            </svg>
                            Orders
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/product-manager/hien-thi-product">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-shopping-cart" aria-hidden="true">
                                <circle cx="9" cy="21" r="1"></circle>
                                <circle cx="20" cy="21" r="1"></circle>
                                <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path>
                            </svg>
                            Products
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="chartjs-size-monitor">
                <div class="chartjs-size-monitor-expand">
                    <div class=""></div>
                </div>
                <div class="chartjs-size-monitor-shrink">
                    <div class=""></div>
                </div>
            </div>
            <br>
            <div class="container">
                <div class="row">
                    <h1>Quản Lý Đơn Hàng</h1>
                    <hr>
                    <div class="col-3">
                        <form class="form-inline" action="/oder/hien-thi/search" method="get">
                            <div class="input-group find-product">
                                <input type="text" class="form-control" name="phone" placeholder="Tìm kiếm"/>
                                <button type="submit" class="btn btn-warning">Tìm kiếm</button>
                            </div>
                        </form>
                    </div>
                    <div class="col-6">
                    </div>
                    <div class="col-3">
                        <h6>
                            Đơn chưa giao: ${countByStatus}
                        </h6>
                    </div>
                </div>
            </div>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th scope="col">STT</th>
                        <th scope="col">Người Nhận</th>
                        <th scope="col">Số Điện Thoại</th>
                        <th scope="col">Tổng Tiền</th>
                        <th scope="col">Trạng Thái</th>
                        <th scope="col">Session</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="list" items="${donHangDTOList}" varStatus="i">
                        <tr>
                            <td>${i.index + 1}</td>
                            <td>${list.hoVaTen}</td>
                            <td>${list.phone}</td>
                            <td><fmt:formatNumber value="${list.totalMoney}" pattern="###,###"/> đ</td>
                            <td>${list.status == 1 ? "Chờ Thanh Toán" :
                                    list.status == 2 ? "Vận Chuyển":
                                            list.status == 3 ? "Giao Hàng" :
                                                    list.status == 4 ? "Thành Công" :
                                                            list.status == 5 ? "Đã Hủy" : "Hoàn Trả"}</td>
                            <td>
                                <a href="/oder/detail/${list.id}" class="btn btn-warning papding">Chi Tiết</a>
                                <a href="#" class="btn btn-warning">Hóa Đơn</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
    </div>
</div>
</body>
<script>
    function confirmDelete(productId) {
        if (confirm("Bạn có muốn xóa sản phẩm này không")) {
            window.location.href = '/product-manager/delete/' + productId;
        } else {

        }
    }
</script>
<script src="/js/bootstrap.js"></script>
</html>