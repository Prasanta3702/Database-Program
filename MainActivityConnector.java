import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

public class MainActivityConnector {

	public static boolean check(String username, String password) {
		boolean flag1 = false;
		boolean flag2 = false;
		String u = null, p = null;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prasanta");
			Statement smt = con.createStatement();
			
			ResultSet res = smt.executeQuery("select * from student");
			
			while(res.next()) {
				String user = res.getString(1);
				String pass = res.getString(2);
				if(user.equalsIgnoreCase(username)) {
					flag1 = true;
					u = user;
				}
				if(pass.equals(password)) {
					flag2 = true;
					p = pass;
				}
			}
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
		
		if(flag1 & flag2) {
			return true;
		}
		return false;
	}

}
