package Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_Cart;
import DAO.DAO_Product;
import DAO.DAO_UserGG;
import DAO.DAO_size;
import Model.Account;
import Model.CategorySize;
import Model.detailOrder;
import Model.order;
import Model.product;
import Model.size;

/**
 * Servlet implementation class UpdateProductInCart
 */
@WebServlet("/UpdateProductInCart")
public class UpdateProductInCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProductInCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		DAO_Cart dao_Cart=new DAO_Cart();
		DAO_size dao_size=new DAO_size();
		DAO_Product dao_Product=new DAO_Product();
		HttpSession session=request.getSession();
		Account ac;
		Object obgg=session.getAttribute("usergg");
		Object ob=  session.getAttribute("account");
		String idDetailUp=request.getParameter("idDetailUp");
		String idDetailDown=request.getParameter("idDetailDown");
		System.out.println("idDetailUp: "+idDetailUp);
		PrintWriter out=response.getWriter();
		if(ob!=null) {
			ac=(Account) ob;
			if(idDetailUp!=null) {
				dao_Cart.upDateToCart(idDetailUp);
			}
			if(idDetailDown!=null) {
				dao_Cart.downToCart(idDetailDown);
			}
			order order=dao_Cart.getOrderByIdAccount(ac.getAccountID());
			String orderID=dao_Cart.checkcart(ac.getAccountID());
			ArrayList<detailOrder>listDetailOrder=dao_Cart.getAllCartByorderID(orderID);
			for(detailOrder cr:listDetailOrder) 
			{
				product pd=dao_Product.getProductByID(cr.getProduct().getProductID());
				ArrayList<CategorySize>listCategorieSizes=dao_size.getIdSizeByCategoryID(pd.getCategoryID());
				ArrayList<size>listOfProduct=new ArrayList<size>();
				for (CategorySize categorySize : listCategorieSizes)
				{
					size s=dao_size.getSizeByID(categorySize.getSizeID());
					listOfProduct.add(s);
				}
				pd.setSizes(listOfProduct);
				cr.setProduct(pd);
			}
			out.println("<div id=\"list-cart\" class=\"list-cart\">");
			for(detailOrder o:listDetailOrder) {
				out.println("<div class=\"product-cart "+(o.getProduct().getIsActive() == 0 ?"inactive":"")+"\">\r\n"
				        + "    <div class=\"box-img\">\r\n"
				        + "        <img src=\"" + o.getProduct().getImgMain() + "\" alt=\"" + o.getProduct().getProductName() + "\">\r\n"
				        + "        <div class=\"detail\">\r\n"
				        + "            <div class=\"product_NT\">\r\n"
				        + "                <p class=\"product-name-cart\">" + o.getProduct().getProductName() + "</p>\r\n"
				        + "                <p class=\"product-title\">" + o.getProduct().getTitle() + "</p>\r\n"
				        + "            </div>\r\n"
				        + "            <div class=\"gr-icon\">\r\n"
				        + "                <a href=\"DeleteCart?IdDetail=" + o.getDetailOrdersID() + "\" class=\"icon\"><i class=\"fa-regular fa-trash-can\"></i></a>\r\n"
				        + "                <a href=\"addTofavourite?productId=" + o.getProduct().getProductID() + "\" class=\"icon\"><i class=\"fa-regular fa-heart\"></i></a>\r\n"
				        + "            </div>\r\n"
				        + "        </div>\r\n"
				        + "    </div>\r\n"
				        + "    <div class=\"size-product\">\r\n"
				        + "        <label for=\"sizeSelect\">Size:</label>\r\n");
				     
				out.println("        <select id=\"sizeSelect\" name=\"size\">\r\n");
				for (size s : o.getProduct().getSizes()) {
				    out.print("        <option value=\"" + s.getSizeName() + "\"");
				    if (s.getSizeName().equals(o.getSize())) {
				        out.print(" selected=\"selected\"");
				    }
				    out.println(">" + s.getSizeName() + "</option>");
				}
				out.println("        </select>\r\n"
				        + "    </div>\r\n"
				        + "    <div id=\"quatily-product\" class=\"quatily-product\">\r\n"
				        + "        <button value=\"" + o.getDetailOrdersID() + "\" onclick=\"loadDownNum(this)\">\r\n"
				        + "            <i class=\"fa-solid fa-chevron-down\"></i>\r\n"
				        + "        </button> " + o.getQuatility() + " \r\n"
				        + "        <button value=\"" + o.getDetailOrdersID() + "\" onclick=\"loadUpNum(this)\"><i class=\"fa-solid fa-chevron-up\"></i></button>\r\n"
				        + "    </div>\r\n"
				        + "    <div class=\"price\">price: " + o.getTotal_money() + "</div>\r\n"
				        + "</div>");
			}
			out.println("</div>  \r\n"
					+ "            <div class=\"bill-cart\">\r\n"
					+ "                <strong>Summary</strong>\r\n"
					+ "                <div class=\"subtotal\">\r\n"
					+ "                    <p>subtotal: </p>\r\n"
					+ "                    <p>"+order.getTotal()+" đ</p>\r\n"
					+ "                </div>\r\n"
					+ "                <div class=\"shipping\">\r\n"
					+ "                    <p>Estimated Delivery & Handling: </p>\r\n"
					+ "                    <p>Free</p>\r\n"
					+ "                </div>\r\n"
					+ "                <div class=\"total\">\r\n"
					+ "                   <p>Total: </p>\r\n"
					+ "                   <p>"+order.getTotal()+"₫</p>\r\n"
					+ "                </div>\r\n"
					+ "                <a href=\"payment.jsp\" class=\"btn favorite--btn size-xl\">Menber checkout</a>"
					+ "            </div>");
		}
		else if(obgg!=null)
		{
			DAO_UserGG userGG=(DAO_UserGG) obgg;
			if(idDetailUp!=null) {
				dao_Cart.upDateToCart(idDetailUp);
			}
			if(idDetailDown!=null) {
				dao_Cart.downToCart(idDetailDown);
			}
			order order=dao_Cart.getOrderByIdGG(userGG.getId());
			String orderID=order.getOrdersID();
			ArrayList<detailOrder>listDetailOrder=dao_Cart.getAllCartByorderID(orderID);
			for(detailOrder cr:listDetailOrder) 
			{
				product pd=dao_Product.getProductByID(cr.getProduct().getProductID());
				ArrayList<CategorySize>listCategorieSizes=dao_size.getIdSizeByCategoryID(pd.getCategoryID());
				ArrayList<size>listOfProduct=new ArrayList<size>();
				for (CategorySize categorySize : listCategorieSizes)
				{
					size s=dao_size.getSizeByID(categorySize.getSizeID());
					listOfProduct.add(s);
				}
				pd.setSizes(listOfProduct);
				cr.setProduct(pd);
			}
			out.println("<div id=\"list-cart\" class=\"list-cart\">");
			for(detailOrder o:listDetailOrder) {
				out.println("<div class=\"product-cart "+(o.getProduct().getIsActive() == 0 ?"inactive":"")+"\">\r\n"
				        + "    <div class=\"box-img\">\r\n"
				        + "        <img src=\"" + o.getProduct().getImgMain() + "\" alt=\"" + o.getProduct().getProductName() + "\">\r\n"
				        + "        <div class=\"detail\">\r\n"
				        + "            <div class=\"product_NT\">\r\n"
				        + "                <p class=\"product-name-cart\">" + o.getProduct().getProductName() + "</p>\r\n"
				        + "                <p class=\"product-title\">" + o.getProduct().getTitle() + "</p>\r\n"
				        + "            </div>\r\n"
				        + "            <div class=\"gr-icon\">\r\n"
				        + "                <a href=\"DeleteCart?IdDetail=" + o.getDetailOrdersID() + "\" class=\"icon\"><i class=\"fa-regular fa-trash-can\"></i></a>\r\n"
				        + "                <a href=\"addTofavourite?productId=" + o.getProduct().getProductID() + "\" class=\"icon\"><i class=\"fa-regular fa-heart\"></i></a>\r\n"
				        + "            </div>\r\n"
				        + "        </div>\r\n"
				        + "    </div>\r\n"
				        + "    <div class=\"size-product\">\r\n"
				        + "        <label for=\"sizeSelect\">Size:</label>\r\n");
				     
				out.println("        <select id=\"sizeSelect\" name=\"size\">\r\n");
				for (size s : o.getProduct().getSizes()) {
				    out.print("        <option value=\"" + s.getSizeName() + "\"");
				    if (s.getSizeName().equals(o.getSize())) {
				        out.print(" selected=\"selected\"");
				    }
				    out.println(">" + s.getSizeName() + "</option>");
				}
				out.println("        </select>\r\n"
				        + "    </div>\r\n"
				        + "    <div id=\"quatily-product\" class=\"quatily-product\">\r\n"
				        + "        <button value=\"" + o.getDetailOrdersID() + "\" onclick=\"loadDownNum(this)\">\r\n"
				        + "            <i class=\"fa-solid fa-chevron-down\"></i>\r\n"
				        + "        </button> " + o.getQuatility() + " \r\n"
				        + "        <button value=\"" + o.getDetailOrdersID() + "\" onclick=\"loadUpNum(this)\"><i class=\"fa-solid fa-chevron-up\"></i></button>\r\n"
				        + "    </div>\r\n"
				        + "    <div class=\"price\">price: " + o.getTotal_money() + "</div>\r\n"
				        + "</div>");
			}
			out.println("</div>  \r\n"
					+ "            <div class=\"bill-cart\">\r\n"
					+ "                <strong>Summary</strong>\r\n"
					+ "                <div class=\"subtotal\">\r\n"
					+ "                    <p>subtotal: </p>\r\n"
					+ "                    <p>"+order.getTotal()+" đ</p>\r\n"
					+ "                </div>\r\n"
					+ "                <div class=\"shipping\">\r\n"
					+ "                    <p>Estimated Delivery & Handling: </p>\r\n"
					+ "                    <p>Free</p>\r\n"
					+ "                </div>\r\n"
					+ "                <div class=\"total\">\r\n"
					+ "                   <p>Total: </p>\r\n"
					+ "                   <p>"+order.getTotal()+"₫</p>\r\n"
					+ "                </div>\r\n"
					+ "                <a href=\"\" class=\"btn favorite--btn size-xl\">Menber checkout</a>\r\n"
					+ "            </div>");
		}
		else {
			 request.setAttribute("cofirm","buyToLogin");
			 request.getRequestDispatcher("/login.jsp").forward(request, response);
			 }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
