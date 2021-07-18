<%--
  Created by IntelliJ IDEA.
  User: denis.volkov
  Date: 7/16/2021
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<title>News List</title>
<body>
<h1>News List</h1>
<ul>
    <c:forEach var="news" items="${news}">
        <li><a href="./news/${news.code}"><img src="${news.image}" />${news.title}</a></li>
    </c:forEach>
</ul>
</body>
</html>
