<%@page import="java.util.ArrayList"%>
<%@page import="Model.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="assets/css/dnnav.css">
    <link rel="stylesheet" href="assets/css/userAdmin.css">
<title>Admin User</title>
<style type="text/css">
</style>
</head>
<body>
<script src="main.js"></script>
<div id="main" class="main">
<jsp:include page="navDashbroad.jsp"></jsp:include>
<div class="main-table">
            <div class="table-product">
                <section class="table_header">
                    <h1>All User of Store</h1>
                    <form class="input-group" action="">
                        <input type="search" placeholder="search" id="input-search">
                        <button class="icon-search"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </form>
                </section>
                <section class="table_body">
                    <table class="table-user">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name Customer</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>email</th>
                                <th>numberphone</th>
                                <th>Create Date</th>
                                <th>Update Date</th>
                                <th>Adress</th>
                                <th>Status</th>
                                <th>Order</th>
                                <th>Option</th>
                            </tr>
                        </thead>
                        <tbody id="body_table">
                         <%
        ArrayList<Account> listA =(ArrayList<Account>) request.getAttribute("listA");
        for (Account o : listA) {
            %>
                            <tr>
                                <td><%=o.getAccountID() %></td>
                                <td>
                                    <img src="assets/img/user.png" alt="">
                                    <%=o.getAccountName() %>
                                </td>
                                <td>
                                    <%=o.getAccountUser() %>
                                </td>
                                <td>
                                    <%=o.getAccountPassword() %>
                                </td>
                                <td>
                                    <%=o.getEmailAcount() %>
                                </td>
                                <td>
                                    <%=o.getAccountPhonenumber() %>
                                </td>
                                <td>
                                    <%=o.getCreated_at() %>
                                </td>
                                <td>
                                    <%=o.getUpdated_at()%>
                                </td>
                                <td>
                                    <%=o.getAccountAdress() %>
                                </td>
                                <td>
                                    <p class="statusAccount activeAccount">Active</p>
                                </td>
                                <td>
                                    <%=o.getOrder()%>
                                </td>
                                <td>
                                   <a href="deleteAccount?id=<%=o.getAccountID() %>"  class="red "><i class="fa-solid fa-trash-can"></i></a>
                                   <a href="ApproveAdmin?id=<%=o.getAccountID()%>" class="blue"><i class="fa-solid fa-pen"></i></a>
                                   <%if(o.getAccess()==0){ %>
                                   <button value="<%=o.getAccountID() %>" onclick="Accsess(this)"><i class="fa-solid fa-eye-low-vision"></i></button>
                                   <%}else{ %>
                                   <button value="<%=o.getAccountID() %>" onclick="InAccess(this)"><i class="fa-solid fa-eye"></i></button>
                                   <%} %>
                                </td>
                            </tr>
                           <%}%>
                        </tbody>
                    </table>
                </section>
            </div>
        </div>
</div>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
           <script type="text/javascript">
           function InAccess(giatri) {
       		//ajax sử dụng ajax
       		var para=giatri.value;
               	  //var elements = document.querySelectorAll('.pagination-1g');
       		     //var amount = element.getAttribute("data-value");
               	 //var amount = para.getAttribute("value");
                    $.ajax({
                        url: "/Wecsneaker/InaccsessAndAccsess",
                        type: "get", //send it through get method
                        data: {
                        	InAccess: para,
                        },
                        success: function (data) {
                        	var row = $("#body_table");
                        	row.html(data);
                        },
                        error: function (xhr) {
                            //Do Something to handle error
                        }
                    });
                }
           function Accsess(giatri) {
          		//ajax sử dụng ajax
                  	  //var elements = document.querySelectorAll('.pagination-1g');
          		     //var amount = element.getAttribute("data-value");
                  	 //var amount = para.getAttribute("value");
                  	 var para=giatri.value;
                       $.ajax({
                           url: "/Wecsneaker/InaccsessAndAccsess",
                           type: "get", //send it through get method
                           data: {
                           	Accsess: para,
                           },
                           success: function (data) {
                        	   var row = $("#body_table");
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