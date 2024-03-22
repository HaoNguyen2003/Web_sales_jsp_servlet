package DAO;

public class DAO_UserGG {
	private String id;
	private String email;
	private String verified_email;
	private String given_name;
	private String family_name;
	private String picture;
	public DAO_UserGG(String id, String email, String verified_email, String given_name, String family_name,
			String picture) {
		super();
		this.id = id;
		this.email = email;
		this.verified_email = verified_email;
		this.given_name = given_name;
		this.family_name = family_name;
		this.picture = picture;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVerified_email() {
		return verified_email;
	}
	public void setVerified_email(String verified_email) {
		this.verified_email = verified_email;
	}
	public String getGiven_name() {
		return given_name;
	}
	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}
	public String getFamily_name() {
		return family_name;
	}
	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "DAO_UserGG [id=" + id + ", email=" + email + ", verified_email=" + verified_email + ", given_name="
				+ given_name + ", family_name=" + family_name + ", picture=" + picture + "]";
	}
	
}
