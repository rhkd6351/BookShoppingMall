<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>yekwang</title>
    <link rel="stylesheet" href="/resources/css/register.css">
</head>
<script src="/resources/js/jquery.min.js"></script>
<script>
    $(document).ready(function(){
        $("#login-id").on("change", function(){
            $.ajax({
                type: "get",
                url: "/user/emailValidCheck",
                data: {
                    "email" : $("#login-id").val()
                },
                dataType: "json",
                success: function (response) {
                    console.log(response);
                    console.log(response.type);
                    if(response == true){
                        console.log(response);
                        console.log(response.type);
                        $("#id-title").css("color","red").text("이메일 (이미 존재하는 아이디입니다)");
                        $("button").attr("disabled",true).css("background-color","black");
                    }else{
                        $("#id-title").css("color","black").text("이메일");
                        $("button").attr("disabled",false).css("background-color","#8B0000");
                    }
                }
            });
        })

    })
</script>

<body>
<div class="content">
    <div class="title">
        BOOK <span style="color: #707070;">SHOPPING</span> MALL
    </div>

    <div class="register">
        <form action="/user/register" method="post" name="regi_form"><br/>
            <br><div class="regi-title" id="id-title">이메일</div>
            <input name="email" type="email" placeholder="abcd@domain.com" id="login-id"><br/>
            <div class="regi-title">비밀번호 (6~20개의 영문 + 숫자 or 특수문자 조합)</div>
            <input name="pw" type="password" placeholder="PASSWORD" id="login-pw"><br/>
            <div class="regi-title">전화번호</div>
            <input name="phone" type="text" placeholder="010-1234-5678"><br/>
            <div class="regi-title">성별</div>
            <select name="gender">
                <option value="">선택</option>
                <option value="male">남성</option>
                <option value="female">여성</option>
            </select>
            <div class="regi-title">생년월일</div>
            <input name="birth"type="date" placeholder="생일"><br/>


        </form>
        <button onclick="valid_check()" >가입하기</button>
    </div>
    <div class="footer">
        rhkd6351@kyonggi.ac.kr <br/>
    </div>
</div>
</body>
<script src="/resources/js/reg_validation.js"></script>
</html>