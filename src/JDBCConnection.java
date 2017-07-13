import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	public Connection getConnection() throws ClassNotFoundException, SQLException {    // Connection class
		Class.forName("oracle.jdbc.driver.OracleDriver"); //Driver class  // oracle 14 jar download 
		Connection con = null;
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "System","Burzum88");  
									//1521 port number Oracle XE eXpress Edition  // username, password
		con.close();    // closing connection 
		return con;
	}
}

