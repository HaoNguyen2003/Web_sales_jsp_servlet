package Model;

public class size {
	private String sizeID;
	private String sizeName;
	public size(String sizeID, String sizeName) {
		super();
		this.sizeID = sizeID;
		this.sizeName = sizeName;
	}
	public String getSizeID() {
		return sizeID;
	}
	public void setSizeID(String sizeID) {
		this.sizeID = sizeID;
	}
	public String getSizeName() {
		return sizeName;
	}
	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}
	public size() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "size [sizeID=" + sizeID + ", sizeName=" + sizeName + "]";
	}
	
}
