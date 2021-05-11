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
    <link rel="stylesheet" href="/resources/css/myPageCart.css?version=3">
    <script src="/resources/js/jquery.min.js"></script>
    <script>
        function refreshCart(){ //카트 리스트 수량-금액 값 설정 메소드
            var sumPrice = 0;
            for(var i = 0; i < $(".cart-list").length; i++){
                if($(".quantity").eq(i).val() <= 0) //0이하 값 변경 방지
                    $(".quantity").eq(i).val(1);

                var indivSum = $(".indivPrice").eq(i).val() * $(".quantity").eq(i).val();
                $(".price").eq(i).text(indivSum);
                sumPrice += indivSum;
            }
            $("#sumPrice").text(sumPrice);
        }
        $(function (){
            refreshCart();
            $(".quantity").on("change",function (){
                $.ajax({
                    type: "get",
                    url: "/cart/update", // http://localhost:8080/cart/update
                    data: {
                        "cartOid" : $(this).parent().parent().find("#cartOid").val(),
                        "quantity" : $(this).val()
                    },
                    dataType: "json",
                    success: function (response) {
                        console.log(response);
                    }
                });
                refreshCart();
            });
        })
    </script>
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
                                <th style="width: 150px">금액</th>
                                <th>주문</th>
                            </tr>
                            </thead>
                            <tbody class="cart-table-body">
                            <c:forEach items="${cartList}" var="cart">
                                <form action="/order/" method="post">
                                <tr class="cart-list">
                                    <td class="cart-desc" colspan="2">
                                        <img class = "prod-image" src="${cart.repUri}" alt="">
                                        <div class="prod-title">${cart.productTitle}</div>
                                        <div class="prod-desc">${cart.pubName} / ${cart.authorName} 저</div>
                                    </td>
                                    <td><input type="number" min=1 max=99 value="${cart.quantity}" name="quantity" class="quantity" id="quantity"/>개</td>
                                    <input type="hidden" value="${cart.price}" class="indivPrice" disabled/>
                                    <input type="hidden" value="${cart.oid}" id = "cartOid" name="cartOid" disabled/>
                                    <input type="hidden" value="${cart.productOid}" name="productOid"/>
                                    <td><span class="price"></span>원</td>
                                    <td>
                                        <button class="book-order">주문하기</button> <br/><br/>
                                        <button class="book-order red" type = "button" onclick="location.href='/cart/delete?cartOid=${cart.oid}'">삭제하기</button>
                                    </td>
                                </tr>
                            </form>
                            </c:forEach>
                            <form method="post" action="/order/">
                            <tr>
                                <td colspan="4">
                                    총 가격 : <span id="sumPrice"></span>원
                                </td>
                                <td>
                                <c:forEach items="${cartList}" var="cart">
                                <input type="hidden" value="${cart.oid}" name="cartOid">
                                </c:forEach>
                                    <button class="book-order">일괄주문</button>
                                </td>
                            </tr>
                            </form>
                            </tbody>
                        </table>
                    </div>
                </div>
    </div>

    <jsp:include page="/resources/jsp/footer.jsp"/>
</div>

</body>
</html>