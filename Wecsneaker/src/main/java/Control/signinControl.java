package Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DAO_Account;
import Model.Account;

/**
 * Servlet implementation class signinControl
 */
@WebServlet("/signinControl")
public class signinControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signinControl() {
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
		Cookie[]arr=request.getCookies();
		for(Cookie cookie:arr) {
			if(cookie.getName().equals("user")) {
				String user=cookie.getValue();
				request.setAttribute("user", user);
			}
			if(cookie.getName().equals("passWord")) {
				String pass=cookie.getValue();
				request.setAttribute("pass", pass);
			}
		}
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String userName=request.getParameter("Username2");
		String passWord=request.getParameter("Password2");
		DAO_Account daoA=new DAO_Account();
		Account account =daoA.checkAccount(userName,passWord);
		if(account.getAccountID()!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("account", account);
			session.setMaxInactiveInterval(60000);
			Cookie user=new Cookie("user", userName);
			Cookie pass=new Cookie("passWord", passWord);
			user.setMaxAge(6000);
			pass.setMaxAge(6000);
			response.addCookie(user);
			response.addCookie(pass);
			response.sendRedirect("homecontrol");
		}
		else {
			String error="sai tài khoản hoặc mật khẩu";
			request.setAttribute("error", error);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
