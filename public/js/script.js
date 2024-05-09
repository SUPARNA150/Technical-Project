document
  .getElementById("register-toggle")
  .addEventListener("click", function () {
    document.querySelector(".register-form").classList.add("show");
    document.querySelector(".login-form").classList.remove("show");
  });

document
  .getElementById("login-toggle")
  .addEventListener("click", function () {
    document.querySelector(".login-form").classList.add("show");
    document.querySelector(".register-form").classList.remove("show");
  });

  function validateRegister() {
    const usernameInput = document.getElementById('username');
    const fnameInput = document.getElementById('fname');
    const lnameInput = document.getElementById('lname');
    const pwdInput = document.getElementById('pwd');
    const cpwdInput = document.getElementById('cpwd');
    const emailInput = document.getElementById('email');
    const mobileInput = document.getElementById('mobile');
    const cityInput = document.getElementById('city');
    const responseMessage = document.getElementById('responseMessage');

    // Regular expressions for email validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    // Validation checks
    if (usernameInput.value.trim() === '') {
        responseMessage.innerHTML = "Please enter a username.";
        responseMessage.classList.remove('success');
        responseMessage.classList.add('error');
        responseMessage.classList.remove('hidden');
        return false;
    }

    if (fnameInput.value.trim() === '') {
        responseMessage.innerHTML = "Please enter your first name.";
        responseMessage.classList.remove('success');
        responseMessage.classList.add('error');
        responseMessage.classList.remove('hidden');
        return false;
    }

    if (lnameInput.value.trim() === '') {
        responseMessage.innerHTML = "Please enter your last name.";
        responseMessage.classList.remove('success');
        responseMessage.classList.add('error');
        responseMessage.classList.remove('hidden');
        return false;
    }

    if (pwdInput.value.length < 10) {
        responseMessage.innerHTML = "Password must be at least 10 characters long.";
        responseMessage.classList.remove('success');
        responseMessage.classList.add('error');
        responseMessage.classList.remove('hidden');
        return false;
    }

    if (pwdInput.value !== cpwdInput.value) {
        responseMessage.innerHTML = "Passwords do not match.";
        responseMessage.classList.remove('success');
        responseMessage.classList.add('error');
        responseMessage.classList.remove('hidden');
        return false;
    }

    if (!emailRegex.test(emailInput.value)) {
        responseMessage.innerHTML = "Please enter a valid email address.";
        responseMessage.classList.remove('success');
        responseMessage.classList.add('error');
        responseMessage.classList.remove('hidden');
        return false;
    }

    if (mobileInput.value.trim() === '' || isNaN(mobileInput.value.trim())) {
        responseMessage.innerHTML = "Please enter a valid mobile number.";
        responseMessage.classList.remove('success');
        responseMessage.classList.add('error');
        responseMessage.classList.remove('hidden');
        return false;
    }

    return true;
}

  function validateForm() {
    const useridInput = document.getElementById('userid');
    const pwdInput = document.getElementById('pwd');
    const useridError = document.getElementById('useridError');
    const pwdError = document.getElementById('pwdError');

    const useridRegex = /^[a-zA-Z0-9]+$/;
    const pwdRegex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{10,}$/;

    if (!useridRegex.test(useridInput.value)) {
        useridError.textContent = "User ID must be alphabetic or alphanumeric and have a minimum of 8 characters.";
        return false;
    } else {
        useridError.textContent = "";
    }

    if (!pwdRegex.test(pwdInput.value)) {
        pwdError.textContent = "Password must be minimum 10 characters including one special character, one upper case, one numeric.";
        return false;
    } else {
        pwdError.textContent = "";
    }

    return true;
}