<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>yekwang</title>
    <link rel="stylesheet" href="../../../resources/css/pwCert.css">
    <script>
        
        var birth = document.getElementsByName("birth");

        function changeBirth(){
            if(birth[0].value == ""){
                alert("날짜를 정확히 입력해주세요");
                return false;
            }
            var form = document.birthForm;
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
                        생년월일 변경
                    </div>
                    <div class="content-main-content"> 
                        <form action="/user/birthChange" method="POST" name = "birthForm">
                        생년월일
                        <input type="date" name = "birth">
                        <input type="button" value="변경" onclick="changeBirth()">
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