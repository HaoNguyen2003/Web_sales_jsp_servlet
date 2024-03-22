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
import DAO.DAO_Category;
import DAO.DAO_Product;
import Model.Account;
import Model.product;

/**
 * Servlet implementation class loadAllProductInDashborad
 */
@WebServlet("/loadAllProductInDashborad")
public class loadAllProductInDashborad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadAllProductInDashborad() {
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
		DAO_Product dao_Product=new DAO_Product();
		DAO_Category dao_Category=new DAO_Category();
		DAO_Brand dao_Brand=new DAO_Brand();
		HttpSession session=request.getSession();
		
		Account ac;
		//
		//
		Object ob=  session.getAttribute("account");
		if(ob!=null) {
			ac=(Account) ob;
			if(ac.getAccountAdmin()==1) {
				request.setAttribute("listB", dao_Brand.getAllBrand());
				request.setAttribute("listC", dao_Category.getAllCategory());
				ArrayList<product>listP=dao_Product.getAllProductInDashBroad();
				request.setAttribute("listP",listP);
				System.out.println("sp+ "+listP.toString());
				Object product=(product)request.getAttribute("product");
				if(product!=null)
				{
					product p=(Model.product) product;
					request.setAttribute("product",p);
					String comfirm= (String) request.getAttribute("cofirm5");
					request.setAttribute("cofirm5",comfirm);
				}
				request.getRequestDispatcher("/dbproduct.jsp").forward(request, response);
			}
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
