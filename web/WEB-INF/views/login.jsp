
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>

    var loginValueCheck = "${loginTry}";

    if(loginValueCheck == "false"){
        alert("${loginMsg}");
    }
    function login(){
        var login_form = document.login_form;
        login_form.submit();
    }
</script>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>yekwang</title>
    <link rel="stylesheet" href="../../resources/css/login.css?version=1">
</head>
<body>
<div class="content">
    <div class="title">
        BOOK <span style="color: #707070;">SHOPPING</span> MALL
    </div>

    <div class="login">
        <form name = "login_form" action="/user/login" method="post">
            <input name = "email" type="text" placeholder="EMAIL" id="login-id"><br/>
            <input name = "pw" type="password" placeholder="PASSWORD" id="login-pw">
        </form>
        <button onclick="login()">로그인</button>
    </div>

    <nav>
        <div><a href="/user/register">회원가입</a></div>
        <div>아이디 찾기</div>
        <div>비밀번호 찾기</div>
    </nav>
    <div class="social-login">
        <a href = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id=eedc76d38d9fb6483db97b48b0be11ee&redirect_uri=http://localhost:8080/user/login/kakao"><div class="social kakao">
            continue with <span>kakao</span>
        </div></a>
        <div class="social facebook">
            continue with <span>facebook</span>
        </div>
    </div>

    <div class="footer">
        rhkd6351@kyonggi.ac.kr <br/>
    </div>
</div>




</body>
</html>
