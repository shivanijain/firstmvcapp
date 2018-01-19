<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <Title>Dashboard</Title>
</head>
<body>
<c:choose>
    <c:when test="${access == false}" >
        Please Login again!!
    </c:when>
    <c:otherwise>
       Welcome ${name}
    </c:otherwise>
</c:choose>
</body>
</html>