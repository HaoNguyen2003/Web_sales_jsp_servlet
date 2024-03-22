package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.DAO_Account;
import Model.Account;

/**
 * Servlet implementation class signupControl
 */
@WebServlet("/signupControl")
public class signupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupControl() {
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
		String userName=request.getParameter("Username1");
		String email=request.getParameter("Email1");
		String FullName=request.getParameter("FullName1");
		String passWord=request.getParameter("Password1");
		String rePass=request.getParameter("Repassword1");
		System.out.println("username: "+userName);
		System.out.println("email: "+email);
		System.out.println("fullname: "+FullName);
		System.out.println("pass: "+passWord +" repass: "+rePass);
		
		DAO_Account daoA=new DAO_Account();
		String error=" ";
		if(daoA.checkAccount(userName,passWord).getAccountName()!=null) {
			error=error+"user name đã tồn tại!!";
		}
		else {
			if(daoA.checkEmail(email).getAccountName()!=null)
			{
				error=error+"email đã tồn tại!!";
			}
			else {
				Account ac=new Account("1", userName, passWord,FullName, email,"0979021848",null, null, "VietNam", 0,1);
				daoA.addAccount(ac);
				request.setAttribute("sussecc", "sussecc");
			}
		}
		if(!error.equals(" ")) {
			request.setAttribute("error1", error);
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
