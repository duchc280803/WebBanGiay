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
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                 fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                 stroke-linejoin="round" class="feather feather-users" aria-hidden="true">
                                <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path>
                                <circle cx="9" cy="7" r="4"></circle>
                                <path d="M23 21v-2a4 4 0 0 0-3-3.87"></path>
                                <path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                            </svg>
                            Customers
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <br>
            <div class="row d-flex justify-content-center align-items-center h-1000">
                <div class="col-lg-12 col-xl-12">
                    <div class="card border-top border-bottom border-3"
                         style="border-color: #f37a27 !important;">
                        <div class="card-body p-5">
                            <div class="mx-n5 px-5 py-4">
                                <div class="row">
                                    <div class="col-lg-12">
                                        <div class="horizontal-timeline">
                                            <ul class="list-inline items d-flex justify-content-between">
                                                <li class="list-inline-item items-list">
                                                    <p class="py-1 px-2 rounded "
                                                       style="background-color: #16FF00;color: black">
                                                        Chờ Thanh Toán
                                                    </p>
                                                </li>
                                                <li class="list-inline-item items-list">
                                                    <c:if test="${customerOderDTO.status == 2}">
                                                        <p class="py-1 px-2 rounded "
                                                           style="background-color: #16FF00;color: black">
                                                            Vận Chuyển
                                                        </p>
                                                    </c:if>
                                                    <c:if test="${customerOderDTO.status != 2}">
                                                        <p class="py-1 px-2 rounded "
                                                           style="background-color: #00C4FF;color: black">
                                                            Vận Chuyển
                                                        </p>
                                                    </c:if>
                                                </li>
                                                <li class="list-inline-item items-list">
                                                    <c:if test="${customerOderDTO.status == 3}">
                                                        <p class="py-1 px-2 rounded "
                                                           style="background-color: #16FF00;color: black">
                                                            Đang Giao
                                                        </p>
                                                    </c:if>
                                                    <c:if test="${customerOderDTO.status != 3}">
                                                        <p class="py-1 px-2 rounded "
                                                           style="background-color: #00C4FF;color: black">
                                                            Đang Giao
                                                        </p>
                                                    </c:if>
                                                </li>
                                                <li class="list-inline-item items-list">
                                                    <c:if test="${customerOderDTO.status == 4}">
                                                        <p class="py-1 px-2 rounded "
                                                           style="background-color: #16FF00;color: black">
                                                            Thành Công
                                                        </p>
                                                    </c:if>
                                                    <c:if test="${customerOderDTO.status != 4}">
                                                        <p class="py-1 px-2 rounded "
                                                           style="background-color: #00C4FF;color: black">
                                                            Thành Công
                                                        </p>
                                                    </c:if>
                                                </li>
                                                <c:if test="${customerOderDTO.status == 4}">
                                                    <li class="list-inline-item items-list">
                                                        <p class="py-1 px-2 rounded "
                                                           style="background-color: #DF2E38;color: black">
                                                            Đã Hủy
                                                        </p>
                                                    </li>
                                                </c:if>
                                                <c:if test="${customerOderDTO.status != 4}">
                                                    <li class="list-inline-item items-list">
                                                        <p class="py-1 px-2 rounded "
                                                           style="background-color: #00C4FF;color: black">
                                                            Đã Hủy
                                                        </p>
                                                    </li>
                                                </c:if>
                                                <c:if test="${customerOderDTO.status == 5}">
                                                    <li class="list-inline-item items-list">
                                                        <p class="py-1 px-2 rounded "
                                                           style="background-color: #16FF00;">
                                                            Hoàn Trả
                                                        </p>
                                                    </li>
                                                </c:if>
                                                <c:if test="${customerOderDTO.status != 5}">
                                                    <li class="list-inline-item items-list">
                                                        <p class="py-1 px-2 rounded "
                                                           style="background-color: #00C4FF;">
                                                            Hoàn Trả
                                                        </p>
                                                    </li>
                                                </c:if>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                                <c:if test="${customerOderDTO.status == 3}">
                                    <div class="hidden">
                                        <form action="/oder/update/${customerOderDTO.id}" method="post"
                                              modelAttributte="oder">
                                            <input type="hidden" value="4" name="status">
                                            <button type="submit" class="btn btn-danger">Hủy Đơn</button>
                                        </form>
                                        <button class="btn btn-danger"></button>
                                        <form action="/oder/update/${customerOderDTO.id}" method="post"
                                              modelAttributte="oder">
                                            <input type="hidden" value="3" name="status">
                                            <button type="submit" class="btn btn-success">Hoàn Thành</button>
                                        </form>
                                    </div>
                                </c:if>
                                <c:if test="${customerOderDTO.status == 2}">
                                    <div class="hidden">
                                        <form action="/oder/update/${customerOderDTO.id}" method="post"
                                              modelAttributte="oder">
                                            <input type="hidden" value="2" name="status">
                                            <button type="submit" class="btn btn-success">Giao Hàng</button>
                                        </form>
                                        <form action="/oder/update/${customerOderDTO.id}" method="post"
                                              modelAttributte="oder">
                                            <input type="hidden" value="4" name="status">
                                            <button type="submit" class="btn btn-danger">Hủy Đơn</button>
                                        </form>
                                    </div>
                                </c:if>
                                <c:if test="${customerOderDTO.status == 1}">
                                    <div class="hidden">
                                        <form action="/oder/update/${customerOderDTO.id}" method="post"
                                              modelAttributte="oder">
                                            <input type="hidden" value="2" name="status">
                                            <button type="submit" class="btn btn-success">Xác Nhận</button>
                                        </form>
                                        <form action="/oder/update/${customerOderDTO.id}" method="post"
                                              modelAttributte="oder">
                                            <input type="hidden" value="4" name="status">
                                            <button type="submit" class="btn btn-danger">Hủy Đơn</button>
                                        </form>
                                    </div>
                                </c:if>
                                <hr>
                                <div class="row">
                                    <h3>Thông Tin Đơn Hàng</h3>
                                    <h3>Người Nhận</h3>
                                    <hr>
                                    <div class="table-responsive">
                                        <table class="table table-striped table-sm">
                                            <thead>
                                            <tr>
                                                <th scope="col">Họ Và Tên</th>
                                                <th scope="col">Số Điện Thoại</th>
                                                <th scope="col">Địa Chỉ</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <tr>
                                                <td>${customerOderDTO.name}</td>
                                                <td>${customerOderDTO.phone}</td>
                                                <td>${customerOderDTO.address}</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                    <br>
                                    <form class="form-inline" action="/product-manager/hien-thi-product/search"
                                          method="get">
                                        <div class="input-group find-product" style="width: 25%;">
                                            <input type="text" class="form-control" name="name" placeholder="Tìm kiếm"/>
                                            <button type="submit" class="btn btn-warning">Tìm kiếm</button>
                                        </div>
                                    </form>
                                    <div class="table-responsive">
                                        <table class="table table-striped table-sm">
                                            <thead>
                                            <tr>
                                                <th scope="col">Image</th>
                                                <th scope="col">Tên Sản Phẩm</th>
                                                <th scope="col">Size</th>
                                                <th scope="col">Quantity</th>
                                                <th scope="col">Unit Price</th>
                                            </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${customerProductDTOS}" var="list">
                                                <tr>
                                                    <td><img src="${list.image}"></td>
                                                    <td>${list.name}</td>
                                                    <td>${list.size}</td>
                                                    <td>${list.quantity}</td>
                                                    <td><fmt:formatNumber value="${list.unitPrice}" pattern="###,###"/>
                                                        đ
                                                    </td>
                                                </tr>
                                                <c:set var="totalMoney" value="${list.quantity * list.unitPrice}"/>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                <div class="row my-4">
                                    <div class="col-md-8">
                                        <p class="mb-0">
                                        <h3>Tồng Tiền</h3></p>
                                    </div>
                                    <div class="col-md-4 ">
                                        <p class="lead fw-bold mb-0" style="color: #f37a27;"><fmt:formatNumber
                                                value="${totalMoney}" pattern="###,###"/> đ</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
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
>
