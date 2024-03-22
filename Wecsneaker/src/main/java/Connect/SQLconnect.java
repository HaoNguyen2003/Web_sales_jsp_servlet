package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLconnect {
	private Connection con=null;
	private final String serverName="localhost";
	private final String postNumber="1433";
	private final String dtbase="Web_banhang";
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		String url="jdbc:sqlserver://"+serverName+":"+postNumber+";databaseName="+dtbase;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con=DriverManager.getConnection(url, "sa", "tienhao1234");
		return con;
	}
}
