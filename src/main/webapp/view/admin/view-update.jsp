<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/19/2023
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <style>
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
                <form:form action="/product-manager/update" method="post" modelAttribute="productViewDTO">
                    <div class="form-outline">
                        <label class="form-label">Mã</label>
                        <form:input type="text" path="id" value="${productViewDTOList.id}" class="form-control"/>
                    </div>
                    <div class="form-outline">
                        <label class="form-label">Name</label>
                        <form:input type="text" path="name" value="${productViewDTOList.name}" class="form-control"/>
                    </div>
                    <br>
                    <label class="form-label">Size</label>
                    <div style="display: flex;">
                        <form:select items="${sizeId}" path="size" value="${productViewDTOList.size}"
                                     class="form-select"
                                     aria-label="Default select example">
                        </form:select>
                    </div>
                    <br>
                    <label class="form-label">Color</label>
                    <div style="display: flex;">
                        <form:select items="${colorId}" path="color" class="form-select"
                                     aria-label="Default select example">
                        </form:select>
                    </div>
                    <br>
                    <label class="form-label">Category</label>
                    <div style="display: flex;">
                        <form:select items="${categoryIds}" path="category" class="form-select"
                                     aria-label="Default select example">
                        </form:select>
                    </div>
                    <br>
                    <label class="form-label">Origin</label>
                    <div style="display: flex;">
                        <form:select items="${originId}" path="origin" class="form-select"
                                     aria-label="Default select example">
                        </form:select>
                    </div>
                    <br>
                    <div class="form-outline">
                        <label class="form-label">Quantity</label>
                        <form:input type="number" value="${productViewDTOList.quantity}" path="quantity"
                                    class="form-control"/>
                    </div>
                    <br>
                    <div class="form-outline">
                        <label class="form-label">Price</label>
                        <form:input type="number" path="price" value="${productViewDTOList.price}"
                                    class="form-control"/>
                    </div>
                    <br>
                    <div class="form-outline">
                        <label class="form-label">Description</label>
                        <form:input type="text" value="${productViewDTOList.description}" path="description"
                                    class="form-control"/>
                    </div>
                    <br>
                    <div class="form-outline">
                        <label class="form-label">Image</label>
                        <form:input type="text" path="image" value="${productViewDTOList.image}" class="form-control"/>
                    </div>
                    <br>
                    <form:button type="submit" class="btn btn-warning">UPDATE</form:button>
                </form:form>
            </div>
            <hr>
            <hr>
        </main>
    </div>
</div>
<script src="/js/bootstrap.js"></script>
</body>
</html>