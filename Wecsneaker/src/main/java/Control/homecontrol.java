package Control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO_Brand;
import DAO.DAO_Product;
import Model.Brand;
import Model.product;

/**
 * Servlet implementation class homecontrol
 */
@WebServlet("/homecontrol")
public class homecontrol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homecontrol() {
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
		ArrayList<product> listS=dao.getAllProductSale();
		request.setAttribute("listS", listS);
		DAO_Brand daoB=new DAO_Brand();
		ArrayList<Brand>listB=daoB.getAllBrand();
		request.setAttribute("listB", listB);
		String cofirmfavourite3=(String) request.getAttribute("cofirmfavourite3");
		request.setAttribute("cofirmfavourite3",  cofirmfavourite3);
		request.getRequestDispatcher("/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
