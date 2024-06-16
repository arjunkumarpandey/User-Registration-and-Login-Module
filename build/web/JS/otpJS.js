
document.addEventListener('DOMContentLoaded', () => {
    // Handling OTP input fields with focus control
    const otpInputs = document.querySelectorAll('.otp-inputs input');

    otpInputs.forEach((input, index) => {
        input.addEventListener('input', (e) => {
            // Move focus to the next input field when a digit is entered
            if (e.target.value.length === 1 && index < otpInputs.length - 1) {
                otpInputs[index + 1].focus();
            }
        });

        input.addEventListener('keydown', (e) => {
            // Move focus to the previous input field on Backspace if current field is empty
            if (e.key === 'Backspace' && index > 0 && e.target.value.length === 0) {
                otpInputs[index - 1].focus();
            }
        });
    });

    // Ensure only numeric input and limit to 6 characters for each OTP input field
    document.getElementById('otp').addEventListener('input', function (e) {
        e.target.value = e.target.value.replace(/[^0-9]/g, '').slice(0, 6); // Ensure only numeric input and max length 6
    });

    // Intercept form submission to concatenate OTP inputs into a single value
    document.querySelector('.otp-form').addEventListener('submit', (e) => {
        e.preventDefault(); // Prevent default form submission
        let otp = '';
        otpInputs.forEach(input => otp += input.value); // Concatenate OTP inputs
        document.querySelector('[name="otp"]').value = otp; // Assign concatenated value to hidden input
        e.target.submit(); // Submit the form
    });

    // Resend OTP functionality (alert for demonstration)
    const resendLink = document.querySelector('.resend-text a');
    resendLink.addEventListener('click', (event) => {
        event.preventDefault();
        alert('OTP has been resent to your phone number.');
        // You can add an AJAX request here to actually resend the OTP
    });
});

