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
    <link rel="stylesheet" href="/resources/css/pub_manage.css?version=2">
    <script src="/resources/js/jquery.min.js"></script>
    <script>
        function showFile(){
            $("#hiddenFile").attr("type", "file");
        }

        function deletePub(){
            location.href="/pub/delete";
        }

        function modifyPub(){
            var form = document.modifyForm;
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
                        출판사 관리
                    </div>
                    <div class="content-main-content">
                        <form action="/pub/modify" enctype="multipart/form-data" name="modifyForm" method="post">
                            <div class="myInfo-content">
                                <div class="myInfo-content-title">
                                    대표 이미지
                                </div>
                                <div class="myInfo-content-content">
                                    <img src="${pubImage.path}" alt="">
                                </div>
                                <button class="form-button" id="changeImage" type="button" onclick="showFile()">이미지 변경</button>
                                <input type="hidden" id = "hiddenFile" name="img">

                            </div>
                            <div class="myInfo-content">
                                <div class="myInfo-content-title">
                                    출판사명
                                </div>
                                <div class="myInfo-content-content">
                                    <input type="text" style="width: 200px;" maxlength="15" value="${pub.name}" disabled name="name">
                                </div>

                            </div>
                            <div class="myInfo-content">
                                <div class="myInfo-content-title">
                                    소개
                                </div>
                                <div class="myInfo-content-content">
                                    <textarea name="description" id="" maxlength="75">${pub.description}</textarea>
                                </div>
                                <input type="hidden" value="${pub.oid}" name = "oid">

                            </div>
                            <br/><br/>
                        </form>
                        <button class="form-button final" type="button" onclick="modifyPub()">수정</button>
                        <button class="form-button final" type="button" onclick="deletePub()">삭제</button>
                    </div>

                </div>
    </div>

    <jsp:include page="/resources/jsp/footer.jsp"/>
</div>

</body>
</html>