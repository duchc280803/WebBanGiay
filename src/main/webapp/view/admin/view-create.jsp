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
<div>
    <c:if test="${not empty message}">
        <div class="alert alert-danger">
                ${message}
            <c:remove var="message" scope="session" />
        </div>
    </c:if>
    <c:if test="${not empty error}">
        <div class="alert alert-danger">
                ${error}
            <c:remove var="error" scope="session" />
        </div>
    </c:if>
</div>
<div class="container-fluid">
    <div class="row">
        <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
            <div class="position-sticky pt-3">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link" href="/admin/dashboard">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home" aria-hidden="true"><path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path><polyline points="9 22 9 12 15 12 15 22"></polyline></svg>
                            Dashboard
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/oder/hien-thi">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file" aria-hidden="true"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                            Orders
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/product-manager/hien-thi-product">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-cart" aria-hidden="true"><circle cx="9" cy="21" r="1"></circle><circle cx="20" cy="21" r="1"></circle><path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path></svg>
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
                <form:form action="/product-manager/create" method="post" modelAttribute="productManagerDTO">
                    <div class="form-outline">
                        <label class="form-label" for="typeText">Name</label>
                        <form:input type="text" path="name" id="typeText" class="form-control"/>
                        <form:errors path="name" cssClass="text-danger"/>
                    </div>
                    <br>
                    <label class="form-label" for="typeText">Size</label>
                    <div style="display: flex;">
                        <form:select items="${sizeId}" path="size" class="form-select" aria-label="Default select example">
                        </form:select>
                        <form:errors path="size" cssClass="text-danger"/>
                        <button style="margin-left: 10px;" class="btn btn-warning">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-plus-square-fill" viewBox="0 0 16 16">
                                <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0z"/>
                            </svg>
                        </button>
                    </div>
                    <br>
                    <label class="form-label" for="typeText">Color</label>
                    <div style="display: flex;">
                        <form:select items="${colorId}" path="color" class="form-select" aria-label="Default select example">
                        </form:select>
                        <form:errors path="color" cssClass="text-danger"/>
                        <button style="margin-left: 10px;" class="btn btn-warning">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-plus-square-fill" viewBox="0 0 16 16">
                                <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0z"/>
                            </svg>
                        </button>
                    </div>
                    <br>
                    <label class="form-label" for="typeText">Category</label>
                    <div style="display: flex;">
                        <form:select items="${categoryIds}" path="category" class="form-select" aria-label="Default select example">
                        </form:select>
                        <form:errors path="category" cssClass="text-danger"/>
                        <button style="margin-left: 10px;" class="btn btn-warning">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-plus-square-fill" viewBox="0 0 16 16">
                                <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0z"/>
                            </svg>
                        </button>
                    </div>
                    <br>
                    <label class="form-label" for="typeText">Origin</label>
                    <div style="display: flex;">
                        <form:select items="${originId}" path="origin" class="form-select" aria-label="Default select example">
                        </form:select>
                        <form:errors path="origin" cssClass="text-danger"/>
                        <button style="margin-left: 10px;" class="btn btn-warning">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                                 class="bi bi-plus-square-fill" viewBox="0 0 16 16">
                                <path d="M2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2zm6.5 4.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3a.5.5 0 0 1 1 0z"/>
                            </svg>
                        </button>
                    </div>
                    <br>
                    <div class="form-outline">
                        <label class="form-label" for="typeText">Quantity</label>
                        <form:input path="quantity" type="number" class="form-control"/>
                        <form:errors path="quantity" cssClass="text-danger"/>
                    </div>
                    <br>
                    <div class="form-outline">
                        <label class="form-label" for="typeText">Price</label>
                        <form:input path="price" type="number" class="form-control"/>
                        <form:errors path="price" cssClass="text-danger"/>
                    </div>
                    <br>
                    <div class="form-outline">
                        <label class="form-label" for="typeText">Description</label>
                        <form:input path="description" type="text" class="form-control"/>
                        <form:errors path="description" cssClass="text-danger"/>
                    </div>
                    <br>
                    <div class="form-outline">
                        <label class="form-label" for="typeText">Image</label>
                        <form:input path="image" type="text" class="form-control"/>
                        <form:errors path="image" cssClass="text-danger"/>
                    </div>
                    <br>
                    <form:button type="submit" class="btn btn-warning">ADD</form:button>
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
