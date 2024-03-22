package Control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_Brand;
import DAO.DAO_Cart;
import DAO.DAO_Category;
import DAO.DAO_Product;
import Model.Account;
import Model.Brand;
import Model.Category;
import Model.product;

/**
 * Servlet implementation class ActiveandInactiveproduct
 */
@WebServlet("/ActiveandInactiveproduct")
public class ActiveandInactiveproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActiveandInactiveproduct() {
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
		PrintWriter out=response.getWriter();
		DAO_Product dao_Product=new DAO_Product();
		DAO_Category dao_Category=new DAO_Category();
		DAO_Brand dao_Brand=new DAO_Brand();
		DAO_Cart dao_Cart=new DAO_Cart();
		HttpSession session=request.getSession();
		
		Account ac;
		//
		//
		Object ob=  session.getAttribute("account");
		if(ob!=null) {
			ac=(Account) ob;
			String idproductActive=request.getParameter("idProductActive");
			String idproductInActive=request.getParameter("idProductInActive");
			if(idproductActive!=null) {
				product product=dao_Product.getProductByID(idproductActive);
				dao_Product.changeActive(idproductActive);	
				dao_Cart.activeproductPrice(product);
			}
			if(idproductInActive!=null) {
				dao_Product.changeInActive(idproductInActive);
				dao_Cart.InactiveProductPrice(idproductInActive);
			}
			System.out.println("idproduct: "+idproductActive);
			if(ac.getAccountAdmin()==1) {
				ArrayList<Brand>listB= dao_Brand.getAllBrand();
				ArrayList<Category>listC= dao_Category.getAllCategory();
				ArrayList<product>listP=dao_Product.getAllProductInDashBroad();
				for (product o : listP) {
					out.println("<tr>\r\n"
							+ "                <td>"+o.getProductID()+"</td>\r\n"
							+ "                <td>\r\n"
							+ "                    <img src=\""+o.getImgMain()+"\" alt=\"\">\r\n"
							+ "                    "+o.getProductName() +"\r\n"
							+ "                </td>\r\n"
							+ "                <td>"+ o.getTitle() +"</td>\r\n"
							+ "                <td>\r\n");
					for (Brand b : listB) {
						if (b.getBrandID().equals(o.getIsBrand())) {
                            out.print(b.getBrandName());
                            break;
                        }
					}
					out.println("</td>\r\n"
							+ "<td>");
					for(Category c:listC) {
						if (c.getCategoryID().equals(o.getCategoryID())) {
                            out.print(c.getCategoryName());
                            break;
                        }
					}
					out.println("</td>\r\n"
							+ "                <td>"+ o.getCreate_at() +"</td>\r\n"
							+ "                <td>"+ o.getUpdate_at() +"</td>\r\n"
							+ "                <td>\r\n"
							+ "                    <strong>"+ o.getPrice_out() * (1 - o.getDiscount() / 100)+"$</strong>\r\n"
							+ "                </td>\r\n"
							+ "                <td>\r\n"
							+ "                    <strong>"+ o.getPrice_in() +"</strong>\r\n"
							+ "                </td>\r\n"
							+ "                <td>"+ o.getDiscount() +"%</td>\r\n"
							+ "                <td>"+ o.getView() +"</td>\r\n"
							+ "                <td>\r\n");
					if(o.getIsActive()==1){
						out.println("<button onclick=\"changeInActive(this)\" id=\""+o.getProductID()+"\" value=\""+o.getProductID()+"\" class=\"status delivered\">Active</button>");
					}
					else {
						out.println("<button onclick=\"changeActive(this)\" id=\""+o.getProductID()+"\" value=\""+o.getProductID()+"\" class=\"status cancelled\">inactive</button>");
					}
					out.println(" </td>\r\n"
							+ "                <td>\r\n"
							+ "                    <a href=\"DeleteProduct\" class=\"red \"><i class=\"fa-solid fa-trash-can\"></i></a>\r\n"
							+ "                    <a href=\"updateproduct?id="+o.getProductID()+"\" class=\"blue\"><i class=\"fa-solid fa-pen-nib\"></i></a>\r\n"
							+ "                </td>\r\n"
							+ "            </tr>");
							
				}
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
