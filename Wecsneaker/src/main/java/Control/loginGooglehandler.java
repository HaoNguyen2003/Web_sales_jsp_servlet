/*
 * package Control;
 * 
 * import java.io.IOException; import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.apache.http.client.ClientProtocolException; import
 * org.apache.http.client.fluent.Request; import
 * org.apache.http.client.fluent.Form;
 * 
 * import com.google.gson.Gson; import com.google.gson.JsonObject;
 * 
 * import DAO.DAO_Account; import DAO.DAO_UserGG; import Model.Constants;
 * 
 *//**
	 * Servlet implementation class loginGooglehandler
	 */
/*
 * @WebServlet("/loginGooglehandler") public class loginGooglehandler extends
 * HttpServlet { private static final long serialVersionUID = 1L;
 * 
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * public loginGooglehandler() { super(); // TODO Auto-generated constructor
 * stub }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException { // TODO Auto-generated
 * method stub String code = request.getParameter("code"); String accessToken =
 * getToken(code); DAO_UserGG user = getUserInfo(accessToken);
 * System.out.println(user.toString()); DAO_Account dao_Account=new
 * DAO_Account(); if(dao_Account.checkIdGG(user.getId()).equals("")) {
 * dao_Account.addUserGG(user); } HttpSession session =request.getSession();
 * session.setAttribute("usergg", user); response.sendRedirect("homecontrol"); }
 * public static String getToken(String code) throws ClientProtocolException,
 * IOException { // call api to get token String response =
 * Request.Post(Constants.GOOGLE_LINK_GET_TOKEN)
 * .bodyForm(Form.form().add("client_id", Constants.GOOGLE_CLIENT_ID)
 * .add("client_secret", Constants.GOOGLE_CLIENT_SECRET) .add("redirect_uri",
 * Constants.GOOGLE_REDIRECT_URI).add("code", code) .add("grant_type",
 * Constants.GOOGLE_GRANT_TYPE).build()) .execute().returnContent().asString();
 * 
 * JsonObject jobj = new Gson().fromJson(response, JsonObject.class); String
 * accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
 * return accessToken; }
 * 
 * public static DAO_UserGG getUserInfo(final String accessToken) throws
 * ClientProtocolException, IOException { String link =
 * Constants.GOOGLE_LINK_GET_USER_INFO + accessToken; String response =
 * Request.Get(link).execute().returnContent().asString();
 * 
 * DAO_UserGG googlePojo = new Gson().fromJson(response, DAO_UserGG.class);
 * 
 * return googlePojo; }
 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { // TODO Auto-generated
		 * method stub doGet(request, response); }
		 * 
		 * }
		 */