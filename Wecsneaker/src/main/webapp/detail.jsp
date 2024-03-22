<%@page import="Model.product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail Product</title>
</head>
<body>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/home.css">
    <link rel="stylesheet" href="assets/css/confirm.css">
    <link rel="icon" href="assets/img/bacground.png" type="image/x-id">
    <link rel="stylesheet" href="assets/css/detail.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightslider/1.1.6/css/lightslider.css" integrity="sha512-+1GzNJIJQ0SwHimHEEDQ0jbyQuglxEdmQmKsu8KI7QkMPAnyDrL9TAnVyLPEttcTxlnLVzaQgxv2FpLCLtli0A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <title>detail</title>
    <style type="text/css">
    /**size**/
.list{
  border: 1px solid #111111;
  width: 65px;
  height: 48px;
  display: flex;
  justify-content:center;
  align-items:center;
  flex-wrap: wrap;
  border-radius:10px; 
  margin-left: 10px;
  margin-bottom: 10px;
}
input[type=radio] {
  position: absolute;
  visibility: hidden;
  width:100%;
  display: none;
}
label {
  color: #111111;
  display: flex;
  justify-content:center;
  align-items:center;
  cursor: pointer;
  font-weight: bold;
  width: 65px;
  height: 48px;
}
input[type=radio]:checked + label{
    color: #111111;
    background: #f5f5f5;
    border-radius: 10px;
    border: 1px solid #111111;
}

.radio-group {
  display: flex;
  flex-wrap: wrap;
  overflow: hidden;
  justify-content:left;
  margin: 20px 0;
}
.outlinenone{
	border: none;
	outline: none;
}
@import url('https://fonts.googleapis.com/css?family=Roboto');
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
        <!-- header-->
        <div class="card-product">
            <div class="product-imgs">
                <div class="img-display">
                    <div class="img-showcase">
                        <img src="${pd.imgMain}" class="slide-img" alt="shoe img">
                    </div>
                </div>
                <div class="img-select">
                    <div class="img-ite">
                            <img src="${pd.imgMain}" alt="" onclick="img('${pd.imgMain}')">
                    </div>
                    <div class="img-ite">
                            <img src="${pd.listMain[0]}" alt="" onclick="img('${pd.listMain[0]}')">
                    </div>
                    <div class="img-ite">
                            <img src="${pd.listMain[1]}" alt="" onclick="img('${pd.listMain[1]}')">
                    </div>
                    <div class="img-ite">
                            <img src="${pd.listMain[2]}" alt="" onclick="img('${pd.listMain[2]}')">
                    </div>
                </div>
            </div>
            <div class="product-content">
                <h2 class="product-name">${pd.productName}</h2>
                <h3 class="product-title">
                    ${pd.title}
                </h3>
                <div class="product-price">
                    <p class="last-price">Old Price: <span>${pd.price_out}</span></p>
                    <%
                    product pd=(product)request.getAttribute("pd");
                    double pricenew=pd.getPrice_out()-(pd.getDiscount()*pd.getPrice_out()/100);
                    %>
                    <p class="new-price">New Price: <span><%=pricenew%></span></p>
                </div>
                <form id="form-container" class="form-container" method="get" action="addToCart">
                <input type="hidden" name="productId" value="${pd.productID}">
                <div class="radio-group">
                <!-- check category != sneker -->
                 <!--quan ao-->
                 <c:forEach items="${listS}" var="o">
                  <div class="list">
                  <input type="radio" id="${o.sizeID}" value="${o.sizeName}" name="selector"><label for="${o.sizeID}">${o.sizeName}</label>
                  </div>
                 </c:forEach>
                <!--giay-->
                <!-- check category == sneker -->
                </div>
                    <div class="gr-button">
                    <a href="addTofavourite?productId=${pd.productID}" class="btn favorite--btn size-xl">Add to favorite</a>
                    <button type="submit"  class="btn add--btn size-xl outlinenone">Add to card</button>
                    </div>
                </form>
                <div class="product-detail">
                    <p>${pd.discription}</p>
                </div>
            </div>
        </div>
        <!-- footer -->
        <jsp:include page="footer.jsp"></jsp:include>
        <!-- footer -->
    </div>
<script src="main.js"></script>
<script type="text/javascript">
document.addEventListener('DOMContentLoaded',function(){
	   const myForm=document.getElementById('form-container');
	   myForm.addEventListener('submit',function(event){
		    var radioButtons = document.getElementsByName('selector');
         var isChecked = false;

         // Kiểm tra xem có radio button nào được chọn không
         for (var i = 0; i < radioButtons.length; i++) {
             if (radioButtons[i].checked) {
                 isChecked = true;
                 break;
             }
         }
         if(!isChecked){
				event.preventDefault();
				showWarningSelectSize()
			}
	   })
})
</script>
<c:choose>
    <c:when test="${ AddCartSuccess != null}">
    <script type="text/javascript">
    showAddSuccess();                 
    </script>
    </c:when>
    </c:choose>
</body>
</html>
</body>
</html>