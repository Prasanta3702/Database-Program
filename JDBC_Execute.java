import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;

public class JDBC_Execute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "prasanta");
			Statement smt = con.createStatement();
			
			ResultSet res = smt.executeQuery("select * from emp");
			
			while(res.next()) {
				int eid = res.getInt(1);
				String name = res.getString(2);
				int salary = res.getInt(3);
				
				System.out.println("ID: "+eid);
				System.out.println("Name: "+name);
				System.out.println("Salary: "+salary);
				System.out.println();
			}
		}
		catch(Exception exc) {
			System.out.println(exc);
		}
	}

}
