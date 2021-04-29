<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>yekwang</title>
    <link rel="stylesheet" href="/resources/css/myPage.css?version=3">
    <link rel="stylesheet" href="/resources/css/product.css?version=3">
    <script src="/resources/js/jquery.min.js"></script>
    <script>
        $(function() {
            var count = 0;
            var max = ${recentBookList.size()} / 3;
            max = Math.ceil(max);

            if(max == 0){ //최근본 책이 없다면
                $(".right-nav").css("display","none");
            }
            $("#recent-max").text(max);
            $("#recent-rec").text(1);

            $(".right-content").css("display","none");
            $(".right-content").eq("0").css("display","block");
            $(".right-content").eq("1").css("display","block");
            $(".right-content").eq("2").css("display","block");

            $(".recent-left").on("click",function(){
                if(count == 0) return;
                $(".right-content").css("display","none");
                count -= 1;
                $(".right-content").eq(3 * count + 0).css("display","block");
                $(".right-content").eq(3 * count + 1).css("display","block");
                $(".right-content").eq(3 * count + 2).css("display","block");

                $("#recent-rec").text(count + 1);
            })
            $(".recent-right").on("click",function(){
                if(count >=(max - 1)) return;
                $(".right-content").css("display","none");
                count += 1;
                $(".right-content").eq(3 * count + 0).css("display","block");
                $(".right-content").eq(3 * count + 1).css("display","block");
                $(".right-content").eq(3 * count + 2).css("display","block");

                $("#recent-rec").text(count + 1);
            })
        })
    </script>
    <script src="/resources/js/right_bar_control.js"></script>
</head>
<body>
<div class="page-wrapper">
    <jsp:include page="/resources/jsp/header.jsp"/>
    <div class="content">
        <section class="content-aside-left">
            <img src="/resources/img/adBanner/ad1.png" alt="" class="left-banner">
        </section>
        <section class="content-aside-center">
            <div class="center center-left">
                <img src="${product.repUri}" class="product-rep-img" alt="">
            </div>
            <div class="center center-right">
                <div class="right-item item-title">${product.title}</div>
                <div class="right-item item-subtitle">${product.subTitle}</div>
                <div class="right-item item-desc">${product.pubName} / ${product.authorName} 저</div>
                <table class = "price">
                    <tr>
                        <td class="bold">정가</td>
                        <td>${product.price}원</td>
                    </tr>
                    <tr>
                        <td class="bold">판매가</td>
                        <td class="bold red em15">${product.price}원</td>
                    </tr>
                    <tr>
                        <td>택배비</td>
                        <td>${product.deliveryFee}원</td>
                    </tr>
                    <tr>
                        <td>개수</td>
                        <td><input type="number" value="1" style="width: 40px;"/></td>
                    </tr>
                </table>
                <div class="right-item item-button">
                    <button class="right-item-button cart floating">장바구니</button>
                    <button class="right-item-button buy floating">바로 구매</button>
                </div>
            </div>
        </section>
        <section class="content-aside-right">
            <div class="right-title">
                최근 본 도서
            </div>
            <c:forEach items="${recentBookList}" var="book">
                <div class="right-content">
                    <a href="/product/view?oid=${book.oid}"><img src="${book.repUri}" alt=""></a>
                </div>
            </c:forEach>
            <div class="right-nav">
                <i class="fas fa-angle-left recent-left"></i>
                <t id="recent-rec"></t> / <t id="recent-max"></t>
                <i class="fas fa-angle-right recent-right"></i>
            </div>
        </section>

        <section class="non-main">
            <div class="em15 non-title">
                책 소개
            </div>
            <div class="non-desc">
                ${product.description}
            </div>
        </section>

        <section class="non-main">
            <div class="em15 non-title">
                목차
            </div>
            <div class="non-desc">
                ${product.contents}
            </div>
        </section>

        <section class="non-main">
            <div class="em15 non-title">
                상세 이미지
            </div>
            <div class="non-desc">
                <img class = "desc-img" src="${product.descUri}" alt="">
            </div>
        </section>

        <section class="non-main">
            <div class="em15 non-title">
                저자 ${product.authorName}
            </div>
            <div class="non-desc">
                ${product.authorDesc}
            </div>
        </section>
    </div>

    <jsp:include page="/resources/jsp/footer.jsp"/>
</div>

</body>
</html>