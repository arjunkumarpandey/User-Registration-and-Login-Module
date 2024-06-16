<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Forgot Password</title>
    
    <link href="CSS/FrogetPassword.css" rel="stylesheet" type="text/css"/>
</head>
<body style="background: url('img/bg2.jpg'); background-size: cover; background-attachment: fixed;">
    <div class="container">
        <form class="password-form" action="ForgetPasswort" method="post">
            <h2>Forgot Password?</h2>
            <p>Enter your Register email address reset your password.</p>
            <div style="text-align:center;">
                <%@include file="message.jsp"%>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            <button type="submit">Reset Password</button>
            <div class="links">
                <a href="LoginPage.jsp">Back to Login</a>
            </div>
        </form>
    </div>
</body>
</html>
