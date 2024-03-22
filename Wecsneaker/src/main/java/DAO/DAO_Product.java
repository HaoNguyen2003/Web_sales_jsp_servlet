package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connect.SQLconnect;
import Model.product;

public class DAO_Product {
	public DAO_Product() {}
	public ArrayList<product> getAllProduct(){
		String Query="select * from Product where Active=1 "
				+ " ORDER BY Product.idProduct DESC;";
		ArrayList<product>list=new ArrayList<product>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			rs=ps.executeQuery();
			while (rs.next()) {
				String[] listimg=rs.getString(12).split("tinghow");
				list.add(new product(rs.getString(1),
						             rs.getString(2),
						             rs.getString(3),
						             rs.getString(4),
						             rs.getDouble(5),
						             rs.getDouble(6),
						             rs.getString(7),
						             rs.getDouble(8),
						             rs.getDate(9),
						             rs.getDate(10),
						             rs.getString(11),
						             listimg,
						             rs.getInt(13),
						             rs.getString(14),
						             rs.getInt(15)
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
	public ArrayList<product> getAllProductInDashBroad() {
	    String Query = "SELECT * FROM Product where idProduct>0"
	    		+ "ORDER BY Product.idProduct DESC;";
	    ArrayList<product> list = new ArrayList<product>();
	    Connection con = null;
	    PreparedStatement ps = null;
	    ResultSet rs;
	    try {
	        con = new SQLconnect().getConnection();
	        ps = con.prepareStatement(Query);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            String[] listimg = rs.getString(12).split("tinghow");
	            list.add(new product(rs.getString(1),
	                                 rs.getString(2),
	                                 rs.getString(3),
	                                 rs.getString(4),
	                                 rs.getDouble(5),
	                                 rs.getDouble(6),
	                                 rs.getString(7),
	                                 rs.getDouble(8),
	                                 rs.getDate(9),
	                                 rs.getDate(10),
	                                 rs.getString(11),
	                                 listimg,
	                                 rs.getInt(13),
	                                 rs.getString(14),
	                                 rs.getInt(15)));
	        }

	        con.close();
	        ps.close();
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	public ArrayList<product> getAllProductSale(){
		String Query="select * from Product\r\n"
				+ "where Product.discount>0 and Active=1  "
				+ "ORDER BY Product.idProduct DESC;;";
		ArrayList<product>list=new ArrayList<product>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			rs=ps.executeQuery();
			while (rs.next()) {
				String[] listimg=rs.getString(12).split("tinghow");
				list.add(new product(rs.getString(1),
						             rs.getString(2),
						             rs.getString(3),
						             rs.getString(4),
						             rs.getDouble(5),
						             rs.getDouble(6),
						             rs.getString(7),
						             rs.getDouble(8),
						             rs.getDate(9),
						             rs.getDate(10),
						             rs.getString(11),
						             listimg,
						             rs.getInt(13),
						             rs.getString(14),
						             rs.getInt(15)
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
	public void deleteProductInDashBroand(String id) {
		String Query="delete Product \r\n"
				+ "where Product.idProduct=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			ps.setString(1, id);
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
	public void deleteProductIndetailorderDashBroand(String id) {
		String Query="delete DetailOrdes\r\n"
				+ "where DetailOrdes.idProduct=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			ps.setString(1, id);
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
	public product getProductByID(String iD) {
		product product=new product();
		String Query="select * from Product \r\n"
				+ "where Product.idProduct=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			ps.setString(1, iD);
			rs=ps.executeQuery();
			while (rs.next()) {
				String[] listimg=rs.getString(12).split("tinghow");
				 product.setProductID(rs.getString(1));
	             product.setCategoryID(rs.getString(2));
	             product.setProductName(rs.getString(3));
	             product.setTitle(rs.getString(4));
	             product.setPrice_out(rs.getDouble(5));
	             product.setPrice_in(rs.getDouble(6));
	             product.setDiscription(rs.getString(7));
	             product.setDiscount(rs.getDouble(8));
	             product.setCreate_at(rs.getDate(9));
	             product.setUpdate_at(rs.getDate(10));
	             product.setImgMain(rs.getString(11));
	             product.setListMain(listimg);
	             product.setView(rs.getInt(13));
	             product.setIsBrand(rs.getString(14));
	             product.setIsActive(rs.getInt(15));
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
		return product;
	}
	public void upView(String IDproduct) {
		String Query="update Product\r\n"
				+ "set viewer=viewer+1\r\n"
				+ "where Product.idProduct=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			ps.setString(1, IDproduct);
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
	public void changeActive(String IDproduct) {
		String Query="update Product\r\n"
				+ "set active=1\r\n"
				+ "where Product.idProduct=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			ps.setString(1, IDproduct);
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
	public void changeInActive(String IDproduct) {
		String Query="update Product\r\n"
				+ "set active=0\r\n"
				+ "where Product.idProduct=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			ps.setString(1, IDproduct);
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
	public ArrayList<product> getAllProductByName(String Name){
		String Query="select * from Product\r\n"
				+ "where Product.nameProduct like ? and Active=1 ORDER BY Product.idProduct DESC;";
		ArrayList<product>list=new ArrayList<product>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			ps.setString(1, "%"+Name+"%");
			rs=ps.executeQuery();
			while (rs.next()) {
				String[] listimg=rs.getString(12).split("tinghow");
				list.add(new product(rs.getString(1),
						             rs.getString(2),
						             rs.getString(3),
						             rs.getString(4),
						             rs.getDouble(5),
						             rs.getDouble(6),
						             rs.getString(7),
						             rs.getDouble(8),
						             rs.getDate(9),
						             rs.getDate(10),
						             rs.getString(11),
						             listimg,
						             rs.getInt(13),
						             rs.getString(14),
						             rs.getInt(15)
						             
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
	public ArrayList<product> getAllProductByNameIndashbroad(String Name){
		String Query="select * from Product\r\n"
				+ "where Product.nameProduct like ? ORDER BY Product.idProduct DESC;";
		ArrayList<product>list=new ArrayList<product>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			ps.setString(1, "%"+Name+"%");
			rs=ps.executeQuery();
			while (rs.next()) {
				String[] listimg=rs.getString(12).split("tinghow");
				list.add(new product(rs.getString(1),
						             rs.getString(2),
						             rs.getString(3),
						             rs.getString(4),
						             rs.getDouble(5),
						             rs.getDouble(6),
						             rs.getString(7),
						             rs.getDouble(8),
						             rs.getDate(9),
						             rs.getDate(10),
						             rs.getString(11),
						             listimg,
						             rs.getInt(13),
						             rs.getString(14),
						             rs.getInt(15)
						             
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
	public ArrayList<product> getAllProductByBrand(String id){
		String Query="select * from Product\r\n"
				+ "where Product.idBrand=? and Active=1 ORDER BY Product.idProduct DESC;";
		ArrayList<product>list=new ArrayList<product>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while (rs.next()) {
				String[] listimg=rs.getString(12).split("tinghow");
				list.add(new product(rs.getString(1),
						             rs.getString(2),
						             rs.getString(3),
						             rs.getString(4),
						             rs.getDouble(5),
						             rs.getDouble(6),
						             rs.getString(7),
						             rs.getDouble(8),
						             rs.getDate(9),
						             rs.getDate(10),
						             rs.getString(11),
						             listimg,
						             rs.getInt(13),
						             rs.getString(14),
						             rs.getInt(15)
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
	public ArrayList<product> getAllProductByCategory(String id,String Bid){
		String Query="select * from Product\r\n"
				+ "where Product.idCategory=? and Product.idBrand=? and Active=1 ORDER BY Product.idProduct DESC;";
		ArrayList<product>list=new ArrayList<product>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			ps.setString(1, id);
			ps.setString(2,Bid);
			rs=ps.executeQuery();
			while (rs.next()) {
				String[] listimg=rs.getString(12).split("tinghow");
				list.add(new product(rs.getString(1),
						             rs.getString(2),
						             rs.getString(3),
						             rs.getString(4),
						             rs.getDouble(5),
						             rs.getDouble(6),
						             rs.getString(7),
						             rs.getDouble(8),
						             rs.getDate(9),
						             rs.getDate(10),
						             rs.getString(11),
						             listimg,
						             rs.getInt(13),
						             rs.getString(14),
						             rs.getInt(15)
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
	public ArrayList<product> getAllProductByCategory(String id){
		String Query="select * from Product\r\n"
				+ "where Product.idCategory=? and Active=1 ORDER BY Product.idProduct DESC;";
		ArrayList<product>list=new ArrayList<product>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			ps.setString(1, id);
			rs=ps.executeQuery();
			while (rs.next()) {
				String[] listimg=rs.getString(12).split("tinghow");
				list.add(new product(rs.getString(1),
						             rs.getString(2),
						             rs.getString(3),
						             rs.getString(4),
						             rs.getDouble(5),
						             rs.getDouble(6),
						             rs.getString(7),
						             rs.getDouble(8),
						             rs.getDate(9),
						             rs.getDate(10),
						             rs.getString(11),
						             listimg,
						             rs.getInt(13),
						             rs.getString(14),
						             rs.getInt(15)
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
	public void addProductAdmin(product product) {
		String Query="insert into Product(idCategory,nameProduct,tilte,price,price_In,discription,discount,created_at,updated_at,image_link,image_list,viewer,idBrand,active)\r\n"
				+ "values(?,?,?,?,?,?,?,GETDATE(),GETDATE(),?,?,?,?,?)";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			ps.setString(1, product.getCategoryID());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getTitle());
			ps.setDouble(4, product.getPrice_out());
			ps.setDouble(5, product.getPrice_in());
			ps.setString(6, product.getDiscription());
			ps.setDouble(7, product.getDiscount());
			ps.setString(8, product.getImgMain());
			String listimg=product.getListMain()[0]+"tinghow"+product.getListMain()[1]+"tinghow"+product.getListMain()[2];
			ps.setString(9,listimg);
			ps.setInt(10, product.getView());
			ps.setString(11, product.getIsBrand());
			ps.setInt(12, product.getIsActive());
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
	public void updateProductAdmin(product product) {
		String Query="update Product\r\n"
				+ "set idCategory=?,nameProduct=?,tilte=?,price=?,price_In=?,discription=?,discount=?,updated_at=getdate(),image_link=?,image_list=?,idBrand=?\r\n"
				+ "where idProduct=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs;
		try {
			con=new SQLconnect().getConnection();
			ps=con.prepareStatement(Query);
			ps.setString(1, product.getCategoryID());
			ps.setString(2, product.getProductName());
			ps.setString(3, product.getTitle());
			ps.setDouble(4, product.getPrice_out());
			ps.setDouble(5, product.getPrice_in());
			ps.setString(6, product.getDiscription());
			ps.setDouble(7, product.getDiscount());
			ps.setString(8, product.getImgMain());
			String listimg=product.getListMain()[0]+"tinghow"+product.getListMain()[1]+"tinghow"+product.getListMain()[2];
			ps.setString(9,listimg);
			ps.setString(10, product.getIsBrand());
			ps.setString(11, product.getProductID());
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
	public static void main(String[] args) {
		System.out.println(new DAO_Product().getAllProductByCategory("1","1").toString());
	}
}
