package Model;

public class Brand {
	private String brandID;
	private String brandName;
	public Brand(String brandID, String brandName) {
		super();
		this.brandID = brandID;
		this.brandName = brandName;
	}
	public String getBrandID() {
		return brandID;
	}
	public void setBrandID(String brandID) {
		this.brandID = brandID;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	@Override
	public String toString() {
		return "Brand [brandID=" + brandID + ", brandName=" + brandName + "]";
	}
	
}
