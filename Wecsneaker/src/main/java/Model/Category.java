package Model;

public class Category {
	private String categoryID;
	private String categoryName;
	public Category(String categoryID, String categoryName) {
		super();
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}
	public Category() {
		super();
	}
	@Override
	public String toString() {
		return "Category [categoryID=" + categoryID + ", categoryName=" + categoryName + "]";
	}
	public String getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(String categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
