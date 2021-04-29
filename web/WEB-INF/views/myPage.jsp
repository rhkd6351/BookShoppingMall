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
    <link rel="stylesheet" href="/resources/css/myPageInfo.css?version=1">
    <script src="/resources/js/jquery.min.js"></script>
    <script>

        function pwChange() {
            var userPlatform = "${user.platform}";
            if(userPlatform != "local"){
                alert("SNS 가입 회원입니다.");
                return false;
            }else{
                location = "/user/changePw"
            }
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
                    기본 회원정보
                </div>
                <div class="content-main-content">
                    <div class="myInfo-content">
                        <div class="myInfo-content-title">
                            사진
                        </div>
                        <div class="myInfo-content-content">
                            기본이미지
                        </div>

                    </div>
                    <div class="myInfo-content">
                        <div class="myInfo-content-title">
                            아이디
                        </div>
                        <div class="myInfo-content-content">
                            ${user.email}&nbsp;
                        </div>

                    </div>
                    <div class="myInfo-content">
                        <div class="myInfo-content-title">
                            비밀번호
                        </div>
                        <div class="myInfo-content-content">
                            ********
                        </div>
                        <button onclick="pwChange()">비밀번호 변경</button>
                    </div>
                    <div class="myInfo-content">
                        <div class="myInfo-content-title">
                            전화번호
                        </div>
                        <div class="myInfo-content-content">
                            ${user.phone}&nbsp;
                        </div>
                        <button onclick="location.href='/user/changePhone'">전화번호 변경</button>
                    </div>
                    <div class="myInfo-content">
                        <div class="myInfo-content-title">
                            성별
                        </div>
                        <div class="myInfo-content-content">
                            ${user.gender}&nbsp;
                        </div>
                        <button onclick="location.href='/user/changeGender'">성별 변경</button>
                    </div>
                    <div class="myInfo-content"
                         style="border-bottom: none;">
                        <div class="myInfo-content-title">
                            생년월일
                        </div>
                        <div class="myInfo-content-content">
                            ${user.birth}&nbsp;
                        </div>
                        <button onclick="location.href='/user/changeBirth'">생년월일 변경</button>
                    </div>
                </div>
            </div>
    </div>

    <jsp:include page="/resources/jsp/footer.jsp"/>
</div>

</body>
</html>