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
import Model.favourite;
import Model.product;
import Model.size;

/**
 * Servlet implementation class loadFavourite
 */
@WebServlet("/loadFavourite")
public class loadFavourite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadFavourite() {
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
		Object ob=  session.getAttribute("account");
		Object obgg=session.getAttribute("usergg");
		if(ob!=null) {
		ac=(Account) ob;
		ArrayList<favourite>favourites=dao_favourite.loadfavourite(ac.getAccountID());
		for(favourite cr:favourites) {
			product pd=dao.getProductByID(cr.getProductID());
			listProduct.add(pd);
		  }
		ArrayList<size>listS= (ArrayList<size>) request.getAttribute("listS");
		product pd= (product) request.getAttribute("pd");
		if(listS!=null) {
			request.setAttribute("flexhidden", "flexhidden");	
		}
		request.setAttribute("pd", pd);
		request.setAttribute("listPC", listProduct);
		request.getRequestDispatcher("/favourite.jsp").forward(request, response);
		}
		else if(obgg!=null)
		{
			DAO_UserGG userGG=(DAO_UserGG) obgg;
			ArrayList<favourite>favourites=dao_favourite.loadfavouriteByGG(userGG.getId());
			for(favourite cr:favourites) {
				product pd=dao.getProductByID(cr.getProductID());
				listProduct.add(pd);
			  }
			ArrayList<size>listS= (ArrayList<size>) request.getAttribute("listS");
			product pd= (product) request.getAttribute("pd");
			if(listS!=null) {
			request.setAttribute("flexhidden", "flexhidden");	
			}
			request.setAttribute("pd", pd);
			request.setAttribute("listPC", listProduct);
			request.getRequestDispatcher("/favourite.jsp").forward(request, response);
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
