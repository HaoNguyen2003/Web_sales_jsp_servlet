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
import DAO.DAO_size;
import Model.Brand;
import Model.CategorySize;
import Model.product;
import Model.size;

/**
 * Servlet implementation class detailcontrol
 */
@WebServlet("/detailcontrol")
public class detailcontrol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public detailcontrol() {
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
		DAO_size dao_size=new DAO_size();
		//String success= (String)request.getAttribute("AddCartSuccess");
		Object ob=request.getParameter("id");
		String id="";
		if(ob!=null) {
			id=(String) ob;
		}
		else {
			id=(String) request.getAttribute("IDFromAddToCart");
			String notication=(String) request.getAttribute("AddCartSuccess");
			request.setAttribute("AddCartSuccess", notication);
		}
		ArrayList<size>listS=new ArrayList<size>();
		product product=dao.getProductByID(id);
		dao.upView(id);
		ArrayList<CategorySize>listCS=dao_size.getIdSizeByCategoryID(product.getCategoryID());
		for (CategorySize categorySize : listCS) {
			size s=dao_size.getSizeByID(categorySize.getSizeID());
			listS.add(s);
		}
		ArrayList<Brand>listB=daoB.getAllBrand();
		//if(success!=null) {
			//request.setAttribute("AddCartSuccess","Success");
		//}
		request.setAttribute("listS",listS);
		request.setAttribute("listB", listB);
		request.setAttribute("pd", product);
		request.setAttribute("size", Integer.valueOf(product.getCategoryID()));
		request.getRequestDispatcher("/detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
