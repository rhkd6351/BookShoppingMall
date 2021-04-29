
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<section class="content-aside-right">
    <div class="right-title">
        최근 본 도서
    </div>
    <c:forEach items="${recentBookList}" var="book">
        <div class="right-content">
            <a href="/product/view?oid=${book.oid}"><img src="${book.repUri}" alt=""></a>
        </div>
    </c:forEach>
    <div class="right-nav">
        <i class="fas fa-angle-left recent-left"></i>
        <t id="recent-rec"></t> / <t id="recent-max"></t>
        <i class="fas fa-angle-right recent-right"></i>
    </div>
</section>
