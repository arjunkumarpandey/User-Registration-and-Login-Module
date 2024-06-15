<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="CSS/LoginCSS.css" rel="stylesheet" type="text/css"/>
</head>
<body style="background: url('img/bg2.jpg'); background-size: cover; background-attachment: fixed;">
    <div class="container">
        <form class="login-form" action="Login" method="post">
            <h2>Login</h2>
            <div style="text-align:center;">
                <%@include file="message.jsp"%>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <div class="password-wrapper">
                    <input type="password" id="password" name="password" required>
                    <i id="eyeicon" class="far fa-eye-slash toggle-password" onclick="togglePassword('password', this)"></i>
                </div>
            </div>
           
            <p class="forgot-password"><a href="ForgetPassword.jsp">Forgot Password?</a></p>
            <button type="submit" class="login-button">Login</button>
            <p class="register-text">Create new account? <a href="RegisterPage.jsp">Register here</a></p>
        </form>
    </div>
    
    <script src="JS/LoginJS.js" type="text/javascript"></script>
</body>
</html>
