package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DAO_Account;
import until.Email;

/**
 * Servlet implementation class forgotpassword
 */
@WebServlet("/forgotpassword")
public class forgotpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public forgotpassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String email=request.getParameter("email");
		DAO_Account dao_Account=new DAO_Account();
		String pass=dao_Account.getPass(email);
		if(pass.equals(""))
		{
			String notice="email này chưa đươc đăng kí!!!";
			request.setAttribute("notice", notice);
		}else {
			Email email2=new Email();
			String notice2="check your email";
			request.setAttribute("notice", notice2);
			email2.sendEmail(email, "Your Information Password", pass);
		}
		request.getRequestDispatcher("/forgotPW.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
