package Model;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

public class product {
	private String productID;
	private String CategoryID;
	private String productName;
	private String title;
	private double price_out;
	private double price_in;
	private String discription;
	private double discount;
	private Date create_at;
	private Date update_at;
	private String imgMain;
	private String[] listMain;
	private int view;
	private String isBrand;
	private ArrayList<size>sizes;
	private int isActive;
	public String getIsBrand() {
		return isBrand;
	}
	public void setIsBrand(String isBrand) {
		this.isBrand = isBrand;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	
	public ArrayList<size> getSizes() {
		return sizes;
	}
	public void setSizes(ArrayList<size> sizes) {
		this.sizes = sizes;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getCategoryID() {
		return CategoryID;
	}
	public void setCategoryID(String categoryID) {
		CategoryID = categoryID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice_out() {
		return price_out;
	}
	public void setPrice_out(double price_out) {
		this.price_out = price_out;
	}
	public double getPrice_in() {
		return price_in;
	}
	public void setPrice_in(double price_in) {
		this.price_in = price_in;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Date getCreate_at() {
		return create_at;
	}
	public void setCreate_at(Date create_at) {
		this.create_at = create_at;
	}
	public Date getUpdate_at() {
		return update_at;
	}
	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}
	public String getImgMain() {
		return imgMain;
	}
	public void setImgMain(String imgMain) {
		this.imgMain = imgMain;
	}
	public String[] getListMain() {
		return listMain;
	}
	public void setListMain(String[] listMain) {
		this.listMain = listMain;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public product(String productID, String categoryID, String productName, String title, double price_out,
			double price_in, String discription, double discount, Date create_at, Date update_at, String imgMain,
			String[] listMain, int view) {
		super();
		this.productID = productID;
		CategoryID = categoryID;
		this.productName = productName;
		this.title = title;
		this.price_out = price_out;
		this.price_in = price_in;
		this.discription = discription;
		this.discount = discount;
		this.create_at = create_at;
		this.update_at = update_at;
		this.imgMain = imgMain;
		this.listMain = listMain;
		this.view = view;
	}
	public product(String productID, String categoryID, String productName, String title, double price_out,
			double price_in, String discription, double discount, Date create_at, Date update_at, String imgMain,
			String[] listMain, int view, String isBrand, int isActive) {
		super();
		this.productID = productID;
		CategoryID = categoryID;
		this.productName = productName;
		this.title = title;
		this.price_out = price_out;
		this.price_in = price_in;
		this.discription = discription;
		this.discount = discount;
		this.create_at = create_at;
		this.update_at = update_at;
		this.imgMain = imgMain;
		this.listMain = listMain;
		this.view = view;
		this.isBrand = isBrand;
		this.isActive = isActive;
	}
	public product() {
		super();
	}
	@Override
	public String toString() {
		return "product [productID=" + productID + ", CategoryID=" + CategoryID + ", productName=" + productName
				+ ", title=" + title + ", price_out=" + price_out + ", price_in=" + price_in + ", discription="
				+ discription + ", discount=" + discount + ", create_at=" + create_at + ", update_at=" + update_at
				+ ", imgMain=" + imgMain + ", listMain=" + Arrays.toString(listMain) + ", view=" + view + ", isBrand="
				+ isBrand + ", sizes=" + sizes + ", isActive=" + isActive + "]";
	}
	
}

