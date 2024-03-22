<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="assets/css/home.css">
    <link rel="stylesheet" href="assets/css/confirm.css">
    <link rel="icon" href="assets/img/bacground.png" type="image/x-id">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightslider/1.1.6/css/lightslider.css" integrity="sha512-+1GzNJIJQ0SwHimHEEDQ0jbyQuglxEdmQmKsu8KI7QkMPAnyDrL9TAnVyLPEttcTxlnLVzaQgxv2FpLCLtli0A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<meta charset="UTF-8">
<title>home</title>
<style type="text/css">
.product-box strong{
    font-size: 10px;
}
</style>
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
        <div class="content-container">
            <div class="content-img">
            </div>
            <div id="sale" class="content-sale">
                <h2 class="sale-header">
                    Sale
                </h2>
                <section class="product-slider">
                    <div class="slider-heading">
                        <h3>All models <span>take your pick</span> </h3>
                    </div>
                    <ul id="autoWidth" class="cs-hidden">
                        <!--1-->
                        <c:forEach items="${listS}" var="o">
                        <li class="item-a">
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
                                        <p>${o.price_out*(1-o.discount/100.00)}</p>
                                        <!--btn-->
                                        <a href="addTofavourite?productId=${o.productID}" class="btn favorite--btn">Add To Favorite</a>
                                    </div>
                                </a>
                            </div>
                        </li>
                        </c:forEach>
                      </ul>
                </section>
            </div>
        </div>
        <!--footer-->
     <jsp:include page="footer.jsp"></jsp:include>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="main.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/lightslider/1.1.6/js/lightslider.min.js" integrity="sha512-Gfrxsz93rxFuB7KSYlln3wFqBaXUc1jtt3dGCp+2jTb563qYvnUBM/GP2ZUtRC27STN/zUamFtVFAIsRFoT6/w==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script>
         $(document).ready(function() {
         $('#autoWidth').lightSlider({
        autoWidth:true,
        loop:true,
        onSliderLoad: function() {
            $('#autoWidth').removeClass('cS-hidden');
        } 
    });  
  });
  /////
    </script>
    <c:choose>
    <c:when test="${ cofirmfavourite3 != null}">
    <script type="text/javascript">
    showAddSuccessF();               
    </script>
    </c:when>
    </c:choose>
</body>
</html>