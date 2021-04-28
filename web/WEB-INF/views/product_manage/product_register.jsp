<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>yekwang</title>
    <link rel="stylesheet" href="../../../resources/css/myPage.css?version=9">
    <link rel="stylesheet" href="../../../resources/css/product_register.css?version=3">
    <script src="../../../resources/js/jquery.min.js"></script>
    <script>
        $(function(){
            $("#author").on("change",function(){
                if($("#author").val() == "0"){
                    $(".author_custom").attr("disabled",false);
                }else{
                    $(".author_custom").attr("disabled",true).val("");
                };
            });
        });

        function register(){
            var author = document.getElementById("author");
            var category = document.getElementById("category");
            if(author.value == ""){
                alert("작가를 선택해주세요");
                return false;
            }
            else if(category.value == "" ){
                alert("카테고리를 선택해주세요");
                return false;
            }
            else{
                var str = $("#description").val();
                str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
                $("#description").val(str);
                
                str = $("#contents").val();
                str = str.replace(/(?:\r\n|\r|\n)/g, '<br/>');
                $("#contents").val(str);
                var form = document.product_regi;
                form.submit();
            }
        }
    </script>
</head>
<body>
<div class="page-wrapper">
    <jsp:include page="../header.jsp"/>
    <div class="content">
        <section class="content-aside-center">
            <jsp:include page="../myPage-top.jsp"/>
            <jsp:include page="../myPage-menu.jsp"/>
                <div class="content-main">
                        <div class="content-main-title">
                            상품 등록 [${pub.name}]
                        </div>

                        <div class="content-main-content">
                            <form action="/product/register" method="POST" enctype="multipart/form-data" name="product_regi">
                            <div class="myInfo-content">
                                <div class="myInfo-content-title">
                                    제목
                                </div>
                                <div class="myInfo-content-content">
                                    <input type="text"  name="title" id="title" maxlength="100">
                                </div>
                            </div>


                            <div class="myInfo-content">
                                <div class="myInfo-content-title">
                                    소제목
                                </div>
                                <div class="myInfo-content-content">
                                    <input type="text"  name="subTitle" id="subTitle" maxlength="100">
                                </div>
                            </div>

                            <div class="myInfo-content">
                                <div class="myInfo-content-title">
                                    작가
                                </div>
                                <div class="myInfo-content-content">
                                    <select name="author" id="author">
                                        <option value="" selected>--------- 선택 ---------</option>
                                        <c:forEach items="${author}" var="author">
                                            <option value="${author.oid}">${author.name}</option>
                                        </c:forEach>
                                        <option value="0">직접 입력</option>
                                    </select>
                                    작가 이름 <input type="text" name = "author_name" class="author_custom" disabled = true > &nbsp;
                                    작가 소개 <input type="text" name = "author_description" class="author_custom" disabled = true >
                                </div>
                            </div>
                                <input type="hidden" name = "pub" readonly value="${pub.oid}" style="width: 300px;">
                            <div class="myInfo-content">
                                <div class="myInfo-content-title">
                                    카테고리
                                </div>
                                <div class="myInfo-content-content">
                                    <select name="category" id="category">
                                        <option value="" selected>--------- 선택 ---------</option>>
                                        <c:forEach items="${category}" var="category">
                                        <option value="<c:out value="${category.oid}"/>"><c:out value="${category.name}"/></option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="myInfo-content">
                                <div class="myInfo-content-title">
                                    가격
                                </div>
                                <div class="myInfo-content-content">
                                    <input type="number" name = "price"  value="0">
                                </div>
                            </div>
                            <div class="myInfo-content">
                                <div class="myInfo-content-title">
                                    택배요금
                                </div>
                                <div class="myInfo-content-content">
                                    <input type="number" name="deliveryFee" value="0">
                                </div>
                            </div>

                            <div class="myInfo-content textarea">
                                <div class="myInfo-content-title">
                                    내용
                                </div>
                                <div class="myInfo-content-content">
                                    <textarea id = "description" name="description" maxlength="3000" placeholder="최대 2000자"></textarea>
                                </div>
                            </div>

                            <div class="myInfo-content textarea">
                                <div class="myInfo-content-title">
                                    목차
                                </div>
                                <div class="myInfo-content-content">
                                    <textarea id = "contents" name="contents" maxlength="3000" placeholder="최대 2000자"></textarea>
                                </div>
                            </div>

                            <div class="myInfo-content">
                                <div class="myInfo-content-title">
                                    메인 이미지
                                </div>
                                <div class="myInfo-content-content">
                                    <input type="file" name="mainImage">
                                </div>
                            </div>

                            <div class="myInfo-content">
                                <div class="myInfo-content-title">
                                    본문 이미지
                                </div>
                                <div class="myInfo-content-content">
                                    <input type="file" name="descriptionImage">
                                </div>
                            </div>
                            </form>
                            <div class="myInfo-content">
                                <div class="myInfo-content-title">
                                    <button onclick="register()">등록</button>
                                </div>
                            </div>

                        </div>
                </div>
    </div>

    <jsp:include page="../footer.jsp"/>
</div>

</body>
</html>