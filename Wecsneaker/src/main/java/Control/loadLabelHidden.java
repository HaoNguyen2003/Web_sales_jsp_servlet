package Control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.DAO_Product;
import DAO.DAO_size;
import Model.CategorySize;
import Model.product;
import Model.size;

/**
 * Servlet implementation class loadLabelHidden
 */
@WebServlet("/loadLabelHidden")
public class loadLabelHidden extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadLabelHidden() {
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
		DAO_size dao_size=new DAO_size();
		String idProduct=request.getParameter("id");
		ArrayList<size>listS=new ArrayList<size>();
		product product=dao.getProductByID(idProduct);
		ArrayList<CategorySize>listCS=dao_size.getIdSizeByCategoryID(product.getCategoryID());
		for (CategorySize categorySize : listCS) {
			size s=dao_size.getSizeByID(categorySize.getSizeID());
			listS.add(s);
		}
		request.setAttribute("listS",listS);
		request.setAttribute("pd", product);
		request.getRequestDispatcher("loadFavourite").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
