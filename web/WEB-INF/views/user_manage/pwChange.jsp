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
    <link rel="stylesheet" href="/resources/css/pwCert.css?version=4">
    <script src="/resources/js/jquery.min.js"></script>
    <script>
        var pwCheck = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/;
        var pw = document.getElementsByName("pw");

        function changePw2(){
            if(pw[0].value != pw[1].value){
                alert("비밀번호가 서로 틀립니다.");
                return false;
            }
            if(pwCheck.test(pw[0].value) == false){
                alert("비밀번호 형식이 올바르지 않습니다. \n 6~20자의 영문 + 숫자 또는 특수문자가 포함되어야 합니다.");
                return false;
            }
            var form = document.pwCh;
            form.submit();
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
                    <form action="/user/pwChange" method="POST" name="pwCh">
                        신규 비밀번호
                        <input type="password" name="pw"><br/><br/>
                        비밀번호 확인
                        <input type="password" name = "pw">
                        <input type="button" value="변경" onclick="changePw2()">
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