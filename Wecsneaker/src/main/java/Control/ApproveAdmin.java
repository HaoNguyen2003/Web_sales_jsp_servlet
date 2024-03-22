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
 * Servlet implementation class ApproveAdmin
 */
@WebServlet("/ApproveAdmin")
public class ApproveAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveAdmin() {
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
		DAO_Account dao_Account=new DAO_Account();
		DAO_favourite dao_favourite=new DAO_favourite();
		HttpSession session=request.getSession();
		
		Account ac;
		//
		//
		Object ob=  session.getAttribute("account");
		if(ob!=null) {
			ac=(Account) ob;
			String idAccount=request.getParameter("id");
			dao_Account.approveAdmin(idAccount);
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
