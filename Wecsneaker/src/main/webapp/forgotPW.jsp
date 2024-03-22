<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
        integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
        crossorigin="anonymous" />


    <!-- Google Fonts  -->
    <link rel="stylesheet" href="assets/css/forgot.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<title>Forgot</title>
</head>
<body>
<div class="card">
        <p class="lock-icon"><i class="fas fa-lock"></i></p>
        <h2>Forgot Password?</h2>
        <p>You can reset your Password here</p>
        <form action="forgotpassword" method="get" style="display: flex; flex-direction: column; width: 350px; justify-content: space-between;align-content: center; margin-left: 65px">
         <input name="email" type="text" class="passInput" placeholder="Email address">
         <c:if test="${notice!=null}">
         <div style="color: red;">email này chưa đươc đăng kí!!!</div>
         </c:if>
        <button type="submit">Send My Password</button>
        </form>
        <a href="signinControl">Sign In</a>
    </div>
</body>
</html>