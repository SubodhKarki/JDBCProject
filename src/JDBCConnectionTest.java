import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectionTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		JDBCConnection jc = new JDBCConnection();
		Connection con = jc.getConnection();
		if (con != null)
			System.out.println("Connection Succeeded");
		else
			System.out.println("Connection Failed");
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("Select * from customers");
		
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
		}
				
		con.close(); // best practice to close each time
	}

}
