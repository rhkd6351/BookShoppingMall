<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>yekwang</title>
    <link rel="stylesheet" href="../../resources/css/register.css">
</head>

<body>
<div class="content">
    <div class="title">
        BOOK <span style="color: #707070;">SHOPPING</span> MALL
    </div>

    <div class="register">
        <form action="/user/register" method="post" name="regi_form"><br/>
            <br><div class="regi-title">이메일</div>
            <input name="email" type="text" placeholder="abcd@domain.com" id="login-id"><br/>
            <div class="regi-title">비밀번호 (6~20개의 영문 + 숫자 or 특수문자 조합)</div>
            <input name="pw" type="password" placeholder="PASSWORD" id="login-pw"><br/>
            <div class="regi-title">전화번호</div>
            <input name="phone" type="text" placeholder="010-1234-5678" id="login-pw"><br/>
            <div class="regi-title">성별</div>
            <select name="gender">
                <option value="">선택</option>
                <option value="male">남성</option>
                <option value="female">여성</option>
            </select>
            <div class="regi-title">생년월일</div>
            <input name="birth"type="date" placeholder="생일" id="login-id"><br/>


        </form>
        <button onclick="valid_check()" >가입하기</button>
    </div>
    <div class="footer">
        rhkd6351@kyonggi.ac.kr <br/>
    </div>
</div>
</body>
<script src="../../resources/js/reg_validation.js"></script>
</html>