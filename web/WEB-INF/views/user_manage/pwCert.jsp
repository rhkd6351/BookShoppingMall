<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>yekwang</title>
    <link rel="stylesheet" href="/resources/css/myPage.css?version=8">
    <link rel="stylesheet" href="/resources/css/pwCert.css?version=3">
    <script src="/resources/js/jquery.min.js"></script>
    <script>
        var cert = "${certify}";
        if(cert == "false"){
            alert("비밀번호가 틀렸습니다.");
        }
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
                    비밀번호 변경
                </div>
                <div class="content-main-content"> 
                    <form action="/user/pwCert" method="POST">
                    본인확인을 위해 현재 비밀번호를 입력하세요 <br/><br/>
                    <input type="password" name="pw">
                    <input type="submit" value="인증" name="" id="">
                    </form>
                </div>
            </div>

        </section>
        <!--
        <section class="content-aside-right">
            right-slide
        </section>
        -->
    </div>

    <footer>
        <div class="footer-wrapper">
            rhkd6351@kyonggi.ac.kr <br/> <br/>
            https://github.com/rhkd6351
        </div>

    </footer>
</div>

</body>
</html>