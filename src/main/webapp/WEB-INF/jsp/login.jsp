<html>
<head>
    <title>
        My Chai Tapri
    </title>
    <link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
</head>
<body>
    <h1>My Chai</h1>
    <%--<form action="/dashboard" method="POST">--%>
    <font color="red">${message}</font>
        <form action="" method="POST">
        <span>Username: </span><input type="text" name="username"><br>
        <span>Password: </span><input type="password" name="password">
        <input type="submit" name="submit" value="Login">
    </form>
    <script src="/webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>