<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 5/14/2023
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="total" value="0"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="org.apache.struts.util.LocalStrings"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/product-css/cart.css">
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
<div class="container" style="padding-top: 20px;">
    <c:if test="${not empty cartDetailDTOS}">
        <div class="row">
            <div class="col-lg-8">
                <div class="table-responsive">

                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <td class="col">Hình ảnh</td>
                            <td class="col">Tên sản phẩm</td>
                            <td class="col">Số lượng</td>
                            <td class="col">Đơn Giá</td>
                            <td class="col">Tổng cộng</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${cartDetailDTOS}" var="list" varStatus="loop">
                            <tr>
                                <td><a href=""><img src="${list.image}" style="width: 80px;height: 80px;"></a></td>
                                <td><a href=""></a>${list.name} <br>
                                    <small>Chọn size nam: ${list.size}</small></td>
                                <td class="text-center">
                                    <form action="/cart/update/${list.idCart}" method="post">
                                        <div class="mXmGu+ shopee-input-quantity">
                                            <button type="submit" class="mJX7hG"
                                                    onclick="decreaseValue(${loop.index},${list.idCart})">
                                                -
                                            </button>
                                            <input id="quantityInput${loop.index}"
                                                   class="mJX7hG _8BP9GU"
                                                   type="text" role="spinbutton" aria-valuenow="1"
                                                   value="${list.quantity}" name="quantity">
                                            <button type="submit" class="mJX7hG"
                                                    onclick="increaseValue(${loop.index})">
                                                +
                                            </button>
                                        </div>
                                    </form>
                                </td>
                                <td class="text-center td-price"><fmt:formatNumber value="${list.price}"
                                                                                   pattern="###,###"/>đ
                                </td>
                                <td class="text-center td-total"><fmt:formatNumber value="${list.price * list.quantity}"
                                                                                   pattern="###,###"/>đ
                                </td>
                                <c:set var="subTotal" value="${list.price * list.quantity}"/>
                                <c:set var="total" value="${total + subTotal}"/>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="cart-bottom">
                    <div class="cart-total">
                        <table class="table table-bordered">
                            <tbody>
                            <tr>
                                <td class="text-right"><strong>Thành tiền:</strong></td>
                                <td class="text-right"><fmt:formatNumber value="${total}" pattern="###,###"/>đ</td>
                            </tr>
                            <tr>
                                <td class="text-right"><strong>Tổng:</strong></td>
                                <td class="text-right"><fmt:formatNumber value="${total}" pattern="###,###"/>₫</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="buttons clearfix">
                    <div class="pull-right"><a href="/oder/view-thanh-toan"
                                               class="btn btn-primary"><span>Thanh toán</span></a></div>
                </div>
            </div>
        </div>
    </c:if>
    <c:if test="${empty cartDetailDTOS}">
        <div class="container" style="margin-right: auto;margin-left: auto;width: 1200px;">
            <div class="snlrc5 --3Iu+" style="display: flex;align-items: center;justify-content: center;height: 37.5rem;flex-direction: column;">
                <div class="+2nxRQ"></div>
                <div class="zH4psk">Giỏ hàng của bạn còn trống</div>
                <a class="OpSzHa" href="http://localhost:8080/product/hien-thi">
                    <button class="shopee-button-solid shopee-button-solid--primary"><span
                            class="_3Vjf2+">MUA NGAY</span></button>
                </a></div>
        </div>
    </c:if>
</div>
<jsp:include page="/view/footer.jsp"></jsp:include>
<script>
    function deleteProduct(cart) {
        if (confirm("Bạn Có Muốn Xóa Sản Phẩm Này Khỏi Giỏ Hàng Không")) {
            window.location.href = '/cart/delete/' + cart;
        } else {

        }
    }

    function decreaseValue(index, cart) {
        var input = document.getElementById("quantityInput" + index);
        var value = parseInt(input.value);
        if (value > 1) {
            input.value = value - 1;
        } else if (value === 1) {
            var confirmation = window.confirm("Bạn có muốn xóa sản phẩm này khỏi giỏ hàng không");
            if (confirmation) {
                window.location.href = '/cart/delete/' + cart;
            }
        }
    }

    function increaseValue(index) {
        var input = document.getElementById("quantityInput" + index);
        var value = parseInt(input.value);
        input.value = value + 1;
    }
</script>
</script>
<script src="/js/bootstrap.js"></script>
</body>
</html>
