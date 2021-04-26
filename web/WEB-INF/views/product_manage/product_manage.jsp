<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>yekwang</title>
    <link rel="stylesheet" href="/resources/css/myPage.css?version=9">
    <link rel="stylesheet" href="/resources/css/product_manage.css?version=3">
    <script src="/resources/js/jquery.min.js"></script>
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
                        상품 관리 [${pub.name}]
                    </div>
                    <div class="content-main-content">
                            <div class="myInfo-content">
                                <table>
                                    <thead>
                                    <tr>
                                        <th>등록번호</th>
                                        <th>이름</th>
                                        <th>저자</th>
                                        <th>상세정보</th>
                                        <th>삭제</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${products}" var="product">
                                    <tr>
                                        <td><c:out value="${product.oid}"/></td>
                                        <td><c:out value="${product.title}"/></td>
                                        <td><c:out value="${product.authorOid}"/></td>
                                        <td><a href="/product/modify?oid=<c:out value="${product.oid}"/>"
                                        style="color: black">보기</a></td>
                                        <td>삭제</td>
                                    </tr>
                                    </c:forEach>

                                    </tbody>
                                </table>
                            </div>
                            <br/><br/>
                    </div>

                </div>
    </div>

    <jsp:include page="../footer.jsp"/>
</div>

</body>
</html>