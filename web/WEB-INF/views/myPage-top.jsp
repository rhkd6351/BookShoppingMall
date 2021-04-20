<%@ page contentType="text/html;charset=UTF-8" language="java" %>

            <div class="content-top">

                <div class="content-top-element">
                    <img src="../../resources/img/user_image.png" alt=""
                         id = "profile-image">

                </div>
                <div class="content-top-element">

                    <div id="user-email">
                        ${user.email}
                    </div>
                    <div id="user-regDate">
                        ${user.platform} ${user.regDate} 가입
                    </div>
                </div>
                <div class="content-top-element">
                    등급
                    <div id="user-grade">
                        Silver
                    </div>
                </div>
                <div class="content-top-element">
                    포인트
                    <div id="user-point">
                        ${user.point}
                    </div>
                </div>
                <div class="content-top-element">
                    쿠폰
                    <div id="user-coupon">
                        3
                    </div>
                </div>
            </div>
