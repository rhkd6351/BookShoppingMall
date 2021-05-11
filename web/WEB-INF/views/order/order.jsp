<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>yekwang</title>
    <link rel="stylesheet" href="/resources/css/myPage.css?version=2">
    <link rel="stylesheet" href="/resources/css/order.css?version=3">
    <script src="/resources/js/jquery.min.js"></script>
</head>
<body>
<div class="page-wrapper">
    <jsp:include page="/resources/jsp/header.jsp"/>
    <div class="content">
        <section class="content-aside-center">
            <div class="content-main">
                <div class="content-main-title">
                    주문
                </div>
                <div class="content-main-content">
                    <div class="content-main-content-floor">
                        <div class="content-main-title">
                            상품정보
                        </div>
                        <table class="cart-table">
                            <thead class="cart-table-head">
                            <tr>
                                <th colspan="1">상품 정보</th>
                                <th>수량</th>
                                <th>금액</th>
                            </tr>
                            </thead>
                            <tbody class="cart-table-body">
                            <c:forEach items="${cartList}" var="cart">
                            <tr>
                                <td class="cart-desc">
                                    <img class = "prod-image" src="${cart.repUri}" alt="">
                                    <div class="prod-title">${cart.productTitle}</div>
                                    <div class="prod-desc">${cart.pubName} / ${cart.authorName} 저</div>
                                </td>
                                <td><input type="number" value="${cart.quantity}" readonly/>개</td>
                                <td>10,000원</td>
                            </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="3">
                                    총 가격 : 20,000원 (상품 17,500원 + 배송비 2,500원)
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="content-main-content-floor">
                        <div class="content-main-title">
                            배송지
                        </div>
                        <div class="content-main-content">

                            <table class="table address-table">
                                <tr style="text-align: left; height: 50px;">
                                    <td>기본 배송지 <input type="radio" name="address" id="" disabled/></td>
                                    <td style="padding-left: 30px;">신규 배송지 <input type="radio" name="address" id=""
                                                                                  checked/></td>
                                </tr>
                                <tr>

                                    <td><button>검색</button></td>
                                    <td><input type="text" readonly></td>
                                </tr>
                                <tr>
                                    <td>상세주소</td>
                                    <td><input type="text"></td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="content-main-content-floor coupon-floor">
                        <div class="content-main-title">
                            쿠폰
                        </div>
                        <div class="content-main-content">
                            <table class="table coupon-table">
                                <tr>
                                    <td><button>선택</button></td>
                                    <td><input type="text" readonly></td>
                                    <td>-3000</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="content-main-content-floor payment-floor">
                        <div class="content-main-title">
                            결제수단
                        </div>
                        <div class="content-main-content">
                            <table class="table payment-table">
                                <tr style="text-align: left; height: 50px;">
                                    <td>무통장 입금 <input type="radio" name="payment" id="" checked/></td>

                                </tr>
                                <tr>
                                    <td>계좌번호는 주문 완료후 표시됩니다</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

        </section>
        <section class="content-aside-right">
            123
        </section>

    <jsp:include page="/resources/jsp/footer.jsp"/>
</div>

</body>
</html>