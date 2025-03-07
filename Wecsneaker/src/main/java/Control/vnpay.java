
  package Control;
  
  import com.google.gson.Gson; import com.google.gson.JsonObject;
  
  import Model.Config;
  
  import java.io.IOException;import java.net.URLEncoder; import
  java.nio.charset.StandardCharsets; import java.text.SimpleDateFormat; import
  java.util.ArrayList; import java.util.Calendar; import java.util.Collections;
  import java.util.HashMap; import java.util.Iterator; import java.util.List;
  import java.util.Map; import java.util.TimeZone; import
  javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
  import javax.servlet.http.HttpServlet; import
  javax.servlet.http.HttpServletRequest; import
  javax.servlet.http.HttpServletResponse;
  
 /**
	 * Servlet implementation class vnpay
	 */

  @WebServlet("/vnpay") public class vnpay extends HttpServlet { private static
  final long serialVersionUID = 1L;
  
 /**
	 * @see HttpServlet#HttpServlet()
	 */

  public vnpay() { super();} // TODO Auto-generated constructor stub }
  
 /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

  protected void doGet(HttpServletRequest request, HttpServletResponse
  response) throws ServletException, IOException { // TODO Auto-generatedmethod stub
  response.getWriter().append("Served at: ").append(request.getContextPath());
  }
  
 /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
		  protected void doPost(HttpServletRequest request, HttpServletResponse
		  response) throws ServletException, IOException { String vnp_Version =
		  "2.1.0"; String vnp_Command = "pay"; String vnp_OrderInfo =
		  request.getParameter("vnp_OrderInfo"); String orderType =
		  request.getParameter("ordertype"); String vnp_TxnRef =
		  Config.getRandomNumber(8); String vnp_IpAddr = Config.getIpAddress(request);
		  String vnp_TmnCode = Config.vnp_TmnCode;
		  
		  int amount = Integer.parseInt(request.getParameter("amount")) * 100; Map
		  vnp_Params = new HashMap<>(); vnp_Params.put("vnp_Version", vnp_Version);
		  vnp_Params.put("vnp_Command", vnp_Command); vnp_Params.put("vnp_TmnCode",
		  vnp_TmnCode); vnp_Params.put("vnp_Amount", String.valueOf(amount));
		  vnp_Params.put("vnp_CurrCode", "VND"); String bank_code =
		  request.getParameter("bankcode"); if (bank_code != null &&
		  !bank_code.isEmpty()) { vnp_Params.put("vnp_BankCode", bank_code); }
		  vnp_Params.put("vnp_TxnRef", vnp_TxnRef); vnp_Params.put("vnp_OrderInfo",
		  vnp_OrderInfo); vnp_Params.put("vnp_OrderType", orderType);
		  
		  String locate = request.getParameter("language"); if (locate != null &&
		  !locate.isEmpty()) { vnp_Params.put("vnp_Locale", locate); } else {
		  vnp_Params.put("vnp_Locale", "vn"); } vnp_Params.put("vnp_ReturnUrl",
		  Config.vnp_ReturnUrl); vnp_Params.put("vnp_IpAddr", vnp_IpAddr); Calendar cld
		  = Calendar.getInstance(TimeZone.getTimeZone("Etc/GMT+7"));
		  
		  SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss"); String
		  vnp_CreateDate = formatter.format(cld.getTime());
		  
		  vnp_Params.put("vnp_CreateDate", vnp_CreateDate); cld.add(Calendar.MINUTE,
		  15); String vnp_ExpireDate = formatter.format(cld.getTime()); //Add Params of2.1.0 Version 
		  vnp_Params.put("vnp_ExpireDate", vnp_ExpireDate); //Billing
		  vnp_Params.put("vnp_Bill_Mobile",
		  request.getParameter("txt_billing_mobile")); vnp_Params.put("vnp_Bill_Email",
		  request.getParameter("txt_billing_email")); String fullName =
		  (request.getParameter("txt_billing_fullname")).trim(); if (fullName != null
		  && !fullName.isEmpty()) { int idx = fullName.indexOf(' '); String firstName =
		  fullName.substring(0, idx); String lastName =
		  fullName.substring(fullName.lastIndexOf(' ') + 1);
		  vnp_Params.put("vnp_Bill_FirstName", firstName);
		  vnp_Params.put("vnp_Bill_LastName", lastName);
		  
		  } vnp_Params.put("vnp_Bill_Address", request.getParameter("txt_inv_addr1"));
		  vnp_Params.put("vnp_Bill_City", request.getParameter("txt_bill_city"));
		  vnp_Params.put("vnp_Bill_Country", request.getParameter("txt_bill_country"));
		  if (request.getParameter("txt_bill_state") != null &&
		  !request.getParameter("txt_bill_state").isEmpty()) {
		  vnp_Params.put("vnp_Bill_State", request.getParameter("txt_bill_state")); }
		  // Invoice vnp_Params.put("vnp_Inv_Phone",
		  request.getParameter("txt_inv_mobile"); vnp_Params.put("vnp_Inv_Email",
		  request.getParameter("txt_inv_email")); vnp_Params.put("vnp_Inv_Customer",
		  request.getParameter("txt_inv_customer")); vnp_Params.put("vnp_Inv_Address",
		  request.getParameter("txt_inv_addr1")); vnp_Params.put("vnp_Inv_Company",
		  request.getParameter("txt_inv_company")); vnp_Params.put("vnp_Inv_Taxcode",
		  request.getParameter("txt_inv_taxcode")); vnp_Params.put("vnp_Inv_Type",
		  request.getParameter("cbo_inv_type")); //Build data to hash and querystring
		  List fieldNames = new ArrayList(vnp_Params.keySet());
		  Collections.sort(fieldNames); StringBuilder hashData = new StringBuilder();
		  StringBuilder query = new StringBuilder(); Iterator itr =
		  fieldNames.iterator(); while (itr.hasNext()) { String fieldName = (String)
		  itr.next(); String fieldValue = (String) vnp_Params.get(fieldName); if
		  ((fieldValue != null) && (fieldValue.length() > 0)) { //Build hash data
		  hashData.append(fieldName); hashData.append('=');
		  hashData.append(URLEncoder.encode(fieldValue,
		  StandardCharsets.US_ASCII.toString())); //Build query
		  query.append(URLEncoder.encode(fieldName,
		  StandardCharsets.US_ASCII.toString())); query.append('=');
		  query.append(URLEncoder.encode(fieldValue,
		  StandardCharsets.US_ASCII.toString())); if (itr.hasNext()) {
		  query.append('&'); hashData.append('&'); } } } String queryUrl =
		  query.toString(); String vnp_SecureHash = Config.hmacSHA512(Config.secretKey,
		  hashData.toString()); queryUrl += "&vnp_SecureHash=" + vnp_SecureHash; String
		  paymentUrl = Config.vnp_PayUrl + "?" + queryUrl; com.google.gson.JsonObject
		  job = new JsonObject(); job.addProperty("code", "00");
		  job.addProperty("message", "success"); job.addProperty("data", paymentUrl);
		  Gson gson = new Gson(); response.getWriter().write(gson.toJson(job)); } }
		 