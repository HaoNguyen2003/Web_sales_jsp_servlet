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
import DAO.DAO_Cart;
import DAO.DAO_Product;
import DAO.DAO_UserGG;
import DAO.DAO_size;
import Model.Account;
import Model.Brand;
import Model.CategorySize;
import Model.detailOrder;
import Model.order;
import Model.product;
import Model.size;

/**
 * Servlet implementation class loadCart
 */
@WebServlet("/loadCart")
public class loadCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loadCart() {
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
		DAO_Cart dao_Cart=new DAO_Cart();
		DAO_size dao_size=new DAO_size();
		ArrayList<Brand>listB=daoB.getAllBrand();
		request.setAttribute("listB", listB);
		HttpSession session=request.getSession();
		Account ac;
		//
		Object obgg=session.getAttribute("usergg");
		String delete=request.getParameter("Delete");
		if(delete!=null) {
			request.setAttribute("Delete", delete);
		}
		String error=(String) request.getAttribute("error");
		if(error!=null) {
			request.setAttribute("error", error);
		}
		//
		Object ob=  session.getAttribute("account");
		if(ob!=null) {
			ac=(Account) ob;
			order order=dao_Cart.getOrderByIdAccount(ac.getAccountID());
			String orderID=dao_Cart.checkcart(ac.getAccountID());
			ArrayList<detailOrder>listDetailOrder=dao_Cart.getAllCartByorderID(orderID);
			for(detailOrder cr:listDetailOrder) 
			{
				product pd=dao.getProductByID(cr.getProduct().getProductID());
				ArrayList<CategorySize>listCategorieSizes=dao_size.getIdSizeByCategoryID(pd.getCategoryID());
				ArrayList<size>listOfProduct=new ArrayList<size>();
				for (CategorySize categorySize : listCategorieSizes)
				{
					size s=dao_size.getSizeByID(categorySize.getSizeID());
					listOfProduct.add(s);
				}
				pd.setSizes(listOfProduct);
				cr.setProduct(pd);
			}
			System.out.println(listDetailOrder.toString());
			request.setAttribute("listDetailOrder",listDetailOrder);
			request.setAttribute("bill", order);
			request.getRequestDispatcher("/Cart.jsp").forward(request, response);
		}
		else if(obgg!=null) {
			DAO_UserGG user=(DAO_UserGG) obgg;
			order order=dao_Cart.getOrderByIdGG(user.getId());
			ArrayList<detailOrder>liDetailOrders=dao_Cart.getAllCartByorderID(order.getOrdersID());
			for(detailOrder cr:liDetailOrders) 
			{
				product pd=dao.getProductByID(cr.getProduct().getProductID());
				ArrayList<CategorySize>listCategorieSizes=dao_size.getIdSizeByCategoryID(pd.getCategoryID());
				ArrayList<size>listOfProduct=new ArrayList<size>();
				for (CategorySize categorySize : listCategorieSizes)
				{
					size s=dao_size.getSizeByID(categorySize.getSizeID());
					listOfProduct.add(s);
				}
				pd.setSizes(listOfProduct);
				cr.setProduct(pd);
			}
			System.out.println(liDetailOrders.toString());
			request.setAttribute("listDetailOrder",liDetailOrders);
			request.setAttribute("bill", order);
			request.getRequestDispatcher("/Cart.jsp").forward(request, response);
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
