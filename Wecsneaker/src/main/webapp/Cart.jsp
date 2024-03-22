<%@page import="Model.size"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="Model.detailOrder"%>
<%@page import="Control.detailcontrol"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="assets/css/home.css">
    <link rel="stylesheet" href="assets/css/confirm.css">
    <link rel="stylesheet" href="assets/css/Cart.css">
    <link rel="icon" href="assets/img/bacground.png" type="image/x-id">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightslider/1.1.6/css/lightslider.css" integrity="sha512-+1GzNJIJQ0SwHimHEEDQ0jbyQuglxEdmQmKsu8KI7QkMPAnyDrL9TAnVyLPEttcTxlnLVzaQgxv2FpLCLtli0A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<title>Insert title here</title>
<style type="text/css">
.product_NT{
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	flex-wrap: wrap;
	width: 230px;
}
button{
 border: none;
 outline: none;
 border-radius: 8px;
 padding: 5px 10px;
 
}
.inactive{
    opacity: 0.4;
    cursor: none;
}
.inactive button{
cursor: none;
pointer-events: none;
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
         <div id="cart" class="cart">
            <div id="list-cart" class="list-cart">

               <% 
               ArrayList<detailOrder>listDetailOrder=(ArrayList<detailOrder>)request.getAttribute("listDetailOrder");
               for(detailOrder o:listDetailOrder){
               %>
                <div style="position: relative;" class="product-cart <%if(o.getProduct().getIsActive()==0){%> inactive <%}%> ">
                    <div class="box-img">
                        <img src="<%=o.getProduct().getImgMain()%>" alt="<%=o.getProduct().getProductName()%>">
                        <div class="detail">
                        <div class="product_NT">
                            <p class="product-name-cart"><%=o.getProduct().getProductName()%></p>
                            <p class="product-title"><%=o.getProduct().getTitle()%></p>
                        </div>
                            <div class="gr-icon">
                                <a href="DeleteCart?IdDetail=<%=o.getDetailOrdersID()%>" class="icon"><i class="fa-regular fa-trash-can"></i></a>
                                <a href="addTofavourite?productId=<%=o.getProduct().getProductID()%>" class="icon"><i class="fa-regular fa-heart"></i></a>
                            </div>
                        </div>
                    </div>
                    <div class="size-product">
                        <label for="sizeSelect">Size:</label>
                        <select id="sizeSelect" name="size">
                        <%for(size s:o.getProduct().getSizes()){ %>
                            <option value="<%=s.getSizeName()%>" <%if(s.getSizeName().equals(o.getSize())){ %> selected="selected"<%}%>><a href=""><%=s.getSizeName()%></a></option>
                          <%}%>
                        </select>
                    </div>
                    <div id="quatily-product" class="quatily-product">
                    <button value="<%=o.getDetailOrdersID()%>" onclick="loadDownNum(this)">
                    <i class="fa-solid fa-chevron-down"></i></button> <%=o.getQuatility()%> 
                    <button value="<%=o.getDetailOrdersID()%>" onclick="loadUpNum(this)" ><i class="fa-solid fa-chevron-up"></i></button></div>
                    <div class="price">price: <%=o.getTotal_money()%></div>
                    <%if(o.getProduct().getIsActive()==0){%> <div style="color: red; position: absolute; right: 200px; top: 80px">Sản Phẩm đã hết hạn</div> <%}%>
                </div>
               <%} %>
             </div>  
            <div class="bill-cart">
                <strong>Summary</strong>
                <div class="subtotal">
                    <p>subtotal: </p>
                    <p>${bill.total} đ</p>
                </div>
                <div class="shipping">
                    <p>Estimated Delivery & Handling: </p>
                    <p>Free</p>
                </div>
                <div class="total">
                   <p>Total: </p>
                   <p>${bill.total}₫</p>
                </div>
                <a href="payment.jsp" class="btn favorite--btn size-xl">Menber checkout</a>
            </div>
    </div>
      <!--footer-->
     <jsp:include page="footer.jsp"></jsp:include>
         </div>
         <script src="main.js"></script>
         <c:choose>
         <c:when test="${Delete != null }">
          <script type="text/javascript">
          showdeleteSuccess();                 
          </script>
          </c:when>
          <c:when test="${error != null }">
          <script type="text/javascript">
          showWarningCart();                
          </script>
          </c:when>
         </c:choose>
           <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
           <script type="text/javascript">
           function loadDownNum(giatri) {
       		//ajax sử dụng ajax
       		var para=giatri.value;
               	  //var elements = document.querySelectorAll('.pagination-1g');
       		     //var amount = element.getAttribute("data-value");
               	 //var amount = para.getAttribute("value");
                    $.ajax({
                        url: "/Wecsneaker/UpdateProductInCart",
                        type: "get", //send it through get method
                        data: {
                        	idDetailDown: para,
                        },
                        success: function (data) {
                        	var row = $("#cart");
                        	row.html(data);
                        },
                        error: function (xhr) {
                            //Do Something to handle error
                        }
                    });
                }
           function loadUpNum(giatri) {
          		//ajax sử dụng ajax
                  	  //var elements = document.querySelectorAll('.pagination-1g');
          		     //var amount = element.getAttribute("data-value");
                  	 //var amount = para.getAttribute("value");
                  	 var para=giatri.value;
                       $.ajax({
                           url: "/Wecsneaker/UpdateProductInCart",
                           type: "get", //send it through get method
                           data: {
                           	idDetailUp: para,
                           },
                           success: function (data) {
                        	   var row = $("#cart");
                        	   row.html(data);
                           },
                           error: function (xhr) {
                               //Do Something to handle error
                           }
                       });
                   }
           </script>
</body>
</html>