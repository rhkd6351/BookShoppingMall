<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>yekwang</title>
    <script src="/resources/js/jquery.min.js"></script>
    <link rel="stylesheet" href="/resources/css/myPage.css?version=7">
    <link rel="stylesheet" href="/resources/css/main.css?version=7">
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
            <div class="slider">
                <img src="/resources/img/slider/1.jpeg" class = "slide-img" alt="">
                <img src="/resources/img/slider/3.jpeg" class = "slide-img" alt="">
                <img src="/resources/img/slider/2.jpeg" class = "slide-img" alt="">
            </div>
            <i class="arrow left fas fa-angle-left"></i>
            <i class="arrow right fas fa-angle-right"></i>
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
            <div class="second-title">
                신간 도서
            </div>
            <c:forEach items="${newBookLayer}" var="book">
                <div class="second-item">
                    <div class="book-box">
                        <a href="/product/view?oid=${book.oid}">
                            <img src="<c:out value="${book.repUri}"/>" alt="" class="book-img">
                        </a>
                        <div class="item-title"><c:out value="${book.title}"/></div>
                        <div class="item-author"><c:out value="${book.authorName}"/></div>
                        <div class="item-price"><c:out value="${book.price}"/>원</div>
                    </div>

                </div>
            </c:forEach>
        </section>
        <section class="non-main">3층 컨텐츠</section>
        <section class="non-main">4층 컨텐츠</section>
    </div>

    <jsp:include page="/resources/jsp/footer.jsp"/>
</div>

</body>
<script src="/resources/js/main-slider-control.js"></script>
</html>