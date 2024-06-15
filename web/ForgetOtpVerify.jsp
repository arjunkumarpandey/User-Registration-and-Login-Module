
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>OTP Verification</title>
        <link href="CSS/otpCSS.css" rel="stylesheet" type="text/css"/>
    </head>
    <body style="background: url('img/bg2.jpg'); background-size: cover; background-attachment: fixed;">
        <div class="container">
        <form class="otp-form" action="ForgetOtpVerify" method="post">

            <h2>Forget Password OTP Verification</h2>
            <p>Please enter the OTP sent to your Gmail</p>
            <div style="color:red; text-align:center;">
                <%@ include file="message.jsp" %>
            </div>
            <div class="form-group">
                <label for="otp">Enter OTP</label>
                <input type="text" id="otp" name="otp" maxlength="6" required>
            </div>
            <button type="submit" class="verify-button">Verify</button>
            <p class="resend-text">Didn't receive OTP? <a href="ForgetOtpVerify?resend=true">Resend OTP</a></p>

        </form>
    </body>
</html>
