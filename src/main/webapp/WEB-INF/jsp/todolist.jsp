<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
    Here is your todos for ${name} with password${password}:
    <table class="table">
        <tr>
            <th>Description</th>
            <th>Date</th>
            <th>Done</th>
            <th>Action</th>
        </tr>
        <c:forEach var="list" items="${lists}">
            <tr>
                <td>${list.desc}</td>
                <td>${list.targetDate}</td>
                <td>${list.isDone}</td>
                <td><a href="/delete-todo?id=${list.id}" class="btn-warning btn">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="/add-todo" class="btn btn-success">Add todo</a>
</div>

<script src="/webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>