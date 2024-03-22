package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connect.SQLconnect;
import Model.Category;


public class DAO_Category {
	public DAO_Category() {}
	public ArrayList<Category> getAllCategory() {
		String Query="select * from Category";
		ArrayList<Category>list=new ArrayList<Category>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new Category(
						rs.getString(1),
						rs.getString(2)
						            ));
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
}
