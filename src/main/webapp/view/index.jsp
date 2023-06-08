<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/11/2023
  Time: 7:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="total" value="0" />
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="org.apache.struts.util.LocalStrings"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/trang-chu/index.css">
</head>
<body>
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
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="banner.jsp"></jsp:include>
<section class="fill-product">
    <div class="container">
        <h2 class="text-center featured-product">Featured Products</h2>
        <hr/>
        <div class="row">
            <c:forEach var="item" items="${list}">
                <div class="col-md-4">
                    <div class="card">
                        <img class="card-img-top" src="${item.image}" alt="Card image cap"/>
                        <div class="card-body">
                            <a href="/product/product-detail/${item.name}" class="card-title">${item.name}</a>
                            <p class="card-text"><strong>Giá:</strong> <fmt:formatNumber value="${item.price}" pattern="###,###"/>đ</p>
                            <form action="/cart/create" method="post">
                                <input type="hidden" name="idProduct" value="${item.id}"/>
                                <button type="submit" class="btn btn-primary">Add to cart</button>
                            </form>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<jsp:include page="footer.jsp"></jsp:include>
<link rel="stylesheet" href="/js/bootstrap.js">
</body>
</html>
