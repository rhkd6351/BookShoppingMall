<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://kit.fontawesome.com/7226f29584.js" crossorigin="anonymous"></script>
<script>
    $(function(){
        var user = "${user.email}";
        if(user == "")
            $(".login-out").text("로그인").attr("href","/user/login");
        else
            $(".login-out").text("로그아웃").attr("href","/user/logout");
    })
</script>
    <header>
        <nav>
            <ul class="nav-aside-left">
                <li>메인화면</li>
                <li>베스트북</li>
                <li>국내도서</li>
                <li>국외도서</li>
            </ul>

            <ul class="nav-aside-right">
                <li><a href="/user/logout" class="login-out">로그아웃</a></li> <!--로그아웃-->
                <li><a href="/user/myPage">내정보</a></li> <!--마이페이지-->
                <li><a href="/cart">장바구니</a></li>
                <li>고객센터</li>
                <li>제작자</li>
            </ul>
        </nav>

        <div class="bookSearch">
            <div class="bookSearch-aside-left">
                <a href="/"><img src="/resources/img/logo_search.png" alt="" id="logo-image"></a>
            </div>
            <div class="bookSearch-aside-center">
                <form action="#" id="search-form">
                    <select name="" id="">
                        <option value="">통합검색</option>
                        <option value="">제목검색</option>
                        <option value="">저자검색</option>
                        <option value="">내용검색</option>
                    </select>
                    <input type="text">
                    <input type="submit" name="" id="" value="검색">
                </form>
            </div>
            <div class="bookSearch-aside-right">
                <img src="/resources/img/logo_event.jpeg" alt="" id="event-image">
            </div>
        </div>
    </header>

<div class="nav2">
    <ul>
        <li>
            <i class="fas fa-bars"></i> 카테고리
        </li>
    </ul>
</div>