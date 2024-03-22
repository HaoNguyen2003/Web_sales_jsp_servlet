<%@page import="Model.product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="assets/css/home.css">
    <link rel="stylesheet" href="assets/css/confirm.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightslider/1.1.6/css/lightslider.css" integrity="sha512-+1GzNJIJQ0SwHimHEEDQ0jbyQuglxEdmQmKsu8KI7QkMPAnyDrL9TAnVyLPEttcTxlnLVzaQgxv2FpLCLtli0A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/store.css">
    <link rel="icon" href="assets/img/bacground.png" type="image/x-id">
<meta charset="UTF-8">
<style type="text/css">
.product-box strong{
    font-size: 16px;
}

.list-page{
width: 100%;
justify-content: center;
}
</style>
<title>Store</title>
</head>
<body>
   <div id="toast">
        <!--success-->
        <!--success-->
    </div>
    <div class="container">
        <!--header-->
         <jsp:include page="header.jsp"></jsp:include>
         <!--header-->
        <div class="Brand-check"><h2>Brand</h2></div>
        <div class="container-full">
            <div class="container-col2">
                <h2 class="header header-category">All Category</h2>
                <ul class="category">
                <c:forEach items="${listC}" var="o">
                <li class="${o.categoryID==tag?"category-selection":""}"><a href="productByCategory?Bid=${Bid}&id=${o.categoryID}">${o.categoryName}</a></li>
                </c:forEach>
                </ul>
            </div>
            <div class="container-col7">
                <div class="list-product">
                    <c:forEach items="${listP}" var="o">
                            <div class="product-box">
                                <!--header-->
                                <span>${o.discount}%</span>
                                <a href="detailcontrol?id=${o.productID}">
                                    <strong class="sizename">${o.productName}</strong>
                                    <!--sale-->
                                    <!--img-->
                                    <img src="${o.imgMain}" class="imgzoom" alt="${o.productName}">
                                    <!--color-->
                                    <div class="product-title">${o.title}</div>
                                    <!--price-->
                                    <div class="buy-price">
                                        <p>${o.price_out}</p>
                                        <!--btn-->
                                        <a href="addTofavourite?productId=${o.productID}" class="btn favorite--btn">Add To Favorite</a>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                </div>
                <ul class="list-page">
                    <li><a href="">1</a></li>
                    <li><a href="">2</a></li>
                    <li><a href="">3</a></li>
                    <li><a href="">4</a></li>
                    <li><a href="">5</a></li>
                </ul>
            </div>
        </div>
         <!--footer-->
        <jsp:include page="footer.jsp"></jsp:include>
    </div>
    <script src="main.js"></script>
    <c:choose>
    <c:when test="${ cofirmfavourite3 != null}">
    <script type="text/javascript">
    showAddSuccessF();               
    </script>
    </c:when>
    </c:choose>
</body>
</html>