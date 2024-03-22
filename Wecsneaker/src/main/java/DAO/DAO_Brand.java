package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connect.SQLconnect;
import Model.Brand;
public class DAO_Brand {
	public DAO_Brand() {}
	public ArrayList<Brand> getAllBrand(){
		String Query="select * from Brand";
		ArrayList<Brand>list=new ArrayList<Brand>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			rs=ps.executeQuery();
			while (rs.next()) {
				list.add(new Brand(
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
	public static void main(String[] args) {
		System.err.println(new DAO_Brand().getAllBrand().toString());
	}
}
