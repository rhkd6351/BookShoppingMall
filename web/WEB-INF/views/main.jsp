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
    <link rel="stylesheet" href="/resources/css/main.css?version=1">
    <script src="/resources/js/jquery.min.js"></script>

    <script>
        $(function(){
            var slider = $(".slider");
            firstSlide = slider.find(".slide-img").first()
                .animate({'opacity':1},200);

            function nextSlide() {
                slider.find(".slide-img").first().appendTo(slider);
                slider.find(".slide-img").last().animate({'opacity':0}, 400);
                slider.find(".slide-img").first().animate({'opacity':1}, 400);
            }

            function prevSlide() {
                slider.find(".slide-img").last().prependTo(slider);
                slider.find(".slide-img").eq(1).animate({'opacity':0}, 400);
                slider.find(".slide-img").first().animate({'opacity':1}, 400);
            }

            var interval;
            function startSlide(){
                interval = setInterval(nextSlide,3000);
            }
            function stopSlide(){
                clearInterval(interval);
            }
            $(".content-aside-center").hover(function(){
                $(".arrow").first().animate({"opacity":1},100);
                $(".arrow").eq(1).animate({"opacity":1},100);
                stopSlide();
            }, function(){
                $(".arrow").first().animate({"opacity":0},100);
                $(".arrow").eq(1).animate({"opacity":0},100);
                $(".arrow").attr("opacity", 0);
                startSlide();
            });


            startSlide();

            $(".right").on("click",function(){
                nextSlide();
            })
            $(".left").on("click",function(){
                prevSlide();
            })

        });

    </script>
</head>
<body>
<div class="page-wrapper">
    <jsp:include page="header.jsp"/>
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
            <div class="right-content">
                1번도서
            </div>
            <div class="right-content">
                2번도서
            </div>
            <div class="right-nav">
                방향키
            </div>
        </section>

        <section class="non-main">
            <div class="second-title">
                신간 도서
            </div>
            <c:forEach items="${newBookLayer}" var="book">
                <div class="second-item">
                    <div class="book-box">
                        <img src="<c:out value="${book.repUri}"/>" alt="" class="book-img">
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

    <jsp:include page="footer.jsp"/>
</div>

</body>
</html>