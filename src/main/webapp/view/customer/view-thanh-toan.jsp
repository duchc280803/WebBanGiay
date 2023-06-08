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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="total" value="0"/>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="org.apache.struts.util.LocalStrings"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/product-css/thanh-toan.css">
</head>
<body>
<jsp:include page="/view/header.jsp"></jsp:include>
<section>
    <div class="container" style="padding-top: 17px;">
        <form:form action="/oder/create" method="post" modelAttribute="oderDTO">
            <div class="row">
                <div class="col-lg-4">
                    <div class="checkout-section section-register">
                        <div class="title section-title">Thông tin giao hàng</div>
                        <div class="section-body">
                            <div class="form-group required account-firstname">
                                <label class="control-label">Họ và tên:</label>
                                <form:input type="text" path="recipientName" placeholder="Họ và tên:"
                                            class="form-control"/>
                                <form:errors path="recipientName" cssClass="text-bg-danger"></form:errors>
                                <div class="form-group required account-email">
                                    <label for="input-email" class="control-label">Điện thoại:</label>
                                    <form:input type="text" path="phone" placeholder="Điện thoại:" id="input-email"
                                                class="form-control"/>
                                    <form:errors path="phone" cssClass="text-bg-danger"></form:errors>
                                    <div class="form-group required account-telephone">
                                        <label for="input-telephone" class="control-label">Email (nếu có):</label>
                                        <input type="text" path="" value=""
                                               placeholder="Email (nếu có):"
                                               id="input-telephone" class="form-control"/>
                                    </div>
                                </div>
                                <div class="checkout-section payment-address">
                                    <div class="title section-title">Địa chỉ giao hàng</div>
                                    <div class="section-body">
                                        <div>
                                            <div class="form-group required address-address-1">
                                                <label class="control-label">Địa chỉ:</label>
                                                <form:input type="text" path="address" placeholder="Địa chỉ:"
                                                            class="form-control"/>
                                                <form:errors path="address" cssClass="text-bg-danger"></form:errors>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-8">
                    <div class="right">
                        <div class="checkout-section shipping-payment" style="display: flex;">
                            <div class="section-shipping">
                                <div class="title section-title">Phương thức giao hàng</div>
                                <div class="section-body">
                                    <div>
                                        <div class="shippings">
                                            <div class="ship-wrapper">
                                                <div class="radio">
                                                    <label>
                                                        <input type="radio" name="shipping_method"
                                                               value="free.free"
                                                               onclick="updateShippingCost(0)">
                                                        <span class="shipping-quote-title">Miễn phí giao hàng - 0₫</span>
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="shippings">
                                            <div class="ship-wrapper">
                                                <div class="radio">
                                                    <label>
                                                        <input type="radio" name="shipping_method"
                                                               value="flat.flat"
                                                               onclick="updateShippingCost(25000)">
                                                        <span class="shipping-quote-title">Ship siêu tốc - 25.000₫</span>
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="section-payment" style="    padding-left: 170px;">
                                <div class="title section-title">Phương thức thanh toán</div>
                                <div class="section-body text-right">
                                    <div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="payment_method" value="cod">
                                                <span>Thanh toán khi nhận hàng</span>
                                            </label>
                                        </div>
                                    </div>
                                    <div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="payment_method"
                                                       value="bank_transfer">
                                                <span>Chuyển khoản ngân hàng</span>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="checkout-section cart-section">
                            <div class="title section-title">Giỏ hàng</div>
                            <div class="section-body"><!---->
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <td class="text-center td-image">Hình ảnh</td>
                                            <td class="text-left td-product">Tên sản phẩm</td>
                                            <td class="text-center td-qty">Số lượng</td>
                                            <td class="text-right td-price">Giá</td>
                                            <td class="text-right td-total">Tổng</td>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="list" items="${cartDetailDTOS}">
                                            <tr>
                                                <td class="text-center td-image"><a href=""><img
                                                        src="${list.image}"
                                                        class="img-thumbnail"></a></td>
                                                <td class="text-left td-product">
                                                    <a href="">
                                                            ${list.name}
                                                    </a>
                                                    <br>
                                                    <small>Chọn size nam: ${list.size}</small>
                                                </td>
                                                <td class="text-left td-qty">
                                                    <form:input type="hidden" path="quantity" value="${list.quantity}"/>
                                                        ${list.quantity}
                                                </td>
                                                <td class="text-right td-price"><fmt:formatNumber
                                                        value="${list.price}"
                                                        pattern="###,###"/> đ
                                                </td>
                                                <td class="text-right td-total">
                                                    <form:input type="hidden" path="totalMoney"
                                                                value="${list.price * list.quantity}"/>
                                                    <fmt:formatNumber value="${list.price * list.quantity}"
                                                                      pattern="###,###"/> đ
                                                </td>
                                                <c:set var="subTotal"
                                                       value="${list.price * list.quantity}"/>
                                                <c:set var="total" value="${total + subTotal}"/>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <table class="table table-bordered">
                                    <tfoot>
                                    <tr>
                                        <td colspan="7" class="text-right"><strong>Thành Tiền</strong></td>
                                        <td class="text-right">
                                            <form:input type="hidden" path="thanhTien" value="${total}"/>
                                            <fmt:formatNumber value="${total}" pattern="###,###"/>đ
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="7" class="text-right"><strong>Miễn phí giao
                                            hàng:</strong></td>
                                        <td class="text-right" id="shippingCost">0₫</td>
                                    </tr>
                                    <tr>
                                        <td colspan="7" class="text-right"><strong>Tổng:</strong></td>
                                        <td class="text-right" id="totalCost"></td>
                                    </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                        <div class="checkout-section confirm-section">
                            <div class="section-body">
                                <div class="buttons confirm-buttons">
                                    <div class="pull-right" style="text-align: center;">
                                        <button type="submit" data-loading-text="<span>MUA HÀNG</span>"
                                                id="quick-checkout-button-confirm" class="btn btn-primary">
                                            <span>MUA HÀNG</span></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</section>
<jsp:include page="/view/footer.jsp"></jsp:include>
<script>
    function updateShippingCost(shippingCost) {
        document.getElementById("shippingCost").textContent = shippingCost + "₫";
    }

    function updateTotalCost() {
        var total = parseFloat("${total}");
        var shippingCost = parseFloat(document.getElementById("shippingCost").textContent.replace("₫", ""));
        var totalCost = total + shippingCost;
        document.getElementById("totalCost").textContent = totalCost.toLocaleString() + "đ";
    }

    // Gọi hàm updateTotalCost() khi giá trị tiền hàng hoặc tiền giao hàng thay đổi
    document.addEventListener("DOMContentLoaded", updateTotalCost);
    document.getElementById("shippingCost").addEventListener("DOMSubtreeModified", updateTotalCost);
</script>
</body>
</html>