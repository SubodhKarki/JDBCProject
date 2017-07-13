import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectionTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		// TODO Auto-generated method stub
		JDBCConnection jc = new JDBCConnection();
		Connection con = jc.getConnection();
		if (con != null)
			System.out.println("Connection Succeeded");
		else
			System.out.println("Connection Failed");
		
		Statement st = con.createStatement();
		
		 PreparedStatement pst = con.prepareStatement("INSERT into customers values(?,?,?");
		 BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		 // BufferedReader reads from the Stream
		 // to use scanner--> Scanner sc = new Scanner (System.in); and modify accordingly sc.readline etc.
		 
		 System.out.println("Enter id: ");
		 int id = Integer.parseInt(br.readLine());
		 System.out.println("Enter name:");
		 String name = br.readLine();
		 System.out.println("Enter favitem:");
		 String favtitem = br.readLine();
		 
		 pst.setInt(1, 10); // 1 means 1st parameter
		 pst.setString(2, "Subodh"); 
		 pst.setString(3, "Guitar");
		 int n = pst.executeUpdate();
		 System.out.println(n + "row/s affected");
		 con.close();
		
		ResultSet rs = st.executeQuery("Select * from customers");
	//	int rs = st.executeUpdate ("delete customers where custid IN (1009,10002,1000,10091,123,1234");
	 System.out.println(rs + " rows affected" );
		
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
			
		}
				
		con.close(); // best practice to close each time
	}

}
