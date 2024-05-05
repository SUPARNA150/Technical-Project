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