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
import DAO.DAO_Product;
import DAO.DAO_UserGG;
import DAO.DAO_favourite;
import Model.Account;
import Model.Brand;
import Model.product;

/**
 * Servlet implementation class deteleFavourite
 */
@WebServlet("/deteleFavourite")
public class deteleFavourite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deteleFavourite() {
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
		ArrayList<Brand>listB=daoB.getAllBrand();
		request.setAttribute("listB", listB);
		DAO_favourite dao_favourite=new DAO_favourite();
		HttpSession session=request.getSession();
		ArrayList<product>listProduct=new ArrayList<product>();
		Account ac;
		Object obgg=session.getAttribute("usergg");
		Object ob=  session.getAttribute("account");
		String idproduct=request.getParameter("id");
		if(ob!=null) {
		ac=(Account) ob;
		dao_favourite.deletefavouritebyproduct(ac.getAccountID(), idproduct);
		response.sendRedirect("loadFavourite");
		}
		else if(obgg!=null) {
			DAO_UserGG userGG=(DAO_UserGG) obgg;
			dao_favourite.deletefavouritebyproductbyGG(userGG.getId(), idproduct);
			response.sendRedirect("loadFavourite");
		}
		else {
			request.setAttribute("cofirmfavourite","LoadCartLogin");
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
