<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="ti-header">
            <img src="assets/img/bacground.png" class="logo" alt="" height="20px" width="auto">
            <ul class="ti-navbar">
            <c:choose>
             <c:when test="${sessionScope.account != null}">
               <li class="li"><a href="">hello ${sessionScope.account.accountName}</a></li>
               <li class="user"><a href="" class="icon"><i class="fa-solid fa-user"></i></a>
                    <ul class="user-nav navbar">
                     <li><a href="logoutControl">Logout</a></li>
                     <li><a href="">Setting</a></li>
                     <c:if test="${sessionScope.account != null && sessionScope.account.accountAdmin == 1}">
                        <li><a href="loadAllProductInDashborad">Dashband</a></li>
                     </c:if>
                    </ul>
                </li>
             </c:when>    
             <c:when test="${sessionScope.usergg != null}">
             <li class="li"><a href="">hello ${sessionScope.usergg.given_name}</a></li>
             <li class="user"><a href="" class="icon"><i class="fa-solid fa-user"></i></a>
                    <ul class="user-nav navbar">
                    <li><a href="logoutControl">Logout</a></li>
                    <li><a href="">Setting</a></li>
                    </ul>
             </li>
             </c:when>
             <c:otherwise>
             <li class="li"><a href="">hello friend</a></li>
             <li class="user"><a href="" class="icon"><i class="fa-solid fa-user"></i></a>
                    <ul class="user-nav navbar">
                    <li><a href="signinControl">Login</a></li>
                    </ul>
              </li>
             </c:otherwise>
             </c:choose>
             <li><a  href="" class="icon"><i class="fa-solid fa-bell"></i></a></li>
            </ul>
        </div>
        <div class="header">
            <ul class="nav nav-left">
                <li><a href="homecontrol">Home</a></li>
                <li class="brand"><a href="storecontrol">Brand</a>
                    <ul class="brand-nav navbar">
                    <c:forEach items="${listB}" var="o">
                    <li><a href="ProductByBrand?id=${o.brandID}">${o.brandName}</a></li>
                    </c:forEach>
                    </ul>
                </li>
                <li><a href="homecontrol#sale">Sale</a></li>
                <li><a href="storecontrol">Store</a></li>
            </ul>
            <div id="nav-center" class="nav nav-center">
                <form action="searchControl">
                    <button type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                    <input name="textSearch" type="text" placeholder="search" id="input-search">
                </form>
            </div>
            <div id="nav" class="nav nav-right">
                <div class="social-icon">
                    <a href="loadFavourite" class="icon"><i class="fa-regular fa-heart"></i></a>
                    <a href="loadCart" class="icon"><i class="fa-solid fa-bag-shopping"></i></a>
                </div>
            </div>
        </div>
        <div class="af-header">
            <h4>TingHow And Memory</h4>
            <p>Em vào đời bằng vang đỏ anh vào đời bằng nước trà, Bằng cơn mưa thơm mùi đất và bằng hoa dại mọc trước nhà.</p>
        </div>
</body>
</html>