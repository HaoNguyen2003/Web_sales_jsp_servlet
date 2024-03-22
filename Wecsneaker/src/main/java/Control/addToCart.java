package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_Cart;
import DAO.DAO_Product;
import DAO.DAO_UserGG;
import Model.Account;
import Model.product;

/**
 * Servlet implementation class addToCart
 */
@WebServlet("/addToCart")
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCart() {
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
		String idProduct=request.getParameter("productId");
		String size=request.getParameter("selector");
		DAO_Cart dao_Cart=new DAO_Cart();
		DAO_Product dao_Product=new DAO_Product();
		HttpSession session=request.getSession();
		Account ac;
		DAO_UserGG userGG;
		//
		//
		product pd= dao_Product.getProductByID(idProduct);
		Object ob=  session.getAttribute("account");
		Object obgg=session.getAttribute("usergg");
		if(ob!=null) {
			ac=(Account) ob;
			if(dao_Cart.checkcart(ac.getAccountID()).equals("error"))
			{
				dao_Cart.createdcart(ac.getAccountID());
				String orderID=dao_Cart.checkcart(ac.getAccountID());
				dao_Cart.addToCart(pd, orderID, size);
			}
			else {
			String orderID=dao_Cart.checkcart(ac.getAccountID());
			String idDetailOrder=dao_Cart.checkProductNumInCartByOrderID(orderID, idProduct, size);
			if(dao_Cart.checkProductNumInCartByOrderID(orderID, idProduct, size)=="") {
				dao_Cart.addToCart(pd, orderID, size);
			}
			else {
			dao_Cart.upDateToCart(idDetailOrder);
			}
		}
			 String success="TingHow";
			 request.setAttribute("IDFromAddToCart", idProduct);
			 request.setAttribute("AddCartSuccess", success);
			 request.getRequestDispatcher("detailcontrol").forward(request, response);
		}
		else if(obgg!=null) {
			userGG=(DAO_UserGG) obgg;
			if(dao_Cart.checkcartByUserGG(userGG.getId()).equals("error"))
			{
				dao_Cart.createdcartByGG(userGG.getId());
				String orderID=dao_Cart.checkcartByUserGG(userGG.getId());
				dao_Cart.addToCart(pd, orderID, size);
			}
			else {
				String orderID=dao_Cart.checkcartByUserGG(userGG.getId());
				String idDetailOrder=dao_Cart.checkProductNumInCartByOrderID(orderID, idProduct, size);
				if(dao_Cart.checkProductNumInCartByOrderID(orderID, idProduct, size)=="") {
					dao_Cart.addToCart(pd, orderID, size);
				}
				else {
				dao_Cart.upDateToCart(idDetailOrder);
				}
			}
			 String success="TingHow";
			 request.setAttribute("IDFromAddToCart", idProduct);
			 request.setAttribute("AddCartSuccess", success);
			 request.getRequestDispatcher("detailcontrol").forward(request, response);
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
