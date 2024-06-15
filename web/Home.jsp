<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Responsive Page with Buttons</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            text-align: center;
            background: #fff;
            padding: 2rem;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        .btn-custom {
            width: 100%;
            max-width: 300px;  /* Set a maximum width for the buttons */
            margin: 1rem auto;  /* Center the buttons */
            padding: 0.75rem;
            font-size: 1rem;
            border-radius: 5px;
        }
        .btn-register {
            background-color: #28a745;
            color: #fff;
        }
        .btn-login {
            background-color: #007bff;
            color: #fff;
        }
        @media (max-width: 576px) {
            .btn-custom {
                font-size: 0.875rem;
                padding: 0.5rem;
            }
        }
    </style>
</head>
<body style="background: url('img/bg2.jpg'); background-size: cover; background-attachment: fixed;">
    <div class="container">
        <h1>Welcome to Login Module</h1>
        <button class="btn btn-custom btn-register">Register</button>
        <button class="btn btn-custom btn-login">Login</button>
    </div>
     <script>
        document.querySelector('.btn-register').addEventListener('click', function() {
            window.location.href = 'RegisterPage.jsp'; 
        });

        document.querySelector('.btn-login').addEventListener('click', function() {
            window.location.href = 'LoginPage.jsp';  // Redirect to the Login page
        });
    </script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
