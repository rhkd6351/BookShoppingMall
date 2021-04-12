function valid_check(){
    var email = document.getElementsByName("email");
    var pw = document.getElementsByName("pw");
    var gender = document.getElementsByName("gender");
    var birth = document.getElementsByName("birth");
    var phone = document.getElementsByName("phone")

    var emailCheck = /^[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}$/;
    var pwCheck = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{6,20}$/;
    var phoneCheck = /(\d{3}).*(\d{3}).*(\d{4})/;



    if(email[0].value == ""){
        alert("email을 입력하세요");
        email[0].focus();
        return false;
    }
    if(pw[0].value == ""){
        alert("비밀번호를 입력하세요")
        pw[0].focus();
        return false;
    }
    if(phone[0].value == ""){
        alert("전화번호를 입력하세요")
        phone[0].focus();
        return false;
    }
    if(gender[0].value == ""){
        alert("성별을 선택하세요")
        gender[0].focus();
        return false;
    }
    if(birth[0].value == ""){
        alert("생년월일을 입력하세요")
        birth[0].focus();
        return false;
    }

    if(emailCheck.test(email[0].value) == false){
        alert("이메일 형식이 올바르지 않습니다. \n ex) aabbcc@naver.com");
        return false;
    }

    if(pwCheck.test(pw[0].value) == false){
        alert("비밀번호 형식이 올바르지 않습니다. \n 6~20자의 영문 + 숫자 또는 특수문자가 포함되어야 합니다.");
        return false;
    }
    if(phoneCheck.test(phone[0].value) == false){
        alert("전화번호 형식이 올바르지 않습니다. \n ex) 010-1234-5678");
        return false;
    }
    var regi_form = document.regi_form;
    regi_form.submit();

}