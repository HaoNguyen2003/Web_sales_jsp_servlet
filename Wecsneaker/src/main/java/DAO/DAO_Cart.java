package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connect.SQLconnect;
import Model.detailOrder;
import Model.order;
import Model.product;

public class DAO_Cart {
	public DAO_Cart() {
	}
	public String checkcart(String accountID) {
		String Query="select * from Orders\r\n"
				+ "where Orders.idAccount=?";
		ArrayList<order>listOrder=new ArrayList<order>();
			try {
				Connection con=new SQLconnect().getConnection();
				PreparedStatement ps=con.prepareStatement(Query);
				ResultSet rs;
				ps.setString(1, accountID);
				rs=ps.executeQuery();
				while(rs.next()) {
					order order=new order();
					order.setOrdersID(rs.getString(1));
					order.setAccountID(rs.getString(2));
					order.setOrderDay(rs.getDate(3));
					order.setStatus(rs.getString(4));
					order.setPayID(rs.getString(5));
					order.setTotal(rs.getDouble(6));
					order.setCompeletePay(rs.getInt(7));
					listOrder.add(order);
				}
				for (order order2 : listOrder) {
					if(order2.getPayID().equals("0")) {
						return order2.getOrdersID();
					}
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
		return "error";
	}
	public String checkcartByUserGG(String userID) {
		String Query="select * from Orders\r\n"
				+ "where Orders.idUserGoogle=?";
		ArrayList<order>listOrder=new ArrayList<order>();
			try {
				Connection con=new SQLconnect().getConnection();
				PreparedStatement ps=con.prepareStatement(Query);
				ResultSet rs;
				ps.setString(1, userID);
				rs=ps.executeQuery();
				while(rs.next()) {
					order order=new order();
					order.setOrdersID(rs.getString(1));
					order.setAccountID(rs.getString(2));
					order.setOrderDay(rs.getDate(3));
					order.setStatus(rs.getString(4));
					order.setPayID(rs.getString(5));
					order.setTotal(rs.getDouble(6));
					order.setCompeletePay(rs.getInt(7));
					listOrder.add(order);
				}
				for (order order2 : listOrder) {
					if(order2.getPayID().equals("0")) {
						return order2.getOrdersID();
					}
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
		return "error";
	}
	public String checkProductNumInCartByOrderID(String orderID,String productID,String size) {
		String Query="select idDetailOrder from DetailOrdes\r\n"
				+ "where DetailOrdes.idOrders=? and DetailOrdes.idProduct=? and DetailOrdes.Size=?";
		String i="";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ResultSet rs;
			ps.setString(1, orderID);
			ps.setString(2, productID);
			ps.setString(3, size);
			rs=ps.executeQuery();
			while(rs.next()) {
				i=rs.getString(1);
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
		return i;
	}
	public void createdcart(String accountID) {
		String Query="insert into Orders(idAccount,compeletePay,idPay)\r\n"
				+ "values(?,0,0)";
			try {
				Connection con=new SQLconnect().getConnection();
				PreparedStatement ps=con.prepareStatement(Query);
				ps.setString(1, accountID);
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
	public double  numProductIncart(String orderID)
	{
		String Query="select Orders.total from Orders\r\n"
				+ "where Orders.idOrders=?";
		double total=0;
			try {
				Connection con=new SQLconnect().getConnection();
				PreparedStatement ps=con.prepareStatement(Query);
				ps.setString(1, orderID);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					total=rs.getDouble(1);
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
			return total;
	}
	public void updateOrder(String email,String name,String number,String address,String id)
	{
		String Query="update Orders\r\n"
				+ "set Orders.orderDay=GETDATE(),idPay=2,StatusOrder='waiting process',compeletePay=0,EmailCustomer=?,nameCustomer=?,NumberCustomer=?,AddressCustomer=?\r\n"
				+ "where Orders.idOrders=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, email);
			ps.setString(2, name);
			ps.setString(3, number);
			ps.setString(4, address);
			ps.setString(5, id);
			ResultSet rs=ps.executeQuery();
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
	public void createdcartByGG(String userGGId) {
		String Query="insert into Orders(idUserGoogle,compeletePay,idPay)\r\n"
				+ "values(?,0,0)";
			try {
				Connection con=new SQLconnect().getConnection();
				PreparedStatement ps=con.prepareStatement(Query);
				ps.setString(1, userGGId);
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
	public void addToCart(product p,String orderID,String size) {
		String Query="insert into DetailOrdes(idOrders,idProduct,num,prices,Size)\r\n"
				+ "values(?,?,1,?,?)";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, orderID);
			ps.setString(2,p.getProductID());
			ps.setDouble(3, p.getPrice_out()*(1-p.getDiscount()/100));
			ps.setString(4, size);
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
	public void upDateToCart(String idDetailOrder) {
		String Query="update DetailOrdes\r\n"
				+ "set num=num+1\r\n"
				+ "where idDetailOrder=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, idDetailOrder);
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
	public void downToCart(String idDetailOrder) {
		String Query="update DetailOrdes\r\n"
				+ "set num=num-1\r\n"
				+ "where idDetailOrder=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, idDetailOrder);
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
	public int getNum(String idDetailOrder)
	{
		String Query="select num from DetailOrdes\r\n"
				+ "where idDetailOrder=?";
		int Quality=0;
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, idDetailOrder);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Quality=rs.getInt(1);
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
		return Quality;
	}
	public ArrayList<detailOrder>getAllCartByorderID(String orderID)
	{
		ArrayList<detailOrder>list=new ArrayList<detailOrder>();
		String Query="select * from DetailOrdes\r\n"
				+ "where DetailOrdes.idOrders=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, orderID);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				product pd=new product();
				pd.setProductID(rs.getString(3));
				list.add(new detailOrder(rs.getString(1), rs.getString(2),pd, rs.getInt(4), rs.getDouble(5), rs.getDouble(6), rs.getString(7)));
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
	public void DeleteDetailOrder(String idDetail) {
		String Query="delete DetailOrdes\r\n"
				+ "where DetailOrdes.idDetailOrder=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, idDetail);
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
	
	public void DeleteDetailOrderByIDOrder(String idOrder) {
		String Query="delete DetailOrdes\r\n"
				+ "where DetailOrdes.idOrders=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, idOrder);
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
	
	
	public void deleteOrderByAccount(String idAccount)
	{
		String Query="delete Orders\r\n"
				+ "where Orders.idAccount=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
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
	
	public order getOrderByIdAccount(String ID) {
		order order =new order();
		String Query="select * from Orders where idAccount=? and idPay=0";
		try {
			Connection con = new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, ID);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				order.setOrdersID(rs.getString(1));
				order.setAccountID(rs.getString(2));
				order.setOrderDay(rs.getDate(3));
				order.setStatus(rs.getString(4));
				order.setPayID(rs.getString(5));
				order.setTotal(rs.getDouble(6));
				order.setCompeletePay(rs.getInt(7));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
	}
	public order getOrderByIdGG(String ID) {
		order order =new order();
		String Query="select * from Orders where idUserGoogle=? and idPay=0";
		try {
			Connection con = new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, ID);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				order.setOrdersID(rs.getString(1));
				order.setAccountID(rs.getString(2));
				order.setOrderDay(rs.getDate(3));
				order.setStatus(rs.getString(4));
				order.setPayID(rs.getString(5));
				order.setTotal(rs.getDouble(6));
				order.setCompeletePay(rs.getInt(7));
				order.setIdGG(rs.getString(8));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return order;
	}
	public ArrayList<order> getAllDetailOrderCompelete(String IDAccount) {
		String Query="select * from Orders\r\n"
				+ "where Orders.idAccount=?";
		ArrayList<order>listOrder=new ArrayList<order>();
			try {
				Connection con=new SQLconnect().getConnection();
				PreparedStatement ps=con.prepareStatement(Query);
				ResultSet rs;
				ps.setString(1, IDAccount);
				rs=ps.executeQuery();
				while(rs.next()) {
					order order=new order();
					order.setOrdersID(rs.getString(1));
					order.setAccountID(rs.getString(2));
					order.setOrderDay(rs.getDate(3));
					order.setStatus(rs.getString(4));
					order.setPayID(rs.getString(5));
					order.setTotal(rs.getDouble(6));
					order.setCompeletePay(rs.getInt(7));
					if(order.getCompeletePay()==1) {
						listOrder.add(order);
					}
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
			return listOrder;
	}
	public ArrayList<order> getAllOrder(String IDAccount) {
		String Query="select * from Orders\r\n"
				+ "where Orders.idAccount=?";
		ArrayList<order>listOrder=new ArrayList<order>();
			try {
				Connection con=new SQLconnect().getConnection();
				PreparedStatement ps=con.prepareStatement(Query);
				ResultSet rs;
				ps.setString(1, IDAccount);
				rs=ps.executeQuery();
				while(rs.next()) {
					order order=new order();
					order.setOrdersID(rs.getString(1));
					order.setAccountID(rs.getString(2));
					order.setOrderDay(rs.getDate(3));
					order.setStatus(rs.getString(4));
					order.setPayID(rs.getString(5));
					order.setTotal(rs.getDouble(6));
					order.setCompeletePay(rs.getInt(7));
						listOrder.add(order);
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
			return listOrder;
	}
	public void updateProductByIDdetail(String idDetail,String Num,String size) {
		String Query="update DetailOrdes\r\n"
				+ "set num=? , Size=?\r\n"
				+ "where idDetailOrder=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, Num);
			ps.setString(2, size);
			ps.setString(3, idDetail);
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
	public int countOrderPay(String IDAccount) {
		int temp=-1;
		String Query="select count(*) from Orders\r\n"
				+ "where Orders.compeletePay=1 and Orders.idAccount=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, IDAccount);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				temp=rs.getInt(1);
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
		return temp;
	}
	public void InactiveProductPrice(String idProduct)
	{
		String Query="update DetailOrdes\r\n"
				+ "set prices=0\r\n"
				+ "where DetailOrdes.idProduct=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setString(1, idProduct);
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
	public void activeproductPrice(product product) {
		String Query="update DetailOrdes\r\n"
				+ "set prices=?\r\n"
				+ "where DetailOrdes.idProduct=?";
		try {
			Connection con=new SQLconnect().getConnection();
			PreparedStatement ps=con.prepareStatement(Query);
			ps.setDouble(1, product.getPrice_out()*(1-product.getDiscount()/100));
			ps.setString(2, product.getProductID());
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
		DAO_Cart dao_Cart=new DAO_Cart();
		System.out.println(dao_Cart.getAllDetailOrderCompelete("7"));
	}
}
