<%--
  Created by IntelliJ IDEA.
  User: denis.volkov
  Date: 7/16/2021
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<title>News Details</title>
<body>
<h1>News Details</h1>
<p><img src="${band.imageURL}"/></p>

<h2>${news.title}</h2>
<br/>
<p>${news.text}</p>
<br/>
<br/>
<p>Date of publication - ${news.startDate}</p>
<br/>
<p>Deletion date - ${news.endDate}</p>
<br/>
<a href="../bands">Back to Band List</a>
</body>
</html>
