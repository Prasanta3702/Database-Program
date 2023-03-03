import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC_Connection {
	public static void main(String[] args) {
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prasanta");
			
			Statement smt = con.createStatement();
			smt.executeUpdate("create table emp ("
					+ "eno number,"
					+ "ename varchar(12),"
					+ "esal number"
					+ ")");
			
			System.out.print("Table created successfully");
			con.close();
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
	}
}
