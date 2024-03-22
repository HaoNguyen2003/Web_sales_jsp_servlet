package Control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO_Brand;
import DAO.DAO_Category;
import DAO.DAO_Product;
import Model.Brand;
import Model.Category;
import Model.product;

/**
 * Servlet implementation class searcgProductIndashbroad
 */
@WebServlet("/searcgProductIndashbroad")
public class searcgProductIndashbroad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searcgProductIndashbroad() {
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
		DAO_Category daoC=new DAO_Category();
		DAO_Brand daoB=new DAO_Brand();
		String name=request.getParameter("textSearch");
		ArrayList<Brand>listB=daoB.getAllBrand();
		ArrayList<product> listP=dao.getAllProductByNameIndashbroad(name);
		ArrayList<Category>listC=daoC.getAllCategory();
		request.setAttribute("listB", listB);
		request.setAttribute("listP", listP);
		request.setAttribute("listC", listC);
		request.getRequestDispatcher("/dbproduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
