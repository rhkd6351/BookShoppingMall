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
    <link rel="stylesheet" href="/resources/css/pwCert.css">
    <script>
        var phoneCheck = /(\d{3}).*(\d{3}).*(\d{4})/;
        var phone = document.getElementsByName("phone");

        function changePhone(){
            if(phoneCheck.test(phone[0].value) == false){
                alert("전화번호 형식이 올바르지 않습니다. \n ex) 010-1234-5678");
                return false;
            }
            var form = document.phoneForm;
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
                        전화번호 변경
                    </div>
                    <div class="content-main-content"> 
                        <form action="/user/phoneChange" method="POST" name = "phoneForm">
                        전화번호
                        <input type="text" name = "phone">
                        <input type="button" value="변경" onclick="changePhone()">
                        </form>
                    </div>
                </div>
                
            </section>
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