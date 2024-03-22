package Model;

public class favourite {
	private String favouriteID;
	private String productID;
	private String accountID;
	private String IDGG;
	
	public String getIDGG() {
		return IDGG;
	}
	public void setIDGG(String iDGG) {
		IDGG = iDGG;
	}
	public favourite() {
}
	public String getFavouriteID() {
		return favouriteID;
	}
	public void setFavouriteID(String favouriteID) {
		this.favouriteID = favouriteID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public favourite(String favouriteID, String productID, String accountID) {
		super();
		this.favouriteID = favouriteID;
		this.productID = productID;
		this.accountID = accountID;
	}
	
	public favourite(String favouriteID, String productID, String accountID, String iDGG) {
		super();
		this.favouriteID = favouriteID;
		this.productID = productID;
		this.accountID = accountID;
		IDGG = iDGG;
	}
	@Override
	public String toString() {
		return "favourite [favouriteID=" + favouriteID + ", productID=" + productID + ", accountID=" + accountID + "]";
	}
	
	// TODO Auto-generated constru
}
