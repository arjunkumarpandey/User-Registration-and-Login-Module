<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OTP Verification</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link href="CSS/otpCSS.css" rel="stylesheet" type="text/css"/>
</head>
<body style="background: url('img/bg2.jpg'); background-size: cover; background-attachment: fixed;">
    <div class="container">
        <form class="otp-form" action="VerifyOtp" method="post">
            <h2>OTP Verification</h2>
            <p>Please enter the OTP sent to your Gmail</p>
            <div style="color:red; text-align:center;">
                <%@ include file="message.jsp" %>
            </div>
            <div class="form-group">
                <label for="otp">Enter OTP</label>
                <input type="text" id="otp" name="otp" maxlength="6" required>
            </div>
            <button type="submit" class="verify-button">Verify</button>
            <p class="resend-text">Didn't receive OTP? <a href="VerifyOtp?resend=true">Resend OTP</a></p>
        </form>
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
    <script>
        function showSuccessMessage() {
            swal({
                title: "Registration Successful",
                text: "We are redirecting to the Login Page",
                icon: "success",
                button: "OK",
            }).then((value) => {
                window.location = "LoginPage.jsp";
            });
        }
        const messageElement = document.querySelector('.server-message');
        if (messageElement && messageElement.textContent.includes("Successfully")) {
            showSuccessMessage();
        }
    </script>
    
</body>
</html>
