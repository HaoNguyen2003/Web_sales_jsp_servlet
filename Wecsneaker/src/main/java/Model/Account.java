package Model;

import java.sql.Date;

public class Account {
	private String accountID;
	private String accountUser;
	private String accountPassword;
	private String accountName;
	private String emailAcount;
	private String accountPhonenumber;
	private Date created_at;
	private Date updated_at;
	private String accountAdress;
	private int accountAdmin;
	private int access=0;
	private int Order=0;
	public int getAccess() {
		return access;
	}
	public void setAccess(int access) {
		this.access = access;
	}
	public Account(String accountID, String accountUser, String accountPassword, String accountName, String emailAcount,
			String accountPhonenumber, Date created_at, Date updated_at, String accountAdress, int accountAdmin,int access) {
		super();
		this.accountID = accountID;
		this.accountUser = accountUser;
		this.accountPassword = accountPassword;
		this.accountName = accountName;
		this.emailAcount = emailAcount;
		this.accountPhonenumber = accountPhonenumber;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.accountAdress = accountAdress;
		this.accountAdmin = accountAdmin;
		this.access=access;
	}
	public int getOrder() {
		return Order;
	}
	public void setOrder(int order) {
		Order = order;
	}
	public Account() {
		super();
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getAccountUser() {
		return accountUser;
	}
	public void setAccountUser(String accountUser) {
		this.accountUser = accountUser;
	}
	public String getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	public String getEmailAcount() {
		return emailAcount;
	}
	public void setEmailAcount(String emailAcount) {
		this.emailAcount = emailAcount;
	}
	public String getAccountPhonenumber() {
		return accountPhonenumber;
	}
	public void setAccountPhonenumber(String accountPhonenumber) {
		this.accountPhonenumber = accountPhonenumber;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public String getAccountAdress() {
		return accountAdress;
	}
	public void setAccountAdress(String accountAdress) {
		this.accountAdress = accountAdress;
	}
	public int getAccountAdmin() {
		return accountAdmin;
	}
	public void setAccountAdmin(int accountAdmin) {
		this.accountAdmin = accountAdmin;
	}
	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", accountUser=" + accountUser + ", accountPassword="
				+ accountPassword + ", emailAcount=" + emailAcount + ", accountPhonenumber=" + accountPhonenumber
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", accountAdress=" + accountAdress
				+ ", accountAdmin=" + accountAdmin + "]";
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


}
