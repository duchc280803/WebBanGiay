<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/11/2023
  Time: 7:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/product-css/product.css">
    <link rel="stylesheet" href="/css/bootstrap.css">
    <style>
        .card-body {
            display: flex;
            align-items: center;
        }

        .card-image {
            order: 1;
            margin-right: 10px;
        }

        .card-content {
            order: 2;
        }

    </style>
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
<section class="container">
    <div class="row">
        <div class="col-3">
            <div class="card mt-4">
                <li class="nav-item">
                    <a id="link1" class="nav-link text-center" aria-current="page" href="/customer/khach-hang">Tài Khoản
                        Của Tôi</a>
                </li>
            </div>
            <div class="card mt-4">
                <li class="nav-item">
                    <a id="link2" class="nav-link text-center" href="/customer/cho-thanh-toan">Đơn Mua</a>
                </li>
            </div>
        </div>
        <div class="col-9">
            <div class="container mt-4">
                <h2>Đơn hàng</h2>
                <ul class="nav nav-pills">
                    <li class="nav-item">
                        <a class="nav-link " href="/customer/cho-thanh-toan">Chờ thanh toán</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/customer/van-chuyen">Vận chuyển</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/customer/dang-giao">Đang giao</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" href="/customer/hoan-thanh">Hoàn thành</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/customer/da-huy">Đã hủy</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/customer/traHangHoanTat">Trả hàng/Hoàn tiền</a>
                    </li>
                </ul>
                <c:forEach var="list" items="${donHangDTOList}" varStatus="index">
                    <div class="card mt-4">
                        <div class="card-header">
                            Đơn hàng ${index.index + 1}
                        </div>
                        <div class="card-body">
                            <img src="${list.image}" class="card-image" class="card-image" style="width: 10%;">
                            <div class="card-content">
                                <h5 class="card-title">${list.name}</h5>
                                <p class="card-text">${list.status == 4 ? 'Hoàn Thành' : ''}</p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/view/footer.jsp"></jsp:include>
<script>
    var link1 = document.getElementById("link1");
    var link2 = document.getElementById("link2");

    link1.onclick = function () {
        link1.style.color = "red";
        link2.style.color = "initial";
    };

    link2.onclick = function () {
        link2.style.color = "blue";
        link1.style.color = "initial";
    };
</script>
<script src="/js/bootstrap.js"></script>
</body>
</html>