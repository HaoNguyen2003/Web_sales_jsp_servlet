package Control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_Brand;
import DAO.DAO_Cart;
import DAO.DAO_Product;
import DAO.DAO_UserGG;
import DAO.DAO_size;
import Model.Account;
import Model.Brand;

/**
 * Servlet implementation class orderCart
 */
@WebServlet("/orderCart")
public class orderCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public orderCart() {
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
		DAO_Product dao=new DAO_Product();
		DAO_Brand daoB=new DAO_Brand();
		DAO_Cart dao_Cart=new DAO_Cart();
		DAO_size dao_size=new DAO_size();
		ArrayList<Brand>listB=daoB.getAllBrand();
		HttpSession session=request.getSession();
		Account ac;
		//
		Object obgg=session.getAttribute("usergg");
		//
		Object ob=  session.getAttribute("account");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String numerPhone=request.getParameter("number");
		if(ob!=null) {
			ac=(Account) ob;
			String orderID=dao_Cart.checkcart(ac.getAccountID());
			if(dao_Cart.numProductIncart(orderID)!=0)
			{
				dao_Cart.updateOrder(email, name, numerPhone, address, orderID);
				request.getRequestDispatcher("/ordersuccess.jsp").forward(request, response);
			}
			else {
				request.setAttribute("error", "error");
				request.getRequestDispatcher("/loadCart").forward(request, response);
			}
			
		}
		else if(obgg!=null)
		{
			DAO_UserGG usergg=(DAO_UserGG) obgg;
			String orderID=dao_Cart.checkcartByUserGG(usergg.getId());
			if(dao_Cart.numProductIncart(orderID)!=0)
			{
				dao_Cart.updateOrder(email, name, numerPhone, address, orderID);
				request.getRequestDispatcher("/ordersuccess.jsp").forward(request, response);
			}
			else {
				request.setAttribute("error", "error");
				request.getRequestDispatcher("/loadCart").forward(request, response);
			}
		}
		else {
			 request.setAttribute("cofirm1","LoadCartLogin");
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
