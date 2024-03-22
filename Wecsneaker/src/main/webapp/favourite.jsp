<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="assets/css/home.css">
    <link rel="stylesheet" href="assets/css/confirm.css">
    <link rel="stylesheet" href="assets/css/favourite.css">
    <link rel="icon" href="assets/img/bacground.png" type="image/x-id">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightslider/1.1.6/css/lightslider.css" integrity="sha512-+1GzNJIJQ0SwHimHEEDQ0jbyQuglxEdmQmKsu8KI7QkMPAnyDrL9TAnVyLPEttcTxlnLVzaQgxv2FpLCLtli0A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.select--btn{
    background-color:#ccc;
    color: #111111;
}
.select--product{
 animation: modelformin ease 0.8s;
}
@keyframes modelformin{
    from{
        transform: translateY(-200px);
    }
    to{
        transform: translateY(0);
    }
}
.inactive{
    opacity: 0.4;
    cursor: none;
}
.inactive .select--btn{
cursor: none;
pointer-events: none;
}
.inactive .clickimg{
cursor: none;
pointer-events: none;
}
.remove--btn{
 background-color: #ff623d;
 color: #fff;
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
         
          <!--  -->
            <div class="Content-favourite">
            <h2 class="favourite-header">
               Your Favourite Product
            </h2>
            <section class="product-slider">
                <div class="slider-heading">
                    <h3>All Product <span>take your pick</span> </h3>
                </div>
                <ul id="autoWidth" class="cs-hidden">
                <c:forEach items="${listPC}" var="o">
                <li class="item-a"> 
                    <div class="product-box button-Select ${o.isActive==0?"inactive":""}">
                        <!--header-->
                        <span>${o.discount}</span>
                        <a class="clickimg" href="detailcontrol?id=${o.productID}">
                            <strong>${o.productName}</strong>
                            <!--sale-->
                            <!--img-->
                            <img src="${o.imgMain}" class="imgzoom" alt="${o.productName}">
                            <!--color-->
                            <!--price-->
                        </a>
                        <a href="loadLabelHidden?id=${o.productID}" id="select-size" class="btn select--btn">select size</a>
                        <a href="deteleFavourite?id=${o.productID}" id="select-size" class="btn remove--btn">remove</a>
                    </div>
                  </li>
                </c:forEach>
                 </ul>
            </section>
         </div>
          <!--  -->
          
         <!-- footer -->
         <jsp:include page="footer.jsp"></jsp:include>
         <!-- footer -->
          <div class="background-behide" id="background-behide">
            <div class="select--product">
           <img src="${pd.imgMain}" alt="${pd.productName}">
           <div class="content">
               <h2 class="select--header">
                   ${pd.productName}
               </h2>
               <p class="select-title">
                   ${pd.title}
               </p>
               <p class="select-prices">
                ${pd.price_out}
                </p>
                <h2 class="select--header">
                    Size
                </h2>
                <form class="form-container" action="addToCart">
                <input type="hidden" name="productId" value="${pd.productID}">
                    <div class="radio-group">
                        <!--quan ao-->
                       <!--quan ao-->
                       <!--giay-->
                      <c:forEach items="${listS}" var="o">
                      <div class="list">
                       <input type="radio" id="${o.sizeID}" value="${o.sizeName}" name="selector"><label for="${o.sizeID}">${o.sizeName}</label>
                      </div>
                      </c:forEach>
                     </div>
                     <button type="submit" class="btn add--btn size-xl">Add To Cart</button>
                </form>
           </div>
       </div>
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
    <script type="text/javascript">
    document.addEventListener('DOMContentLoaded', function () {
        // Lấy tham chiếu đến các phần tử cần thiết
        var selectSizeButton = document.getElementById('select-size');
        var backgroundBehide = document.getElementById('background-behide');
        backgroundBehide.addEventListener('click', function (event) {
          // Kiểm tra xem sự kiện click có xảy ra trong background-behide không
          if (event.target === backgroundBehide) {
            backgroundBehide.style.display = 'none';
          }
        });
      });
    </script>
     <c:choose>
     <c:when test="${ flexhidden != null}">
    <script type="text/javascript">
    var backgroundBehide = document.getElementById('background-behide');
    backgroundBehide.style.display = 'flex';
    </script>
    </c:when>
    </c:choose>
</body>
</html>