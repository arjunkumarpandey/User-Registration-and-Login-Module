<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String check = (String) session.getAttribute("success");
    if (check == null) {
        response.sendRedirect("LoginPage.jsp");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Welcome to Home Page</h1>
        <h3>You successfully logged in</h3>
        <h3>Thank You</h3>
    </body>
</html>
