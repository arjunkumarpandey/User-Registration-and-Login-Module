<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Password</title>
    <link href="CSS/UpdatePasswordCSS.css" rel="stylesheet" type="text/css"/>
</head>
<body style="background: url('img/bg2.jpg'); background-size: cover; background-attachment: fixed;">
    <div class="container">
        <form class="password-form" action="UpdatePassword" method="post">
            <h2>Change Password</h2>
            <div class="form-group">
                <label for="new-password">New Password</label>
                <input type="password" id="new-password" name="password" required>
            </div>
            <div class="form-group">
                <label for="confirm-password">Confirm New Password</label>
                <input type="password" id="confirm-password" name="confirm-password" required>
            </div>
            <button type="submit">Change Password</button>
        </form>
    </div>
</body>
</html>
