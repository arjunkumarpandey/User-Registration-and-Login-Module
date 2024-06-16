<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Page</title>
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="CSS/RegistrationCSS.css" rel="stylesheet" type="text/css"/>
</head>
<body style="background: url('img/bg2.jpg'); background-size: cover; background-attachment: fixed;">
    <div class="container">
        <form class="registration-form" action="Register" method="post">
            <h2>Register</h2>
            
           <div style="text-align:center;">
                <%@include file="message.jsp"%>
            </div>
            
            <div class="form-group">
                <label for="name">Full Name</label>
                <input type="text" id="name" name="name" value="<%= session.getAttribute("name") != null ? session.getAttribute("name") : "" %>" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" value="<%= session.getAttribute("email") != null ? session.getAttribute("email") : "" %>" required>
            </div>
            <div class="form-group">
                <label for="phone">Phone Number</label>
                <input type="tel" id="phone" name="phone" value="<%= session.getAttribute("phone") != null ? session.getAttribute("phone") : "" %>" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <div class="password-wrapper">
                    <input type="password" id="password" name="password" value="<%= session.getAttribute("password") != null ? session.getAttribute("password") : "" %>" required>
                    <i id="eyeicon" class="far fa-eye-slash toggle-password" onclick="togglePassword('password', this)"></i>
                </div>
            </div>
            <div class="form-group">
                <label for="confirm-password">Confirm Password</label>
                <div class="password-wrapper">
                    <input type="password" id="confirm-password" name="cnf_password" value="<%= session.getAttribute("cnf_password") != null ? session.getAttribute("cnf_password") : "" %>" required>
                    <i id="eyeicon2" class="far fa-eye-slash toggle-password" onclick="togglePassword('confirm-password', this)"></i>
                </div>
            </div>
            <button type="submit" class="register-button">Register</button>
            <p class="signin-text">Already have an account? <a href="LoginPage.jsp">Sign In</a></p>
        </form>
    </div>
    <script src="JS/RegistrationJS.js" type="text/javascript"></script>
    
</body>
</html>
