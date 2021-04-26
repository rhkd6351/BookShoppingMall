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
        
        var gender = document.getElementsByName("gender");

        function changeGender(){
            if(gender[0].value == ""){
                alert("성별을 정확히 입력해주세요");
                return false;
            }
            var form = document.genderForm;
            form.submit();
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
                        성별 변경
                    </div>
                    <div class="content-main-content"> 
                        <form action="/user/genderChange" method="POST" name = "genderForm">
                        성별
                        <select name="gender">
                            <option value="">선택</option>
                            <option value="male">남성</option>
                            <option value="female">여성</option>
                        </select>
                        <input type="button" value="변경" onclick="changeGender()">
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