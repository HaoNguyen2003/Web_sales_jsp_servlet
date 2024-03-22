<%@page import="Model.product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/login.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/confirm.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<link rel="icon" href="assets/img/bacground.png" type="image/x-id">
<title>Login</title>
</head>
<body>
<div id="toast">
        <!--success-->
       <!--success-->
</div>
 <div class="container" id="container">
        <div id="signup" class="form-container sign-up">
            <form action="signupControl" id="myformSignup" method="post">
                <h1>Create Account</h1>
                <div class="social-icon">
                    <a href="https://accounts.google.com/o/oauth2/auth?scope=profile&redirect_uri=http://localhost:8080/Wecsneaker/loginGooglehandler&response_type=code
		   &client_id=861884420350-9hqkdkhljar433oh8pc8kqom2qvrem3m.apps.googleusercontent.com&approval_prompt=force" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-instagram"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
                </div>
                <span>or use your email for registeration</span>
                <input name="Email1" id="Email1" type="email" placeholder="Email">
                <input name="FullName1" id="FullName1" type="text" placeholder="FullName">
                <input name="Username1" id="Username1" type="text" placeholder="Username">
                <input name="Password1"  id="Password1" type="password" placeholder="Password">
                <input name="Repassword1" id="Repassword1" type="password" placeholder="Repassword">
                <button type="submit" id="submit">Sign up</button>
            </form>
        </div>
        <div id="signin" class="form-container sign-in">
            <form action="signinControl" id="myformSignin" method="post">
                <h1>Sign In</h1>
                <div class="social-icon">
                    <a href="https://accounts.google.com/o/oauth2/auth?scope=profile&redirect_uri=http://localhost:8080/Wecsneaker/loginGooglehandler&response_type=code
		   &client_id=861884420350-9hqkdkhljar433oh8pc8kqom2qvrem3m.apps.googleusercontent.com&approval_prompt=force" class="icon"><i class="fa-brands fa-google-plus-g"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-facebook-f"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-instagram"></i></a>
                    <a href="#" class="icon"><i class="fa-brands fa-linkedin-in"></i></a>
                </div>
                <span>or use your email for registeration</span>
                <input name="Username2" id="Username2" value="${user}" type="text" placeholder="Username">
                <input name="Password2" id="Password2" value="${pass}" type="password" placeholder="Password">
                <a href="forgotPW.jsp">forget your password</a>
                <button type="submit" id="submit">Sign in</button>
            </form>
        </div>
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-left">
                    <h1>Welcome Back!</h1>
                    <p>
                        Enter your personal details to use all of site
                        features
                    </p>
                    <button class="hidden" id="login">Sign In</button>
                </div>
                <div class="toggle-panel toggle-right">
                    <h1>Hello friend!</h1>
                    <p>
                        Register your personal details to use all of site
                        features
                    </p>
                    <button class="hidden" id="register">Sign Up</button>
                </div>
            </div>
        </div>
    </div>
    <script src="main.js"></script>
    <script>
    </script>
    <c:choose>
    <c:when test="${error1 != null}">
    <script type="text/javascript">
    container.classList.add('active')
    showErrorSignUp();                 
    </script>
    </c:when>
  
    <c:when test="${error != null}">
    <script type="text/javascript">
    showError();                 
    </script>
    </c:when>
    
    <c:when test="${sussecc != null}">
    <script type="text/javascript">
    showinfor();                 
    </script>
    </c:when>
    
    <c:when test="${cofirm != null }">
    <script type="text/javascript">
    showinforLogin();                 
    </script>
    </c:when>
    
    <c:when test="${cofirm1 != null }">
    <script type="text/javascript">
    showinforLoadCard();                 
    </script>
    </c:when>
    
    <c:when test="${cofirmfavourite != null }">
    <script type="text/javascript">
    showinforLoginFavorite();                 
    </script>
    </c:when>
    
     <c:when test="${cofirmfavourite2 != null }">
    <script type="text/javascript">
    showinforLoginFavorite2();                 
    </script>
    </c:when>
    </c:choose>
</body>
</html>