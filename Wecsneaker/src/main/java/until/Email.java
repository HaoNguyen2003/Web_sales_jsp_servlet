package until;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	//icul sylb iwln zgcl
	//tinghow
	final static String email="tinghow1234@gmail.com";
	final static String passApp="icul sylb iwln zgcl";
	public void sendEmail(String Email,String title, String Content) {
		Properties properties=new Properties();
		properties.put("mail.smtp.host", "smtp.gmail.com");//SMTP host
		properties.put("mail.smtp.port", "587");//SMTP port GG TLS 587 SSL 465
		properties.put("mail.smtp.auth", "true");//sign in gmail
		properties.put("mail.smtp.starttls.enable", "true");
		//create authenticator for sign in
		Authenticator authenticator =new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(email, passApp);
			}
		};
		//create SessionMail login
		Session session=Session.getInstance(properties, authenticator);
		MimeMessage message=new MimeMessage(session);
		
		  try {
	      message.addHeader("Content-type", "text/HTML; charset=UTF-8");
		//set person to 
		  message.setFrom(email); message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(Email,false));
		// Tiêu đề email
		  message.setSubject(title); 
		// Quy đinh ngày gửi 
		  message.setSentDate(new Date());
		//Quy đinh email nhận phản hồi
		  //message.setReplyTo(Address)
		  //nội dung
		  message.setContent("<!DOCTYPE html>\r\n"
		  		+ "<html lang=\"en\">\r\n"
		  		+ "<head>\r\n"
		  		+ "    <meta charset=\"UTF-8\">\r\n"
		  		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
		  		+ "    <title>Document</title>\r\n"
		  		+ "    <style>\r\n"
		  		+ "        *{\r\n"
		  		+ "            font-family: 'Courier New', Courier, monospace;\r\n"
		  		+ "        }\r\n"
		  		+ "        .main{\r\n"
		  		+ "            width: 300px;\r\n"
		  		+ "            border-radius: 30px;\r\n"
		  		+ "            background-color: #fff;\r\n"
		  		+ "            display: flex;\r\n"
		  		+ "            flex-direction: column;\r\n"
		  		+ "            justify-content: center;\r\n"
		  		+ "            align-items: center;\r\n"
		  		+ "            box-shadow: 0 5px 10px rgba(0,0,0,.6);\r\n"
		  		+ "        }\r\n"
		  		+ "    </style>\r\n"
		  		+ "</head>\r\n"
		  		+ "<body>\r\n"
		  		+ "    <div class=\"main\">\r\n"
		  		+ "        <img src=\"https://inkythuatso.com/uploads/thumbnails/800/2023/01/13-anh-meme-meo-gio-tay-inkythuatso-17-15-31-10.jpg\" alt=\"\" width=\"200px\" height=\"100px\" style=\"border-radius: 10px;\">\r\n"
		  		+ "        <br><h3>Password:"+Content+"</h3>\r\n"
		  		+ "    </div>\r\n"
		  		+ "</body>\r\n"
		  		+ "</html>","text/html");
		  Transport.send(message);
		  System.out.println("gửi thành công");
		  } catch (MessagingException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); 
		}
	}
	public static void main(String[] args) {
		Email email=new Email();
		email.sendEmail("nguyentienhao12.3tpk@gmail.com", "Information pass", "pass của m nè:tienhao1234");
	}
}