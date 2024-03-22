<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="assets/css/home.css">
<link rel="stylesheet" href="assets/css/payment.css">
<link rel="stylesheet" href="assets/css/confirm.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/lightslider/1.1.6/css/lightslider.css" integrity="sha512-+1GzNJIJQ0SwHimHEEDQ0jbyQuglxEdmQmKsu8KI7QkMPAnyDrL9TAnVyLPEttcTxlnLVzaQgxv2FpLCLtli0A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<meta charset="UTF-8">
<title>Insert title here</title>
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
         <div class="container2">
            <form action="orderCart" class="h500">

                <div class="row">
        
                    <div class="col">
        
                        <h3 class="title">billing address</h3>
        
                        <div class="inputBox">
                            <span>full name :</span>
                            <input name="name" type="text" placeholder="Tinghow" required="required">
                        </div>
                        <div class="inputBox">
                            <span>email :</span>
                            <input name="email" type="email" placeholder="example@example.com" required="required">
                        </div>
                        <div class="inputBox">
                            <span>address :</span>
                            <input name="address" type="text" placeholder="room - street - locality" required="required">
                        </div>
                        <div class="inputBox">
                            <span>Phone Number :</span>
                            <input name="number" type="number" placeholder="Number" required="required">
                        </div>
                        <input type="submit" value="Thanh Toán Khi Nhận Hàng" class="submit-btn" required="required">
                    </div>
                </div>
            </form>
         </div>
         <jsp:include page="footer.jsp"></jsp:include>
     </div>
</body>
</html>