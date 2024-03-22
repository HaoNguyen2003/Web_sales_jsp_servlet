package Model;
public class detailOrder {
	private String detailOrdersID;
	private String OrderID;
	private product product;
	private int Quatility;
	private double prices;
	private double total_money;
	private String size;
	public detailOrder(String detailOrdersID, String orderID, Model.product product, int quatility, double prices,
			double total_money, String size) {
		super();
		this.detailOrdersID = detailOrdersID;
		OrderID = orderID;
		this.product = product;
		Quatility = quatility;
		this.prices = prices;
		this.total_money = total_money;
		this.size = size;
	}
	public String getDetailOrdersID() {
		return detailOrdersID;
	}
	public void setDetailOrdersID(String detailOrdersID) {
		this.detailOrdersID = detailOrdersID;
	}
	public String getOrderID() {
		return OrderID;
	}
	public void setOrderID(String orderID) {
		OrderID = orderID;
	}
	public Model.product getProduct() {
		return product;
	}
	public void setProduct(Model.product productID) {
		this.product = productID;
	}
	public int getQuatility() {
		return Quatility;
	}
	public void setQuatility(int quatility) {
		Quatility = quatility;
	}
	public double getPrices() {
		return prices;
	}
	public void setPrices(double prices) {
		this.prices = prices;
	}
	public double getTotal_money() {
		return total_money;
	}
	public void setTotal_money(double total_money) {
		this.total_money = total_money;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return "detailOrder [detailOrdersID=" + detailOrdersID + ", OrderID=" + OrderID + ", productID=" + product.toString()
				+ ", Quatility=" + Quatility + ", prices=" + prices + ", total_money=" + total_money + ", size=" + size
				+ "]";
	}
	public detailOrder() {
		super();	
	}
}
