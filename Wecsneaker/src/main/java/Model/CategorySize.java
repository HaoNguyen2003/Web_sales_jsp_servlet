package Model;

public class CategorySize {
	private String categoryID;
	private String sizeID;
	public CategorySize(String categoryID, String sizeID) {
		super();
		this.categoryID = categoryID;
		this.sizeID = sizeID;
	}
	public CategorySize() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public String getSizeID() {
		return sizeID;
	}
	public void setSizeID(String sizeID) {
		this.sizeID = sizeID;
	}
	@Override
	public String toString() {
		return "CategorySize [categoryID=" + categoryID + ", sizeID=" + sizeID + "]";
	}
	
}
