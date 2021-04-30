<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>yekwang</title>
    <link rel="stylesheet" href="/resources/css/myPage.css?version=1">
    <link rel="stylesheet" href="/resources/css/myPageCart.css?version=2">
    <script src="/resources/js/jquery.min.js"></script>
</head>
<body>
<div class="page-wrapper">
    <jsp:include page="/resources/jsp/header.jsp"/>
    <div class="content">
        <section class="content-aside-center">
            <jsp:include page="/resources/jsp/myPage-top.jsp"/>
            <jsp:include page="/resources/jsp/myPage-menu.jsp"/>
                <div class="content-main">
                    <div class="content-main-title">
                        장바구니
                    </div>
                    <div class="content-main-content">
                        <table class="cart-table">
                            <thead class="cart-table-head">
                            <tr>
                                <th colspan="2">상품 정보</th>
                                <th>수량</th>
                                <th>금액</th>
                                <th>주문</th>
                            </tr>
                            </thead>
                            <tbody class="cart-table-body">
                            <c:forEach items="${cartList}" var="cart">
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td class="cart-desc">
                                        <img class = "prod-image" src="${cart.repUri}" alt="">
                                        <div class="prod-title">${cart.productTitle}</div>
                                        <div class="prod-desc">${cart.pubName} / ${cart.authorName} 저</div>
                                    </td>
                                    <td><input type="number" value="${cart.quantity}"/>개</td>
                                    <td>${cart.price * cart.quantity}원</td>
                                    <td>
                                        <button class="book-order">주문하기</button> <br/><br/>
                                        <button class="book-order red" type = "button" onclick="location.href='/cart/delete?cartOid=${cart.oid}'">삭제하기</button>
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="4">
                                    총 가격 : 20,000원 (상품 17,500원 + 배송비 2,500원)
                                </td>
                                <td>
                                    <button class="book-order">선택주문</button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
    </div>

    <jsp:include page="/resources/jsp/footer.jsp"/>
</div>

</body>
</html>