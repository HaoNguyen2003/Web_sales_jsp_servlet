package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connect.SQLconnect;
import Model.favourite;

public class DAO_favourite {
	public DAO_favourite() {}
	public boolean checkProductInfavourite(String idAccount,String idProduct)
	{
		int x=0;
		String Query="select count(*) from favourite where idAccount=? and idProduct=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps;
			ps=con.prepareStatement(Query);
			ps.setString(1, idAccount);
			ps.setString(2, idProduct);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				x=rs.getInt(1);
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
		if (x==1) {
			return true;
		}
		return false;
	}
	public boolean checkProductInfavouriteByUserGG(String idUser,String idProduct)
	{
		int x=0;
		String Query="select count(*) from favourite where IDGG=? and idProduct=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps;
			ps=con.prepareStatement(Query);
			ps.setString(1, idUser);
			ps.setString(2, idProduct);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				x=rs.getInt(1);
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
		if (x==1) {
			return true;
		}
		return false;
	}
	
	public void addTofavourite(String idAccount,String idProduct) {
		String Query="insert into favourite(idAccount,idProduct)\r\n"
				+ "values(?,?)";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps;
			ps=con.prepareStatement(Query);
			ps.setString(1, idAccount);
			ps.setString(2, idProduct);
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
	public void addTofavouriteIDGG(String IDGG,String idProduct) {
		String Query="insert into favourite(IDGG,idProduct)\r\n"
				+ "values(?,?)";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps;
			ps=con.prepareStatement(Query);
			ps.setString(1, IDGG);
			ps.setString(2, idProduct);
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
	public void deletefavouritebyproduct(String idAccount,String idProduct) {
		String Query="delete favourite\r\n"
				+ "where favourite.idAccount=? and favourite.idProduct=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps;
			ps=con.prepareStatement(Query);
			ps.setString(1, idAccount);
			ps.setString(2, idProduct);
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
	public void deletefavouritebyproductbyGG(String IDGG,String idProduct) {
		String Query="delete favourite\r\n"
				+ "where favourite.IDGG=? and favourite.idProduct=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps;
			ps=con.prepareStatement(Query);
			ps.setString(1, IDGG);
			ps.setString(2, idProduct);
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
	public void deletefavouritebyproduct(String idAccount) {
		String Query="delete favourite\r\n"
				+ "where favourite.idAccount=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps;
			ps=con.prepareStatement(Query);
			ps.setString(1, idAccount);
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
	public void deletefavouritebyproductByGG(String IDGG) {
		String Query="delete favourite\r\n"
				+ "where favourite.IDGG=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps;
			ps=con.prepareStatement(Query);
			ps.setString(1, IDGG);
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
	public ArrayList<favourite> loadfavourite(String idAccount) {
		ArrayList<favourite>favourites=new ArrayList<favourite>();
		String Query="select * from favourite where idAccount=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps;
			ps=con.prepareStatement(Query);
			ps.setString(1, idAccount);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				favourites.add(new favourite(rs.getString(1),rs.getString(2),rs.getString(3)));
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
		return favourites;
	}
	public ArrayList<favourite> loadfavouriteByGG(String Idgg) {
		ArrayList<favourite>favourites=new ArrayList<favourite>();
		String Query="select * from favourite where IDGG=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps;
			ps=con.prepareStatement(Query);
			ps.setString(1, Idgg);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				favourites.add(new favourite(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
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
		return favourites;
	}
	public static void main(String[] args) {
		System.out.println(new DAO_favourite().loadfavourite("7").toString());
	}
}
