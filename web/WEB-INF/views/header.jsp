<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <header>
        <nav>
            <ul class="nav-aside-left">
                <li>메인화면</li>
                <li>베스트북</li>
                <li>국내도서</li>
                <li>국외도서</li>
            </ul>

            <ul class="nav-aside-right">
                <li><a href="/user/logout">로그아웃</a></li> <!--로그아웃-->
                <li><a href="/user/myPage">내정보</a></li> <!--마이페이지-->
                <li>장바구니</li>
                <li>고객센터</li>
            </ul>
        </nav>

        <div class="bookSearch">
            <div class="bookSearch-aside-left">
                <a href="/user/myPage"><img src="../../resources/img/logo_search.png" alt="" id="logo-image"></a>
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
                <img src="../../resources/img/logo_event.jpeg" alt="" id="event-image">
            </div>
        </div>
    </header>