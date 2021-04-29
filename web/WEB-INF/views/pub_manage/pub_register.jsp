<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>yekwang</title>
    <link rel="stylesheet" href="/resources/css/myPage.css?version=10">
    <link rel="stylesheet" href="/resources/css/pub_register.css?version=2">
    <script src="/resources/js/jquery.min.js"></script>
    <script>
        function pubRegi(){
            var form = document.pub_regi;
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
                        출판사 등록
                    </div>
                    <div class="content-main-content">
                        <form action="/pub/register" method="post" enctype="multipart/form-data"
                        name="pub_regi">
                            <div class="myInfo-content">
                                <div class="myInfo-content-title">
                                    사진
                                </div>
                                <div class="myInfo-content-content">
                                    출판사 대표 이미지를 등록하세요 (50px * 50px)
                                </div>
                                <input type="file" value="파일 선택" name="pub_img"/>

                            </div>
                            <div class="myInfo-content">
                                <div class="myInfo-content-title">
                                    이름
                                </div>
                                <div class="myInfo-content-content">
                                    <input type="text" style="width: 200px;" maxlength="15" name="pub_name">

                                </div>

                            </div>
                            <div class="myInfo-content">
                                <div class="myInfo-content-title">
                                    소개
                                </div>
                                <div class="myInfo-content-content">
                                    <textarea id="" maxlength="75" name="pub_desc"></textarea>
                                </div>

                            </div>
                            <br/><br/>
                        </form>
                        <button class="form-button final" onclick="pubRegi()">등록하기</button>
                    </div>

                </div>
    </div>
    <jsp:include page="/resources/jsp/footer.jsp"/>
</div>

</body>
</html>