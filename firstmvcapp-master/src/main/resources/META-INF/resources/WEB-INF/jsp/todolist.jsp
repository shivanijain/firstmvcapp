<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
    Here is your todos for ${name}:
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
                <td><fmt:formatDate value="${list.targetDate}" pattern="dd/MM/yyy"></fmt:formatDate></td>
                <td>${list.isDone}</td>
                <td><a href="/update-todo?id=${list.id}" class="btn-success btn">Update</a>
                      <a href="/delete-todo?id=${list.id}" class="btn-warning btn">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="/add-todo" class="btn btn-success">Add todo</a>
</div>
<%@include file="common/footer.jspf"%>
