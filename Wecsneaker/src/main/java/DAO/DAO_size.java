package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connect.SQLconnect;
import Model.CategorySize;
import Model.size;

public class DAO_size {

	public DAO_size() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArrayList<CategorySize>getIdSizeByCategoryID(String CategoryID){
		ArrayList<CategorySize>list=new ArrayList<CategorySize>();
		String Query="select * from CategorySize\r\n"
				+ "where CategoryID=?";
		try {
			Connection con =new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, CategoryID);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new CategorySize(rs.getString(1),rs.getString(2)));
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
	public size getSizeByID(String idsize) {
		size size=new size();
		String Query="select * from Size\r\n"
				+ "where SizeID=?";
		try {
			Connection con =new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, idsize);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				size.setSizeID(rs.getString(1));
				size.setSizeName(rs.getString(2));
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
		return size;
	}
	public static void main(String[] args) {
		System.out.println(new DAO_size().getSizeByID("1").toString());
	}
}
