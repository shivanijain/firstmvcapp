<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
<div class="container">
    <h1>Add todo</h1>
    <form:form action="/insert-todo" method="post" commandName="todo">
        <fieldset class="form-group">
            <form:label path="desc">Description</form:label>
            <form:input path="desc" type="text" name="desc" required="required" class="form-control"></form:input>
            <form:errors path="desc" cssClass="text-warning" />
        </fieldset>
        <fieldset>
            <input type="submit" value="Add Todo" class="btn btn-success">
        </fieldset>
    </form:form>
</div>
<script src="/webjars/jquery/3.1.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>