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

import DAO.DAO_Account;
import DAO.DAO_Brand;
import DAO.DAO_Category;
import DAO.DAO_Product;
import Model.Account;
import Model.Brand;
import Model.Category;
import Model.product;

/**
 * Servlet implementation class InaccsessAndAccsess
 */
@WebServlet("/InaccsessAndAccsess")
public class InaccsessAndAccsess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InaccsessAndAccsess() {
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
		DAO_Account dao_Account=new DAO_Account();
		HttpSession session=request.getSession();
		
		Account ac;
		//
		//
		Object ob=  session.getAttribute("account");
		if(ob!=null) {
			ac=(Account) ob;
			String InAccess=request.getParameter("InAccess");
			String Access=request.getParameter("Accsess");
			if(Access!=null) {
				dao_Account.access(Access);
			}
			if(InAccess!=null) {
				dao_Account.Inaccess(InAccess);
			}
			System.out.println("access: "+Access  +"Inaccsess"+InAccess);
			if(ac.getAccountAdmin()==1) {
				ArrayList<Account>listA=dao_Account.loadAllAccount();
				for(Account o:listA) {
					out.println("                           <tr>\r\n"
							+ "                                <td>"+o.getAccountID()+"</td>\r\n"
							+ "                                <td>\r\n"
							+ "                                    <img src=\"assets/img/user.png\" alt=\"\">\r\n"
							+ "                                    "+o.getAccountName()+"\r\n"
							+ "                                </td>\r\n"
							+ "                                <td>\r\n"
							+ "                                    "+o.getAccountUser() +"\r\n"
							+ "                                </td>\r\n"
							+ "                                <td>\r\n"
							+ "                                    "+o.getAccountPassword()+"\r\n"
							+ "                                </td>\r\n"
							+ "                                <td>\r\n"
							+ "                                    "+o.getEmailAcount() +"\r\n"
							+ "                                </td>\r\n"
							+ "                                <td>\r\n"
							+ "                                    "+o.getAccountPhonenumber()+"\r\n"
							+ "                                </td>\r\n"
							+ "                                <td>\r\n"
							+ "                                    "+o.getCreated_at() +"\r\n"
							+ "                                </td>\r\n"
							+ "                                <td>\r\n"
							+ "                                    "+o.getUpdated_at()+"\r\n"
							+ "                                </td>\r\n"
							+ "                                <td>\r\n"
							+ "                                    "+o.getAccountAdress()+"\r\n"
							+ "                                </td>\r\n"
							+ "                                <td>\r\n"
							+ "                                    <p class=\"statusAccount activeAccount\">Active</p>\r\n"
							+ "                                </td>\r\n"
							+ "                                <td>\r\n"
							+ "                                    "+o.getOrder()+"\r\n"
							+ "                                </td>\r\n"
							+ "                                <td>\r\n"
							+ "                                  <a href=\"deleteAccount?id="+o.getAccountID()+"\"  class=\"red \"><i class=\"fa-solid fa-trash-can\"></i></a>\r\n"
							+ "                                   <a href=\"ApproveAdmin?id="+o.getAccountID()+"\" class=\"blue\"><i class=\"fa-solid fa-pen\"></i></a>");
					if(o.getAccess()==0){ 
						out.println("<button value=\""+o.getAccountID()+"\" onclick=\"Accsess(this)\"><i class=\"fa-solid fa-eye-low-vision\"></i></button>");
					}
					else {
						out.println("<button value=\""+o.getAccountID() +"\" onclick=\"InAccess(this)\"><i class=\"fa-solid fa-eye\"></i></button>");
					}
					out.println(" </td>\r\n"
							+ "</tr>");
				}
			}
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
