<!DOCTYPE html>
<%@page import="java.sql.Date"%>
<%@page import="Model.Category"%>
<%@page import="Model.Brand"%>
<%@page import="Model.product"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
    <link rel="stylesheet" href="assets/css/dnnav.css">
    <title>Admin</title>
    <style type="text/css">
  .delivered a{
  color: #066b21;
  }
  .cancelled a{
    color: #b30021;   
}
  a {
	text-decoration: none;
    }
    .status{
    padding: 0.4rem 0.5rem;
    border-radius: 2rem;
    text-align: center;
    border: none;
	outline: none;
	width: 100px;
}
button.Update,
button.create{
    width: 200px;
    outline: none;
    padding: 10px 15px;
    text-align: center;
    background-color: #111111;
    border: none;
    border-radius: 50px;
    cursor: pointer;
    margin-left: 120px;
    color: #f5f5f5;
}
.Update,
.create:hover{
    opacity: 0.8;
    padding: 10px 30px;
}
    </style>
</head>
<body>
    <script src="main.js"></script>
    <script type="text/javascript">
    document.addEventListener('DOMContentLoaded', function () {
        const test = document.getElementById('test');
        const form=document.getElementById('main')
        test.addEventListener('click',function(event) {
            if (event.target === test) {
                test.style.display = 'none';
            }
            test.addEventListener('click')  
        })
      })
    </script>
    <div id="main" class="main">
     <jsp:include page="navDashbroad.jsp"></jsp:include>

        <div class="main-table">
            <div class="table-product">
                <section class="table_header">
                    <h1>All Product of Store</h1>
                    <form class="input-group" action="searcgProductIndashbroad">
                        <input name="textSearch" type="search" placeholder="search" id="input-search">
                        <button type="submit" class="icon-search"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </form>
                    <div onclick="addproduct()" id="add-product" class="add-product">
                        <i class="fa-solid fa-plus"></i>
                        <p class="nameAdd">Add Product</p>
                    </div>
                </section>
                <section class="table_body">
                    <table>
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>title</th>
                                <th>Brand</th>
                                <th>Category</th>
                                <th>Create Date</th>
                                <th>Update Date</th>
                                <th>Price out</th>
                                <th>Price In</th>
                                <th>Discount</th>
                                <th>View</th>
                                <th>Status</th>
                                <th>Option</th>
                            </tr>
                        </thead>
                        <tbody id="body_table">
         <%
        ArrayList<product> listP = (ArrayList<product>) request.getAttribute("listP");
        ArrayList<Brand> brands = (ArrayList<Brand>) request.getAttribute("listB");
        ArrayList<Category> categories = (ArrayList<Category>) request.getAttribute("listC");
        for (product o : listP) {
            %>
            <tr>
                <td><%= o.getProductID() %></td>
                <td>
                    <img src="<%= o.getImgMain() %>" alt="">
                    <%= o.getProductName() %>
                </td>
                <td><%= o.getTitle() %></td>
                <td>
                    <% // Hiển thị tên thương hiệu
                        for (Brand b : brands) {
                            if (b.getBrandID().equals(o.getIsBrand())) {
                                out.print(b.getBrandName());
                                break;
                            }
                        }
                    %>
                </td>
                <td>
                    <% // Hiển thị tên danh mục
                        for (Category c : categories) {
                            if (c.getCategoryID().equals(o.getCategoryID())) {
                                out.print(c.getCategoryName());
                                break;
                            }
                        }
                    %>
                </td>
                <td><%= o.getCreate_at() %></td>
                <td><%= o.getUpdate_at() %></td>
                <td>
                    <strong><%= o.getPrice_out() * (1 - o.getDiscount() / 100) %>$</strong>
                </td>
                <td>
                    <strong><%= o.getPrice_in() %></strong>
                </td>
                <td><%= o.getDiscount() %>%</td>
                <td><%= o.getView() %></td>
                <td>
                <%if(o.getIsActive()==1){ %>
                <button onclick="changeInActive(this)" id="<%=o.getProductID()%>" value="<%=o.getProductID()%>" class="status delivered">Active</button>
                 <%}
                   else{%>
                 <button onclick="changeActive(this)" id="<%=o.getProductID()%>" value="<%=o.getProductID()%>" class="status cancelled">inactive</button>
              <%}%>
                 
                </td>
                <td>
                    <a href="DeleteProduct?id=<%=o.getProductID()%>" class="red "><i class="fa-solid fa-trash-can"></i></a>
                    <a href="updateproduct?id=<%=o.getProductID()%>" class="blue"><i class="fa-solid fa-pen-nib"></i></a>
                </td>
            </tr>
        <%
        }
    %>
                       
                        </tbody>
                    </table>
                </section>
            </div>
        </div>
        <div id="test">
            <div id="addProductIntable" class="addProductIntable">
                <div class="addProductIntable-header">
                </div>
                <form class="form-product" action="addProductIndashbroad" method="post">
                    <div class="input">
                      <label for=""> Product Name:</label> <input name="nameproduct" type="text">
                    </div>
                    <div class="input">
                        <label for="">Product title: </label><input name="producttitle" type="text">
                    </div>
                    <div class="input">
                        <label for="">price In:</label> <input step="0.001" name="priceIn" type="number">
                    </div>
                    <div class="input">
                        <label for="">Price Out:</label> <input step="0.001" name="priceOut" type="number">
                    </div>
                    <div class="input">
                    <label for="">Sale:</label> <input step="0.001" name="discount" type="number">
                    </div>
                    <div class="category">
                        <label for="Selector-Category">Category</label>
                        <select name="Selector-Category" id="Selector-Category">
                        <%for(Category c:categories){ %>
                            <option value="<%=c.getCategoryID()%>"><%=c.getCategoryName()%></option>
                            <%} %>
                        </select>
                    </div>
                    <div class="Brand">
                        <label for="Selector-brand">brand</label>
                        <select name="Selector-brand" id="Selector-brand">
                        <%for(Brand b: brands){ %>
                            <option value="<%=b.getBrandID()%>"><%=b.getBrandName()%></option>
                            <%} %>
                        </select>
                    </div>
                    <div class="input">
                      <label for="">  Main Image: </label><input name="imgmain" type="text">
                    </div>
                    <div class="input">
                       <label for=""> Image 1: </label><input name="img1" type="text">
                    </div>
                    <div class="input">
                        <label for="">Image 2: </label><input name="img2" type="text">
                    </div>
                    <div class="input">
                        <label for="">Image 3:</label> <input name="img3" type="text">
                    </div>
                    <div class="input">
                       <label for=""> Discription:</label> <textarea name="Discription" id="" cols="40" rows="6"></textarea>
                    </div>
                    <button class="create" type="submit">Create</button>
                </form>
            </div>
        </div>
        <%Object ob=request.getAttribute("product");
        product product=new product();
        if(ob!=null)
        {
        	product=(product)ob;
        }
        else{
        	product.setCategoryID("");
        	product.setProductName("");
        	product.setTitle("");
        	product.setDiscription("");
        	product.setDiscount(0);
        	product.setPrice_in(0);
        	product.setPrice_in(0);
        	product.setImgMain("");
        	product.setListMain(new String[]{"","",""});
        	
        }
        %>
        <div id="test2">
            <div id="addProductIntable" class="addProductIntable">
                <div class="addProductIntable-header">
                </div>
                <form class="form-product" action="updateproductIndashbroand" method="get">
                    <div class="input">
                      <input name="idproduct" type="hidden" value="<%=product.getProductID()%>">
                      <label for=""> Product Name:</label> <input value="<%=product.getProductName()%>" name="nameproduct" type="text">
                    </div>
                    <div class="input">
                        <label for="">Product title: </label><input value="<%=product.getTitle()%>" name="producttitle" type="text">
                    </div>
                    <div class="input">
                        <label for="">price In:</label> <input value="<%=product.getPrice_in()%>" step="0.001" name="priceIn" type="number">
                    </div>
                    <div class="input">
                        <label for="">Price Out:</label> <input value="<%=product.getPrice_out()%>" step="0.001" name="priceOut" type="number">
                    </div>
                     <div class="input">
                    <label for="">Sale:</label> <input value="<%=product.getDiscount()%>" step="0.001" name="discount" type="number">
                    </div>
                    <div class="category">
                        <label for="Selector-Category">Category</label>
                        <select name="Selector-Category" id="Selector-Category">
                            <%for(Category c:categories){ %>
                            <option value="<%=c.getCategoryID()%>" <%if(c.getCategoryID().equals(product.getCategoryID())){%> selected="selected" <%}%>><%=c.getCategoryName()%></option>
                            <%} %>
                        </select>
                    </div>
                    <div class="Brand">
                        <label for="Selector-brand">brand</label>
                        <select name="Selector-brand" id="Selector-brand">
                            <%for(Brand b: brands){ %>
                            <option value="<%=b.getBrandID()%>" <%if(b.getBrandID().equals(product.getIsBrand())){%> selected="selected" <%}%>><%=b.getBrandName()%></option>
                            <%} %>
                        </select>
                    </div>
                    <%String img1=product.getListMain()[0];
                    String img2=product.getListMain()[1];
                    String img3=product.getListMain()[2];
                    %>
                    <div class="input">
                      <label for="">  Main Image: </label><input value="<%=product.getImgMain()%>"  type="text">
                    </div>
                    <div class="input">
                       <label for=""> Image 1: </label><input value="<%=img1%>" type="text">
                    </div>
                    <div class="input">
                        <label for="">Image 2: </label><input value="<%=img2%>" type="text">
                    </div>
                    <div class="input">
                        <label for="">Image 3:</label> <input value="<%=img3%>" type="text">
                    </div>
                    <div class="input">
                       <label for=""> Discription:</label> <textarea name="Discription" id="" cols="40" rows="6"><%=product.getDiscription()%></textarea>
                    </div>
                    <button class="Update" type="submit">Update</button>
                </form>
            </div>
        </div>
    </div>
    <script type="text/javascript">
    function addproduct() {
        const test = document.getElementById('test');
        test.style.display='flex'
      }
      function updateproduct() {
        const test = document.getElementById('test2');
        test.style.display='flex'
      }
      document.addEventListener('DOMContentLoaded', function () {
        const test = document.getElementById('test');
        const form=document.getElementById('main')
        test.addEventListener('click',function(event) {
            if (event.target === test) {
                test.style.display = 'none';
            }
            test.addEventListener('click')  
        })
      })
      
      document.addEventListener('DOMContentLoaded', function () {
        const test = document.getElementById('test2');
        const form=document.getElementById('main')
        test.addEventListener('click',function(event) {
            if (event.target === test) {
                test.style.display = 'none';
            }
            test.addEventListener('click')  
        })
      })
    </script>
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
     <script type="text/javascript">
     function changeActive(giatri) {
    	 var para=giatri.value;
      	  //var elements = document.querySelectorAll('.pagination-1g');
		     //var amount = element.getAttribute("data-value");
      	 //var amount = para.getAttribute("value");
           $.ajax({
               url: "/Wecsneaker/ActiveandInactiveproduct",
               type: "get", //send it through get method
               data: {
               	idProductActive: para,
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
     function changeInActive(giatri) {
    	 var para=giatri.value;
      	  //var elements = document.querySelectorAll('.pagination-1g');
		     //var amount = element.getAttribute("data-value");
      	 //var amount = para.getAttribute("value");
           $.ajax({
               url: "/Wecsneaker/ActiveandInactiveproduct",
               type: "get", //send it through get method
               data: {
               	idProductInActive: para,
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
         <c:choose>
         <c:when test="${cofirm5 != null }">
          <script type="text/javascript">
          const test = document.getElementById('test2');
          test.style.display='flex'
          </script>
          </c:when>
         </c:choose>
</body>
</html>