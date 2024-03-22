package Model;

import java.sql.Date;

public class order {
	private String ordersID;
	private String accountID;
	private Date orderDay;
	private String payID;
	private double total;
	private String status;
	private int compeletePay;
	private String idGG;
	public String getIdGG() {
		return idGG;
	}

	public void setIdGG(String idGG) {
		this.idGG = idGG;
	}

	public order(String ordersID, String accountID, Date orderDay, String payID, double total, String status) {
		super();
		this.ordersID = ordersID;
		this.accountID = accountID;
		this.orderDay = orderDay;
		this.payID = payID;
		this.total = total;
		this.status = status;
	}
	
	public int getCompeletePay() {
		return compeletePay;
	}

	public void setCompeletePay(int compeletePay) {
		this.compeletePay = compeletePay;
	}

	public String getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(String ordersID) {
		this.ordersID = ordersID;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public Date getOrderDay() {
		return orderDay;
	}
	public void setOrderDay(Date orderDay) {
		this.orderDay = orderDay;
	}
	public String getPayID() {
		return payID;
	}
	public void setPayID(String payID) {
		this.payID = payID;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public order() {
		super();
		this.ordersID="error";
	}

	@Override
	public String toString() {
		return "order [ordersID=" + ordersID + ", accountID=" + accountID + ", orderDay=" + orderDay + ", payID="
				+ payID + ", total=" + total + ", status=" + status + ", compeletePay=" + compeletePay + "]";
	}
}
	
