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
                <h4>Hồ Sơ Của Tôi</h4>
                <h6>Quản Lý Thông Tin Hồ Sơ Để Bảo Mật Tài Khoản</h6>
                <hr>
                <div class="row">
                    <div class="col-lg-9">
                        <label class="form-label">Tên Đăng Nhập</label> : ${user.name}
                        <br>
                        <label class="form-label">${user.name}</label>
                        <input type="text" class="form-control" style="width: 60%">
                        <label class="form-label">${user.email}</label>
                        <input type="email" class="form-control" style="width: 60%">
                        <label class="form-label">${user.phone}</label>
                        <input type="number" class="form-control" style="width: 60%">
                        <label class="form-label">Giới Tính</label>
                        <input type="radio" class="form-check-input">${user.gender}
                        <input type="radio" class="form-check-input">${user.gender}
                        <br>
                        <label class="form-label">Ngày Sinh</label>
                        <input type="date" class="form-control" style="width: 60%" value="${user.ngaySinh}">
                        <br>
                        <button class="btn btn-danger">Lưu</button>
                    </div>
                    <div class="col-lg-3">
                    </div>
                </div>
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