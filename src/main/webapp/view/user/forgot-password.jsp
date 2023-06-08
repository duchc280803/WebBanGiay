<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/11/2023
  Time: 7:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <style>
        .center {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 400px;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
        }
    </style>
</head>
<body>
<div class="center">
    <div class="card text-center">
        <div class="card-header h5 text-white bg-primary">Password Reset</div>
        <div class="card-body px-5">
            <p class="card-text py-2">
                Enter your email address and we'll send you an email with instructions to reset your password.
            </p>
            <div class="form-outline">
                <input type="email" id="typeEmail" class="form-control my-3"/>
                <label class="form-label" for="typeEmail">Email input</label>
            </div>
            <a href="#" class="btn btn-primary w-100">Reset password</a>
            <div class="d-flex justify-content-between mt-4">
                <a class="" href="/dang-nhap/form">Login</a>
            </div>
        </div>
    </div>
</div>
<script src="/js/bootstrap.js"></script>
</body>
</html>
