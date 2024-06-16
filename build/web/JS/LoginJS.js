// Toggle password visibility
function togglePassword(id, element) {
    const input = document.getElementById(id);
    if (input.type === "password") {
        input.type = "text";
        element.classList.remove("fa-eye-slash");
        element.classList.add("fa-eye");
    } else {
        input.type = "password";
        element.classList.remove("fa-eye");
        element.classList.add("fa-eye-slash");
    }
}
