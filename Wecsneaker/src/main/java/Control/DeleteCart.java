package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.DAO_Cart;
import DAO.DAO_UserGG;
import Model.Account;

/**
 * Servlet implementation class DeleteCart
 */
@WebServlet("/DeleteCart")
public class DeleteCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCart() {
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
		String idDetail=request.getParameter("IdDetail");
		HttpSession session=request.getSession();
		Account ac;
		//
		//
		Object obgg=session.getAttribute("usergg");
		Object ob=  session.getAttribute("account");
		if(ob!=null) {
			ac=(Account) ob;
			dao_Cart.DeleteDetailOrder(idDetail);
			String success="Delete Success";
			request.setAttribute("Delete", success);
			request.getRequestDispatcher("loadCart").forward(request, response);
		}
		else if(obgg!=null) {
			DAO_UserGG userGG=(DAO_UserGG) obgg;
			dao_Cart.DeleteDetailOrder(idDetail);
			String success="Delete Success";
			request.setAttribute("Delete", success);
			request.getRequestDispatcher("loadCart").forward(request, response);
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
