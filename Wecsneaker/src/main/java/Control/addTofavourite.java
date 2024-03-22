package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_UserGG;
import DAO.DAO_favourite;
import Model.Account;


/**
 * Servlet implementation class addTofavourite
 */
@WebServlet("/addTofavourite")
public class addTofavourite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTofavourite() {
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
		DAO_favourite dao_favourite=new DAO_favourite();
		String idProduct=request.getParameter("productId");
		System.out.println("id: "+idProduct);
		HttpSession session=request.getSession();
		Account ac;
		String referer = request.getHeader("Referer");
		//
		//
		Object obgg=session.getAttribute("usergg");
		Object ob=  session.getAttribute("account");
		if(ob!=null) {
			ac=(Account) ob;
			
			if(!dao_favourite.checkProductInfavourite(ac.getAccountID(), idProduct)) {
			    dao_favourite.addTofavourite(ac.getAccountID(), idProduct);
			}
			request.setAttribute("cofirmfavourite3", "LoadCartLogin");
			response.sendRedirect(referer);
		}
		else if(obgg!=null) {
			DAO_UserGG userGG=(DAO_UserGG) obgg;
			if(!dao_favourite.checkProductInfavouriteByUserGG(userGG.getId(), idProduct)) {
			    dao_favourite.addTofavouriteIDGG(userGG.getId(), idProduct);
			}
			request.setAttribute("cofirmfavourite3", "LoadCartLogin");
			response.sendRedirect(referer);
		}
		else {
				request.setAttribute("cofirmfavourite2","LoadCartLogin");
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
