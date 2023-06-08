<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/14/2023
  Time: 9:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/trang-chu/footer.css">
</head>
<body>
<footer class="bg-light">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <h5 class="name-footer">Về chúng tôi</h5>
                <p>Chúng tôi là một cửa hàng bán giày chuyên nghiệp, cung cấp cho khách hàng những sản phẩm chất lượng
                    và dịch vụ tốt nhất.</p>
            </div>
            <div class="col-lg-4 col-md-6">
                <h5 class="name-footer">Sản phẩm</h5>
                <ul class="list-unstyled">
                    <c:forEach items="${categoryList}" var="categoryList">
                        <li><a href="#">${categoryList.name}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="col-lg-4">
                <h5 class="name-footer">Liên hệ</h5>
                <p>Địa chỉ: 123 Nguyễn Văn Linh, Quận 7, TP.HCM</p>
                <p>Số điện thoại: 0123456789</p>
                <p>Email: contact@shoestore.com</p>
            </div>
        </div>
        <hr>
        <div class="row">
            <div class="col-md-6">
                <p>&copy; 2021 Shoe Store. All rights reserved.</p>
            </div>
            <div class="col-md-6">
                <ul class="list-inline float-md-right">
                    <li class="list-inline-item"><a href="#">Điều khoản sử dụng</a></li>
                    <li class="list-inline-item"><a href="#">Chính sách bảo mật</a></li>
                    <li class="list-inline-item"><a href="#">FAQ</a></li>
                </ul>
            </div>
        </div>
    </div>
</footer>
<script src="/js/bootstrap.js"></script>
</body>
</html>
