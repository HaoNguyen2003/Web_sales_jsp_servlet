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

import DAO.DAO_Account;
import DAO.DAO_Brand;
import DAO.DAO_Cart;
import DAO.DAO_Category;
import DAO.DAO_Product;
import DAO.DAO_favourite;
import Model.Account;
import Model.order;

/**
 * Servlet implementation class deleteAccount
 */
@WebServlet("/deleteAccount")
public class deleteAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteAccount() {
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
		PrintWriter out=response.getWriter();
		DAO_Product dao_Product=new DAO_Product();
		DAO_Category dao_Category=new DAO_Category();
		DAO_Brand dao_Brand=new DAO_Brand();
		DAO_Account dao_Account=new DAO_Account();
		DAO_favourite dao_favourite=new DAO_favourite();
		DAO_Cart dao_Cart= new DAO_Cart();
		HttpSession session=request.getSession();
		
		Account ac;
		//
		//
		Object ob=  session.getAttribute("account");
		if(ob!=null) {
			ac=(Account) ob;
			String idAccount=request.getParameter("id");
			ArrayList<order>listOrders=dao_Cart.getAllOrder(idAccount);
			for (order order : listOrders) {
				dao_Cart.DeleteDetailOrderByIDOrder(order.getOrdersID());
			}
			dao_favourite.deletefavouritebyproduct(idAccount);
			dao_Cart.deleteOrderByAccount(idAccount);
			dao_Account.deteleAccount(idAccount);
			response.sendRedirect("LoadAllAccount");
		}else {
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
