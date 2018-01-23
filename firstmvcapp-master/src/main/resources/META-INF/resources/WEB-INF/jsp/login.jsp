<%@include file="common/header.jspf"%>
<div class="container">
    <h1>My Chai</h1>
    <%--<form action="/dashboard" method="POST">--%>
    <font color="red">${message}</font>
    <form action="" method="POST">
        <fieldset class="form-group">
            <label>Username</label>
            <input type="text" name="username" required="required" class="form-control"></input>
        </fieldset>
        <fieldset class="form-group">
            <label>Password</label>
            <input type="text" name="password" required="required" class="form-control"></input>
        </fieldset>
        <%--<span>Username: </span><input type="text" name="username"><br>
        <span>Password: </span><input type="password" name="password">--%>
        <fieldset class="form-group">
            <input type="submit" name="submit" value="Login" class="btn btn-success">
        </fieldset>
    </form>
</div>
<%@include file="common/footer.jspf"%>