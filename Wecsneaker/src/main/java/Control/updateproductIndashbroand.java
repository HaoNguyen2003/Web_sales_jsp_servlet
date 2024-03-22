package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_Product;
import Model.Account;
import Model.product;

/**
 * Servlet implementation class updateproductIndashbroand
 */
@WebServlet("/updateproductIndashbroand")
public class updateproductIndashbroand extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateproductIndashbroand() {
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
		HttpSession session=request.getSession();
		Account ac;
		//
		//
		Object ob=  session.getAttribute("account");
		if(ob!=null) {
			ac=(Account) ob;
			String idProduct=request.getParameter("idproduct"); 
			String nameproduct=request.getParameter("nameproduct");
			String producttitle=request.getParameter("producttitle");
			double priceIn=Double.valueOf(request.getParameter("priceIn"));
			double priceOut=Double.valueOf(request.getParameter("priceOut"));
			double discount=Double.valueOf(request.getParameter("discount"));
			String Selector_Category=request.getParameter("Selector-Category");
			String Selector_brand=request.getParameter("Selector-brand");
			String imgmain=request.getParameter("imgmain");
			String img1=request.getParameter("img1");
			String img2=request.getParameter("img2");
			String img3=request.getParameter("img3");
			DAO_Product dao_Product=new DAO_Product();
			product ptemp=dao_Product.getProductByID(idProduct);
			if(imgmain==null)
			{
				imgmain=ptemp.getImgMain();
			}
			if(img1==null)
			{
				img1=ptemp.getListMain()[0];
			}
			if(img2==null)
			{
				img2=ptemp.getListMain()[1];
			}
			if(img3==null){
				img3=ptemp.getListMain()[2];
			}
			String[] listmain=new String[] {img1,img2,img3};
			String Discription=request.getParameter("Discription");
			product product =new product(idProduct, Selector_Category, nameproduct, producttitle, priceOut, priceIn, Discription, discount,null,null,imgmain,listmain, 0,Selector_brand,1);
			System.out.println("nó nè"+product.toString());
			dao_Product.updateProductAdmin(product);
			response.sendRedirect("loadAllProductInDashborad");
		}
		else {
			 request.setAttribute("cofirm5","addProduct");
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
