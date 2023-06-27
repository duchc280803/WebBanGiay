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
    <link rel="stylesheet" href="/css/product-css/product.css">
    <link rel="stylesheet" href="/css/bootstrap.css">
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
<jsp:include page="/view/banner.jsp"></jsp:include>
<div class="all">
    <section class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="list-group">
                    <div class="box-product-hot">
                        <div class="header">DANH MỤC SẢN PHẨM</div>
                        <c:forEach var="category" items="${categoryList}">
                            <a
                                    type="submit"
                                    href="/product/category/${category.id}"
                                    class="list-group-item list-group-item-action"
                            >
                                    ${category.name}
                            </a>
                        </c:forEach>
                    </div>
                </div>
            </div>
            <div class="col-lg-9 all-product">
                <div class="container">
                    <div class="row card-image-margin">
                        <c:forEach items="${productList}" var="product">
                            <div class="col-md-4">
                                <div class="card box-produc">
                                    <img
                                            src="${product.image}"
                                            class="card-img-top"
                                            alt="Sản phẩm 1"
                                    />
                                    <div class="card-body">
                                        <a class="link-view" title="" href="/product/product-detail/${product.name}"
                                        ><h4 class="card-title">
                                                ${product.name}
                                        </h4></a
                                        >
                                        <p class="card-text"><strong>Giá:</strong> <fmt:formatNumber value="${product.price}" pattern="###,###"/>đ</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <div class="row phan-trang">
                        <div class="col-lg-4 d-flex justify-content-center">
                            <ul class="pagination main-pager">
                                <c:if test="${results.number  > 0}">
                                    <li class="page-item previous-center">
                                        <a class="page-link" href="/product/view-product?pageNumber=${results.number - 1}">Previous</a>
                                    </li>
                                </c:if>
                            </ul>
                        </div>
                        <div class="col-lg-4 d-flex justify-content-center">
                            <ul class="pagination main-pager">
                                <li class="page-item previous">
                                    <form action="/product/view-product" method="get">
                                        <input type="number" id="input-value" name="number" min="${results.number + 1}" max="${results.totalPages}"
                                               style="width: 40px; border: none; appearance: none; text-align: center;"
                                               value="${results.number + 1}">
                                    </form>
                                </li>
                            </ul>
                        </div>
                        <div class="col-lg-4 d-flex justify-content-center">
                            <ul class="pagination main-pager">
                                <li class="page-item previous-center">
                                    <c:if test="${results.number < results.totalPages - 1}">
                                        <a class="page-link" href="/product/view-product?pageNumber=${results.number + 1}">Next</a>
                                    </c:if>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<jsp:include page="/view/footer.jsp"></jsp:include>
<link rel="stylesheet" href="/js/bootstrap.js">
</body>
</html>