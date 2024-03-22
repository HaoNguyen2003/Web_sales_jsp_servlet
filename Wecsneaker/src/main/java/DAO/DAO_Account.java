package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connect.SQLconnect;
import Model.Account;

public class DAO_Account {
	public DAO_Account() {}
	public String checkIdGG(String id)
	{
		String iduser="";
		String Query="select iduser from usergoogle\r\n"
				+ "where iduser=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ResultSet rs;
			ps.setString(1, id);
			rs=ps.executeQuery();
			while(rs.next())
			{
			 if(rs.getString(1)!=null) {
				 iduser=rs.getString(1);
			 };
			}
			con.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return iduser;
	}
	public void addUserGG(DAO_UserGG user)
	{
		String Query="insert into usergoogle(iduser,customername,picture)\r\n"
				+ "values(?,?,?)";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, user.getId());
			ps.setString(2, user.getFamily_name()+user.getGiven_name());
			ps.setString(3, user.getPicture());
			ps.executeQuery();
			con.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Account checkAccount(String user,String pass) {
		Account account=new Account();
		String Query="SELECT *FROM Account\r\n"
				+ "WHERE CONVERT(varchar(max), Account.userAccount) =? and CONVERT(varchar(max), Account.passAccount)=? and access=1";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				account.setAccountID(rs.getString(1));
				account.setAccountUser(rs.getString(2));
				account.setAccountPassword(rs.getString(3));
				account.setAccountName(rs.getString(4));;
				account.setEmailAcount(rs.getString(5));
				account.setAccountPhonenumber(rs.getString(6));
				account.setCreated_at(rs.getDate(7));
				account.setUpdated_at(rs.getDate(8));
				account.setAccountAdress(rs.getString(9));
				account.setAccountAdmin(rs.getInt(10));
			}
			con.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
	public Account checkEmail(String email) {
		Account account=new Account();
		String Query="SELECT *\r\n"
				+ "FROM Account\r\n"
				+ "Where CONVERT(varchar(max), Account.emailAccount) = ?;";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				account.setAccountID(rs.getString(1));
				account.setAccountUser(rs.getString(2));
				account.setAccountPassword(rs.getString(3));
				account.setAccountName(rs.getString(4));;
				account.setEmailAcount(rs.getString(5));
				account.setAccountPhonenumber(rs.getString(6));
				account.setCreated_at(rs.getDate(7));
				account.setUpdated_at(rs.getDate(8));
				account.setAccountAdress(rs.getString(9));
				account.setAccountAdmin(rs.getInt(10));
			}
			con.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
	public void addAccount(Account ac) {
		String Query="insert into Account(userAccount,passAccount,nameAccount,emailAccount,numberPhone,created_at,updated_at,adress,admins,access)\r\n"
				+ "values(?,?,?,?,?,getdate(),getdate(),?,?,1)";
		Connection con;
		try {
			con = new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, ac.getAccountUser());
			ps.setString(2, ac.getAccountPassword());
			ps.setString(3, ac.getAccountName());
			ps.setString(4, ac.getEmailAcount());
			ps.setString(5, ac.getAccountPhonenumber());
			ps.setString(6, ac.getAccountAdress());
			ps.setInt(7, ac.getAccountAdmin());
			ps.executeQuery();
			con.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void approveAdmin(String IdAccount) {
		String Query="update Account\r\n"
				+ "set admins=1\r\n"
				+ "where idAccount=?";
		Connection con;
		try {
			con = new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1,IdAccount);
			ps.executeQuery();
			con.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Inaccess(String idAccount)
	{
		String Query="update Account\r\n"
				+ "set access=0\r\n"
				+ "where idAccount=?";
		Connection con;
		try {
			con = new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1,idAccount);
			ps.executeQuery();
			con.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void access(String idAccount) {
		String Query="update Account\r\n"
				+ "set access=1\r\n"
				+ "where idAccount=?";
		Connection con;
		try {
			con = new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1,idAccount);
			ps.executeQuery();
			con.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deteleAccount(String idAccount) {
		String Query="delete Account\r\n"
				+ "where idAccount=?";
		Connection con;
		try {
			con = new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1,idAccount);
			ps.executeQuery();
			con.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<Account> loadAllAccount() {
		String Query="select * from Account\r\n"
				+ "where Account.idAccount>0 and admins!=1\r\n"
				+ "order by idAccount DESC";
		ArrayList<Account>list=new ArrayList<Account>();
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ResultSet rs= ps.executeQuery();
			while (rs.next()) {
				list.add(new Account(rs.getString(1),
						             rs.getString(2),
						             rs.getString(3),
						             rs.getString(4),
						             rs.getString(5),
						             rs.getString(6),
						             rs.getDate(7),
						             rs.getDate(8),
						             rs.getString(9),
						             rs.getInt(10),
						             rs.getInt(11)));
			}
			con.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public String getPass(String Email) {
		String Query="select passAccount from Account\r\n"
				+ "where CONVERT(varchar(max), Account.emailAccount) =?;";
		String email="";
		Connection con;
		try {
			con = new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1,Email);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				email=rs.getString(1);
			}
			con.close();
			ps.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}
	public static void main(String[] args) {
		//Account ac=new Account("1","Tinghow12345","Nguyen Tien Hao","nguyentienhao12.3tpk@gmail.com","0878193742",null, Date.valueOf(LocalDate.now()),Date.valueOf(LocalDate.now()),"VietNam",0);
		DAO_Account dao=new DAO_Account();
		//dao.addAccount(ac);
		System.out.println(dao.checkEmail("nguyentienhao2020a@gmail.com").toString());
	}
}
